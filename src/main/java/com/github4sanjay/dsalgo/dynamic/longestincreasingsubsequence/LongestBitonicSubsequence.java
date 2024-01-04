package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

/*
 * Given an array arr[0 … n-1] containing n positive integers, a subsequence of arr[] is called Bitonic if it is first increasing,
 * then decreasing. Write a function that takes an array as argument and returns the length of the longest bitonic subsequence.
 * A sequence, sorted in increasing order is considered Bitonic with the decreasing part as empty. Similarly,
 * decreasing order sequence is considered Bitonic with the increasing part as empty.
 *
 * Examples:
 *
 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
 * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
 *
 * Input arr[] = {12, 11, 40, 5, 3, 1}
 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
 *
 * Input arr[] = {80, 60, 30, 40, 20, 10}
 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)
 */
public class LongestBitonicSubsequence {

  public static int find(int[] arr) {

    int[] increasingSubsequence = increasingSubsequence(arr);
    int[] decreasingSubsequence = decreasingSubsequence(arr);

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, increasingSubsequence[i] + decreasingSubsequence[i] - 1);
    }
    return max;
  }

  private static int[] increasingSubsequence(int[] arr) {
    int[] dp = new int[arr.length];
    dp[0] = 1;

    for (int i = 1; i < arr.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          max = Math.max(max, dp[j]);
        }
      }
      if (max == Integer.MIN_VALUE) {
        dp[i] = 1;
      } else {
        dp[i] = max + 1;
      }
    }

    return dp;
  }

  private static int[] decreasingSubsequence(int[] arr) {
    int[] dp = new int[arr.length];
    dp[arr.length - 1] = 1;

    for (int i = arr.length - 2; i >= 0; i--) {
      int max = Integer.MIN_VALUE;
      for (int j = i + 1; j <= arr.length - 1; j++) {
        if (arr[i] > arr[j]) {
          max = Math.max(max, dp[j]);
        }
      }

      if (max == Integer.MIN_VALUE) {
        dp[i] = 1;
      } else {
        dp[i] = max + 1;
      }
    }

    return dp;
  }
}
