package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndTest {

  @Test
  public void testRemoveNthFromEnd() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    LinkNode<Integer> head = new LinkNode<>(1, null);
    head.setNext(new LinkNode<>(2, null));
    head.getNext().setNext(new LinkNode<>(3, null));
    head.getNext().getNext().setNext(new LinkNode<>(4, null));
    head.getNext().getNext().getNext().setNext(new LinkNode<>(5, null));

    var manipulator = new RemoveNthNodeFromEnd();

    // Remove the 2nd node from the end (4)
    head = manipulator.remove(head, 2);

    // The resulting list should be: 1 -> 2 -> 3 -> 5
    assertEquals(1, head.getData());
    assertEquals(2, head.getNext().getData());
    assertEquals(3, head.getNext().getNext().getData());
    assertEquals(5, head.getNext().getNext().getNext().getData());
    assertNull(head.getNext().getNext().getNext().getNext());
  }

  @Test
  public void testRemoveNthFromEndSingleNode() {
    // Create a linked list with a single node: 1
    LinkNode<Integer> head = new LinkNode<>(1, null);

    var manipulator = new RemoveNthNodeFromEnd();

    // Remove the only node from the end (empty list)
    head = manipulator.remove(head, 1);

    assertNull(head);
  }

  @Test
  public void testRemoveNthFromEndInvalidN() {
    // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
    LinkNode<Integer> head = new LinkNode<>(1, null);
    head.setNext(new LinkNode<>(2, null));
    head.getNext().setNext(new LinkNode<>(3, null));
    head.getNext().getNext().setNext(new LinkNode<>(4, null));
    head.getNext().getNext().getNext().setNext(new LinkNode<>(5, null));

    var manipulator = new RemoveNthNodeFromEnd();

    // Try to remove a node at an invalid position
    assertThrows(IllegalArgumentException.class, () -> manipulator.remove(head, 6));
  }
}
