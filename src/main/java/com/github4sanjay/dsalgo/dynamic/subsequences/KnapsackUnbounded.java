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

  public static int recursion(int[] weights, int[] values, int allowedWeight) {
    return recursion(weights, values, weights.length - 1, allowedWeight);
  }

  public static int recursion(int[] weights, int[] values, int weightIndex, int allowedWeight) {
    if (weightIndex == 0) {
      if (allowedWeight >= weights[weightIndex]) {
        return values[weightIndex];
      } else {
        return 0;
      }
    }
    var notTake = recursion(weights, values, weightIndex - 1, allowedWeight);
    int take = Integer.MIN_VALUE;
    if (weights[weightIndex] <= allowedWeight) {
      take =
          values[weightIndex]
              + recursion(weights, values, weightIndex, allowedWeight - weights[weightIndex]);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int[] weights, int[] values, int allowedWeight) {
    var dp = new Integer[weights.length][allowedWeight + 1];
    dp[weights.length - 1][allowedWeight] =
        memoization(weights, values, weights.length - 1, allowedWeight, dp);
    return dp[weights.length - 1][allowedWeight];
  }

  public static int memoization(
      int[] weights, int[] values, int weightIndex, int allowedWeight, Integer[][] dp) {
    if (weightIndex == 0) {
      if (allowedWeight >= weights[weightIndex]) {
        return values[weightIndex];
      } else {
        return 0;
      }
    }
    if (dp[weightIndex][allowedWeight] != null) {
      return dp[weightIndex][allowedWeight];
    }
    var notTake = memoization(weights, values, weightIndex - 1, allowedWeight, dp);
    int take = Integer.MIN_VALUE;
    if (weights[weightIndex] <= allowedWeight) {
      take =
          values[weightIndex]
              + memoization(weights, values, weightIndex, allowedWeight - weights[weightIndex], dp);
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

  public static int tabulation(
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

        var notTake = dp[weightIndex - 1][allowedWeight];
        int take = Integer.MIN_VALUE;
        if (weights[weightIndex] <= allowedWeight) {
          take = values[weightIndex] + dp[weightIndex][allowedWeight - weights[weightIndex]];
        }
        var result = Math.max(notTake, take);
        dp[weightIndex][allowedWeight] = result;
      }
    }
    return dp[WEIGHT_INDEX][ALLOWED_WEIGHT];
  }
}
