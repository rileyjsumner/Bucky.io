package com.Utility.DataStructure;

import java.awt.Color;

public class RedBlackTree<K,V> {

  private Node<K,V> root;

  private class Node<K,V> {

    private K key;
    private V value;
    private Color color;
    private Node<K,V> left;
    private Node<K,V> right;

    public Node(K key, V value, Color color) {
      this.key = key;
      this.value = value;
      this.color = color;
    }

    public Node(K key, V value, Color color, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.left = left;
      this.right = right;
    }
  }

  public RedBlackTree(Node<K, V> root) {
    this.root = root;
  }

  public void insert(K key, V value) {

  }

  public void delete(K key) {

  }

  public V get(K key) {
    return null;
  }

  public boolean contains(K key) {
    return false;
  }
}
