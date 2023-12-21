package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class SumOfBST {

  public static int recursive(BinaryNode root) {
    if (root == null) {
      return 0;
    }
    var leftSum = recursive(root.getLeft());
    var rightSum = recursive(root.getRight());
    return leftSum + rightSum + root.getData();
  }
}
