package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.LinkedList;

public class RemoveLeavesInGenericTree {

  public static void main(String[] args) {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    GenericTreeUtil.display(root);
    RemoveLeavesInGenericTree.remove(root);
    GenericTreeUtil.display(root);
  }

  // remove from behind so that indexes in front will not be effected
  private static void remove(Node root) {
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
        if (child.getChildren().size() == 0) {
          children.remove(child);
        }
      }
    }
  }

  private static void removeRecursion(Node root) {
    for (var child : root.getChildren()) {
      removeRecursion(child);
    }
    var children = root.getChildren();
    for (int i = children.size() - 1; i >= 0; i--) {
      var child = children.get(i);
      if (child.getChildren().size() == 0) {
        children.remove(child);
      }
    }
  }
}
