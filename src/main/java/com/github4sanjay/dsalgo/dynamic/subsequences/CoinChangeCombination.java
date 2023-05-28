package com.github4sanjay.dsalgo.dynamic.subsequences;

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

    System.out.println(tabular1D(new int[] {1, 2, 3}, 4)); // 4
    System.out.println(tabular1D(new int[] {2, 5, 3, 6}, 10)); // 5

    System.out.println(countRecursive(new int[] {1, 2, 3}, 4)); // 4 1111,112,13,121,22
    System.out.println(countRecursive(new int[] {2, 5, 3, 6}, 10)); // 5

    System.out.println(countMemoization(new int[] {1, 2, 3}, 4)); // 4 1111,112,13,121,22
    System.out.println(countMemoization(new int[] {2, 5, 3, 6}, 10)); // 5

    System.out.println(tabular2D(new int[] {1, 2, 3}, 4)); // 4 1111,112,13,121,22
    System.out.println(tabular2D(new int[] {2, 5, 3, 6}, 10)); // 5
  }

  private static int tabular1D(int[] coins, int target) {

    int[] dp = new int[target + 1]; // stores no. of ways to pay target at index

    dp[0] = 1; // ways to pay 0 is always 1
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j < dp.length; j++) {
        dp[j] = dp[j] + dp[j - coins[i]];
      }
    }
    return dp[target];
  }

  public static int countRecursive(int[] coins, int target) {
    return countRecursive(coins, coins.length - 1, target);
  }

  private static int countRecursive(int[] coins, int index, int target) {
    if (index == 0) {
      if (target % coins[index] == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    var notTake = countRecursive(coins, index - 1, target);
    var take = 0;
    if (coins[index] <= target) {
      take = countRecursive(coins, index, target - coins[index]);
    }
    return take + notTake;
  }

  public static int countMemoization(int[] coins, int target) {
    return countMemoization(coins, coins.length - 1, target, new Integer[coins.length][target + 1]);
  }

  private static int countMemoization(int[] coins, int index, int target, Integer[][] dp) {
    if (index == 0) {
      if (target % coins[index] == 0) {
        return 1;
      } else {
        return 0;
      }
    }

    if (dp[index][target] != null) return dp[index][target];

    var notTake = countMemoization(coins, index - 1, target, dp);
    var take = 0;
    if (coins[index] <= target) {
      take = countMemoization(coins, index, target - coins[index], dp);
    }
    var result = take + notTake;
    dp[index][target] = result;
    return result;
  }

  private static int tabular2D(int[] coins, int target) {
    var dp = new int[coins.length][target + 1];

    for (int t = 0; t <= target; t++) {
      if (t % coins[0] == 0) {
        dp[0][t] = 1;
      } else {
        dp[0][t] = 0;
      }
    }

    for (int i = 1; i < coins.length; i++) {
      for (int t = 0; t <= target; t++) {
        var notTake = dp[i - 1][t];
        var take = 0;
        if (coins[i] <= t) {
          take = dp[i][t - coins[i]];
        }
        var result = take + notTake;
        dp[i][t] = result;
      }
    }
    return dp[coins.length - 1][target];
  }
}
