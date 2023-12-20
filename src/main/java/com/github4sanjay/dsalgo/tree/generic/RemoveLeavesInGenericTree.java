package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class RemoveLeavesInGenericTree {

  // remove from behind so that indexes in front will not be effected
  public static void remove(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
      var children = node.getChildren();
      for (int i = children.size() - 1; i >= 0; i--) {
        var child = children.get(i);
        if (child.getChildren().isEmpty()) {
          children.remove(child);
        }
      }
    }
  }

  public static void removeRecursion(Node root) {
    var children = root.getChildren();

    for (int i = children.size() - 1; i >= 0; i--) {
      var child = children.get(i);
      if (child.getChildren().isEmpty()) {
        children.remove(child);
      }
    }

    for (var child : children) {
      removeRecursion(child);
    }
  }
}
