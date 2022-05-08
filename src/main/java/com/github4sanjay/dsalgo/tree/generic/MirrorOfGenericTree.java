package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.Collections;
import java.util.LinkedList;

public class MirrorOfGenericTree {

  public static void main(String[] args) {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    GenericTreeUtil.display(root);
    MirrorOfGenericTree.mirror(root);
    GenericTreeUtil.display(root);
  }

  private static void mirror(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      Collections.reverse(node.getChildren());
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
    }
  }

  private static void mirrorRecursion(Node root) {
    for (var child : root.getChildren()) {
      mirrorRecursion(child);
    }
    var children = root.getChildren();
    Collections.reverse(children);
  }
}
