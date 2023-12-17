package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Rearrange a linked list in such a way that all odd position nodes are together and all even
 * positions node are together,
 *
 * <p>Examples:
 *
 * <p>Input: 1->2->3->4 Output: 1->3->2->4
 *
 * <p>Input: 10->22->30->43->56->70 Output: 10->30->56->22->43->70
 */
public class OddEvenLinkedList {

  public static void get(LinkedList<Integer> linkedList) {
    var oddList = new LinkedList<Integer>();
    var evenList = new LinkedList<Integer>();
    while (linkedList.getSize() > 0) {
      var data = linkedList.removeFirst();
      if (data % 2 == 1) {
        oddList.addLast(data);
      } else {
        evenList.addLast(data);
      }
    }
    // original linkedlist have both even and odd numbers
    if (oddList.getSize() > 0 && evenList.getSize() > 0) {
      oddList.getTail().setNext(evenList.getHead());
      linkedList.setHead(oddList.getHead());
      linkedList.setTail(evenList.getTail());
      linkedList.setSize(oddList.getSize() + evenList.getSize());
      // original linkedlist only odd numbers
    } else if (oddList.getSize() > 0) {
      linkedList.setHead(oddList.getHead());
      linkedList.setTail(oddList.getTail());
      linkedList.setSize(oddList.getSize());
      // original linkedlist only even numbers
    } else {
      linkedList.setHead(evenList.getHead());
      linkedList.setTail(evenList.getTail());
      linkedList.setSize(evenList.getSize());
    }
  }
}
