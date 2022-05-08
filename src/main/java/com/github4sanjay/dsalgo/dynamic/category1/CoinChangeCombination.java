package com.github4sanjay.dsalgo.dynamic.category1;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S
 * = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins
 * doesn’t matter.
 *
 * <p>For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are
 * five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.
 */
public class CoinChangeCombination {

  public static void main(String[] args) {

    System.out.println(count(new int[] {1, 2, 3}, 4)); // 4
    System.out.println(count(new int[] {2, 5, 3, 6}, 10)); // 5
  }

  private static int count(int[] coins, int target) {

    int[] dp = new int[target + 1]; // stores no. of ways to pay target at index

    dp[0] = 1; // ways to pay 0 is always 1
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j < dp.length; j++) {
        dp[j] = dp[j] + dp[j - coins[i]];
      }
    }
    return dp[target];
  }
}
