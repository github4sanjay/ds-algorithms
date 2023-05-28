package com.github4sanjay.dsalgo.dynamic.grid;

/*
Given a value V, if we want to make a change for V cents, and we have an infinite supply of each of C = { C1, C2, .., Cm} valued coins, what is the minimum number of coins to make the change? If it’s not possible to make a change, print -1.

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required We can use one coin of 25 cents and one of 5 cents

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required We can use one coin of 6 cents and 1 coin of 5 cents

 */
public class MinCoinWhenInfiniteCoinsAvailable {
  public static void main(String[] args) {

    System.out.println(countRecursive(new int[] {1, 2, 3}, 4)); // 2
    System.out.println(countRecursive(new int[] {2, 5, 3, 6}, 10)); // 2
    System.out.println(countRecursive(new int[] {25, 10, 5}, 30)); // 2
    System.out.println(countRecursive(new int[] {9, 6, 5, 1}, 11)); // 2

    System.out.println(countMemoize(new int[] {1, 2, 3}, 4)); // 2
    System.out.println(countMemoize(new int[] {2, 5, 3, 6}, 10)); // 2
    System.out.println(countMemoize(new int[] {25, 10, 5}, 30)); // 2
    System.out.println(countMemoize(new int[] {9, 6, 5, 1}, 11)); // 2

    System.out.println(countTabulation(new int[] {1, 2, 3}, 4)); // 2
    System.out.println(countTabulation(new int[] {2, 5, 3, 6}, 10)); // 2
    System.out.println(countTabulation(new int[] {25, 10, 5}, 30)); // 2
    System.out.println(countTabulation(new int[] {9, 6, 5, 1}, 11)); // 2
  }

  public static int countRecursive(int[] coins, int target) {
    return countRecursive(coins, coins.length - 1, target);
  }

  private static int countRecursive(int[] coins, int index, int target) {
    if (index == 0) {
      if (target % coins[index] == 0) return target / coins[index];
      else return Integer.MAX_VALUE;
    }

    var notTake = countRecursive(coins, index - 1, target);
    var take = Integer.MAX_VALUE;
    if (coins[index] <= target) {
      var result = countRecursive(coins, index, target - coins[index]);
      if (result != Integer.MAX_VALUE) {
        take = 1 + result;
      }
    }
    return Math.min(take, notTake);
  }

  public static int countMemoize(int[] coins, int target) {
    return countMemoize(coins, coins.length - 1, target, new Integer[coins.length][target + 1]);
  }

  private static int countMemoize(int[] coins, int index, int target, Integer[][] dp) {
    if (index == 0) {
      if (target % coins[index] == 0) return target / coins[index];
      else return Integer.MAX_VALUE;
    }

    if (dp[index][target] != null) return dp[index][target];

    var notTake = countMemoize(coins, index - 1, target, dp);
    var take = Integer.MAX_VALUE;
    if (coins[index] <= target) {
      var result = countMemoize(coins, index, target - coins[index], dp);
      if (result != Integer.MAX_VALUE) {
        take = 1 + result;
      }
    }
    dp[index][target] = Math.min(take, notTake);
    return dp[index][target];
  }

  public static int countTabulation(int[] coins, int target) {
    var dp = new int[coins.length][target + 1];
    for (int t = 0; t <= target; t++) {
      if (t % coins[0] == 0) {
        dp[0][t] = t / coins[0];
      } else {
        dp[0][t] = Integer.MAX_VALUE;
      }
    }
    for (int i = 1; i < coins.length; i++) {
      for (int t = 0; t <= target; t++) {
        var notTake = dp[i - 1][t];
        var take = Integer.MAX_VALUE;
        if (coins[i] <= t) {
          var result = dp[i][t - coins[i]];
          if (result != Integer.MAX_VALUE) {
            take = 1 + result;
          }
        }
        dp[i][t] = Math.min(take, notTake);
      }
    }
    return dp[coins.length - 1][target];
  }
}
