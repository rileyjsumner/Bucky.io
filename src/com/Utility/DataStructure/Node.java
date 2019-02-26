package com.Utility.DataStructure;

public class Node<T> {
  private      T  data;
  private Node<T> head;
  private Node<T> tail;
  private Node<T> left;
  private Node<T> right;

  protected Node(Node<T> next, T data) {
    this.right = next;
    this.data  = data;
  }

  protected Node(Node<T> left, Node<T> right, T data) {
    this.left  = left;
    this.right = right;
    this.data  = data;
  }

  protected Node(Node<T> right, T data, Node<T> head) {
    this.right = right;
    this.data  = data;
    this.head  = head;
  }

  protected Node(Node<T> left, Node<T> right, T data, Node<T> head, Node<T> tail) {
    this.left  = left;
    this.right = right;
    this.data  = data;
    this.head  = head;
    this.tail  = tail;
  }

  protected Node<T> getNext() {
    return this.left;
  }
  protected void setNext(Node<T> next, T data) {
    this.left = new Node<>(next, data);
  }
  protected void setNext(Node<T> next) {
    this.left = next;
  }
  protected T getData() {
    return this.data;
  }
}