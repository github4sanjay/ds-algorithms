package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import java.util.Stack;

public class MaxBinaryTree {

  public static void main(String[] args) {
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, -1, -1, 37, 30, -1, -1, -1, 75, 62, -1, 70, -1, -1, 87, -1, -1});
    System.out.println(MaxBinaryTree.recursive(root));
    System.out.println(MaxBinaryTree.iterative(root));
  }

  // preorder
  private static int iterative(BinaryNode root) {
    if (root == null) return 0;
    var stack = new Stack<BinaryNode>();
    stack.push(root);
    int max = Integer.MIN_VALUE;
    while (!stack.isEmpty()) {
      var node = stack.pop();
      max = Math.max(max, node.getData());
      if (node.getRight() != null) {
        stack.push(node.getRight());
      }
      if (node.getLeft() != null) {
        stack.push(node.getLeft());
      }
    }
    return max;
  }

  private static int recursive(BinaryNode root) {
    if (root == null) {
      return Integer.MIN_VALUE;
    }
    int maxLeft = recursive(root.getLeft());
    int maxRight = recursive(root.getRight());
    return Math.max(Math.max(maxLeft, maxRight), root.getData());
  }
}
