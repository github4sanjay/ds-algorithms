package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

class OddEvenLinkedListTest {

  @Test
  public void testOddEvenSeparation() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(22);
    linkedList.addLast(30);
    linkedList.addLast(43);
    linkedList.addLast(56);
    linkedList.addLast(70);

    OddEvenLinkedList.get(linkedList);

    assertEquals(43, linkedList.getHead().getData());
    assertEquals(70, linkedList.getTail().getData());

    LinkNode<Integer> current = linkedList.getHead();
    while (current.getNext() != null) {
      if (current.getData() % 2 == 1) {
        assertTrue(current.getData() % 2 != current.getNext().getData() % 2);
      } else {
        assertEquals(current.getData() % 2, current.getNext().getData() % 2);
      }
      current = current.getNext();
    }
  }

  @Test
  public void testOddEvenSeparationWhenOnlyOdd() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(1);
    linkedList.addLast(13);
    linkedList.addLast(3);
    linkedList.addLast(9);
    linkedList.addLast(5);
    linkedList.addLast(7);

    OddEvenLinkedList.get(linkedList);

    assertEquals(1, linkedList.getHead().getData());
    assertEquals(7, linkedList.getTail().getData());
  }

  @Test
  public void testOddEvenSeparationWhenOnlyEven() {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(12);
    linkedList.addLast(132);
    linkedList.addLast(36);
    linkedList.addLast(96);
    linkedList.addLast(58);
    linkedList.addLast(70);

    OddEvenLinkedList.get(linkedList);

    assertEquals(12, linkedList.getHead().getData());
    assertEquals(70, linkedList.getTail().getData());
  }
}
