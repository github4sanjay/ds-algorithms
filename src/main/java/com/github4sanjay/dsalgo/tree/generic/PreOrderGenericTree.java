package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderGenericTree {

  public static void main(String[] args) {
    var root =
        GenericTreeUtil.createTree(new int[] {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
    System.out.println(PreOrderGenericTree.traverse(root));
    System.out.println(PreOrderGenericTree.traverseRecursion(root));
  }

  private static List<Integer> traverse(Node root) {
    var stack = new Stack<Node>();
    stack.push(root);
    var list = new ArrayList<Integer>();
    while (!stack.isEmpty()) {
      var node = stack.pop();
      list.add(node.getData());
      var children = node.getChildren();
      for (int i = children.size() - 1; i >= 0; i--) { // add last (or rightmost) children first
        stack.push(children.get(i));
      }
    }
    return list;
  }

  private static List<Integer> traverseRecursion(Node root) {
    var list = new ArrayList<Integer>();
    traverseRecursion(root, list);
    return list;
  }

  private static void traverseRecursion(Node root, List<Integer> list) {
    list.add(root.getData());
    for (var child : root.getChildren()) {
      traverseRecursion(child, list);
    }
  }
}
