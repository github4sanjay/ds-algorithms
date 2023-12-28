package com.github4sanjay.dsalgo.dynamic.subsequences;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S
 * = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
 * doesn’t matter.
 *
 * <p>For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are
 * five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChangeCombination {

  public static int recursion(int[] coins, int target) {
    return recursion(coins, target, coins.length - 1);
  }

  private static int recursion(int[] coins, int target, int index) {
    if (index == 0) {
      if (target % coins[index] == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    int notTake = recursion(coins, target, index - 1);
    int take = 0;
    if (coins[index] <= target) {
      take = recursion(coins, target - coins[index], index);
    }
    return notTake + take;
  }

  public static int memoization(int[] coins, int target) {
    var dp = new Integer[coins.length][target + 1];
    dp[coins.length - 1][target] = memoization(coins, target, coins.length - 1, dp);
    return dp[coins.length - 1][target];
  }

  private static int memoization(int[] coins, int target, int index, Integer[][] dp) {
    if (index == 0) {
      if (target % coins[index] == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    if (dp[index][target] != null) {
      return dp[index][target];
    }
    int notTake = memoization(coins, target, index - 1, dp);
    int take = 0;
    if (coins[index] <= target) {
      take = memoization(coins, target - coins[index], index, dp);
    }
    var result = notTake + take;
    dp[index][target] = result;
    return result;
  }

  public static int tabular(int[] coins, int target) {
    var dp = new Integer[coins.length][target + 1];
    dp[coins.length - 1][target] = tabular(coins, coins.length - 1, target, dp);
    return dp[coins.length - 1][target];
  }

  private static int tabular(int[] coins, int INDEX, int TARGET, Integer[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int target = 0; target <= TARGET; target++) {
        if (index == 0) {
          if (target % coins[index] == 0) {
            dp[index][target] = 1;
            continue;
          } else {
            dp[index][target] = 0;
            continue;
          }
        }

        int notTake = dp[index - 1][target];
        int take = 0;
        if (coins[index] <= target) {
          take = dp[index][target - coins[index]];
        }
        var result = notTake + take;
        dp[index][target] = result;
      }
    }
    return dp[INDEX][TARGET];
  }
}
