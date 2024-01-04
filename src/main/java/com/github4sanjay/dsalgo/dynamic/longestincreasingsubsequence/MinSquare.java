package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

/*
 * Minimum number of squares whose sum equals to given number n
 *
 * A number can always be represented as a sum of squares of other numbers.
 * Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …).
 * Given a number n, find the minimum number of squares that sum to X.
 * Examples :
 *
 * Input:  n = 100
 * Output: 1
 * 100 can be written as 10^2. Note that 100 can also be
 * written as 5^2 + 5^2 + 5^2 + 5^2, but this
 * representation requires 4 squares.
 *
 * Input:  n = 6
 * Output: 3
 */
public class MinSquare {

  public static int recursion(int n) {
    if (n <= 3) {
      return n;
    }
    var min = Integer.MAX_VALUE;
    for (var i = 1; i <= n; i++) {
      var temp = i * i;
      if (temp > n) break;
      else {
        min = Math.min(min, 1 + recursion(n - temp));
      }
    }
    return min;
  }

  public static int memoization(int n) {
    var dp = new Integer[n + 1];
    dp[n] = memoization(n, dp);
    return dp[n];
  }

  public static int memoization(int n, Integer[] dp) {
    if (n <= 3) {
      return n;
    }
    if (dp[n] != null) {
      return dp[n];
    }
    var min = Integer.MAX_VALUE;
    for (var i = 1; i <= n; i++) {
      var temp = i * i;
      if (temp > n) break;
      else {
        min = Math.min(min, 1 + memoization(n - temp, dp));
      }
    }
    dp[n] = min;
    return dp[n];
  }

  public static int tabulation(int n) {
    var dp = new Integer[n + 1];
    dp[n] = tabulation(n, dp);
    return dp[n];
  }

  public static int tabulation(int N, Integer[] dp) {
    for (var n = 0; n <= N; n++) {
      if (n <= 3) {
        dp[n] = n;
        continue;
      }
      var min = Integer.MAX_VALUE;
      for (var i = 1; i <= n; i++) {
        var temp = i * i;
        if (temp > n) break;
        else {
          min = Math.min(min, 1 + dp[n - temp]);
        }
      }
      dp[n] = min;
    }
    return dp[N];
  }

  /*
   * dp[i] = min {dp[i-1] for 1^2, dp[i-4] for 2^2, ....} + 1
   */
  public static int getMinSquares(int n) {

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      int localMin = Integer.MAX_VALUE;
      int j = 1;
      while (true) {
        if (i - j * j >= 0) {
          localMin = Math.min(localMin, dp[i - j * j]);
          j++;
        } else {
          break;
        }
      }

      if (localMin == Integer.MIN_VALUE) {
        dp[i] = 1;
      } else {
        dp[i] = localMin + 1;
      }
    }
    return dp[n];
  }
}
