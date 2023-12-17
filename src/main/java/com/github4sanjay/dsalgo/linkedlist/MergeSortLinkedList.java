package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class MergeSortLinkedList {

  public static <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> linkedList) {
    if (linkedList.getSize() == 0) return new LinkedList<>();
    return sort(linkedList.getHead(), linkedList.getTail());
  }

  private static <T extends Comparable<T>> LinkedList<T> sort(LinkNode<T> head, LinkNode<T> tail) {
    if (head == tail) {
      var newLinkedList = new LinkedList<T>();
      newLinkedList.addFirst(head.getData());
      return newLinkedList;
    }
    var mid = MidNodeLinkedList.find(head, tail);
    var list1 = sort(head, mid);
    var list2 = sort(mid.getNext(), tail);
    return MergeTwoSortedLinkedList.merge(list1.getHead(), list2.getHead());
  }
}
