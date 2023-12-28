package com.github4sanjay.dsalgo.dynamic.fibonacci;

public class Fibonacci {

  public static int recursion(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return recursion(n - 2) + recursion(n - 1);
  }

  public static int tabulation(int n) {
    var dp = new int[n + 1];
    dp[n] = tabulation(n, dp);
    return dp[n];
  }

  private static int tabulation(int n, int[] dp) {
    for (int i = 0; i <= n; i++) {
      if (i == 0) {
        dp[i] = 0;
        continue;
      }
      if (i == 1) {
        dp[i] = 1;
        continue;
      }

      if (dp[i] != 0) {
        return dp[n];
      }

      int fib1 = dp[i - 1];
      int fib2 = dp[i - 2];
      int fib = fib1 + fib2;
      dp[i] = fib;
    }
    return dp[n];
  }

  public static int memoization(int n) {
    var dp = new int[n + 1];
    dp[n] = memoization(n, dp);
    return dp[n];
  }

  private static int memoization(int n, int[] dp) {
    if (n == 0) return 0;
    if (n == 1) return 1;

    if (dp[n] != 0) {
      return dp[n];
    }

    int fib1 = memoization(n - 1, dp);
    int fib2 = memoization(n - 2, dp);
    int fib = fib1 + fib2;
    dp[n] = fib;
    return fib;
  }
}
