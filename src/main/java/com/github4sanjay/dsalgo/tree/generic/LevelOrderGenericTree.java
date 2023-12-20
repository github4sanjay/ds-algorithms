package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderGenericTree {

  // use queue
  public static List<Integer> traverse(Node root) {
    var queue = new LinkedList<Node>();
    queue.offer(root);
    var list = new ArrayList<Integer>();
    while (!queue.isEmpty()) {
      var node = queue.poll();
      list.add(node.getData());
      for (var child : node.getChildren()) {
        queue.offer(child);
      }
    }
    return list;
  }
}
