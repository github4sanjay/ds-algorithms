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
    int[][] gold = {{1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};

    System.out.println(getMaxGold(gold));
    System.out.println(recursive(gold));
    System.out.println(memoization(gold));
    System.out.println(tabular(gold));

    int[][] gold1 = {{10, 33, 13, 15}, {22, 21, 4, 1}, {5, 0, 2, 3}, {0, 6, 14, 2}};

    System.out.println(getMaxGold(gold1)); // 83
    System.out.println(recursive(gold1));
    System.out.println(memoization(gold1));
    System.out.println(tabular(gold1));
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

  private static int recursive(int[][] gold, int i, int j) {

    if ((j < 0 || i < 0 || i > gold.length - 1)) {
      return 0;
    }

    if (j == 0) {
      return gold[i][j];
    }

    int rightUpperDiagonal = recursive(gold, i + 1, j - 1);
    int right = recursive(gold, i, j - 1);
    int rightLowerDiagonal = recursive(gold, i - 1, j - 1);

    return gold[i][j] + Math.max(Math.max(rightUpperDiagonal, rightLowerDiagonal), right);
  }

  public static int recursive(int[][] gold) {
    int maxGold = Integer.MIN_VALUE;

    for (int i = 0; i < gold.length; i++) {
      int goldCollected = recursive(gold, i, gold.length - 1);
      maxGold = Math.max(maxGold, goldCollected);
    }

    return maxGold;
  }

  private static int memoization(int[][] gold, int i, int j, Integer[][] dp) {

    if ((j < 0 || i < 0 || i > gold.length - 1)) {
      return 0;
    }

    if (j == 0) {
      return gold[i][j];
    }

    if (dp[i][j] != null) return dp[i][j];

    int rightUpperDiagonal = recursive(gold, i + 1, j - 1);
    int right = recursive(gold, i, j - 1);
    int rightLowerDiagonal = recursive(gold, i - 1, j - 1);

    var result = gold[i][j] + Math.max(Math.max(rightUpperDiagonal, rightLowerDiagonal), right);
    dp[i][j] = result;
    return result;
  }

  public static int memoization(int[][] gold) {
    int maxGold = Integer.MIN_VALUE;

    for (int i = 0; i < gold.length; i++) {
      int goldCollected =
          memoization(gold, i, gold.length - 1, new Integer[gold.length][gold[0].length]);
      maxGold = Math.max(maxGold, goldCollected);
    }

    return maxGold;
  }

  public static int tabular(int[][] gold) {

    var dp = new int[gold.length][gold[0].length];

    for (int i = 0; i < gold.length; i++) {
      dp[i][0] = gold[i][0];
    }

    for (int i = 0; i < gold.length; i++) {
      for (int j = 1; j < gold[0].length; j++) {
        int rightUpperDiagonal = Integer.MIN_VALUE;
        if (i + 1 < gold.length) {
          rightUpperDiagonal = dp[i + 1][j - 1];
        }

        int right = dp[i][j - 1];

        int rightLowerDiagonal = Integer.MIN_VALUE;
        if (i - 1 >= 0) {
          rightLowerDiagonal = dp[i - 1][j - 1];
        }
        var result = gold[i][j] + Math.max(Math.max(rightUpperDiagonal, rightLowerDiagonal), right);
        dp[i][j] = result;
      }
    }
    int maxGold = Integer.MIN_VALUE;

    for (int i = 0; i < gold.length; i++) {
      int goldCollected = dp[i][gold.length - 1];
      maxGold = Math.max(maxGold, goldCollected);
    }

    return maxGold;
  }
}
