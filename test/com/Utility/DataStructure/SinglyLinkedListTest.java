package com.Utility.DataStructure;

import org.junit.Test;

public class SinglyLinkedListTest extends ListTest {

  private static SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

  @Test
  public static void testAdd() {
    if(linkedList.isEmpty()) {
      linkedList.add(4);
    }

  }
}
