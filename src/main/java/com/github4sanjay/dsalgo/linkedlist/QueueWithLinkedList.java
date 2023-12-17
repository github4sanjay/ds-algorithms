package com.github4sanjay.dsalgo.linkedlist;

import java.util.LinkedList;

public class QueueWithLinkedList<T> {

  LinkedList<T> list;

  public QueueWithLinkedList() {
    this.list = new LinkedList<>();
  }

  public void add(T item) {
    list.addLast(item);
  }

  public T peek() {
    return list.getFirst();
  }

  public T remove() {
    if (list.isEmpty()) {
      throw new RuntimeException("List is empty");
    }
    return list.removeFirst();
  }
}
