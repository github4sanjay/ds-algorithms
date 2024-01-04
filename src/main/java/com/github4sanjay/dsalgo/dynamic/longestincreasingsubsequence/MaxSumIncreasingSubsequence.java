package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

/*
 * Given an array of n positive integers.
 * Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are sorted in increasing order.
 *
 * For example,
 *
 * if input is {1, 101, 2, 3, 100, 4, 5},
 * then output should be 106 (1 + 2 + 3 + 100),
 *
 * if the input array is {3, 4, 5, 10},
 * then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 */
public class MaxSumIncreasingSubsequence {

  public static int recursion(int[] input) {

    return recursion(input, 0, -1);
  }

  private static int recursion(int[] input, int index, int prevInd) {
    if (index == input.length) {
      return 0;
    }
    var notTake = recursion(input, index + 1, prevInd);
    var take = Integer.MIN_VALUE;
    if (prevInd == -1 || input[index] > input[prevInd]) {
      take = input[index] + recursion(input, index + 1, index);
    }
    return Math.max(notTake, take);
  }

  // time -> n^2, space -> n
  public static int find(int[] arr) {

    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    int maxSum = arr[0];

    for (int i = 1; i < arr.length; i++) {
      int sum = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) { // increasing
          sum = Math.max(sum, dp[j]);
        }
      }

      if (sum == Integer.MIN_VALUE) { // handle element if it is the smallest till now
        dp[i] = arr[i];
      } else {
        dp[i] = sum + arr[i];
      }

      maxSum = Math.max(maxSum, dp[i]);
    }
    return maxSum;
  }
}
