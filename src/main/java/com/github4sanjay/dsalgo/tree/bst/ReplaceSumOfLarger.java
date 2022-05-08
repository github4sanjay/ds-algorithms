package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;
import com.github4sanjay.dsalgo.util.AlgoUtil;

public class ReplaceSumOfLarger {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(new int[] {50, 25, 12, n, n, 37, n, n, 75, 62, n, n, 87, n, n});
    BSTUtil.inOrder(root);
    System.out.println();
    ReplaceSumOfLarger.replace(root);
    AlgoUtil.print(BSTUtil.display(root));
  }

  private static void replace(BinaryNode root) {
    var answer = new Answer();
    answer.sum = 0;
    replace(root, answer);
  }

  // reverse in order and keep the sum
  private static void replace(BinaryNode root, Answer answer) {

    if (root == null) {
      return;
    }
    int rootData = root.getData();
    replace(root.getRight(), answer);
    root.setData(answer.sum);
    answer.sum = answer.sum + rootData;
    replace(root.getLeft(), answer);
  }

  private static class Answer {
    int sum;
  }
}
