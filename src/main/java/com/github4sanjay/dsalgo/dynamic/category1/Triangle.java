package com.github4sanjay.dsalgo.dynamic.category1;

/*
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally,
if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 */
public class Triangle {
  public static void main(String[] args) {
    System.out.println(
        recursive(
            new int[][] {
              {2, 0, 0, 0},
              {3, 4, 0, 0},
              {6, 5, 7, 0},
              {4, 1, 8, 3},
            })); // 11

    System.out.println(
        recursive(
            new int[][] {
              {-10},
            })); // -10

    System.out.println(
        memoization(
            new int[][] {
              {2, 0, 0, 0},
              {3, 4, 0, 0},
              {6, 5, 7, 0},
              {4, 1, 8, 3},
            })); // 11

    System.out.println(
        memoization(
            new int[][] {
              {-10},
            })); // -10

    System.out.println(
        tabular(
            new int[][] {
              {2, 0, 0, 0},
              {3, 4, 0, 0},
              {6, 5, 7, 0},
              {4, 1, 8, 3},
            })); // 11

    System.out.println(
        tabular(
            new int[][] {
              {-10},
            })); // -10
  }

  public static int recursive(int[][] triangle) {
    return recursive(triangle, 0, 0);
  }

  private static int recursive(int[][] triangle, int i, int j) {
    if (i == triangle.length - 1) return triangle[i][j];
    var d = triangle[i][j] + recursive(triangle, i + 1, j);
    var dg = triangle[i][j] + recursive(triangle, i + 1, j + 1);
    return Math.min(d, dg);
  }

  public static int memoization(int[][] triangle) {
    return recursive(triangle, 0, 0, new Integer[triangle.length][triangle[0].length]);
  }

  private static int recursive(int[][] triangle, int i, int j, Integer[][] dp) {
    if (i == triangle.length - 1) return triangle[i][j];
    if (dp[i][j] != null) return dp[i][j];
    var d = triangle[i][j] + recursive(triangle, i + 1, j);
    var dg = triangle[i][j] + recursive(triangle, i + 1, j + 1);
    var result = Math.min(d, dg);
    dp[i][j] = result;
    return result;
  }

  public static int tabular(int[][] triangle) {
    var dp = new int[triangle.length][triangle[0].length];
    for (int j = 0; j < triangle[triangle.length - 1].length; j++) {
      dp[triangle.length - 1][j] = triangle[triangle.length - 1][j];
    }
    for (int i = triangle.length - 2; i >= 0; i--) {
      for (int j = i; j >= 0; j--) {
        var d = triangle[i][j] + dp[i + 1][j];
        var dg = triangle[i][j] + dp[i + 1][j + 1];
        var result = Math.min(d, dg);
        dp[i][j] = result;
      }
    }
    return dp[0][0];
  }
}
