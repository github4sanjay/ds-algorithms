package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

/*
  The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
  such that all elements of the subsequence are sorted in increasing order.
  For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.

  Examples:

  Input: arr[] = {3, 10, 2, 1, 20}
  Output: Length of LIS = 3
  The longest increasing subsequence is 3, 10, 20

  Input: arr[] = {3, 2}
  Output: Length of LIS = 1
  The longest increasing subsequences are {3} and {2}

  Input: arr[] = {50, 3, 10, 7, 40, 80}
  Output: Length of LIS = 4
  The longest increasing subsequence is {3, 7, 40, 80}
*/
public class LongestIncreasingSubsequence {

  public static int recursion(int[] input) {
    return recursion(input, 0, -1);
  }

  private static int recursion(int[] input, int index, int maxIndex) {
    if (index == input.length) {
      return 0;
    }
    var notTake = recursion(input, index + 1, maxIndex);
    var take = Integer.MIN_VALUE;
    if (maxIndex == -1 || input[index] > input[maxIndex]) {
      take = 1 + recursion(input, index + 1, index);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int[] input) {
    // max index starts with -1 so store everything with adding + 1
    var dp = new Integer[input.length][input.length + 1];
    dp[0][0] = memoization(input, 0, -1, dp);
    return dp[0][0];
  }

  private static int memoization(int[] input, int index, int maxIndex, Integer[][] dp) {
    if (index == input.length) {
      return 0;
    }
    if (dp[index][maxIndex + 1] != null) {
      return dp[index][maxIndex + 1];
    }
    var notTake = memoization(input, index + 1, maxIndex, dp);
    var take = Integer.MIN_VALUE;
    if (maxIndex == -1 || input[index] > input[maxIndex]) {
      take = 1 + memoization(input, index + 1, index, dp);
    }
    dp[index][maxIndex + 1] = Math.max(notTake, take);
    return dp[index][maxIndex + 1];
  }

  // time -> n^2, space -> n
  public static int tabulation(int[] arr) {
    int[] dp = new int[arr.length];
    dp[0] = 1;
    int max = 1;
    for (int i = 1; i < arr.length; i++) {
      int localMax = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) { // increasing
          localMax = Math.max(localMax, dp[j]);
        }
      }

      if (localMax == Integer.MIN_VALUE) { // handle element if it is the smallest till now
        dp[i] = 1;
      } else {
        dp[i] = localMax + 1;
      }

      max = Math.max(max, dp[i]);
    }

    return max;
  }
}
