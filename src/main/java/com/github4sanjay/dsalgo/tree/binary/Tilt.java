package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

/**
 * You are required to complete the body of tilt function. The function is expected to set the value
 * of data member "tilt". "tilt" of a node is the absolute value of difference between sum of nodes
 * in it's left subtree and right subtree. "tilt" of the whole tree is represented as the sum of
 * "tilt"s of all it's nodes.
 */
public class Tilt {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, n, 75, 62, n, 70, n, n, 87, n, n});
    System.out.println(Tilt.recursive(root));
  }

  private static int recursive(BinaryNode root) {
    var answer = new Answer();
    recursive(root, answer);
    return answer.tiltSum;
  }

  /**
   * calculate left sum and right sum then return by adding root.data tiltSum = tiltSum + (left sum
   * - right sum)
   */
  private static int recursive(BinaryNode root, Answer answer) {
    if (root == null) {
      return 0;
    }

    int leftSum = recursive(root.getLeft(), answer);
    int rightSum = recursive(root.getRight(), answer);

    answer.tiltSum = answer.tiltSum + Math.abs(leftSum - rightSum);
    ;
    return leftSum + rightSum + root.getData();
  }

  private static class Answer {
    int tiltSum;
  }
}
