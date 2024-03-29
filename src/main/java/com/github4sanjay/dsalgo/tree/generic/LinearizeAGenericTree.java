package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.Stack;

/** Preorder lenearize */
public class LinearizeAGenericTree {

  /** During pre order save the last node and add current node as children to previous node */
  public static void lenearize(Node root) {
    var stack = new Stack<Node>();
    stack.push(root);
    Node prev = null;
    while (!stack.isEmpty()) {
      var node = stack.pop();
      if (prev != null) {
        prev.addChildren(node);
      }
      prev = node;
      var children = node.getChildren();
      for (int i = children.size() - 1; i >= 0; i--) {
        stack.push(children.get(i));
        children.remove(i);
      }
    }
  }

  // O(n^2)
  public static void recursion(Node root) {
    for (var child : root.getChildren()) {
      recursion(child);
    }
    var children = root.getChildren();
    while (children.size() > 1) {
      var lastChild = children.remove(children.size() - 1);
      var secondLastChild = children.get(children.size() - 1);
      var secondLastChildTail = getTail(secondLastChild);
      secondLastChildTail.addChildren(lastChild);
    }
  }

  private static Node getTail(Node node) {
    while (node.getChildren().size() == 1) {
      node = node.getChildren().get(0);
    }
    return node;
  }
}
