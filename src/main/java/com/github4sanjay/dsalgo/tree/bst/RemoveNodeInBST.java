package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class RemoveNodeInBST {

  public static BinaryNode remove(BinaryNode root, int data) {
    if (root == null) return null;

    if (data < root.getData()) {
      root.setLeft(remove(root.getLeft(), data));
    } else if (data > root.getData()) {
      root.setRight(remove(root.getRight(), data));
    } else {
      if (root.getLeft() == null && root.getRight() == null) {
        return null;
      } else if (root.getLeft() == null) {
        return root.getRight();
      } else if (root.getRight() == null) {
        return root.getLeft();
      } else {
        var maxInLeft = MaxInBST.recursive(root.getLeft());
        root.setData(maxInLeft);
        remove(root.getLeft(), maxInLeft);
      }
    }
    return root;
  }
}
