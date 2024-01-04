package com.github4sanjay.dsalgo.dynamic.printresults;

import com.github4sanjay.dsalgo.util.AlgoUtil;
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

  public static int recursion(int[] items, int[] weights, int cap) {
    return recursion(items, weights, cap, weights.length - 1);
  }

  private static int recursion(int[] items, int[] weights, int cap, int index) {
    if (index == 0) {
      if (cap >= weights[index]) {
        return items[index];
      } else {
        return 0;
      }
    }
    var notTake = recursion(items, weights, cap, index - 1);
    var take = Integer.MIN_VALUE;
    if (weights[index] <= cap) {
      take = items[index] + recursion(items, weights, cap - weights[index], index - 1);
    }
    return Math.max(take, notTake);
  }

  public static int memoization(int[] items, int[] weights, int cap) {
    var dp = new Integer[weights.length][cap + 1];
    dp[weights.length - 1][cap] = memoization(items, weights, weights.length - 1, cap, dp);
    return dp[weights.length - 1][cap];
  }

  private static int memoization(int[] items, int[] weights, int index, int cap, Integer[][] dp) {
    if (index == 0) {
      if (cap >= weights[index]) {
        return items[index];
      } else {
        return 0;
      }
    }
    if (dp[index][cap] != null) {
      return dp[index][cap];
    }
    var notTake = memoization(items, weights, index - 1, cap, dp);
    var take = Integer.MIN_VALUE;
    if (weights[index] <= cap) {
      take = items[index] + memoization(items, weights, index - 1, cap - weights[index], dp);
    }
    dp[index][cap] = Math.max(take, notTake);
    return dp[index][cap];
  }

  public static int tabulation(int[] items, int[] weights, int cap) {
    var dp = new Integer[weights.length][cap + 1];
    dp[weights.length - 1][cap] = tabulation(items, weights, weights.length - 1, cap, dp);
    return dp[weights.length - 1][cap];
  }

  private static int tabulation(int[] items, int[] weights, int INDEX, int CAP, Integer[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int cap = 0; cap <= CAP; cap++) {
        if (cap == 0) {
          dp[index][cap] = 0;
          continue;
        }
        if (index == 0) {
          if (cap >= weights[index]) {
            dp[index][cap] = items[index];
          } else {
            dp[index][cap] = 0;
          }
          continue;
        }

        var notTake = memoization(items, weights, index - 1, cap, dp);
        var take = Integer.MIN_VALUE;
        if (weights[index] <= cap) {
          take = items[index] + memoization(items, weights, index - 1, cap - weights[index], dp);
        }
        dp[index][cap] = Math.max(take, notTake);
      }
    }
    return dp[INDEX][CAP];
  }

  /*
   *       0  1   2   3   4   5   6  7
   * 5  2 [0, 0, 15, 15, 15, 15, 15, 15]
   * 14 5 [0, 0, 15, 15, 15, 15, 15, 29]
   * 10 1 [0, 10, 15, 25, 25, 25, 25, 29]
   * 45 3 [0, 10, 15, 45, 55, 60, 70, 70]
   * 30 4 [0, 10, 15, 45, 55, 60, 70, 75]
   */
  public static Answer find(int[] items, int[] weights, int cap) {
    var dp = new Integer[weights.length][cap + 1];
    dp[weights.length - 1][cap] = tabulation(items, weights, weights.length - 1, cap, dp);

    AlgoUtil.print(dp);
    var queue = new LinkedList<Node>();
    var path = new ArrayList<List<Integer>>();
    queue.add(new Node(weights.length - 1, cap, new ArrayList<>()));
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.col == 0) {
        path.add(node.pathSoFar);
      } else {
        int ifTaken = dp[node.row - 1][node.col - weights[node.row]] + items[node.row];
        int ifNotTaken = dp[node.row - 1][node.col];
        if (dp[node.row][node.col] == ifNotTaken && dp[node.row][node.col] == ifTaken) {
          var newPathIfTaken = new ArrayList<>(node.pathSoFar);
          newPathIfTaken.add(node.row);
          queue.add(new Node(node.row - 1, node.col - weights[node.row], newPathIfTaken));

          var newPathIfNotTaken = new ArrayList<>(node.pathSoFar);
          queue.add(new Node(node.row - 1, node.col, newPathIfNotTaken));
        } else if (dp[node.row][node.col] == ifNotTaken) {
          var newPathIfNotTaken = new ArrayList<>(node.pathSoFar);
          queue.add(new Node(node.row - 1, node.col, newPathIfNotTaken));
        } else {
          var newPathIfTaken = new ArrayList<>(node.pathSoFar);
          newPathIfTaken.add(node.row);
          queue.add(new Node(node.row - 1, node.col - weights[node.row], newPathIfTaken));
        }
      }
    }
    return new Answer(dp[weights.length - 1][cap], path);
  }

  public static Answer findWithExtra0(int[] items, int[] weights, int cap) {
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
    queue.push(new Node(dp.length - 1, dp[0].length - 1, new ArrayList<Integer>()));
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
