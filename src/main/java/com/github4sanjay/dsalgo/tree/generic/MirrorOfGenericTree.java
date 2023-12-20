package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.Collections;
import java.util.LinkedList;

public class MirrorOfGenericTree {

  public static void mirror(Node root) {
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

  public static void mirrorRecursion(Node root) {
    for (var child : root.getChildren()) {
      mirrorRecursion(child);
    }
    var children = root.getChildren();
    Collections.reverse(children);
  }
}
