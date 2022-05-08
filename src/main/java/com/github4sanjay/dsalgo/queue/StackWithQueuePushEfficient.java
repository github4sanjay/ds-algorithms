package com.github4sanjay.dsalgo.queue;

import java.util.LinkedList;
import java.util.Queue;

/** Push efficient */
public class StackWithQueuePushEfficient {

  private final Queue<Integer> mainQueue;
  private final Queue<Integer> helperQueue;

  public StackWithQueuePushEfficient() {
    this.mainQueue = new LinkedList<>();
    this.helperQueue = new LinkedList<>();
  }

  public boolean isEmpty() {
    return mainQueue.isEmpty();
  }

  public int size() {
    return mainQueue.size();
  }

  public int pop() {
    while (mainQueue.size() > 1) {
      helperQueue.add(mainQueue.remove());
    }
    int data = mainQueue.remove();
    while (helperQueue.size() > 0) {
      mainQueue.add(helperQueue.remove());
    }
    return data;
  }

  public int top() {
    while (mainQueue.size() > 1) {
      helperQueue.add(mainQueue.remove());
    }
    int data = mainQueue.remove();
    helperQueue.add(data);
    while (helperQueue.size() > 0) {
      mainQueue.add(helperQueue.remove());
    }
    return data;
  }

  public void push(int data) {
    mainQueue.add(data);
  }

  public static void main(String[] args) {
    var stack = new StackWithQueuePushEfficient();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop()); // 2
    stack.push(4);
    stack.push(3);
    System.out.println(stack.pop()); // 3
    System.out.println(stack.pop()); // 4
    System.out.println(stack.top()); // 1
  }
}
