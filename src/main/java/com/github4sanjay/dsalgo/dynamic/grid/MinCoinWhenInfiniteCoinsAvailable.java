package com.github4sanjay.dsalgo.dynamic.grid;

/*
 * Given a value V, if we want to make a change for V cents, and we have an infinite supply of
 * each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change?
 * If it’s not possible to make a change, print -1.
 *
 * Examples:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents
 *
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinCoinWhenInfiniteCoinsAvailable {

  public static int recursion(int[] coins, int target) {
    return recursion(coins, coins.length - 1, target);
  }

  private static int recursion(int[] coins, int index, int target) {
    if (index == 0) {
      if (target % coins[index] == 0) return target / coins[index];
      else return Integer.MAX_VALUE;
    }

    var notTake = recursion(coins, index - 1, target);
    var take = Integer.MAX_VALUE;
    if (coins[index] <= target) {
      var result = recursion(coins, index, target - coins[index]);
      if (result != Integer.MAX_VALUE) {
        take = 1 + result;
      }
    }
    return Math.min(take, notTake);
  }

  public static int memoization(int[] coins, int target) {
    return memoization(coins, coins.length - 1, target, new Integer[coins.length][target + 1]);
  }

  private static int memoization(int[] coins, int index, int target, Integer[][] dp) {
    if (index == 0) {
      if (target % coins[index] == 0) return target / coins[index];
      else return Integer.MAX_VALUE;
    }

    if (dp[index][target] != null) return dp[index][target];

    var notTake = memoization(coins, index - 1, target, dp);
    var take = Integer.MAX_VALUE;
    if (coins[index] <= target) {
      var result = memoization(coins, index, target - coins[index], dp);
      if (result != Integer.MAX_VALUE) {
        take = 1 + result;
      }
    }
    dp[index][target] = Math.min(take, notTake);
    return dp[index][target];
  }

  public static int tabulation(int[] coins, int target) {
    var dp = new Integer[coins.length][target + 1];
    dp[coins.length - 1][target] = tabulation(coins, coins.length - 1, target, dp);
    return dp[coins.length - 1][target];
  }

  private static int tabulation(int[] coins, int INDEX, int TARGET, Integer[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int target = 0; target <= TARGET; target++) {
        if (index == 0) {
          if (target % coins[index] == 0) {
            dp[index][target] = target / coins[index];
            continue;
          } else {
            dp[index][target] = Integer.MAX_VALUE;
            continue;
          }
        }

        var notTake = dp[index - 1][target];
        var take = Integer.MAX_VALUE;
        if (coins[index] <= target) {
          var result = dp[index][target - coins[index]];
          if (result != Integer.MAX_VALUE) {
            take = 1 + result;
          }
        }
        dp[index][target] = Math.min(take, notTake);
      }
    }
    return dp[INDEX][TARGET];
  }
}
