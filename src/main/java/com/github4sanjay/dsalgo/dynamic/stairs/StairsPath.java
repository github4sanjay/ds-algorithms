package com.github4sanjay.dsalgo.dynamic.stairs;

public class StairsPath {

  public static int recursion(int n, int k) {

    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }

    int sum = 0;
    for (int i = 1; i <= k; i++) {
      sum = sum + recursion(n - i, k);
    }
    return sum;
  }

  public static int memoization(int n, int k) {
    var dp = new int[n + 1];
    dp[n] = memoization(n, k, dp);
    return dp[n];
  }

  private static int memoization(int n, int k, int[] dp) {

    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    if (dp[n] != 0) {
      return dp[n];
    }

    int sum = 0;
    for (int i = 1; i <= k; i++) {
      sum = sum + recursion(n - i, k);
    }
    dp[n] = sum;
    return sum;
  }

  public static int tabulation(int n, int k) {
    var dp = new int[n + 1];
    dp[n] = tabulation(n, k, dp);
    return dp[n];
  }

  private static int tabulation(int N, int k, int[] dp) {

    for (int n = 0; n <= N; n++) {
      if (n == 0) {
        dp[n] = 1;
        continue;
      }

      int sum = 0;
      for (int i = 1; i <= k; i++) {
        if (n - i >= 0) {
          sum = sum + dp[n - i];
        }
      }
      dp[n] = sum;
    }
    return dp[N];
  }
}
