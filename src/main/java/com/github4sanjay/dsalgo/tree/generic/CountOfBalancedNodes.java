package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;
import java.util.HashSet;

public class CountOfBalancedNodes {

  public static void main(String[] args) {
    int[] arr =
        new int[] {
          10, 20, -50, -1, 60, -1, -1, 30, 70, -1, -80, 110, -1, -120, -1, -1, 90, -1, -1, 40, -100,
          -1, -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);
    System.out.println(count(root));
  }

  static int count = 0;

  public static int count(Node root) {
    size(root);
    return count;
  }

  public static int size(Node root) {
    if (root == null) return 0;
    if (root.getChildren().isEmpty()) {
      count++;
      return 1;
    }

    var totalChildren = 0;
    var set = new HashSet<Integer>();
    for (var child : root.getChildren()) {
      totalChildren = totalChildren + size(child);
      set.add(totalChildren);
    }

    if (set.size() == 1) {
      count++;
    }
    return totalChildren + 1;
  }
}
