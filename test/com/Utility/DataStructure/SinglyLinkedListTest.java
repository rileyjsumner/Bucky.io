package com.Utility.DataStructure;

import org.junit.Test;

public class SinglyLinkedListTest {

  private static SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

  @Test
  public static void testAdd() {
    if(linkedList.isEmpty()) {
      linkedList.add(4);
    }

  }
}
