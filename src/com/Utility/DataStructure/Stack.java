package com.Utility.DataStructure;

public class Stack<T> extends LinkedList<T> implements ListADT<T> {

  private Node<T> head;

  private class Node<T> {

    private T data;
    private Node<T> next;

    private Node() {
      this.data = null;
      this.next = null;
    }

    private Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }

    private T getData() {
      return data;
    }

    private void setData(T data) {
      this.data = data;
    }

    private Node<T> getNext() {
      return next;
    }

    private void setNext(Node<T> next) {
      this.next = next;
    }
  }

  public Stack() {
    this.head = null;
  }

  public Stack(Node<T> head) {
    this.head = head;
  }

  public Node<T> peek() {
    return this.head;
  }

  public Node<T> pop() {
    Node<T> node = head;
    this.head = head.getNext();
    return node;
  }

  public void add(T data) {
    Node<T> node = head;
    head = new Node<>(data, node);
  }


}
