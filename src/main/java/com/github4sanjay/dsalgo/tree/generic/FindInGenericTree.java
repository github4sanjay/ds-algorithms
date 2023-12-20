package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class FindInGenericTree {

  public static boolean find(Node root, int find) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node.getData() == find) {
        return true;
      }
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
    }
    return false;
  }

  public static boolean findRecursion(Node root, int find) {
    if (root.getData() == find) {
      return true;
    }
    for (var child : root.getChildren()) {
      if (findRecursion(child, find)) {
        return true;
      }
    }
    return false;
  }
}
