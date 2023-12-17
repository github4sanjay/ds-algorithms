package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class MidNodeLinkedList {

  public static <T> LinkNode<T> find(LinkNode<T> head, LinkNode<T> tail) {
    var faster = head;
    var slower = head;

    while (faster != tail && faster.getNext() != tail) {
      faster = faster.getNext().getNext();
      slower = slower.getNext();
    }
    return slower;
  }
}
