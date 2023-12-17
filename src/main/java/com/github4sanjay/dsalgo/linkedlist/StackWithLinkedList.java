package com.github4sanjay.dsalgo.linkedlist;

import java.util.LinkedList;

public class StackWithLinkedList<T> {

  LinkedList<T> list;

  public StackWithLinkedList() {
    this.list = new LinkedList<>();
  }

  public void push(T item) {
    list.addFirst(item);
  }

  public T top() {
    return list.getFirst();
  }

  public T pop() {
    if (list.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    return list.removeFirst();
  }
}
