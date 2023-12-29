package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * 1. You are given a number n, representing the number of elements.
 * 2. You are given a number k, representing the number of subsets.
 * 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
 * E.g.
 * For n = 4 and k = 3 total ways is 6
 * 12-3-4
 * 1-23-4
 * 13-2-4
 * 14-2-3
 * 1-24-3
 * 1-2-34
 *
 * Note : For brute force check backtracking
 */
public class PartitionKSubsets {

  /*
   *
   *
   *      n-1, k  n-1,k-1
   *          \  /
   *           \/
   *           n,k
   *
   * f(n,k) = k*f(n-1, k) + f(n-1,k-1)
   */
  public static int recursion(int n, int k) {
    if (n <= 0 || k <= 0) return 0;
    if (n == k) return 1;

    return k * recursion(n - 1, k) + recursion(n - 1, k - 1);
  }

  public static int memoization(int n, int k) {
    var dp = new Integer[n + 1][k + 1];
    dp[n][k] = memoization(n, k, dp);
    return dp[n][k];
  }

  private static int memoization(int n, int k, Integer[][] dp) {
    if (n <= 0 || k <= 0) return 0;
    if (n == k) return 1;

    if (dp[n][k] != null) {
      return dp[n][k];
    }

    dp[n][k] = k * memoization(n - 1, k, dp) + memoization(n - 1, k - 1, dp);
    return dp[n][k];
  }

  public static int tabulation(int n, int k) {
    var dp = new Integer[n + 1][k + 1];
    dp[n][k] = tabulation(n, k, dp);
    return dp[n][k];
  }

  private static int tabulation(int N, int K, Integer[][] dp) {
    for (int n = 0; n <= N; n++) {
      for (int k = 0; k <= K; k++) {
        if (n == 0 || k == 0) {
          dp[n][k] = 0;
          continue;
        }
        if (n < k) {
          dp[n][k] = 0;
          continue;
        }
        if (n == k) {
          dp[n][k] = 1;
          continue;
        }
        dp[n][k] = k * dp[n - 1][k] + dp[n - 1][k - 1];
      }
    }
    return dp[N][K];
  }
}
