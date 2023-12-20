package com.github4sanjay.dsalgo.tree.generic.structure;

import java.util.*;

public class GenericTreeUtil {

  public static class NodeAndChildren {
    int data;
    List<Integer> children;

    public NodeAndChildren(int data, List<Integer> children) {
      this.data = data;
      this.children = children;
    }

    @Override
    public String toString() {
      return "NodeAndChildren{" + "data=" + data + ", children=" + children + '}';
    }
  }

  public static List<NodeAndChildren> display(Node root) {
    ArrayList<NodeAndChildren> map = getNodeAndChildren(root);

    for (var nodeAndChildren : map) {
      System.out.println(nodeAndChildren.data + "--->" + nodeAndChildren.children);
    }
    return map;
  }

  private static ArrayList<NodeAndChildren> getNodeAndChildren(Node root) {
    var stack = new Stack<Node>();
    stack.push(root);
    var map = new ArrayList<NodeAndChildren>();
    while (!stack.isEmpty()) {
      var node = stack.pop();
      var list = new ArrayList<Integer>();
      var children = node.getChildren();
      for (int i = children.size() - 1; i >= 0; i--) { // add last (or rightmost) children first
        var child = children.get(i);
        stack.push(child);
      }
      for (var child : children) {
        list.add(child.getData());
      }

      map.add(new NodeAndChildren(node.getData(), list));
    }
    return map;
  }

  public static List<NodeAndChildren> displayRecursion(Node root) {
    var map = new ArrayList<NodeAndChildren>();
    displayRecursion(root, map);
    for (var nodeAndChildren : map) {
      System.out.println(nodeAndChildren.data + "--->" + nodeAndChildren.children);
    }
    return map;
  }

  private static void displayRecursion(Node root, List<NodeAndChildren> map) {
    var list = new ArrayList<Integer>();
    for (var child : root.getChildren()) {
      list.add(child.getData());
    }
    map.add(new NodeAndChildren(root.getData(), list));

    for (var child : root.getChildren()) {
      displayRecursion(child, map);
    }
  }

  public static Node createTree(int[] arr) {
    var stack = new Stack<Node>();
    Node root = null;
    for (int j : arr) {
      if (j == -1) {
        stack.pop();
      } else {
        var node = new Node();
        node.setData(j);

        if (stack.isEmpty()) {
          root = node;
        } else {
          var peekNode = stack.peek();
          peekNode.addChildren(node);
        }
        stack.push(node);
      }
    }

    return root;
  }
}
