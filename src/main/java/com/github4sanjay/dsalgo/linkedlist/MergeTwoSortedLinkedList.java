package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;

public class MergeTwoSortedLinkedList {

  public static LinkNode<Integer> merge(LinkNode<Integer> head1, LinkNode<Integer> head2) {
    if (head1 == null || head2 == null) return head1 == null ? head2 : head1;
    LinkNode<Integer> prev = null;
    LinkNode<Integer> head = null;
    var current1 = head1;
    var current2 = head2;
    while (current1 != null && current2 != null) {
      if (current1.getData().compareTo(current2.getData()) < 0) {
        if (prev == null) {
          head = current1;
        } else {
          prev.setNext(current1);
        }
        prev = current1;
        current1 = current1.getNext();
      } else if (current1.getData().compareTo(current2.getData()) >= 0) {
        if (prev == null) {
          head = current2;
        } else {
          prev.setNext(current2);
        }
        prev = current2;
        current2 = current2.getNext();
      }
    }
    if (current1 != null) {
      prev.setNext(current1);
    }
    if (current2 != null) {
      prev.setNext(current2);
    }
    return head;
  }

  private static void print(LinkNode<Integer> head) {
    var current = head;
    while (current != null) {
      System.out.println(current.getData());
      current = current.getNext();
    }
  }
}
