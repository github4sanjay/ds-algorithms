package com.github4sanjay.dsalgo.tree.generic;

import com.github4sanjay.dsalgo.tree.generic.structure.Node;

public class DiameterInGenericTree {

  public static Answer find(Node root) {
    var answer = new Answer(Integer.MIN_VALUE);
    find(root, answer);
    return answer;
  }

  private static int find(Node root, Answer answer) {

    int height = -1;

    int firstMaxHeight = 0;
    int secondMaxHeight = 0;
    for (var child : root.getChildren()) {
      height = Math.max(height, find(child, answer));
      if (height > firstMaxHeight) {
        secondMaxHeight = firstMaxHeight;
        firstMaxHeight = height;
      } else if (height > secondMaxHeight) {
        secondMaxHeight = height;
      }
    }
    answer.maxDiameter = Math.max(answer.maxDiameter, firstMaxHeight + secondMaxHeight + 2);
    return height + 1;
  }

  /**
   * Check this at every node maxDiameter = height of first longest + second longest child + 2
   * O(n^2)
   */
  private static void findNotEfficient(Node root, Answer answer) {

    int firstMaxHeight = 0;
    int secondMaxHeight = 0;
    for (var child : root.getChildren()) {
      int height = HeightGenericTree.find(child);
      if (height > firstMaxHeight) {
        firstMaxHeight = height;
        secondMaxHeight = firstMaxHeight;
      } else if (height > secondMaxHeight) {
        secondMaxHeight = height;
      }
    }
    answer.maxDiameter = Math.max(answer.maxDiameter, firstMaxHeight + secondMaxHeight + 2);
  }

  public static class Answer {
    int maxDiameter;

    public Answer(int maxDiameter) {
      this.maxDiameter = maxDiameter;
    }

    @Override
    public String toString() {
      return "Answer{" + "maxDiameter=" + maxDiameter + '}';
    }
  }
}
