package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * 1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
 * 2. You've an infinite supply of m * 1 tiles.
 * 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
 *
 * n 39
 * m 16
 *
 * 61
 */
public class TilingWithKX1 {

  public static void main(String[] args) {
    System.out.println(TilingWithKX1.find(39, 16)); // 61
  }

  private static int find(int n, int m) {
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      if (i < m) {
        dp[i] = 1;
      } else if (i == m) {
        dp[i] = 2;
      } else {
        dp[i] = dp[i - 1] + dp[i - m];
      }
    }
    return dp[n];
  }

  // brute force
  private static int findWithBruteForce(int n, int m) {
    if (n < 0) return 0;
    if (n == 1 || n == 0) return 1;
    return findWithBruteForce(n - 1, m) + findWithBruteForce(n - m, m);
  }
}
