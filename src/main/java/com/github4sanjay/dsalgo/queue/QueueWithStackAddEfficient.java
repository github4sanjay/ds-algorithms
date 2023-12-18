package com.github4sanjay.dsalgo.queue;

import java.util.Stack;

public class QueueWithStackAddEfficient {

  private final Stack<Integer> mainStack;
  private final Stack<Integer> helperStack;

  public QueueWithStackAddEfficient() {
    this.mainStack = new Stack<>();
    this.helperStack = new Stack<>();
  }

  public void add(Integer data) {
    mainStack.push(data);
  }

  public Integer peek() {
    while (mainStack.size() > 1) {
      helperStack.push(mainStack.pop());
    }

    var data = mainStack.pop();
    helperStack.push(data);

    while (!helperStack.isEmpty()) {
      mainStack.push(helperStack.pop());
    }
    return data;
  }

  public Integer remove() {
    while (mainStack.size() > 1) {
      helperStack.push(mainStack.pop());
    }

    var data = mainStack.pop();
    while (!helperStack.isEmpty()) {
      mainStack.push(helperStack.pop());
    }
    return data;
  }

  public int size() {
    return mainStack.size();
  }

  public static void main(String[] args) {
    var queue = new QueueWithStackAddEfficient();
    queue.add(10);
    queue.add(20);
    queue.add(30);
    queue.remove();
    queue.remove();
    queue.add(110);
    queue.add(120);
    System.out.println(queue.peek());
    System.out.println(queue.size());

    queue.remove();

    System.out.println(queue.peek());
    System.out.println(queue.size());
  }
}
