package com.github4sanjay.dsalgo.tree.binary;

import com.github4sanjay.dsalgo.tree.binary.structure.BinaryNode;
import com.github4sanjay.dsalgo.tree.binary.structure.BinaryTreeUtil;

/**
 * You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node
 * has a value greater than all nodes on it's left side and smaller value than all node on it's
 * right side.
 */
public class LargestBstSubtree {

  public static void main(String[] args) {
    int n = -1;
    var root =
        BinaryTreeUtil.create(new int[] {50, 25, 12, n, n, 37, n, n, 75, 62, n, n, 87, n, n});
    var answer = LargestBstSubtree.recursive(root);
    System.out.println(
        "Node containing largest BST : "
            + answer.node.getData()
            + " and number of nodes : "
            + answer.noOfNodes);

    var root1 =
        BinaryTreeUtil.create(
            new int[] {50, 25, 12, n, n, 37, 30, n, n, 51, n, n, 75, 62, 60, n, n, 70, n, n, n});
    var answer1 = LargestBstSubtree.recursive(root1);
    System.out.println(
        "Node containing largest BST : "
            + answer1.node.getData()
            + " and number of nodes : "
            + answer1.noOfNodes);
  }

  private static Answer recursive(BinaryNode root) {
    if (root == null) {
      var answer = new Answer();
      answer.isBST = true;
      answer.max = Integer.MIN_VALUE;
      answer.min = Integer.MAX_VALUE;
      return answer;
    }

    var leftAnswer = recursive(root.getLeft());
    var rightAnswer = recursive(root.getRight());

    var answer = new Answer();
    answer.isBST =
        leftAnswer.isBST
            && rightAnswer.isBST
            && root.getData() > leftAnswer.max
            && root.getData() < rightAnswer.min;
    answer.min = Math.min(root.getData(), Math.min(leftAnswer.min, rightAnswer.min));
    answer.max = Math.max(root.getData(), Math.max(leftAnswer.max, rightAnswer.max));

    if (answer.isBST) {
      answer.node = root;
      answer.noOfNodes = 1 + leftAnswer.noOfNodes + rightAnswer.noOfNodes;
    } else if (leftAnswer.noOfNodes > rightAnswer.noOfNodes) {
      answer.node = leftAnswer.node;
      answer.noOfNodes = leftAnswer.noOfNodes;
    } else {
      answer.node = rightAnswer.node;
      answer.noOfNodes = rightAnswer.noOfNodes;
    }
    return answer;
  }

  private static class Answer {
    int max;
    int min;
    int noOfNodes; // size of largest BST in current node
    BinaryNode node; // node containing largest BST
    boolean isBST;

    @Override
    public String toString() {
      return "Answer{"
          + "max="
          + max
          + ", min="
          + min
          + ", noOfNodes="
          + noOfNodes
          + ", node="
          + node
          + ", isBST="
          + isBST
          + '}';
    }
  }
}
