package com.Utility.DataStructure;

public class AVLTree<K,V> {

  public Node<K,V> root;

  private class Node<K,V> {

    private K key;
    private V value;
    private Node<K,V> left;
    private Node<K,V> right;

    private Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = null;
      this.right = null;
    }

    public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.left = left;
      this.right = right;
    }

    private K getKey() {
      return this.key;
    }

    private V getValue() {
      return value;
    }

    private Node<K, V> getLeft() {
      return left;
    }

    private Node<K, V> getRight() {
      return right;
    }

    private void setLeft(Node<K, V> left) {
      this.left = left;
    }

    private void setRight(Node<K, V> right) {
      this.right = right;
    }
  }

  public void insert(K key, V value) {
    insertHelper(root, key, value);
  }

  private void insertHelper(Node<K,V> node, K key, V value) {

  }

  public void remove(K key) {
    removeHelper(root, key);
  }

  private void removeHelper(Node<K,V> node, K key) {

  }
}
