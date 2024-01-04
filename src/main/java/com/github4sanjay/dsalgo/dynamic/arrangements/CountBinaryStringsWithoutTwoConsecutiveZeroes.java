package com.github4sanjay.dsalgo.dynamic.arrangements;

/*
 * 1. You are given a number n.
 * 2. You are required to print the number of binary strings of length
 * n with no consecutive 0's.
 *
 * 6 -> 21
 */
public class CountBinaryStringsWithoutTwoConsecutiveZeroes {

  public static int recursion(int n) {
    return recursion(n, 1, 1, 1);
  }

  private static int recursion(int n, int index, int totalEndingWith0, int totalEndingWith1) {
    if (index == n) {
      return totalEndingWith0 + totalEndingWith1;
    }
    return recursion(n, index + 1, totalEndingWith1, totalEndingWith0 + totalEndingWith1);
  }

  public static int memoization(int n) {
    var dp = new Integer[n + 1];
    dp[n] = memoization(n, 1, 1, 1, dp);
    return dp[n];
  }

  private static int memoization(
      int n, int index, int totalEndingWith0, int totalEndingWith1, Integer[] dp) {
    if (index == n) {
      return totalEndingWith0 + totalEndingWith1;
    }
    if (dp[index] != null) {
      return dp[index];
    }
    var result =
        memoization(n, index + 1, totalEndingWith1, totalEndingWith0 + totalEndingWith1, dp);
    dp[index] = result;
    return result;
  }

  public static int tabulation(int n) {
    int countEndWithZero = 1; // count of length 1 end with 0
    int countEndWithOne = 1; // count of length 1 end with 1
    for (int i = 2; i <= n; i++) {
      int temp = countEndWithOne;
      countEndWithOne = countEndWithOne + countEndWithZero;
      countEndWithZero = temp;
    }
    return countEndWithOne + countEndWithZero;
  }
}
