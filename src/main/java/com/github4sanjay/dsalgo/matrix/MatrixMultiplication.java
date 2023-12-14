package com.github4sanjay.dsalgo.matrix;

/**
 * Program to multiply two matrices
 *
 * <p>Given two matrices, the task to multiply them. Matrices can either be square or rectangular.
 *
 * <p>Examples:
 *
 * <p>Input : mat1[][] = {{1, 2}, {3, 4}} mat2[][] = {{1, 1}, {1, 1}} Output : {{3, 3}, {7, 7}}
 * Input : mat1[][] = {{2, 4}, {3, 4}} mat2[][] = {{1, 2}, {1, 3}} Output : {{6, 16}, {7, 18}}
 */
public class MatrixMultiplication {

  public static int[][] multiply(int[][] mat1, int[][] mat2) {
    if (mat1[0].length != mat2.length) {
      throw new RuntimeException("Multiplication not possible");
    }
    var result = new int[mat1.length][mat2[0].length];
    for (int i = 0; i < result.length; i++) {
      for (int j = 0; j < result[0].length; j++) {
        int sum = 0;
        for (int k = 0; k < mat2.length /*m1[0].length*/; k++) {
          sum = sum + mat1[i][k] * mat2[k][j];
        }
        result[i][j] = sum;
      }
    }
    return result;
  }
}
