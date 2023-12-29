package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * 1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
 * 2. You've an infinite supply of m * 1 tiles.
 * 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 *
 * n 39
 * m 16
 *
 * 61
 */
public class TilingWithKX1 {

  // brute force
  public static int recursion(int n, int m) {
    if (n < m) return 1;
    if (n == m) return 2;
    return recursion(n - 1, m) + recursion(n - m, m);
  }

  public static int memoization(int n, int m) {
    var dp = new int[n + 1];
    dp[n] = memoization(n, m, dp);
    return dp[n];
  }

  private static int memoization(int n, int m, int[] dp) {
    if (n < m) return 1;
    if (n == m) return 2;
    if (dp[n] != 0) return dp[n];
    dp[n] = memoization(n - 1, m, dp) + memoization(n - m, m, dp);
    return dp[n];
  }

  public static int tabulation(int n, int m) {
    var dp = new int[n + 1];
    dp[n] = tabulation(n, m, dp);
    return dp[n];
  }

  private static int tabulation(int N, int m, int[] dp) {
    for (int n = 0; n <= N; n++) {
      if (n < m) {
        dp[n] = 1;
      } else if (n == m) {
        dp[n] = 2;
      } else {
        dp[n] = dp[n - 1] + dp[n - m];
      }
    }
    return dp[N];
  }
}
