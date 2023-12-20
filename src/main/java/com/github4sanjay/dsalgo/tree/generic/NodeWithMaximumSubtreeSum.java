package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class NodeWithMaximumSubtreeSum {

  public static Answer find(Node root) {
    var answer = new Answer(Integer.MIN_VALUE);
    find(root, answer);
    return answer;
  }

  /**
   * if sum of all children + root is greater than previous max then change and return the current
   * sum to previous to nodes
   */
  private static int find(Node root, Answer answer) {

    int tempSum = 0;
    for (var child : root.getChildren()) {
      tempSum = tempSum + find(child, answer);
    }

    int sum = tempSum + root.getData();
    if (sum > answer.maxSum) {
      answer.maxSum = sum;
      answer.node = root.getData();
    }
    return sum;
  }

  public static class Answer {
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
