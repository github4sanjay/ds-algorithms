package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;
import com.github4sanjay.dsalgo.linkedlist.structure.LinkedListUtil;

public class RemoveDuplicatesInSorted {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(2);
    linkedList.addLast(2);
    linkedList.addLast(2);
    linkedList.addLast(3);
    linkedList.addLast(3);
    linkedList.addLast(5);
    linkedList.addLast(5);
    linkedList.addLast(5);
    linkedList.addLast(5);
    linkedList.addLast(5);

    // LinkedListUtil.removeDuplicates(linkedList.getHead());
    // linkedList.print();
    LinkedListUtil.removeDuplicatesCreatingNewLinkedList(linkedList.getHead()).print();
  }
}
