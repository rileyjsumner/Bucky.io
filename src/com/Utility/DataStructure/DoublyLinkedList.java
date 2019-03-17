package com.Utility.DataStructure;

import com.Exception.KeyNotFoundException;

public class DoublyLinkedList<T> extends LinkedList<T> implements ListADT<T> {

  private Node<T> head;

  private class Node<T> {

    private T data;
    private Node<T> previous;
    private Node<T> next;

    private Node() {
      this.data = null;
      this.previous = null;
      this.next = null;
    }

    private Node(T data) {
      this.data = data;
      this.previous = null;
      this.next = null;
    }

    private Node(T data, Node<T> previous, Node<T> next) {
      this.data = data;
      this.previous = previous;
      this.next = next;
    }

    private Node<T> getNext() {
      return this.next;
    }

    private void setNext(Node<T> node) {
      this.next = node;
    }

    private T getData() {
      return this.data;
    }

    private void setPrevious(Node<T> node) {
      this.previous = node;
    }
  }

  public DoublyLinkedList() {
    this.head = null;
  }

  public DoublyLinkedList(Node<T> head) {
    this.head = head;
  }

  public void add(T data) {
    Node<T> node = head;
    if(node == null) {
      head = new Node<>(data);
    } else {
      while (node.getNext() != null) {
        node = node.getNext();
      }
      node.setNext(new Node<>(data, node, null));
    }
  }

  public void remove(T data) throws KeyNotFoundException {
    if(!contains(data)) {
      throw new KeyNotFoundException();
    }
    Node<T> node = head;
    Node<T> prev = null;
    if(node != null) {
      while(node.getNext() != null) {
        if(node.getData().equals(data)) {
          if(prev == null) {
            head = node.getNext();
          } else {
            prev.setNext(node.getNext());
            node.getNext().setPrevious(prev);
          }
        }
        prev = node;
        node = node.getNext();
      }
    }
  }

}
