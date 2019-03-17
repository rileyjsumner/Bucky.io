package com.Utility.DataStructure;

import com.Exception.DuplicateKeyException;

import java.awt.Color;

public class RedBlackTree<K extends Comparable<K>,V> {

  private Node<K,V> root;

  private class Node<K,V> {

    private K key;
    private V value;
    private Color color;
    private Node<K,V> left;
    private Node<K,V> right;

    private Node(K key, V value, Color color) {
      this.key = key;
      this.value = value;
      this.color = color;
    }

    private Node(K key, V value, Color color, Node<K, V> left, Node<K, V> right) {
      this.key = key;
      this.value = value;
      this.color = color;
      this.left = left;
      this.right = right;
    }

    private K getKey() {
      return this.key;
    }

    private Node<K,V> getLeft() {
      return this.left;
    }

    private Node<K,V> getRight() {
      return this.right;
    }
  }

  public RedBlackTree(Node<K,V> root) {
    this.root = root;
  }

  public void insert(K key, V value) throws DuplicateKeyException {
    if(contains(key)) {
      throw new DuplicateKeyException();
    }
    insertHelper(root, key, value);
  }

  private void insertHelper(Node<K,V> node, K key, V value) {
    if(node.getKey().compareTo(key) > 0) {
      insertHelper(node.getLeft(), key, value);
    } else if(node.getKey().compareTo(key) < 0) {
      insertHelper(node.getRight(), key, value);
    }
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
