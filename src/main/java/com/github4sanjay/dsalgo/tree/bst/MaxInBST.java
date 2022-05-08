package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class MaxInBST {

  public static void main(String[] args) {
    var root = BSTUtil.create(new int[] {1, 2, 3, 4, 5, 6, 7});
    System.out.println(MaxInBST.recursive(root)); // 7
  }

  public static int recursive(BinaryNode root) {
    if (root.getRight() == null) {
      return root.getData();
    } else {
      return recursive(root.getRight());
    }
  }
}
