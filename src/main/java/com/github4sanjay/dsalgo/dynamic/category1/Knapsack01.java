package com.github4sanjay.dsalgo.dynamic.category1;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and
 * wt[0..n-1] which represent values and weights associated with n items respectively. Also given an
 * integer W which represents knapsack capacity, find out the maximum value subset of val[] such
 * that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
 * either pick the complete item or don’t pick it (0-1 property).
 */
public class Knapsack01 {

  public static void main(String[] args) {
    int[] val = new int[] {60, 100, 120};
    int[] wt = new int[] {10, 20, 30};

    System.out.println(knapsack(50, wt, val)); // 220

    System.out.println(recursive(wt, val, 50)); // 220
    System.out.println(memoization(wt, val, 50)); // 220
    System.out.println(tabular(wt, val, 50)); // 220
  }

  private static int knapsack(int w, int[] wt, int[] val) {
    int[][] dp = new int[wt.length + 1][w + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (j < wt[i - 1]) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wt[i - 1]]);
        }
      }
    }
    return dp[wt.length][w];
  }

  public static int recursive(int[] wt, int[] val, int w) {
    return recursive(wt.length - 1, w, wt, val);
  }

  private static int recursive(int i, int w, int[] wt, int[] val) {
    if (w == 0) return 0;
    if (i == 0) {
      if (w <= wt[0]) return val[0];
      else return 0;
    }
    var notTake = recursive(i - 1, w, wt, val);
    var take = Integer.MIN_VALUE;
    if (wt[i] <= w) {
      take = val[i] + recursive(i - 1, w - wt[i], wt, val);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int[] wt, int[] val, int w) {
    return recursive(wt.length - 1, w, wt, val, new Integer[wt.length][w + 1]);
  }

  private static int recursive(int i, int w, int[] wt, int[] val, Integer[][] dp) {
    if (w == 0) return 0;
    if (i == 0) {
      if (w <= wt[0]) return val[0];
      else return 0;
    }

    if (dp[i][w] != null) {
      return dp[i][w];
    }
    var notTake = recursive(i - 1, w, wt, val);
    var take = Integer.MIN_VALUE;
    if (wt[i] <= w) {
      take = val[i] + recursive(i - 1, w - wt[i], wt, val);
    }
    var result = Math.max(notTake, take);
    dp[i][w] = result;
    return result;
  }

  private static int tabular(int[] wt, int[] val, int w) {
    var dp = new int[wt.length][w + 1];
    for (int i = 0; i < wt.length; i++) {
      dp[i][0] = 0;
    }
    for (int j = wt[0]; j <= w; j++) {
      dp[0][j] = val[0];
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        var notTake = dp[i - 1][j];
        var take = Integer.MIN_VALUE;
        if (wt[i] <= j) {
          take = val[i] + dp[i - 1][j - wt[i]];
        }
        var result = Math.max(notTake, take);
        dp[i][j] = result;
      }
    }

    return dp[dp.length - 1][w];
  }
}
