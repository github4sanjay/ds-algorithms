package com.github4sanjay.dsalgo.dynamic.category6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
  Given an array arr[], where each element represents the maximum number of steps that can be made forward from that element,
  the task is to print all possible paths that require the minimum number of jumps to reach the end of the given array starting from the first array element.

  Note: If an element is 0, then there are no moves allowed from that element.

  Examples:

  Input: arr[] = {1, 1, 1, 1, 1}
  Output:
  0 ⇾ 1 ⇾ 2 ⇾ 3 ⇾4
  Explanation:
  In every step, only one jump is allowed.
  Therefore, only one possible path exists to reach end of the array.

  Input: arr[] = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}
  Output:
  0 ⇾ 3 ⇾ 5 ⇾ 6 ⇾ 9
  0 ⇾ 3 ⇾ 5 ⇾ 7 ⇾ 9
*/
public class FindAllPathsWithMinimumJumps {

  public static void main(String[] args) {
    System.out.println(FindAllPathsWithMinimumJumps.find(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
    System.out.println(FindAllPathsWithMinimumJumps.find(new int[] {1, 1, 1, 1, 1}));
  }

  private static class Node {
    int index;
    int ways;
    int jump;
    List<Integer> path;

    public Node(int index, int ways, int jump, List<Integer> path) {
      this.index = index;
      this.ways = ways;
      this.jump = jump;
      this.path = path;
    }
  }

  private static List<List<Integer>> find(int[] jumps) {

    Integer[] dp = new Integer[jumps.length];
    dp[jumps.length - 1] = 0;
    for (int i = dp.length - 2; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= jumps[i]; j++) {
        if (i + j >= dp.length) continue;
        if (dp[i + j] != null) {
          min = Math.min(min, dp[i + j]);
        }
      }
      if (min != Integer.MAX_VALUE) {
        dp[i] = min + 1;
      }
    }

    var list = new ArrayList<List<Integer>>();
    var queue = new LinkedList<Node>();
    var path = new ArrayList<Integer>();
    path.add(0);
    queue.push(new Node(0, dp[0], jumps[0], path));
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.ways == 0) {
        list.add(node.path);
      }
      for (int i = 1; i <= node.jump && node.index + i < dp.length; i++) {
        var currentIndex = node.index + i;

        // add node whose ways = (current node ways - 1)
        if (dp[currentIndex] != null && dp[currentIndex] == node.ways - 1) {
          var newPath = new ArrayList<>(node.path);
          newPath.add(node.index + i);
          queue.push(new Node(currentIndex, dp[currentIndex], jumps[currentIndex], newPath));
        }
      }
    }

    return list;
  }
}
