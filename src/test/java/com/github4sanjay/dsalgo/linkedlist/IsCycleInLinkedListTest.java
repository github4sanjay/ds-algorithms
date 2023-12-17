package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsCycleInLinkedListTest {

  @Test
  public void testIsCycleInLinkedListWhenCycleIsPresent() {

    LinkNode<Integer> node1 = new LinkNode<>(6, null);
    LinkNode<Integer> node2 = new LinkNode<>(9, null);
    LinkNode<Integer> node3 = new LinkNode<>(15, null);
    LinkNode<Integer> node4 = new LinkNode<>(30, null);
    LinkNode<Integer> node5 = new LinkNode<>(2, null);
    LinkNode<Integer> node6 = new LinkNode<>(3, null);
    LinkNode<Integer> node7 = new LinkNode<>(8, null);
    LinkNode<Integer> node8 = new LinkNode<>(10, null);

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    node7.setNext(node8);
    node8.setNext(node5);

    Assertions.assertTrue(IsCycleInLinkedList.findWithExtraSpace(node1));
    Assertions.assertTrue(IsCycleInLinkedList.find(node1));
  }

  @Test
  public void testIsCycleInLinkedListWhenCycleIsNotPresent() {

    LinkNode<Integer> node1 = new LinkNode<>(6, null);
    LinkNode<Integer> node2 = new LinkNode<>(9, null);
    LinkNode<Integer> node3 = new LinkNode<>(15, null);
    LinkNode<Integer> node4 = new LinkNode<>(30, null);
    LinkNode<Integer> node5 = new LinkNode<>(2, null);
    LinkNode<Integer> node6 = new LinkNode<>(3, null);
    LinkNode<Integer> node7 = new LinkNode<>(8, null);
    LinkNode<Integer> node8 = new LinkNode<>(10, null);

    node1.setNext(node2);
    node2.setNext(node3);
    node3.setNext(node4);
    node4.setNext(node5);
    node5.setNext(node6);
    node6.setNext(node7);
    node7.setNext(node8);

    Assertions.assertFalse(IsCycleInLinkedList.findWithExtraSpace(node1));
    Assertions.assertTrue(IsCycleInLinkedList.find(node1));
  }
}
