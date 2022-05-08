package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class LowestCommonAncestorGenericTree {

  public static void main(String[] args) {
    var root =
        GenericTreeUtil.createTree(
            new int[] {
              10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100,
              -1, -1, -1
            });
    System.out.println(LowestCommonAncestorGenericTree.recursion(root, 120, 80));
  }

  private static int recursion(Node root, int first, int second) {
    var path1 = NodeToRootPathGenericTree.recursion(root, first);
    var path2 = NodeToRootPathGenericTree.recursion(root, second);
    int i = path1.size() - 1;
    int j = path2.size() - 1;
    while (i >= 0 && j >= 0 && path1.get(i).equals(path2.get(j))) {
      i--;
      j--;
    }
    return path1.get(i + 1);
  }
}
