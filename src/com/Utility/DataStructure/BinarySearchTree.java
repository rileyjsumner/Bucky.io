package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;
import com.Exception.KeyNotFoundException;

public class BinarySearchTree<K extends Comparable<K>,V> implements SearchTreeADT<K,V> {

  private Node<K,V> root;
  private LinkedList<K> traversal;
  private int size;

  private class Node<K,V> {

    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;

    private Node() {
      this.key = null;
      this.left = null;
      this.right = null;
    }

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

    private Node(K key, V value, Node<K,V> left, Node<K,V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    private Node<K,V> getLeft() {
      return this.left;
    }

    private Node<K,V> getRight() {
      return this.right;
    }

    private K getKey() {
      return this.key;
    }

    private V getValue() {
      return this.value;
    }

    private void setLeft(Node<K,V> node) {
      this.left = node;
    }
    private void setRight(Node<K,V> node) {
      this.right = node;
    }
    private void setKey(K key) {
      this.key = key;
    }
  }

  public BinarySearchTree() {
    this.root = null;
    this.traversal = new LinkedList<>();
    this.size = 0;
  }

  public BinarySearchTree(Node<K,V> root) {
    this.root = root;
    this.traversal = new LinkedList<>();
    this.size = 0;
  }

  public void insert(K key, V value) throws DuplicateKeyException {
    if(contains(key)) {
      throw new DuplicateKeyException();
    }
    root = insertHelper(root, key, value);
    size++;
  }

  private Node<K,V> insertHelper(Node<K,V> node, K key, V value) {
    if(node == null) {
      return new Node<>(key, value);
    }
    if(node.getKey().compareTo(key) > 0) {
      node.setLeft(insertHelper(node.getLeft(), key, value));
    } else if(node.getKey().compareTo(key) < 0) {
      node.setRight(insertHelper(node.getRight(), key, value));
    }
    return node;
  }

  public void remove(K key) throws KeyNotFoundException {
    if(!contains(key)) {
      throw new KeyNotFoundException();
    }
    root = removeHelper(root, key);
  }

  private Node<K,V> removeHelper(Node<K,V> node, K key) {
    if(node.getKey().compareTo(key) > 0) {
      node.setLeft(removeHelper(node.getLeft(), key));
    } else if(node.getKey().compareTo(key) < 0) {
      node.setRight(removeHelper(node.getRight(), key));
    }
    node.setKey(getInOrderPredecessor(key).getKey());
    return node;
  }

  private Node<K,V> getInOrderPredecessor(K key) {
    return root;
  }

  public V get(K key) {
    return getHelper(root, key);
  }

  private V getHelper(Node<K,V> node, K key) {
    if(node.getKey().compareTo(key) > 0) {
      return getHelper(node.getLeft(), key);
    } else if(node.getKey().compareTo(key) < 0) {
      return getHelper(node.getRight(), key);
    }
    return node.getValue();
  }

  public boolean contains(K key) {
    return containsHelper(root, key);
  }

  private boolean containsHelper(Node<K,V> node, K key) {
    if(node == null) {
      return false;
    }
    if(node.getKey().compareTo(key) > 0) {
      return containsHelper(node.getLeft(), key);
    } else if(node.getKey().compareTo(key) < 0) {
      return containsHelper(node.getRight(), key);
    } else {
      return true;
    }
  }

  public LinkedList<K> inOrderTraversal() { // LVR
    traversal.clear();
    inOrderTraversalHelper(root);
    return traversal;
  }
  private void inOrderTraversalHelper(Node<K,V> node) {
    if(node == null) {
      return;
    }
    inOrderTraversalHelper(node.getLeft());
    traversal.add(node.getKey());
    inOrderTraversalHelper(node.getRight());
  }

  public LinkedList<K> preOrderTraversal() {
    traversal.clear();
    preOrderTraversalHelper(root);
    return traversal;
  }
  private void preOrderTraversalHelper(Node<K,V> node) { // LRV
    if(node == null) {
      return;
    }
    preOrderTraversalHelper(node.getLeft());
    preOrderTraversalHelper(node.getRight());
    traversal.add(node.getKey());
  }

  public LinkedList<K> postOrderTraversal() {
    traversal.clear();
    postOrderTraversalHelper(root);
    return traversal;
  }
  private void postOrderTraversalHelper(Node<K,V> node) { // VLR
    if(node == null) {
      return;
    }
    traversal.add(node.getKey());
    preOrderTraversalHelper(node.getLeft());
    preOrderTraversalHelper(node.getRight());
  }

  public LinkedList<K> levelOrderTraversal() {
    traversal.clear();
    int height = height();
    for (int i = 1; i <= height; i++) {
      levelOrderTraversalHelper(root, i);
    }
    return traversal;
  }
  private void levelOrderTraversalHelper(Node<K,V> node, int level) {
    if(node == null) {
      return;
    }
    if(level == 1) {
      traversal.add(node.getKey());
    } else if(level > 1) {
      levelOrderTraversalHelper(node.getLeft(), level-1);
      levelOrderTraversalHelper(node.getRight(), level-1);
    }

  }

  public int height() {
    return getHeightHelper(root);
  }

  private int getHeightHelper(Node<K,V> node) {
    if(node == null) {
      return 0;
    }
    int leftHeight = getHeightHelper(node.getLeft());
    int rightHeight = getHeightHelper(node.getRight());

    return ((leftHeight > rightHeight) ? leftHeight : rightHeight) + 1;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getSize() {
    return size;
  }

}
