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
    if (list.size() == 0) {
      throw new RuntimeException("List is empty");
    }
    return list.removeFirst();
  }

  public static void main(String[] args) {
    var stack = new QueueWithLinkedList<Integer>();
    stack.add(10);
    stack.add(20);
    stack.add(30);
    stack.add(40);

    System.out.println(stack.remove());
    System.out.println(stack.peek());
  }
}
