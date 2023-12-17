package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class RemoveNthNodeFromEnd {

  public <T> LinkNode<T> remove(LinkNode<T> head, int n) {
    if (head == null) throw new IllegalArgumentException("Invalid head");
    if (n == 1 && head.getNext() == null) {
      return null;
    }
    var slowPtr = head;
    var fastPtr = head;
    for (int i = 0; i < n && fastPtr != null; i++) {
      fastPtr = fastPtr.getNext();
    }

    if (fastPtr == null) throw new IllegalArgumentException("Invalid n");
    while (fastPtr.getNext() != null) {
      slowPtr = slowPtr.getNext();
      fastPtr = fastPtr.getNext();
    }
    slowPtr.setNext(slowPtr.getNext().getNext());
    return head;
  }
}
