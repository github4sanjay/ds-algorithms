package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class MergeTwoSortedLinkedList {

  public static <T extends Comparable<T>> LinkNode<T> mergeWithoutCreatingNewLinkedList(
      LinkNode<T> head1, LinkNode<T> head2) {
    if (head1 == null || head2 == null) return head1 == null ? head2 : head1;
    LinkNode<T> prev = null;
    LinkNode<T> head = null;
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

  public static <T extends Comparable<T>> LinkedList<T> merge(
      LinkNode<T> head1, LinkNode<T> head2) {

    var newLinkedList = new LinkedList<T>();
    while (head1 != null && head2 != null) {
      if (head1.getData().compareTo(head2.getData()) < 0) {
        newLinkedList.addLast(head1.getData());
        head1 = head1.getNext();
      } else if (head2.getData().compareTo(head1.getData()) < 0) {
        newLinkedList.addLast(head2.getData());
        head2 = head2.getNext();
      } else {
        newLinkedList.addLast(head1.getData());
        newLinkedList.addLast(head2.getData());
        head1 = head1.getNext();
        head2 = head2.getNext();
      }
    }

    if (head1 != null) {
      while (head1 != null) {
        newLinkedList.addLast(head1.getData());
        head1 = head1.getNext();
      }
    }

    if (head2 != null) {
      while (head2 != null) {
        newLinkedList.addLast(head2.getData());
        head2 = head2.getNext();
      }
    }

    return newLinkedList;
  }
}
