package com.github4sanjay.dsalgo.dynamic.category1;

public class StairsPathWithVariableJumps {

  public static void main(String[] args) {
    System.out.println(
        StairsPathWithVariableJumps.find(new int[] {5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
  }

  public static int find(int[] jumps) {
    // return dpMemoization(0, jumps, new int[jumps.length+1]);
    // return dpTabular(jumps.length, jumps);
    return recursion(jumps.length, jumps);
  }

  public static int dpTabular(int n, int[] jumps) {
    int[] dp = new int[n + 1];
    dp[n] = 1;
    for (int i = n - 1; i >= 0; i--) {
      int sum = 0;
      for (int j = 1; j <= jumps[i]; j++) {
        if (i + j >= dp.length) continue;
        sum += dp[i + j];
      }
      dp[i] = sum;
    }
    return dp[0];
  }

  private static int dpMemoization(int n, int[] jumps, int[] questionBank) {

    if (n >= jumps.length) {
      if (n == jumps.length) {
        return 1;
      }
      return 0;
    }

    if (questionBank[n] != 0) {
      return questionBank[n];
    }

    int sum = 0;
    for (int i = 1; i <= jumps[n]; i++) {
      sum = sum + dpMemoization(n + i, jumps, questionBank);
    }

    questionBank[n] = sum;
    return sum;
  }

  private static int recursion(int n, int[] jumps) {

    if (n >= jumps.length) {
      if (n == jumps.length) {
        return 1;
      }
      return 0;
    }

    int sum = 0;
    for (int i = 1; i <= jumps[n]; i++) {
      sum = sum + recursion(n + i, jumps);
    }
    return sum;
  }
}
