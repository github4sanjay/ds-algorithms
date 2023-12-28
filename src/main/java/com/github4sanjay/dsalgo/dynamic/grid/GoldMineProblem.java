package com.github4sanjay.dsalgo.dynamic.grid;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is
 * the amount of gold in tons. Initially the miner is at first column but can be at any row. He can
 * move only (right->,right up /,right down\) that is from a given cell, the miner can move to the
 * cell diagonally up towards the right or right or diagonally down towards the right. Find out
 * maximum amount of gold he can collect.
 */
public class GoldMineProblem {

  public static int recursion(int[][] mine) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < mine.length; i++) {
      max = Math.max(max, recursion(mine, i, mine[0].length - 1));
    }
    return max;
  }

  private static int recursion(int[][] mine, int row, int column) {
    if (row < 0 || column < 0 || row > mine.length - 1 || column > mine[0].length - 1) {
      return Integer.MIN_VALUE;
    }
    if (column == 0) return mine[row][column];
    int upperDiagonal = recursion(mine, row - 1, column - 1);
    int left = recursion(mine, row, column - 1);
    int lowerDiagonal = recursion(mine, row + 1, column - 1);
    return mine[row][column] + Math.max(upperDiagonal, Math.max(left, lowerDiagonal));
  }

  public static int memoization(int[][] mine) {
    var max = Integer.MIN_VALUE;
    var dp = new Integer[mine.length][mine[0].length];
    for (int i = 0; i < mine.length; i++) {
      max = Math.max(max, memoization(mine, i, mine[0].length - 1, dp));
    }
    return max;
  }

  private static int memoization(int[][] mine, int row, int column, Integer[][] dp) {
    if (row < 0 || column < 0 || row > mine.length - 1 || column > mine[0].length - 1) {
      return Integer.MIN_VALUE;
    }
    if (column == 0) return mine[row][column];
    if (dp[row][column] != null) {
      return dp[row][column];
    }
    int upperDiagonal = memoization(mine, row - 1, column - 1, dp);
    int left = memoization(mine, row, column - 1, dp);
    int lowerDiagonal = memoization(mine, row + 1, column - 1, dp);
    var max = mine[row][column] + Math.max(upperDiagonal, Math.max(left, lowerDiagonal));
    dp[row][column] = max;
    return max;
  }

  public static int tabular(int[][] mine) {
    var max = Integer.MIN_VALUE;
    var dp = new Integer[mine.length][mine[0].length];
    for (int j = mine.length - 1; j >= 0; j--) {
      max = Math.max(max, tabular(mine, j, dp));
    }
    return max;
  }

  private static int tabular(int[][] mine, int C, Integer[][] dp) {
    int maxInColumn = Integer.MIN_VALUE;
    for (int row = 0; row < mine.length; row++) {
      if (C == mine[0].length - 1) {
        dp[row][C] = mine[row][C];
        continue;
      }

      int upperDiagonal = Integer.MIN_VALUE;
      if (row - 1 >= 0) {
        upperDiagonal = dp[row - 1][C + 1];
      }
      int left = dp[row][C + 1];
      int lowerDiagonal = Integer.MIN_VALUE;
      if (row + 1 < mine.length) {
        lowerDiagonal = dp[row + 1][C + 1];
      }

      int max = mine[row][C] + Math.max(upperDiagonal, Math.max(left, lowerDiagonal));
      dp[row][C] = max;
      maxInColumn = Math.max(maxInColumn, max);
    }
    return maxInColumn;
  }
}
