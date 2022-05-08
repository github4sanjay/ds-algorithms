package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

public class AddFirst {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addFirst(10);
    linkedList.addFirst(20);
    linkedList.addFirst(30);
    linkedList.print();
  }
}
