package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class MidNodeLinkedListTest {

  @Test
  public void testFindMidNodeEvenLength() {

    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(4);

    LinkNode<Integer> mid = MidNodeLinkedList.find(linkedList.getHead(), linkedList.getTail());

    assertEquals(2, mid.getData());
  }

  @Test
  public void testFindMidNodeOddLength() {
    // Creating a linked list with odd number of elements
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(2);
    linkedList.addLast(3);

    LinkNode<Integer> mid = MidNodeLinkedList.find(linkedList.getHead(), linkedList.getTail());

    assertEquals(2, mid.getData());
  }

  @Test
  public void testFindMidNodeSingleElement() {
    // Creating a linked list with only one element
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);

    LinkNode<Integer> mid = MidNodeLinkedList.find(linkedList.getHead(), linkedList.getTail());

    assertEquals(1, mid.getData());
  }

  @Test
  public void testFindMidNodeEmptyList() {
    // Creating an empty linked list
    LinkedList<Integer> linkedList = new LinkedList<>();

    LinkNode<Integer> mid = MidNodeLinkedList.find(linkedList.getHead(), linkedList.getTail());

    assertNull(mid);
  }
}
