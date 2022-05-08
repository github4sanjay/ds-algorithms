package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.GenericTreeUtil;
import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class NodeWithMaximumSubtreeSum {

  public static void main(String[] args) {
    int[] arr =
        new int[] {
          10, 20, -50, -1, 60, -1, -1, 30, -70, -1, 80, -1, 90, -1, -1, 40, -100, -1, -1, -1
        };
    var root = GenericTreeUtil.createTree(arr);
    System.out.println(NodeWithMaximumSubtreeSum.find(root));
  }

  private static Answer find(Node root) {
    var answer = new Answer(Integer.MIN_VALUE);
    find(root, 0, answer);
    return answer;
  }

  /**
   * if sum of all children + root is greater than previous max then change and return the current
   * sum to previous to nodes
   */
  private static int find(Node root, int sum, Answer answer) {

    int tempSum = 0;
    for (var child : root.getChildren()) {
      tempSum = tempSum + find(child, sum, answer);
    }

    sum = tempSum + root.getData();
    if (sum > answer.maxSum) {
      answer.maxSum = sum;
      answer.node = root.getData();
    }
    return sum;
  }

  private static class Answer {
    int maxSum;
    int node;

    public Answer(int maxSum) {
      this.maxSum = maxSum;
    }

    @Override
    public String toString() {
      return "Answer{" + "maxSum=" + maxSum + ", node=" + node + '}';
    }
  }
}
