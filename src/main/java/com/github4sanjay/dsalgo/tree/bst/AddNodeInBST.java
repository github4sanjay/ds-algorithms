package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class AddNodeInBST {

  public static BinaryNode add(BinaryNode root, int data) {
    if (root == null) {
      return new BinaryNode(data);
    }
    if (data < root.getData()) {
      root.setLeft(add(root.getLeft(), data));
    } else {
      root.setRight(add(root.getRight(), data));
    }
    return root;
  }
}
