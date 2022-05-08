package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class AddAtIndex {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(40);

    linkedList.addAtIndex(2, 30);
    linkedList.addAtIndex(4, 50);
    linkedList.addAtIndex(0, 5);

    linkedList.addAtIndex(-2, 1);
    linkedList.addAtIndex(12, 60);

    linkedList.print();
  }
}
