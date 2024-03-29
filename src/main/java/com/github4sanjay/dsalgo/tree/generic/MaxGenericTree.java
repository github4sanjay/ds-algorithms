package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class MaxGenericTree {

  public static int find(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    int max = Integer.MIN_VALUE;
    while (!queue.isEmpty()) {
      var node = queue.poll();
      max = Math.max(max, node.getData());
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
    }
    return max;
  }

  public static int findRecursion(Node root) {
    return findRecursion(root, Integer.MIN_VALUE);
  }

  private static int findRecursion(Node root, int max) {

    for (var child : root.getChildren()) {
      max = Math.max(max, find(child));
    }
    return Math.max(max, root.getData());
  }
}
