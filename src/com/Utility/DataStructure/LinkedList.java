package com.Utility.DataStructure;

import com.Exception.KeyNotFoundException;

public class LinkedList<T> implements ListADT<T> {

  private Node<T> head;
  private int size;

  private class Node<T> {

    private T data;
    private Node<T> next;

    private Node() {
      this.data = null;
      this.next = null;
    }

    private Node(Node<T> next, T data) {
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

    private void setNext(Node<T> next, T data) {
      this.next = next;
      this.data = data;
    }
  }
  /**
   * Empty constructor for SinglyLinkedList<T>, initializes an
   * empty head element
   */
  public LinkedList() {
    this.head = null;
    size = 0;
  }

  /**
   * Constructor to set the first element in the list, sets up
   * with empty next element
   * @param data value to store in head node
   */
  public LinkedList(T data) {
    this.head = new Node<>(null, data);
    size = 1;
  }

  /**
   * Adds data to the end of the linkedList
   * @param data to add into the list
   */
  public void add(T data) {
    if(head == null) {
      this.head = new Node<>(null, data);
    } else {
      Node<T> current = head;
      while(current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(null, data);
    }
    size++;
  }

  /**
   * Adds new data to the list after a designated element
   * @param data to add to the list,
   * @param after this value is found in the list
   */
  public void addAfter(T data, T after) {
    Node<T> current = head;
    Node<T> next;
    while(current.getNext() != null) {
      if(current.getData() == after) {
        next = current.getNext();
        current.setNext(next, data);
        break;
      }
    }

  }

  /**
   * Remove an element from the linkedList
   * @param data to remove
   */
  public void remove(T data) throws KeyNotFoundException {
    if(!contains(data)) {
      throw new KeyNotFoundException();
    }
    Node<T> current = head;
    Node<T> previous = null;
    while(current.getNext() != null) {
      if(current.getData() == data) {
        previous.setNext(current.getNext());
      }
      previous = current;
    }
    size--;
  }

  /**
   * Remove the head element, setting new head to the
   * next element
   */
  public void removeFront() {
    this.head = head.getNext();
    size--;
  }

  /**
   * Remove an element after a given element
   * @param after this element, remove the next node
   */
  public void removeAfter(T after) {
    Node<T> current = head;

    while(current.getNext() != null) {
      if(current.getData() == after) {
        current.setNext(current.getNext().getNext());
        break;
      }
    }
    size--;
  }

  public boolean contains(T data) {
    Node<T> node = head;
    if(node == null) {
      return false;
    } else {
      while(node.getNext() != null) {
        if(node.getData().equals(data)) {
          return true;
        }
        node = node.getNext();
      }
    }
    return false;
  }

  public void clear() {
    this.size = 0;
    this.head = null;
  }

  /**
   * Accessor method for size field
   * @return size of list
   */
  public int getSize() {
    return size;
  }

  /**
   * Boolean if the size of the list is 0
   * @return true if empty
   */
  public boolean isEmpty() {
    return size == 0;
  }
}
