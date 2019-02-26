package com.Utility.DataStructure;

public class BinarySearchTree<T> {

  private T root;
  private Node<T> leftNode;
  private Node<T> rightNode;

  public BinarySearchTree() {
    root = null;
    leftNode = null;
    rightNode = null;
  }

  public void add(T data) {
    if(root == null) {
      root = data;
    }


  }
}
