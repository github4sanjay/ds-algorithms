package com.github4sanjay.dsalgo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import org.junit.jupiter.api.Test;

public class IntersectionOfTwoLinkedListTest {

  @Test
  public void testFind() {
    // Test case 1
    // ----------- intersection by value -----------------------------------------
    LinkedList<Integer> linkedList = new LinkedList<>();

    linkedList.addLast(3);
    linkedList.addLast(6);
    linkedList.addLast(9);
    linkedList.addLast(15);
    linkedList.addLast(30);

    LinkedList<Integer> anotherLL = new LinkedList<>();
    anotherLL.addLast(10);
    anotherLL.addLast(15);
    anotherLL.addLast(30);
    var result = IntersectionOfTwoLinkedList.find(linkedList, anotherLL);

    assertEquals(15, result);
  }

  @Test
  public void testFindValueComparison() {
    // ----------- intersection by reference -----------------------------------------
    LinkNode<Integer> head1 = new LinkNode<>(3, null);
    LinkNode<Integer> head2 = new LinkNode<>(10, null);

    LinkNode<Integer> node1 = new LinkNode<>(6, null);
    LinkNode<Integer> node2 = new LinkNode<>(9, null);
    LinkNode<Integer> node3 = new LinkNode<>(15, null);
    LinkNode<Integer> node4 = new LinkNode<>(30, null);

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);

    head1.setNext(node1);
    head2.setNext(node3);

    LinkNode<Integer> intersection = IntersectionOfTwoLinkedList.find(head1, head2);
    assertEquals(node3, intersection);
  }
}
