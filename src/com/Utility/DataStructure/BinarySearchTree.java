package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;

public class BinarySearchTree<K extends Comparable<K>, V> {

  private Node<K,V> root;
  private SinglyLinkedList<K> traversal;

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
  }

  public BinarySearchTree() {
    this.root = null;
    this.traversal = new SinglyLinkedList<>();
  }

  public BinarySearchTree(Node<K,V> root) {
    this.root = root;
    this.traversal = new SinglyLinkedList<>();
  }

  public void insert(K key, V value) throws DuplicateKeyException {
    if(contains(key)) {
      throw new DuplicateKeyException();
    }
    root = insertHelper(root, key, value);
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

  public SinglyLinkedList<K> inOrderTraversal() { // LVR
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

  public SinglyLinkedList<K> preOrderTraversal() {
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

  public SinglyLinkedList<K> postOrderTraversal() {
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

  public SinglyLinkedList<K> levelOrderTraversal() {
    traversal.clear();
    int height = getHeight();
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

  public int getHeight() {
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

}
