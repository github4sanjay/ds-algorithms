package com.github4sanjay.dsalgo.dynamic.category6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Question
  1. You are given a number n, representing the count of items.
  2. You are given n numbers, representing the values of n items.
  3. You are given n numbers, representing the weights of n items.
  3. You are given a number "cap", which is the capacity of a bag you've.
  4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
  5. Also, you have to print the indices of items that should be selected to make maximum profit.
  6. You have to print all such configurations.

 Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item again and again

 Input Format
  A number n
  A number m
  e11
  e12..
  e21
  e22..
  .. n * m number of elements

 Sample Input
  5
  15 14 10 45 30
  2 5 1 3 4
  7
 Sample Output
  75
  3 4
*/
public class FindAllResultsIn01Knapsack {

  public static void main(String[] args) {
    // System.out.println(FindAllResultsIn01Knapsack.find(new int[]{15, 14, 10, 45, 30}, new
    // int[]{2, 5, 1, 3, 4}, 7));
    System.out.println(
        FindAllResultsIn01Knapsack.find(
            new int[] {15, 14, 10, 45, 30, 75}, new int[] {2, 5, 1, 3, 4, 7}, 7));
  }

  private static Answer find(int[] items, int[] weights, int cap) {
    int[][] dp = new int[items.length + 1][cap + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (j - weights[i - 1] < 0) { // weight is greater than capacity
          int ifNotTaken = dp[i - 1][j];
          dp[i][j] = ifNotTaken;
        } else {
          int ifTaken = dp[i - 1][j - weights[i - 1]] + items[i - 1];
          int ifNotTaken = dp[i - 1][j];
          dp[i][j] = Math.max(ifNotTaken, ifTaken);
        }
      }
    }

    var list = new ArrayList<List<Integer>>();
    var queue = new LinkedList<Node>();
    queue.push(new Node(dp.length - 1, dp[0].length - 1, new ArrayList<>()));
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.col == 0 || node.row == 0) {
        list.add(node.pathSoFar);
      } else {
        int ifTaken = dp[node.row - 1][node.col - weights[node.row - 1]] + items[node.row - 1];
        int ifNotTaken = dp[node.row - 1][node.col];
        if (dp[node.row][node.col] == ifTaken && dp[node.row][node.col] == ifNotTaken) {
          var newPathIfTaken = new ArrayList<>(node.pathSoFar);
          newPathIfTaken.add(node.row - 1);
          queue.add(new Node(node.row - 1, node.col - weights[node.row - 1], newPathIfTaken));

          var newPathIfNotTaken = new ArrayList<>(node.pathSoFar);
          queue.add(new Node(node.row - 1, node.col, newPathIfNotTaken));
        } else if (dp[node.row][node.col] == ifNotTaken) {
          var newPath = new ArrayList<>(node.pathSoFar);
          queue.add(new Node(node.row - 1, node.col, newPath));
        } else {
          var newPath = new ArrayList<>(node.pathSoFar);
          newPath.add(node.row - 1);
          queue.add(new Node(node.row - 1, node.col - weights[node.row - 1], newPath));
        }
      }
    }
    return new Answer(dp[dp.length - 1][dp[0].length - 1], list);
  }

  public static class Answer {
    int max;
    List<List<Integer>> itemIndexes;

    public Answer(int max, List<List<Integer>> itemIndexes) {
      this.max = max;
      this.itemIndexes = itemIndexes;
    }

    @Override
    public String toString() {
      return "Answer{" + "max=" + max + ", itemIndexes=" + itemIndexes + '}';
    }
  }

  public static class Node {
    int row;
    int col;
    List<Integer> pathSoFar;

    public Node(int row, int col, List<Integer> pathSoFar) {
      this.row = row;
      this.col = col;
      this.pathSoFar = pathSoFar;
    }
  }
}
