package com.github4sanjay.dsalgo.dynamic.subsequences;

public class CoinChangePermutation {

  public static int recursion(int[] coins, int target) {
    if (target < 0) return 0;
    if (target == 0) {
      return 1;
    }
    int totalWays = 0;
    for (int i = 0; i < coins.length; i++) {
      totalWays += recursion(coins, target - coins[i]);
    }
    return totalWays;
  }

  public static int memoization(int[] coins, int target) {
    var dp = new Integer[target + 1];
    dp[target] = memoization(coins, target, dp);
    return dp[target];
  }

  public static int memoization(int[] coins, int target, Integer[] dp) {
    if (target < 0) return 0;
    if (target == 0) {
      return 1;
    }
    if (dp[target] != null) {
      return dp[target];
    }
    int totalWays = 0;
    for (int i = 0; i < coins.length; i++) {
      totalWays += memoization(coins, target - coins[i], dp);
    }
    dp[target] = totalWays;
    return totalWays;
  }

  public static int tabular(int[] coins, int target) {
    var dp = new Integer[target + 1];
    dp[target] = tabular(coins, target, dp);
    return dp[target];
  }

  private static int tabular(int[] coins, int TARGET, Integer[] dp) {
    for (int target = 0; target <= TARGET; target++) {
      if (target == 0) {
        dp[target] = 1;
        continue;
      }
      int totalWays = 0;
      for (int i = 0; i < coins.length; i++) {
        if (target - coins[i] >= 0) {
          totalWays += dp[target - coins[i]];
        }
      }
      dp[target] = totalWays;
    }
    return dp[TARGET];
  }
}
