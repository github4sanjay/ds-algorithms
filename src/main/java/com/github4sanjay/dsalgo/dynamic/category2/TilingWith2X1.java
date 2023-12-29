package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles.
 * A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 * Examples:
 *
 * Input n = 3
 * Output: 3
 * Explanation:
 * We need 3 tiles to tile the board of size  2 x 3.
 * We can tile the board using following ways
 * 1) Place all 3 tiles vertically.
 * 2) Place first tile vertically and remaining 2 tiles horizontally.
 * 3) Place first 2 tiles horizontally and remaining tiles vertically
 *
 * Input n = 4
 * Output: 5
 * Explanation:
 * For a 2 x 4 board, there are 5 ways
 * 1) All 4 vertical
 * 2) All 4 horizontal
 * 3) First 2 vertical, remaining 2 horizontal
 * 4) First 2 horizontal, remaining 2 vertical
 * 5) Corner 2 vertical, middle 2 horizontal
 */
public class TilingWith2X1 {
  public static int recursion(int n) {
    if (n == 0) return 1;
    if (n == 1) {
      return 1;
    }

    return recursion(n - 1) + recursion(n - 2);
  }

  public static int memoization(int n) {
    var dp = new int[n + 1];
    dp[n] = memoization(n, dp);
    return dp[n];
  }

  private static int memoization(int n, int[] dp) {
    if (n == 0) return 1;
    if (n == 1) {
      return 1;
    }
    if (dp[n] != 0) {
      return dp[n];
    }
    dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
    return dp[n];
  }

  public static int tabulation(int n) {
    var dp = new int[n + 1];
    dp[n] = tabulation(n, dp);
    return dp[n];
  }

  private static int tabulation(int N, int[] dp) {
    for (var n = 0; n <= N; n++) {
      if (n == 0 || n == 1) {
        dp[n] = 1;
        continue;
      }

      dp[n] = dp[n - 1] + dp[n - 2];
    }
    return dp[N];
  }

  public static int variableDP(int n) {
    int secondLast = 0;
    int last = 1;
    for (int i = 1; i <= n; i++) {
      int temp = last;
      last = secondLast + last;
      secondLast = temp;
    }
    return last;
  }
}
