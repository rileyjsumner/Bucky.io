package com.Utility.DataStructure;

public class CircularLinkedList<T> extends LinkedList<T> implements ListADT<T> {

  private Node<T> head;
  private int size;

  private class Node<T> {

    private Node<T> next;
    private T data;

    private Node() {
      this.data = null;
      this.next = null;
    }
  }
}
