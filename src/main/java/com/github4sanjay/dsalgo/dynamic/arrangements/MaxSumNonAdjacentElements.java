package com.github4sanjay.dsalgo.dynamic.arrangements;

/*
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers
 * in the sequence should be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7
 * should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 *
 * Examples :
 *
 * Input : arr[] = {5, 5, 10, 100, 10, 5}
 * Output : 110
 *
 * Input : arr[] = {1, 2, 3}
 * Output : 4
 *
 * Input : arr[] = {1, 20, 3}
 * Output : 20
 */
public class MaxSumNonAdjacentElements {

  public static int recursion(int[] arr) {
    return recursion(arr, arr.length - 1);
  }

  // brute force 2^n time complexity
  private static int recursion(int[] arr, int index) {

    if (index == 0) return arr[0];
    if (index < 0) return 0;

    var notTake = recursion(arr, index - 1);
    var take = arr[index] + recursion(arr, index - 2);
    return Math.max(notTake, take);
  }

  public static int memoization(int[] arr) {
    return memoization(arr, arr.length - 1, new Integer[arr.length]);
  }

  //  O(n) time complexity, space O(n) + O(n)
  private static int memoization(int[] arr, int index, Integer[] dp) {

    if (index == 0) return arr[0];
    if (index < 0) return 0;

    if (dp[index] != null) return dp[index];

    var notTake = recursion(arr, index - 1);
    var take = arr[index] + recursion(arr, index - 2);
    var result = Math.max(notTake, take);
    dp[index] = result;
    return result;
  }

  //  O(n) time complexity, space O(n)
  public static int tabulation(int[] arr) {
    var dp = new int[arr.length];
    dp[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      var notTake = dp[i - 1];
      var take = arr[i];
      if (i - 2 >= 0) {
        take = take + dp[i - 2];
      }
      var result = Math.max(notTake, take);
      dp[i] = result;
    }

    return dp[arr.length - 1];
  }

  //  O(n) time complexity, space constant
  public static int tabulationSpaceOptimized(int[] arr) {
    var prev1 = arr[0];
    var prev2 = 0;
    for (int i = 1; i < arr.length; i++) {
      var notTake = prev1;
      var take = arr[i];
      if (i - 2 >= 0) {
        take = take + prev2;
      }
      var result = Math.max(notTake, take);
      prev2 = prev1;
      prev1 = result;
    }

    return prev1;
  }

  public static int variableDP(int[] arr) {

    int include = 0;
    int exclude = 0;
    for (int j : arr) {
      int tempInclude = include;
      include = j + exclude;
      exclude = Math.max(tempInclude, exclude);
    }

    return Math.max(include, exclude);
  }
}
