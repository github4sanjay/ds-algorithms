package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

/**
 * You are required to check if the tree is balanced. A binary tree is balanced if for every node
 * the gap between height's of it's left and right subtree is not more than 1.
 */
public class IsBalanced {

  public static void main(String[] args) {
    int n = -1;

    var root =
        BinaryTreeUtil.create(new int[] {50, 25, 12, n, n, 37, n, n, 75, 62, n, n, 87, n, n});
    System.out.println(IsBalanced.recursive(root));

    var root1 =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, 51, n, n, 75, 62, 60, n, n, 70, n, n, n});
    System.out.println(IsBalanced.recursive(root1));
  }

  private static Answer recursive(BinaryNode root) {
    if (root == null) {
      var answer = new Answer();
      answer.isBalanced = true;
      answer.height = -1;
      return answer;
    }

    var leftAnswer = recursive(root.getLeft());
    var rightAnswer = recursive(root.getRight());

    var answer = new Answer();
    answer.isBalanced =
        leftAnswer.isBalanced
            && rightAnswer.isBalanced
            && Math.abs(leftAnswer.height - rightAnswer.height) <= 1;
    answer.height = Math.max(leftAnswer.height, rightAnswer.height) + 1;
    return answer;
  }

  private static class Answer {
    int height;
    boolean isBalanced;

    @Override
    public String toString() {
      return "Answer{" + "height=" + height + ", isBalanced=" + isBalanced + '}';
    }
  }
}
