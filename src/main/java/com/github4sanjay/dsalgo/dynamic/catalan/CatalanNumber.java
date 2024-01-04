package com.github4sanjay.dsalgo.dynamic.catalan;

/*
 * Program for nth Catalan Number
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * 2) Count the number of possible Binary Search Trees with n keys
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 * 4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
 *
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 *
 * Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
 *
 * Recursive Solution
 * Catalan numbers satisfy the following recursive formula.
 *
 *
 * C0=1 and Cn+1= sum{i=0}^{n}Ci*Cn-i for n geq 0;
 */
public class CatalanNumber {

  /*
   *
   * C0 = 1
   * C1 = 1
   * C2 = C0*C1 + C1*C0 = 2
   * C3 = C0*C2 + C1*C1 + C2*C0 = 5
   * C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0 = 14
   */
  public static int recursion(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + recursion(i) * recursion(n - i - 1);
    }
    return sum;
  }

  public static int memoization(int n) {
    var dp = new Integer[n + 1];
    dp[n] = memoization(n, dp);
    return dp[n];
  }

  private static int memoization(int n, Integer[] dp) {
    if (n == 0 || n == 1) {
      return 1;
    }
    if (dp[n] != null) {
      return dp[n];
    }
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum = sum + memoization(i, dp) * memoization(n - i - 1, dp);
    }
    dp[n] = sum;
    return dp[n];
  }

  public static int tabulation(int n) {
    var dp = new Integer[n + 1];
    dp[n] = tabulation(n, dp);
    return dp[n];
  }

  private static int tabulation(int N, Integer[] dp) {
    for (var n = 0; n <= N; n++) {
      if (n == 0 || n == 1) {
        dp[n] = 1;
        continue;
      }

      int sum = 0;
      for (int i = 0; i < n; i++) {
        sum = sum + dp[i] * dp[n - i - 1];
      }
      dp[n] = sum;
    }
    return dp[N];
  }
}
