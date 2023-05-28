package com.github4sanjay.dsalgo.dynamic.category1;

/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square
that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */
public class UniqueGridPathsWithObstacles {

  public static void main(String[] args) {
    var grid = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(recursive(grid)); // 2
    System.out.println(memoization(grid)); // 2
    System.out.println(tabular(grid)); // 2

    grid = new int[][] {{0, 1}, {0, 0}};
    System.out.println(recursive(grid)); // 1
    System.out.println(memoization(grid)); // 1
    System.out.println(tabular(grid)); // 1
  }

  public static int recursive(int[][] grid) {
    return recursive(grid, grid.length - 1, grid[0].length - 1);
  }

  private static int recursive(int[][] grid, int m, int n) {
    if (n < 0 || m < 0) return 0;
    if (grid[m][n] == 1) return 0;
    else if (m == 0 && n == 0) return 1;
    else return recursive(grid, m - 1, n) + recursive(grid, m, n - 1);
  }

  public static int memoization(int[][] grid) {
    return memoization(
        grid, grid.length - 1, grid[0].length - 1, new Integer[grid.length][grid[0].length]);
  }

  private static int memoization(int[][] grid, int m, int n, Integer[][] dp) {
    if (n < 0 || m < 0) return 0;
    else if (grid[m][n] == 1) return 0;
    else if (m == 0 && n == 0) return 1;
    if (dp[m][n] != null) return dp[m][n];
    else {
      var result = recursive(grid, m - 1, n) + recursive(grid, m, n - 1);
      dp[m][n] = result;
      return result;
    }
  }

  public static int tabular(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    var dp = new Integer[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) dp[i][j] = 0;
        else if (i == 0 || j == 0) {
          dp[i][j] = 1;
        } else {
          var result = dp[i - 1][j] + dp[i][j - 1];
          dp[i][j] = result;
        }
      }
    }
    return dp[m - 1][n - 1];
  }
}
