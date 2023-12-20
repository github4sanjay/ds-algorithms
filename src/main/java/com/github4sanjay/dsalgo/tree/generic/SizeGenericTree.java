package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class SizeGenericTree {

  public static int find(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    int count = 0;
    while (!queue.isEmpty()) {
      var node = queue.poll();
      count++;
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
    }
    return count;
  }

  public static int findRecursion(Node root) {

    int count = 1;
    for (var child : root.getChildren()) {
      count = count + find(child);
    }
    return count;
  }
}
