package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class MergeSortLinkedListTest {

  @Test
  public void testSortEmptyList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    LinkedList<Integer> sortedList = MergeSortLinkedList.sort(linkedList);

    assertEquals(0, sortedList.getSize());
  }

  @Test
  public void testSortSingleElement() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(5);

    LinkedList<Integer> sortedList = MergeSortLinkedList.sort(linkedList);

    assertEquals(1, sortedList.getSize());
    assertEquals(5, (int) sortedList.getFirst());
  }

  @Test
  public void testSortEvenLengthList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(5);
    linkedList.addLast(7);
    linkedList.addLast(3);

    LinkedList<Integer> sortedList = MergeSortLinkedList.sort(linkedList);

    assertEquals(4, sortedList.getSize());
    assertEquals(3, (int) sortedList.getFirst());
    assertEquals(5, (int) sortedList.getAtIndex(1));
    assertEquals(7, (int) sortedList.getAtIndex(2));
    assertEquals(10, (int) sortedList.getLast());
  }

  @Test
  public void testSortOddLengthList() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(8);
    linkedList.addLast(3);
    linkedList.addLast(1);
    linkedList.addLast(6);
    linkedList.addLast(4);

    LinkedList<Integer> sortedList = MergeSortLinkedList.sort(linkedList);

    assertEquals(5, sortedList.getSize());
    assertEquals(1, (int) sortedList.getFirst());
    assertEquals(3, (int) sortedList.getAtIndex(1));
    assertEquals(4, (int) sortedList.getAtIndex(2));
    assertEquals(6, (int) sortedList.getAtIndex(3));
    assertEquals(8, (int) sortedList.getLast());
  }
}
