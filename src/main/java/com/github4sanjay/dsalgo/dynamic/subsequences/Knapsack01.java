package com.github4sanjay.dsalgo.dynamic.subsequences;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the
 * maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and
 * wt[0..n-1] which represent values and weights associated with n items respectively. Also given an
 * integer W which represents knapsack capacity, find out the maximum value subset of val[] such
 * that sum of the weights of this subset is smaller than or equal to W. You cannot break an item,
 * either pick the complete item or don’t pick it (0-1 property).
 */
public class Knapsack01 {

  public static int recursion(int[] weights, int[] values, int allowedWeight) {
    return recursion(weights, values, weights.length - 1, allowedWeight);
  }

  private static int recursion(int[] weights, int[] values, int weightIndex, int allowedWeight) {
    if (weightIndex == 0) {
      if (allowedWeight >= weights[weightIndex]) return values[weightIndex];
      else return 0;
    }
    var notTake = recursion(weights, values, weightIndex - 1, allowedWeight);
    var take = 0;
    if (weights[weightIndex] <= allowedWeight) {
      take =
          values[weightIndex]
              + recursion(weights, values, weightIndex - 1, allowedWeight - weights[weightIndex]);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int[] weights, int[] values, int allowedWeight) {
    var dp = new Integer[weights.length][allowedWeight + 1];
    dp[weights.length - 1][allowedWeight] =
        memoization(weights, values, weights.length - 1, allowedWeight, dp);
    return dp[weights.length - 1][allowedWeight];
  }

  private static int memoization(
      int[] weights, int[] values, int weightIndex, int allowedWeight, Integer[][] dp) {
    if (weightIndex == 0) {
      if (allowedWeight >= weights[weightIndex]) return values[weightIndex];
      else return 0;
    }
    if (dp[weightIndex][allowedWeight] != null) {
      return dp[weightIndex][allowedWeight];
    }
    var notTake = memoization(weights, values, weightIndex - 1, allowedWeight, dp);
    var take = 0;
    if (weights[weightIndex] <= allowedWeight) {
      take =
          values[weightIndex]
              + memoization(
                  weights, values, weightIndex - 1, allowedWeight - weights[weightIndex], dp);
    }
    var result = Math.max(notTake, take);
    dp[weightIndex][allowedWeight] = result;
    return result;
  }

  public static int tabulation(int[] weights, int[] values, int allowedWeight) {
    var dp = new Integer[weights.length][allowedWeight + 1];
    dp[weights.length - 1][allowedWeight] =
        tabulation(weights, values, weights.length - 1, allowedWeight, dp);
    return dp[weights.length - 1][allowedWeight];
  }

  private static int tabulation(
      int[] weights, int[] values, int WEIGHT_INDEX, int ALLOWED_WEIGHT, Integer[][] dp) {
    for (int weightIndex = 0; weightIndex <= WEIGHT_INDEX; weightIndex++) {
      for (int allowedWeight = 0; allowedWeight <= ALLOWED_WEIGHT; allowedWeight++) {
        if (weightIndex == 0) {
          if (allowedWeight >= weights[weightIndex]) {
            dp[weightIndex][allowedWeight] = values[weightIndex];
            continue;
          } else {
            dp[weightIndex][allowedWeight] = 0;
            continue;
          }
        }
        if (dp[weightIndex][allowedWeight] != null) {
          return dp[weightIndex][allowedWeight];
        }
        var notTake = dp[weightIndex - 1][allowedWeight];
        var take = 0;
        if (weights[weightIndex] <= allowedWeight) {
          take = values[weightIndex] + dp[weightIndex - 1][allowedWeight - weights[weightIndex]];
        }
        var result = Math.max(notTake, take);
        dp[weightIndex][allowedWeight] = result;
      }
    }
    return dp[WEIGHT_INDEX][ALLOWED_WEIGHT];
  }
}
