package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class ReversePairLinkedList {

  public static <T> LinkNode<T> reversePair(LinkNode<T> head) {
    if (head == null) return head;
    var current = head;
    LinkNode<T> prev = null;
    while (current != null && current.getNext() != null) {
      var next = current.getNext();
      var temp = next.getNext();
      current.setNext(temp);
      next.setNext(current);
      if (prev == null) {
        head = next;
      } else {
        prev.setNext(next);
      }
      prev = current;
      current = temp;
    }
    return head;
  }
}
