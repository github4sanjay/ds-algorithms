package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.Stack;

/**
 * 1. You are given a partially written GenericTree class. 2. You are required to find the ceil and
 * floor value of a given element.
 *
 * <p>ceil is bigger and floor is smaller
 */
public class CeilAndFloor {

  public static Answer iterative(Node root, int data) {
    var stack = new Stack<Node>();
    stack.push(root);
    int floor = Integer.MIN_VALUE;
    int ceil = Integer.MAX_VALUE;
    while (!stack.isEmpty()) {
      var node = stack.pop();
      if (data > node.getData()) {
        floor = Math.max(floor, node.getData());
      }
      if (data < node.getData()) {
        ceil = Math.min(ceil, node.getData());
      }
      var children = node.getChildren();
      for (int i = children.size() - 1; i >= 0; i--) {
        var child = children.get(i);
        stack.push(child);
      }
    }
    return new Answer(ceil, floor);
  }

  public static Answer recursive(Node root, int data) {
    Answer answer = new Answer(Integer.MAX_VALUE, Integer.MIN_VALUE);
    recursive(root, data, answer);
    return answer;
  }

  private static void recursive(Node root, int data, Answer answer) {
    if (data > root.getData()) {
      answer.floor = Math.max(answer.floor, root.getData());
    }
    if (data < root.getData()) {
      answer.ceil = Math.min(answer.ceil, root.getData());
    }
    for (var child : root.getChildren()) {
      recursive(child, data, answer);
    }
  }

  public static class Answer {
    int ceil;
    int floor;

    public Answer() {}

    public Answer(int ceil, int floor) {
      this.ceil = ceil;
      this.floor = floor;
    }

    @Override
    public String toString() {
      return "Answer{" + "ceil=" + ceil + ", floor=" + floor + '}';
    }
  }
}
