package com.github4sanjay.dsalgo.dynamic.grid;

public class LargestSquareSubmatrix {
  /*
   * Go to each cell of the matrix
   * If the cell has 1, then find the largest square of 1s with the current cell as the top left corner.
   *      Recursively traverse the cells to find the largest square of 1s till a 0 is encountered or position is not valid.
   * Keep track of the size of the largest square.
   */
  public static int recursion(int[][] matrix) {
    var result = Integer.MIN_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(result, recursion(matrix, i, j));
      }
    }
    return result;
  }

  private static int recursion(int[][] matrix, int i, int j) {
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
      return 0;
    }

    if (matrix[i][j] == 0) {
      return 0;
    }
    return 1
        + Math.min(
            recursion(matrix, i + 1, j),
            Math.min(recursion(matrix, i + 1, j + 1), recursion(matrix, i, j + 1)));
  }

  public static int memoization(int[][] matrix) {
    var result = Integer.MIN_VALUE;
    var dp = new Integer[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(result, memoization(matrix, i, j, dp));
      }
    }
    return result;
  }

  private static int memoization(int[][] matrix, int i, int j, Integer[][] dp) {
    if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
      return 0;
    }
    if (matrix[i][j] == 0) {
      return 0;
    }
    if (dp[i][j] != null) {
      return dp[i][j];
    }
    dp[i][j] =
        1
            + Math.min(
                memoization(matrix, i + 1, j, dp),
                Math.min(memoization(matrix, i + 1, j + 1, dp), memoization(matrix, i, j + 1, dp)));
    return dp[i][j];
  }

  public static int tabulation(int[][] matrix) {
    var result = Integer.MIN_VALUE;
    var dp = new Integer[matrix.length][matrix[0].length];
    tabulation(matrix, matrix.length - 1, matrix[0].length - 1, dp);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(result, dp[i][j]);
      }
    }
    return result;
  }

  private static void tabulation(int[][] matrix, int I, int J, Integer[][] dp) {
    for (int i = I; i >= 0; i--) {
      for (int j = J; j >= 0; j--) {
        if (i == I) {
          dp[i][j] = matrix[i][j];
          continue;
        }
        if (j == J) {
          dp[i][j] = matrix[i][j];
          continue;
        }
        if (matrix[i][j] == 0) {
          dp[i][j] = 0;
          continue;
        }
        dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
      }
    }
  }
}
