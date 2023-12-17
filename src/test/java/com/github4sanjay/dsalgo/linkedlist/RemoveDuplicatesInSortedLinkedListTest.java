package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesInSortedLinkedListTest {

  @Test
  public void testRemoveDuplicatesFromList() {
    // Create a sorted linked list with duplicates
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(3);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.addLast(5);

    // Remove duplicates in the list
    RemoveDuplicatesInSortedLinkedList.remove(linkedList.getHead());

    // Check the list after removing duplicates
    assertEquals(1, (int) linkedList.getAtIndex(0));
    assertEquals(2, (int) linkedList.getAtIndex(1));
    assertEquals(3, (int) linkedList.getAtIndex(2));
    assertEquals(4, (int) linkedList.getAtIndex(3));
    assertEquals(5, (int) linkedList.getAtIndex(4));
  }

  @Test
  public void testRemoveDuplicatesAndCreateNewList() {
    // Create a sorted linked list with duplicates
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(3);
    linkedList.addLast(3);
    linkedList.addLast(4);
    linkedList.addLast(5);
    linkedList.addLast(5);

    // Remove duplicates and create a new linked list without duplicates
    LinkedList<Integer> newLinkedList =
        RemoveDuplicatesInSortedLinkedList.removeCreatingNewLinkedList(linkedList.getHead());

    // Check the new list after removing duplicates
    assertEquals(1, (int) newLinkedList.getAtIndex(0));
    assertEquals(2, (int) newLinkedList.getAtIndex(1));
    assertEquals(3, (int) newLinkedList.getAtIndex(2));
    assertEquals(4, (int) newLinkedList.getAtIndex(3));
    assertEquals(5, (int) newLinkedList.getAtIndex(4));
  }
}
