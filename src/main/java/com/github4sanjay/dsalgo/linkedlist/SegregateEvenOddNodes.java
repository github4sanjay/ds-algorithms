package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class SegregateEvenOddNodes {

  public static LinkNode<Integer> segregate(LinkNode<Integer> head) {
    if (head == null || head.getNext() == null) return head;
    LinkNode<Integer> headOdd = new LinkNode<>(-1, null);
    LinkNode<Integer> headEven = new LinkNode<>(-1, null);
    LinkNode<Integer> tailOdd = headOdd;
    LinkNode<Integer> tailEven = headEven;
    var current = head;
    while (current != null) {
      if (current.getData() % 2 == 1) {
        tailOdd.setNext(current);
        tailOdd = current;
      } else {
        tailEven.setNext(current);
        tailEven = current;
      }
      current = current.getNext();
    }
    tailOdd.setNext(headEven.getNext());
    return headOdd.getNext();
  }
}
