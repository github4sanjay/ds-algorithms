package com.github4sanjay.dsalgo.queue;

import java.util.Stack;

public class QueueWithStackRemoveEfficient {

  private final Stack<Integer> mainStack;
  private final Stack<Integer> helperStack;

  public QueueWithStackRemoveEfficient() {
    this.mainStack = new Stack<>();
    this.helperStack = new Stack<>();
  }

  public void add(Integer data) {
    while (!mainStack.isEmpty()) {
      helperStack.push(mainStack.pop());
    }
    mainStack.push(data);
    while (!helperStack.isEmpty()) {
      mainStack.push(helperStack.pop());
    }
  }

  public Integer peek() {
    return mainStack.peek();
  }

  public Integer remove() {
    return mainStack.pop();
  }

  public int size() {
    return mainStack.size();
  }

  public static void main(String[] args) {
    var queue = new QueueWithStackRemoveEfficient();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.remove();
    queue.remove();
    queue.add(110);
    queue.add(120);
    System.out.println(queue.peek()); //
    System.out.println(queue.size());

    queue.remove();

    System.out.println(queue.peek());
    System.out.println(queue.size());
  }
}
