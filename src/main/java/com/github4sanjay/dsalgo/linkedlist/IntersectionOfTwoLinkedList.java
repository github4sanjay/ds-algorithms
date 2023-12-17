package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Write a function to get the intersection point of two Linked Lists
 *
 * <p>There are two singly linked lists in a system. By some programming error, t he end node of one
 * of the linked list got linked to the second list, forming an inverted Y shaped list.
 *
 * <p>Write a program to get the point where two linked list merge.
 */
public class IntersectionOfTwoLinkedList {

  /**
   * Traverse both head till end put its elements in two stacks then start popping from stack and
   * compare if they equal save it in previous if they not equal return previous
   */
  public static LinkNode<Integer> find(LinkNode<Integer> head1, LinkNode<Integer> head2) {
    var stack1 = new LinkedList<LinkNode<Integer>>();
    while (head1 != null) {
      stack1.addFirst(head1);
      head1 = head1.getNext();
    }

    var stack2 = new LinkedList<LinkNode<Integer>>();
    while (head2 != null) {
      stack2.addFirst(head2);
      head2 = head2.getNext();
    }

    LinkNode<Integer> prev = null;
    while (stack1.getSize() != 0 && stack2.getSize() != 0) {
      var node1 = stack1.removeFirst();
      var node2 = stack2.removeFirst();
      if (node1 != node2) {
        return prev;
      } else {
        prev = node1; // or node2 as both are equal
      }
    }
    return null;
  }

  /** does value comparison */
  public static int find(LinkedList<Integer> list1, LinkedList<Integer> list2) {
    int size1 = list1.getSize();
    int size2 = list2.getSize();
    var head1 = list1.getHead();
    var head2 = list2.getHead();
    if (size1 > size2) {
      int extra = size1 - size2;
      while (extra > 0) {
        head1 = head1.getNext();
        extra--;
      }
    } else if (size1 < size2) {
      int extra = size2 - size1;
      while (extra > 0) {
        head2 = head2.getNext();
        extra--;
      }
    }

    while (!head1.getData().equals(head2.getData())) {
      head1 = head1.getNext();
      head2 = head2.getNext();
    }
    return head1.getData();
  }
}
