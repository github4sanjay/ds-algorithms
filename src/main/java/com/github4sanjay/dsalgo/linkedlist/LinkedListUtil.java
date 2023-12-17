package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class LinkedListUtil {

  public static void print(LinkNode<Integer> head) {
    var current = head;
    while (current != null) {
      var data = current.getData();
      System.out.println(data);
      current = current.getNext();
    }
  }
}
