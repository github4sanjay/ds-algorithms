package com.github4sanjay.dsalgo.dynamic.grid;

/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns
 * cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost
 * to traverse through that cell. The total cost of a path to reach (m, n) is the sum of all the
 * costs on that path (including both source and destination). You can only traverse down, right and
 * diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i,
 * j+1), and (i+1, j+1) can be traversed. You may assume that all costs are positive integers.
 */
public class MazeTraversalMinCost {

  public static int recursion(int[][] cost) {
    return recursion(cost, cost.length - 1, cost[0].length - 1);
  }

  private static int recursion(int[][] cost, int destRow, int destCol) {
    if (destRow < 0 || destCol < 0) return Integer.MAX_VALUE;
    if (destRow == 0 && destCol == 0) return cost[destRow][destCol];

    var up = recursion(cost, destRow - 1, destCol);
    var diagonals = recursion(cost, destRow - 1, destCol - 1);
    var left = recursion(cost, destRow, destCol - 1);
    return cost[destRow][destCol] + Math.min(up, Math.min(diagonals, left));
  }

  public static int memoization(int[][] cost) {
    var dp = new Integer[cost.length][cost[0].length];
    dp[cost.length - 1][cost[0].length - 1] =
        memoization(cost, cost.length - 1, cost[0].length - 1, dp);
    return dp[cost.length - 1][cost[0].length - 1];
  }

  private static int memoization(int[][] cost, int destRow, int destCol, Integer[][] dp) {
    if (destRow < 0 || destCol < 0) return Integer.MAX_VALUE;
    if (destRow == 0 && destCol == 0) return cost[destRow][destCol];

    if (dp[destRow][destCol] != null) {
      return dp[destRow][destCol];
    }

    var up = recursion(cost, destRow - 1, destCol);
    var diagonals = recursion(cost, destRow - 1, destCol - 1);
    var left = recursion(cost, destRow, destCol - 1);
    var min = cost[destRow][destCol] + Math.min(up, Math.min(diagonals, left));
    dp[destRow][destCol] = min;
    return min;
  }

  public static int tabulation(int[][] cost) {
    var dp = new Integer[cost.length][cost[0].length];
    dp[0][0] = tabulation(cost, cost.length - 1, cost[0].length - 1, dp);
    return dp[0][0];
  }

  private static int tabulation(int[][] cost, int R, int C, Integer[][] dp) {

    for (int destRow = R; destRow >= 0; destRow--) {
      for (int destCol = C; destCol >= 0; destCol--) {
        // if (destRow < 0 || destCol < 0) return Integer.MAX_VALUE;
        if (destRow == R && destCol == C) {
          dp[destRow][destCol] = cost[destRow][destCol];
          continue;
        }

        var up = Integer.MAX_VALUE;
        if (destRow + 1 <= R) {
          up = dp[destRow + 1][destCol] == null ? Integer.MAX_VALUE : dp[destRow + 1][destCol];
        }

        var diagonals = Integer.MAX_VALUE;
        if (destRow + 1 <= R && destCol + 1 <= C) {
          diagonals =
              dp[destRow + 1][destCol + 1] == null
                  ? Integer.MAX_VALUE
                  : dp[destRow + 1][destCol + 1];
        }

        var left = Integer.MAX_VALUE;
        if (destCol + 1 <= C) {
          left = dp[destRow][destCol + 1] == null ? Integer.MAX_VALUE : dp[destRow][destCol + 1];
        }

        var min = cost[destRow][destCol] + Math.min(up, Math.min(diagonals, left));
        dp[destRow][destCol] = min;
      }
    }
    return dp[0][0];
  }
}
