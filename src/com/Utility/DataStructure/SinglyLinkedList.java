package com.Utility.DataStructure;

public class SinglyLinkedList<T> {

  private Node<T> head;

  public SinglyLinkedList() {
    this.head = null;
  }
  public SinglyLinkedList(T data) {
    this.head = new Node<>(null, data);
  }

  public void add(T data) {
    if(head == null) {
      this.head = new Node<>(null, data);
    } else {
      Node<T> current = head;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(data);
    }
  }
  public void addAfter(T data, T after) {

  }
  public void remove(T data) {
    Node<T> current = head;
    Node<T> previous = null;
    while(current.getNext() != null) {
      if(current.getData() == data) {
        previous.setNext(current.getNext().getData());
      }
      previous = current;
    }
  }
  public void removeFront() {
    this.head = head.getNext();
  }
  public void removeAfter(T data, T after) {

  }

}
