package com.github4sanjay.dsalgo.dynamic.subsequences;

/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to
 * calculate the maximum amount that could make up this quantity exactly. This is different from
 * classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * Examples:
 *
 * <p>Input : W = 100 val[] = {1, 30} wt[] = {1, 50} Output : 100 There are many ways to fill
 * knapsack. 1) 2 instances of 50 unit weight item. 2) 100 instances of 1 unit weight item. 3) 1
 * instance of 50 unit weight item and 50 instances of 1 unit weight items. We get maximum value
 * with option 2.
 *
 * <p>Input : W = 8 val[] = {10, 40, 50, 70} wt[] = {1, 3, 4, 5} Output : 110 We get maximum value
 * with one unit of weight 5 and one unit of weight 3.
 */
public class KnapsackUnbounded {

  public static void main(String[] args) {
    int[] val = new int[] {15, 14, 10, 45, 30};
    int[] wt = new int[] {2, 5, 1, 3, 4};
    System.out.println(knapsack(7, wt, val)); // 100
    System.out.println(recursive(7, wt, val)); // 1OO
    System.out.println(memoization(7, wt, val)); // 1OO
    System.out.println(tabular(7, wt, val)); // 1OO

    val = new int[] {10, 40, 50, 70};
    wt = new int[] {1, 3, 4, 5};
    System.out.println(knapsack(8, wt, val)); // 110
    System.out.println(recursive(8, wt, val)); // 11O
    System.out.println(memoization(8, wt, val)); // 11O
    System.out.println(tabular(8, wt, val)); // 11O
  }

  //  with 2d array
  private static int knapsack(int w, int[] wt, int[] val) {
    int[][] dp = new int[wt.length + 1][w + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          int noOfTimesWtCanBeTaken = j / wt[i - 1];
          int max = Integer.MIN_VALUE;
          for (int k = 0; k <= noOfTimesWtCanBeTaken; k++) {
            if (k == 0) {
              max = dp[i - 1][j];
            } else {
              max = Math.max(max, val[i - 1] * k + dp[i - 1][j - wt[i - 1] * k]);
            }
          }
          dp[i][j] = max;
        }
      }
    }
    return dp[wt.length][w];
  }

  //  with 1d array
  private static int knapsackIn1DArray(int w, int[] wt, int[] val) {
    int[] dp = new int[w + 1];
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < wt.length; j++) {
        if (i < wt[j]) continue;
        dp[i] = Math.max(dp[i], val[j] + dp[i - wt[j]]);
      }
    }
    return dp[w];
  }

  public static int recursive(int w, int[] wt, int[] val) {
    return recursive(wt.length - 1, w, wt, val);
  }

  private static int recursive(int i, int w, int[] wt, int[] val) {
    if (w == 0) return 0;
    if (i == 0) {
      if (wt[0] <= w) {
        // if wt[0] is 5 then w=5, w=10, w=15 and so on will have values
        return (w / wt[0]) * val[0];
      } else {
        return 0;
      }
    }
    var notTake = recursive(i - 1, w, wt, val);
    var take = Integer.MIN_VALUE;
    if (w >= wt[i]) {
      take = val[i] + recursive(i, w - wt[i], wt, val);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int w, int[] wt, int[] val) {
    return memoization(wt.length - 1, w, wt, val, new Integer[wt.length][w + 1]);
  }

  private static int memoization(int i, int w, int[] wt, int[] val, Integer[][] dp) {
    if (w == 0) return 0;
    if (i == 0) {
      if (wt[0] <= w) {
        // if wt[0] is 5 then w=5, w=10, w=15 and so on will have values
        return (w / wt[0]) * val[0];
      } else {
        return 0;
      }
    }
    if (dp[i][w] != null) return dp[i][w];
    var notTake = memoization(i - 1, w, wt, val, dp);
    var take = Integer.MIN_VALUE;
    if (w >= wt[i]) {
      take = val[i] + memoization(i, w - wt[i], wt, val, dp);
    }
    var result = Math.max(notTake, take);
    dp[i][w] = result;
    return result;
  }

  public static int tabular(int w, int[] wt, int[] val) {
    var dp = new int[wt.length][w + 1];
    for (int i = 0; i < wt.length; i++) dp[i][0] = 0;
    for (int j = wt[0]; j <= w; j++) {
      dp[0][j] = (j / wt[0]) * val[0];
    }
    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        var notTake = dp[i - 1][j];
        var take = Integer.MIN_VALUE;
        if (j >= wt[i]) {
          take = val[i] + dp[i][j - wt[i]];
        }
        var result = Math.max(notTake, take);
        dp[i][j] = result;
      }
    }

    return dp[dp.length - 1][w];
  }
}
