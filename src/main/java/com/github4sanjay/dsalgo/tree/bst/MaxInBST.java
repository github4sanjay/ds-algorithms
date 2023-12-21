package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class MaxInBST {

  public static int recursive(BinaryNode root) {
    if (root.getRight() == null) {
      return root.getData();
    } else {
      return recursive(root.getRight());
    }
  }
}
