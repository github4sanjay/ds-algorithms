package com.github4sanjay.dsalgo.dynamic.stairs;

public class StairsPathWithVariableJumps {

  public static void main(String[] args) {
    System.out.println(
        StairsPathWithVariableJumps.recursion(new int[] {5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
  }

  public static int recursion(int[] jumps) {
    return recursion(jumps.length, jumps);
  }

  private static int recursion(int n, int[] jumps) {

    if (n < 0) return 0;
    if (n == 0) return 1;

    int sum = 0;
    for (int i = 1; i <= jumps[jumps.length - n]; i++) {
      sum = sum + recursion(n - i, jumps);
    }
    return sum;
  }

  public static int memoization(int[] jumps) {
    var dp = new int[jumps.length + 1];
    dp[jumps.length] = memoization(jumps.length, jumps, dp);
    return dp[jumps.length];
  }

  private static int memoization(int n, int[] jumps, int[] dp) {

    if (n < 0) return 0;
    if (n == 0) return 1;

    if (dp[n] != 0) {
      return dp[n];
    }

    int sum = 0;
    for (int i = 1; i <= jumps[jumps.length - n]; i++) {
      sum = sum + recursion(n - i, jumps);
    }
    dp[n] = sum;
    return sum;
  }

  public static int tabular(int[] jumps) {
    var dp = new int[jumps.length + 1];
    dp[0] = tabular(jumps.length, jumps, dp);
    return dp[0];
  }

  private static int tabular(int N, int[] jumps, int[] dp) {

    for (int n = N; n >= 0; n--) {
      if (n == N) {
        dp[n] = 1;
        continue;
      }

      int sum = 0;
      for (int i = 1; i <= jumps[n]; i++) {
        if (n + i <= N) {
          sum = sum + dp[n + i];
        }
      }
      dp[n] = sum;
    }
    return dp[0];
  }
}
