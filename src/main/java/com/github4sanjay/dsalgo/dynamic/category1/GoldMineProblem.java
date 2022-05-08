package com.github4sanjay.dsalgo.dynamic.category1;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a positive integer which is
 * the amount of gold in tons. Initially the miner is at first column but can be at any row. He can
 * move only (right->,right up /,right down\) that is from a given cell, the miner can move to the
 * cell diagonally up towards the right or right or diagonally down towards the right. Find out
 * maximum amount of gold he can collect.
 */
public class GoldMineProblem {

  public static void main(String[] args) {
    int gold[][] = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};

    System.out.print(getMaxGold(gold));
  }

  private static int getMaxGold(int[][] gold) {

    int totalRow = gold.length;
    int totalCol = gold[0].length;

    int[][] dp = new int[totalRow][totalCol];

    for (int j = totalCol - 1; j >= 0; j--) {
      for (int i = 0; i < totalRow; i++) {
        if (j == totalCol - 1) {
          dp[i][j] = gold[i][j];
        } else if (i == 0) {
          dp[i][j] = gold[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
        } else if (i == totalRow - 1) {
          dp[i][j] = gold[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
        } else {
          dp[i][j] =
              gold[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]);
        }
      }
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      max = Math.max(max, dp[i][0]);
    }
    return max;
  }
}
