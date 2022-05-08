package com.github4sanjay.dsalgo.dynamic.category2;

/**
 * 1. You are given a number n, representing the number of elements. 2. You are given a number k,
 * representing the number of subsets. 3. You are required to print the number of ways in which
 * these elements can be partitioned in k non-empty subsets. E.g. For n = 4 and k = 3 total ways is
 * 6 12-3-4 1-23-4 13-2-4 14-2-3 1-24-3 1-2-34
 *
 * <p>Note : For brute force check backtracking
 */
public class PartitionKSubsets {

  public static void main(String[] args) {
    System.out.println(PartitionKSubsets.find(5, 4));
  }

  private static int find(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (i == j) {
          dp[i][j] = 1;
        } else if (i < j) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
        }
      }
    }
    return dp[n][k];
  }

  private static int findByRecursion(int n, int k) {
    if (n < 0 || k < 0) return 0;
    if (n < k) return 0;
    if (n == k) return 1;

    return k * findByRecursion(n - 1, k) + findByRecursion(n - 1, k - 1);
  }
}
