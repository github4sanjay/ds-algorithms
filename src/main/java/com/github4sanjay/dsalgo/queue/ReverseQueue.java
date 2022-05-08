package com.github4sanjay.dsalgo.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

  public static <T> void reverse(Queue<T> queue) {
    Stack<T> stack = new Stack<>();
    while (!queue.isEmpty()) {
      stack.push(queue.remove());
    }
    while (!stack.empty()) {
      queue.offer(stack.pop());
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);
    System.out.println(queue);
    ReverseQueue.reverse(queue);
    System.out.println(queue);
  }
}
