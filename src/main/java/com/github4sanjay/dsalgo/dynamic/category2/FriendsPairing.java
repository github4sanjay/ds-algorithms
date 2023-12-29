package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * Given n friends, each one can remain single or can be paired up with some other friend.
 * Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
 *
 * Examples :
 *
 * Input  : n = 3
 * Output : 4
 *
 * Explanation
 * {1}, {2}, {3} : all single
 * {1}, {2, 3} : 2 and 3 paired but 1 is single.
 * {1, 2}, {3} : 1 and 2 are paired but 3 is single.
 * {1, 3}, {2} : 1 and 3 are paired but 2 is single.
 * Note that {1, 2} and {2, 1} are considered same.
 */
public class FriendsPairing {

  private static int count(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] * (i - 1);
    }
    return dp[n];
  }

  // combination f(n) = f(n-1) + (n-1) f(n-2)
  public static int recursion(int n) {
    if (n < 0) return 0;
    if (n == 1 || n == 0) return 1;
    return recursion(n - 1) + recursion(n - 2) * (n - 1);
  }

  public static int memoization(int n) {
    var dp = new int[n + 1];
    dp[n] = memoization(n, dp);
    return dp[n];
  }

  private static int memoization(int n, int[] dp) {
    if (n < 0) return 0;
    if (n == 1 || n == 0) return 1;
    dp[n] = recursion(n - 1) + recursion(n - 2) * (n - 1);
    return dp[n];
  }

  public static int tabulation(int n) {
    var dp = new int[n + 1];
    dp[n] = tabulation(n, dp);
    return dp[n];
  }

  private static int tabulation(int N, int[] dp) {
    for (int n = 0; n <= N; n++) {
      if (n == 1 || n == 0) {
        dp[n] = 1;
        continue;
      }
      dp[n] = dp[n - 1] + dp[n - 2] * (n - 1);
    }
    return dp[N];
  }

  // permutation f(n) = n * f(n-1) + nc2 * f(n-2)
  public static int tabulationWithPermutation(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      dp[i] = i * dp[i - 1] + dp[i - 2] * (i * (i - 1)) / 2;
    }
    return dp[n];
  }
}
