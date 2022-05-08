package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/**
 * Rearrange a linked list such that all even and odd positioned nodes are together Last Updated:
 * 18-04-2019 Rearrange a linked list in such a way that all odd position nodes are together and all
 * even positions node are together,
 *
 * <p>Examples:
 *
 * <p>Input: 1->2->3->4 Output: 1->3->2->4
 *
 * <p>Input: 10->22->30->43->56->70 Output: 10->30->56->22->43->70
 */
public class OddEvenLinkedList {

  public static void main(String[] args) {
    var linkedList = new LinkedList<Integer>();
    linkedList.addLast(10);
    linkedList.addLast(22);
    linkedList.addLast(30);
    linkedList.addLast(43);
    linkedList.addLast(56);
    linkedList.addLast(70);
    OddEvenLinkedList.get(linkedList);
    linkedList.print();
  }

  private static void get(LinkedList<Integer> linkedList) {
    var oddList = new LinkedList<Integer>();
    var evenList = new LinkedList<Integer>();
    var currentNode = linkedList.getHead();
    while (currentNode.getNext() != null) {
      if (currentNode.getData() % 2 == 1) {
        oddList.addLast(currentNode.getData());
      } else {
        evenList.addLast(currentNode.getData());
      }
      currentNode = currentNode.getNext();
    }
    oddList.getTail().setNext(evenList.getHead());
    linkedList.setHead(oddList.getHead());
    linkedList.setTail(oddList.getTail());
  }
}
