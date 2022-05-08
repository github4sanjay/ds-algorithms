package com.github4sanjay.dsalgo.queue;

import java.util.LinkedList;
import java.util.Queue;

/** pop efficient */
public class StackWithQueuePopEfficient {

  private final Queue<Integer> mainQueue;
  private final Queue<Integer> helperQueue;

  public StackWithQueuePopEfficient() {
    this.mainQueue = new LinkedList<>();
    this.helperQueue = new LinkedList<>();
  }

  public boolean isEmpty() {
    return mainQueue.isEmpty();
  }

  public int size() {
    return mainQueue.size();
  }

  public int peek() {
    return mainQueue.peek();
  }

  public int pop() {
    return mainQueue.remove();
  }

  /**
   * if q1 is empty add it else remove all elements from q1 to q2 add data in q1 and then add back
   * all the elements from q2 to q1
   */
  public void push(int data) {
    while (!mainQueue.isEmpty()) {
      helperQueue.add(mainQueue.remove());
    }
    mainQueue.add(data);
    while (!helperQueue.isEmpty()) {
      mainQueue.add(helperQueue.remove());
    }
  }

  public static void main(String[] args) {
    var stack = new StackWithQueuePopEfficient();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop()); // 2
    stack.push(4);
    stack.push(3);
    System.out.println(stack.pop()); // 3
    System.out.println(stack.pop()); // 4
  }
}
