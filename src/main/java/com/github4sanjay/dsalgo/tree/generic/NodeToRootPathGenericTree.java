package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.ArrayList;
import java.util.List;

public class NodeToRootPathGenericTree {

  public static List<Integer> recursion(Node root, int find) {
    if (root.getData() == find) {
      var path = new ArrayList<Integer>();
      path.add(root.getData());
      return path;
    }
    for (var child : root.getChildren()) {
      var path = recursion(child, find);
      if (!path.isEmpty()) {
        path.add(root.getData());
        return path;
      }
    }
    return new ArrayList<>();
  }
}
