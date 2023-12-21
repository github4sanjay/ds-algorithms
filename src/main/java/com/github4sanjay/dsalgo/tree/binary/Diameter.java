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

  public static int recursive(BinaryNode root) {
    var answer = new Answer();
    answer.maxDiameter = Integer.MIN_VALUE;
    recursive(root, answer);
    return answer.maxDiameter;
  }

  private static int recursive(BinaryNode root, Answer answer) {
    if (root == null) {
      return -1;
    }

    var leftHeight = recursive(root.getLeft(), answer);
    var rightHeight = recursive(root.getRight(), answer);

    answer.maxDiameter = Math.max(answer.maxDiameter, leftHeight + rightHeight + 2);
    return Math.max(leftHeight, rightHeight) + 1;
  }

  private static class Answer {
    int maxDiameter;

    @Override
    public String toString() {
      return "Answer{" + "maxDiameter=" + maxDiameter + '}';
    }
  }
}
