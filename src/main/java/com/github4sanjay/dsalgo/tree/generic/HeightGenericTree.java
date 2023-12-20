package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class HeightGenericTree {

  public static int find(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    queue.offer(null);
    int height = -1; // for edge height (keep 0 if want node height)
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        for (var child : node.getChildren()) {
          queue.offer(child);
        }
      } else {
        height++;
        if (!queue.isEmpty()) { // don't add if empty
          queue.offer(null);
        }
      }
    }
    return height;
  }

  public static int findRecursion(Node root) {
    int height = -1; // 0 if nodes height
    for (var child : root.getChildren()) {
      height = Math.max(height, find(child));
    }
    return height + 1;
  }
}
