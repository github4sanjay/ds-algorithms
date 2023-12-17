package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class RotateLinkedList {

  public static <T> LinkNode<T> rotateRight(LinkNode<T> head, int k) {
    var current = head;
    for (int i = 0; i < k; i++) {
      current = current.getNext();
    }
    var faster = current;
    current = head;
    while (faster.getNext() != null) {
      faster = faster.getNext();
      current = current.getNext();
    }
    faster.setNext(head);
    head = current.getNext();
    current.setNext(null);
    return head;
  }
}
