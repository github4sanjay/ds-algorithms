package com.github4sanjay.dsalgo.dynamic.grid;

/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the
bottom-right corner.

Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
public class UniqueGridPaths {

  public static void main(String[] args) {
    int m = 3, n = 7;
    System.out.println(recursive(m - 1, n - 1)); // 28
    System.out.println(memoization(m, n)); // 28
    System.out.println(tabular(m, n)); // 28

    m = 3;
    n = 2;
    System.out.println(recursive(m - 1, n - 1)); // 3
    System.out.println(memoization(m, n)); // 3
    System.out.println(tabular(m, n)); // 3
  }

  public static int recursive(int m, int n) {
    if (n < 0 || m < 0) return 0;
    else if (m == 0 && n == 0) return 1;
    else return recursive(m - 1, n) + recursive(m, n - 1);
  }

  public static int memoization(int m, int n) {
    return memoization(m - 1, n - 1, new Integer[m][n]);
  }

  private static int memoization(int m, int n, Integer[][] dp) {
    if (n < 0 || m < 0) return 0;
    else if (m == 0 && n == 0) return 1;
    if (dp[m][n] != null) return dp[m][n];
    else {
      var result = recursive(m - 1, n) + recursive(m, n - 1);
      dp[m][n] = result;
      return result;
    }
  }

  public static int tabular(int m, int n) {
    var dp = new Integer[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 1;
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        var result = dp[i - 1][j] + dp[i][j - 1];
        dp[i][j] = result;
      }
    }
    return dp[m - 1][n - 1];
  }
}
