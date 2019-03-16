package com.Utility.DataStructure;

public class SinglyLinkedList<T> {

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
      this.next = next;
      this.data = data;
    }

    private Node<T> getNext() {
      return this.next;
    }

    private void setNext(Node<T> next) {
      this.next = next;
    }
    private void setNext(Node<T> next, T data) {
      this.next = next;
      this.data = data;
    }

    private T getData() {
      return this.data;
    }
  }

  /**
   * Empty constructor for SinglyLinkedList<T>, initializes an
   * empty head element
   */
  public SinglyLinkedList() {
    this.head = null;
    size = 0;
  }

  /**
   * Constructor to set the first element in the list, sets up
   * with empty next element
   * @param data value to store in head node
   */
  public SinglyLinkedList(T data) {
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
  public void remove(T data) {
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
