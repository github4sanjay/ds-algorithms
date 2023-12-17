package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class AddTwoLinkedListsTest {

  @Test
  public void testAdd() {
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.addLast(5);
    list1.addLast(6);
    list1.addLast(3);

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.addLast(8);
    list2.addLast(4);
    list2.addLast(2);

    LinkedList<Integer> expected = new LinkedList<>();
    expected.addLast(1);
    expected.addLast(4);
    expected.addLast(0);
    expected.addLast(5);

    LinkedList<Integer> result = AddTwoLinkedLists.add(list1, list2);

    // Compare the expected result with the actual result
    assertEquals(expected.getSize(), result.getSize());

    LinkNode<Integer> expectedHead = expected.getHead();
    LinkNode<Integer> resultHead = result.getHead();

    while (expectedHead != null && resultHead != null) {
      assertEquals(expectedHead.getData(), resultHead.getData());
      expectedHead = expectedHead.getNext();
      resultHead = resultHead.getNext();
    }
  }

  @Test
  public void testAddReversing() {
    LinkedList<Integer> list1 = new LinkedList<>();
    list1.addLast(5);
    list1.addLast(6);
    list1.addLast(3);

    LinkedList<Integer> list2 = new LinkedList<>();
    list2.addLast(8);
    list2.addLast(4);
    list2.addLast(2);

    LinkedList<Integer> expected = new LinkedList<>();
    expected.addLast(1);
    expected.addLast(4);
    expected.addLast(0);
    expected.addLast(5);

    LinkedList<Integer> result = AddTwoLinkedLists.addReversing(list1, list2);

    // Compare the expected result with the actual result
    assertEquals(expected.getSize(), result.getSize());

    LinkNode<Integer> expectedHead = expected.getHead();
    LinkNode<Integer> resultHead = result.getHead();

    while (expectedHead != null && resultHead != null) {
      assertEquals(expectedHead.getData(), resultHead.getData());
      expectedHead = expectedHead.getNext();
      resultHead = resultHead.getNext();
    }
  }
}
