package com.Utility.DataStructure;

public class List<T> {

  private Node<T> head;
  private int size;

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

  public List() {

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
