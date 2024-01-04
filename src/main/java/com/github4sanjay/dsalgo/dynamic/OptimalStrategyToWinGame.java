package com.github4sanjay.dsalgo.dynamic;

/*
 * Consider a row of N coins of values V1 . . . Vn, where N is even.
 * We play a game against an opponent by alternating turns.
 * In each turn, a player selects either the first or last coin from the row, removes it from the row permanently,
 * and receives the value of the coin. Determine the maximum possible amount of money we can definitely
 * win if we move first.
 *
 * Note: The opponent is as clever as the user.
 *
 * Examples:
 *
 * Input: {5, 3, 7, 10}
 * Output: 15 -> (10 + 5)
 *
 *
 *  Input: {8, 15, 3, 7}
 * Output: 22 -> (7 + 15)
 */
public class OptimalStrategyToWinGame {

  public static int recursion(int[] coins) {
    return recursion(coins, 0, coins.length - 1);
  }

  private static int recursion(int[] coins, int start, int end) {
    if (start > end) {
      return 0;
    }
    if (end - start == 1) {
      return Math.max(coins[start], coins[end]);
    }
    var whenPickLeft = Integer.MIN_VALUE;
    if (coins[start + 1] > coins[end]) {
      whenPickLeft = coins[start] + recursion(coins, start + 2, end);
    } else {
      whenPickLeft = coins[start] + recursion(coins, start + 1, end - 1);
    }
    var whenPickRight = Integer.MIN_VALUE;
    if (coins[start] > coins[end - 1]) {
      whenPickRight = coins[end] + recursion(coins, start + 1, end - 1);
    } else {
      whenPickRight = coins[end] + recursion(coins, start, end - 2);
    }
    return Math.max(whenPickLeft, whenPickRight);
  }

  public static int memoization(int[] coins) {
    var dp = new Integer[coins.length][coins.length];
    dp[0][coins.length - 1] = memoization(coins, 0, coins.length - 1, dp);
    return dp[0][coins.length - 1];
  }

  private static int memoization(int[] coins, int start, int end, Integer[][] dp) {
    if (start > end) {
      return 0;
    }
    if (end - start == 1) {
      dp[start][end] = Math.max(coins[start], coins[end]);
      return dp[start][end];
    }

    if (dp[start][end] != null) {
      return dp[start][end];
    }

    var whenPickLeft =
        coins[start]
            + Math.min(
                memoization(coins, start + 2, end, dp), memoization(coins, start + 1, end - 1, dp));
    var whenPickRight =
        coins[end]
            + Math.min(
                memoization(coins, start + 1, end - 1, dp), memoization(coins, start, end - 2, dp));
    dp[start][end] = Math.max(whenPickLeft, whenPickRight);
    return dp[start][end];
  }

  public static int tabulation(int[] coins) {
    var dp = new Integer[coins.length][coins.length];
    dp[0][coins.length - 1] = tabulation(coins, dp);
    return dp[0][coins.length - 1];
  }

  private static int tabulation(int[] coins, Integer[][] dp) {
    for (int gap = 1; gap < coins.length; gap = gap + 2) {
      for (int start = 0, end = gap; end < coins.length; start++, end++) {
        if (end - start == 1) {
          dp[start][end] = Math.max(coins[start], coins[end]);
          continue;
        }

        var whenPickLeft = coins[start] + Math.min(dp[start + 2][end], dp[start + 1][end - 1]);
        var whenPickRight = coins[end] + Math.min(dp[start + 1][end - 1], dp[start][end - 2]);
        dp[start][end] = Math.max(whenPickLeft, whenPickRight);
      }
    }
    return dp[0][coins.length - 1];
  }
}
