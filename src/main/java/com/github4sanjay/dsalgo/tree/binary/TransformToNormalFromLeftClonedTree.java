package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import com.github4sanjay.dsalgo.util.AlgoUtil;

/**
 * You are required to complete the body of transBackFromLeftClonedTree function. The function is
 * expected to convert a left-cloned tree back to it's original form. In a left-clone tree a new
 * node for every node equal in value to it is inserted between itself and it's left child.
 */
public class TransformToNormalFromLeftClonedTree {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {
              50, 50, 25, 25, 12, 12, n, n, n, n, 37, 37, 30, 30, n, n, n, n, n, n, 75, 75, 62, 62,
              n, n, 70, 70, n, n, n, n, 87, 87, n, n, n
            });
    AlgoUtil.print(BinaryTreeUtil.display(root));
    System.out.println();

    TransformToNormalFromLeftClonedTree.recursive(root);
    AlgoUtil.print(BinaryTreeUtil.display(root));
  }

  private static void recursive(BinaryNode root) {
    if (root == null) {
      return;
    }
    if (root.getLeft() != null) {
      root.setLeft(root.getLeft().getLeft());
      recursive(root.getLeft());
    }

    if (root.getRight() != null) {
      recursive(root.getRight());
    }
  }
}
