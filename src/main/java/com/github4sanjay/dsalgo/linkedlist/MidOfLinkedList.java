package com.github4sanjay.dsalgo.linkedlist;

import com.github4sanjay.dsalgo.linkedlist.structure.LinkedList;

/** Without using size property find the mid of linked list. */
public class MidOfLinkedList {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.addLast(10);
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addLast(40);
    linkedList.addLast(50);

    System.out.println(linkedList.getMid()); // 30
    linkedList.addLast(60);
    System.out.println(linkedList.getMid()); // 30
  }
}
