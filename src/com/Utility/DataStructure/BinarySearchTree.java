package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;

public class BinarySearchTree<K extends Comparable<K>> {

  private Node<K> root;
  private Node<K> leftNode;
  private Node<K> rightNode;

  private class Node<K> {

    private K key;
    private Node<K> left;
    private Node<K> right;

    private Node() {
      this.key = null;
      this.left = null;
      this.right = null;
    }

    private Node(K key) {
      this.key = key;
      this.left = null;
      this.right = null;
    }

    private Node(K key,Node<K> left, Node<K> right) {
      this.key = key;
      this.left = left;
      this.right = right;
    }

    private Node<K> getLeft() {
      return this.left;
    }

    private Node<K> getRight() {
      return this.right;
    }

    private K getKey() {
      return this.key;
    }
  }

  public BinarySearchTree() {
    this.root = null;
    this.leftNode = null;
    this.rightNode = null;
  }

  public BinarySearchTree(Node<K> root) {
    this.root = root;
    this.leftNode = null;
    this.rightNode = null;
  }

  public BinarySearchTree(Node<K> root, Node<K> left, Node<K> right) {
    this.root = root;
    this.leftNode = left;
    this.rightNode = right;
  }

  public void insert(K key) throws DuplicateKeyException {
    root = insertHelper(root, key);
  }

  private Node<K> insertHelper(Node<K> node, K key) throws DuplicateKeyException {
    if(node == null) {
      return new Node<>(key);
    }
    if(node.getKey().compareTo(key) > 0) {
      return insertHelper(node.getLeft(), key);
    } else if(node.getKey().compareTo(key) < 0) {
      return insertHelper(node.getRight(), key);
    } else {
      throw new DuplicateKeyException();
    }
  }

  public boolean contains(K key) {
    return containsHelper(root, key);
  }

  private boolean containsHelper(Node<K> node, K key) {
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

  public SinglyLinkedList<K> inOrderTraversal() {
    return new SinglyLinkedList<>();
  }

  public SinglyLinkedList<K> preOrderTraversal() {
    return new SinglyLinkedList<>();
  }

  public SinglyLinkedList<K> postOrderTraversal() {
    return new SinglyLinkedList<>();
  }

  public SinglyLinkedList<K> levelOrderTraversal() {
    return new SinglyLinkedList<>();
  }




}
