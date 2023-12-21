package com.github4sanjay.dsalgo.tree.bst;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;

public class ReplaceSumOfLarger {

  public static void replace(BinaryNode root) {
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
