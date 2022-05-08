package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.util.LinkedList;

public class RemoveLeaves {

  public static void main(String[] args) {
    var root1 =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    RemoveLeaves.recursive(root1);
    AlgoUtil.print(BinaryTreeUtil.display(root1));

    var root2 =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    RemoveLeaves.iterative(root2);
    AlgoUtil.print(BinaryTreeUtil.display(root2));
  }

  private static void iterative(BinaryNode root) {
    var queue = new LinkedList<BinaryNode>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();

      if (node.getLeft() != null) {
        var leftNode = node.getLeft();
        if (leftNode.getRight() == null && leftNode.getLeft() == null) {
          node.setLeft(null);
        } else {
          queue.offer(node.getLeft());
        }
      }

      if (node.getRight() != null) {
        var rightNode = node.getRight();
        if (rightNode.getRight() == null && rightNode.getLeft() == null) {
          node.setRight(null);
        } else {
          queue.offer(node.getRight());
        }
      }
    }
  }

  private static void recursive(BinaryNode root) {
    if (root == null) return;

    if (root.getLeft() != null) {
      var leftNode = root.getLeft();
      if (leftNode.getRight() == null && leftNode.getLeft() == null) {
        root.setLeft(null);
      } else {
        recursive(root.getLeft());
      }
    }

    if (root.getRight() != null) {
      var rightNode = root.getRight();
      if (rightNode.getRight() == null && rightNode.getLeft() == null) {
        root.setRight(null);
      } else {
        recursive(root.getRight());
      }
    }
  }
}
