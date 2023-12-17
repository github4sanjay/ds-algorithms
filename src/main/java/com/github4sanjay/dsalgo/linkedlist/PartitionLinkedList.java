package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkNode;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class PartitionLinkedList {

  public static LinkNode<Integer> partition(LinkNode<Integer> head, Integer k) {
    var front = new LinkedList<Integer>();
    var rear = new LinkedList<Integer>();
    var curr = head;
    while (curr != null) {
      if (curr.getData() < k) {
        front.addLast(curr.getData());
      } else {
        rear.addLast(curr.getData());
      }
      curr = curr.getNext();
    }
    if (front.getSize() > 0 && rear.getSize() > 0) {
      front.getTail().setNext(rear.getHead());
      return front.getHead();
    } else if (front.getSize() > 0) {
      return front.getHead();
    } else {
      return rear.getHead();
    }
  }
}
