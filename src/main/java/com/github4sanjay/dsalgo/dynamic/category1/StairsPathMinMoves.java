package com.github4sanjay.dsalgo.dynamic.category1;

public class StairsPathMinMoves {

  public static void main(String[] args) {
    System.out.println(StairsPathMinMoves.find(new int[] {3, 3, 1, 1, 4, 1, 1, 0, 1, 1, 1}));
  }

  public static Integer find(int[] jumps) {
    // return dpMemoization(0, jumps, new int[jumps.length+1]);
    // return recursion(0, jumps);
    return dpTabular(jumps.length, jumps);
  }

  public static Integer dpTabular(int n, int[] jumps) {
    Integer[] dp = new Integer[n + 1];
    dp[n] = 0; // minimum moves
    for (int i = n - 1; i >= 0; i--) {
      int min = Integer.MAX_VALUE;
      for (int j = 1; j <= jumps[i]; j++) {
        if (i + j >= dp.length) continue;
        if (dp[i + j] != null && dp[i + j] < min) {
          min = dp[i + j];
        }
      }
      if (min != Integer.MAX_VALUE) dp[i] = min + 1;
    }
    return dp[0];
  }
}
