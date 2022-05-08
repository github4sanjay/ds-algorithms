package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

public class Diameter {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, n, 75, 62, n, 70, n, n, 87, n, n});
    System.out.println(Diameter.recursive(root));
  }

  private static Answer recursive(BinaryNode root) {
    if (root == null) {
      var answer = new Answer();
      answer.maxHeight = -1;
      answer.maxDiameter = 0;
      return answer;
    }

    var leftAnswer = recursive(root.getLeft());
    var rightAnswer = recursive(root.getRight());

    var answer = new Answer();
    answer.maxDiameter =
        Math.max(
            Math.max(leftAnswer.maxDiameter, rightAnswer.maxDiameter),
            leftAnswer.maxHeight + rightAnswer.maxHeight + 2);
    answer.maxHeight = Math.max(leftAnswer.maxHeight, rightAnswer.maxHeight) + 1;
    return answer;
  }

  private static class Answer {
    int maxDiameter;
    int maxHeight;

    @Override
    public String toString() {
      return "Answer{" + "maxDiameter=" + maxDiameter + ", maxHeight=" + maxHeight + '}';
    }
  }
}
