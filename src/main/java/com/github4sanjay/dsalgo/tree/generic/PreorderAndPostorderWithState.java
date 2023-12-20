package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderAndPostorderWithState {

  /*
   * if state = -1, put in preorder
   * if state == children.size put in postorder and pop
   * else keep on pushing children from position pair.state
   */
  public static Answer traverse(Node root) {
    var answer = new Answer();
    var stack = new Stack<Pair>();
    stack.push(new Pair(root, -1));
    while (!stack.isEmpty()) {
      var node = stack.peek();
      var children = node.node.getChildren();
      if (node.state == -1) {
        answer.addPreorder(node.node.getData());
        node.state = 0; // set to push for first child
      } else if (node.state == children.size()) {
        stack.pop();
        answer.addPostorder(node.node.getData());
      } else {
        stack.push(new Pair(children.get(node.state), -1));
        node.state = node.state + 1; // increase for next child
      }
    }
    return answer;
  }

  private static class Pair {
    Node node;
    int state;

    public Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static class Answer {
    List<Integer> preorder;
    List<Integer> postorder;

    public Answer() {
      this.preorder = new ArrayList<>();
      this.postorder = new ArrayList<>();
    }

    public void addPreorder(int data) {
      preorder.add(data);
    }

    public void addPostorder(int data) {
      postorder.add(data);
    }

    @Override
    public String toString() {
      return "Answer{" + "preorder=" + preorder + ", postorder=" + postorder + '}';
    }
  }
}
