package com.github4sanjay.dsalgo.dynamic.category1;

/*
Given an array arr[] of length N and an integer X, the task is to find the number of subsets with a
 sum equal to X.

Examples:

Input: arr[] = {1, 2, 3, 3}, X = 6
Output: 3
All the possible subsets are {1, 2, 3},
{1, 2, 3} and {3, 3}

Input: arr[] = {1, 1, 1, 1}, X = 1
Output: 4
 */
public class CountsSubsetsWithSumK {

  public static void main(String[] args) {
    System.out.println(recursive(new int[] {1, 2, 3, 3}, 6)); // 3
    System.out.println(recursive(new int[] {1, 1, 1, 1}, 1)); // 4
    System.out.println(recursive(new int[] {1, 2, 2, 3}, 3)); // 3
    System.out.println(recursive(new int[] {3, 5, 6, 7}, 9)); // 4
    System.out.println(recursive(new int[] {1, 2, 1}, 3)); // 2

    System.out.println();

    System.out.println(memoization(new int[] {1, 2, 3, 3}, 6)); // 3
    System.out.println(memoization(new int[] {1, 1, 1, 1}, 1)); // 4
    System.out.println(memoization(new int[] {1, 2, 2, 3}, 3)); // 3
    System.out.println(memoization(new int[] {3, 5, 6, 7}, 9)); // 4
    System.out.println(memoization(new int[] {1, 2, 1}, 3)); // 2

    System.out.println();

    System.out.println(tabular(new int[] {1, 2, 3, 3}, 6)); // 3
    System.out.println(tabular(new int[] {1, 1, 1, 1}, 1)); // 4
    System.out.println(tabular(new int[] {1, 2, 2, 3}, 3)); // 3
    System.out.println(tabular(new int[] {3, 5, 6, 7}, 9)); // 4
    System.out.println(tabular(new int[] {1, 2, 1}, 3)); // 2
  }

  public static int recursive(int[] arr, int sum) {
    return recursive(arr, arr.length - 1, sum);
  }

  private static int recursive(int[] arr, int i, int sum) {
    if (sum == 0) return 1;
    if (i == 0) return arr[i] == sum ? 1 : 0;

    var notTake = recursive(arr, i - 1, sum);
    var take = 0;
    if (arr[i] <= sum) {
      take = recursive(arr, i - 1, sum - arr[i]);
    }
    return take + notTake;
  }

  public static int memoization(int[] arr, int sum) {
    return memoization(arr, arr.length - 1, sum, new Integer[arr.length][sum + 1]);
  }

  private static int memoization(int[] arr, int i, int sum, Integer[][] dp) {
    if (sum == 0) return 1;
    if (i == 0) return arr[i] == sum ? 1 : 0;

    if (dp[i][sum] != null) return dp[i][sum];

    var notTake = recursive(arr, i - 1, sum);
    var take = 0;
    if (arr[i] <= sum) {
      take = recursive(arr, i - 1, sum - arr[i]);
    }
    var result = take + notTake;
    dp[i][sum] = result;
    return result;
  }

  public static int tabular(int[] arr, int sum) {

    var dp = new int[arr.length][sum + 1];
    for (int i = 0; i < arr.length; i++) dp[i][0] = 1;
    if (arr[0] <= sum) {
      dp[0][arr[0]] = 1;
    }

    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        var notTake = dp[i - 1][j];
        var take = 0;
        if (arr[i] <= j) {
          take = dp[i - 1][j - arr[i]];
        }
        var result = take + notTake;
        dp[i][j] = result;
      }
    }

    return dp[dp.length - 1][sum];
  }
}
