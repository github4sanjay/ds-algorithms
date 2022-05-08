package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

public class LCA {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, n, 75, 62, 60, n, n, 70, n, n, 87, n, n});
    System.out.println(LCA.find(root, 12, 30)); // 25
  }

  // find place where two diverge on left and right side
  private static int find(BinaryNode root, int first, int second) {

    if (first < root.getData() && second < root.getData()) { // when both smaller
      return find(root.getLeft(), first, second);
    } else if (first > root.getData() && second > root.getData()) { // when both large
      return find(root.getRight(), first, second);
    } else {
      return root.getData();
    }
  }
}
