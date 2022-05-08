package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class SumOfBST {

  public static void main(String[] args) {
    var root = BSTUtil.create(new int[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(SumOfBST.recursive(root)); // 28
  }

  private static int recursive(BinaryNode root) {
    if (root == null) {
      return 0;
    }
    var leftSum = recursive(root.getLeft());
    var rightSum = recursive(root.getRight());
    return leftSum + rightSum + root.getData();
  }
}
