package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class DistanceBetweenNodes {

  public static int recursion(Node root, int first, int second) {
    var path1 = NodeToRootPathGenericTree.recursion(root, first);
    var path2 = NodeToRootPathGenericTree.recursion(root, second);
    int i = path1.size() - 1;
    int j = path2.size() - 1;
    while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j))) {
      i--;
      j--;
    }
    i++;
    j++;
    return i + j;
  }
}
