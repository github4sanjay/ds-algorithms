package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class SizeOfBST {

  public static int recursive(BinaryNode root) {
    if (root == null) {
      return 0;
    }
    var leftSize = recursive(root.getLeft());
    var rightSize = recursive(root.getRight());
    return leftSize + rightSize + 1;
  }
}
