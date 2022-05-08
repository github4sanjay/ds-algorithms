package com.github4sanjay.dsalgo.dynamic.category1;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
 * cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost
 * to traverse through that cell. The total cost of a path to reach (m, n) is the sum of all the
 * costs on that path (including both source and destination). You can only traverse down, right and
 * diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i,
 * j+1), and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 */
public class MazeTraversalMinCost {

  public static void main(String[] args) {
    int[][] cost = {
      {1, 2, 3},
      {4, 8, 2},
      {1, 5, 3}
    };

    System.out.println(minCost(cost));
  }

  private static int minCost(int[][] cost) {
    int[][] dp = new int[cost.length][cost[0].length];
    dp[cost.length - 1][cost[0].length - 1] = cost[cost.length - 1][cost[0].length - 1];

    for (int i = cost.length - 1; i >= 0; i--) {
      for (int j = cost[i].length - 1; j >= 0; j--) {
        if (i == cost.length - 1 && j == cost[0].length - 1) continue;

        if (i == cost.length - 1) {
          dp[i][j] = cost[i][j] + dp[i][j + 1];
        } else if (j == cost[0].length - 1) {
          dp[i][j] = cost[i][j] + dp[i + 1][j];
        } else {
          dp[i][j] = cost[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
        }
      }
    }
    return dp[0][0];
  }
}
