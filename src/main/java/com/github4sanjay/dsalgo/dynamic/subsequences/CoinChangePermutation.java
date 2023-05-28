package com.github4sanjay.dsalgo.dynamic.subsequences;

public class CoinChangePermutation {
  public static void main(String[] args) {

    System.out.println(count(new int[] {1, 2, 3}, 4)); // 7 1111,112,13,31,121,211,22
    System.out.println(count(new int[] {2, 5, 3, 6}, 7)); // 5
  }

  private static int count(int[] coins, int target) {

    int[] dp = new int[target + 1]; // stores no. of ways to pay target at index

    dp[0] = 1; // ways to pay 0 is always 1
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] > i) continue;
        dp[i] = dp[i] + dp[i - coins[j]];
      }
    }
    return dp[target];
  }
}
