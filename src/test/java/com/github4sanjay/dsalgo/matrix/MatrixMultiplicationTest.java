package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatrixMultiplicationTest {

  @Test
  public void testMultiply_ValidMatrices() {
    int[][] mat1 = {
      {1, 1, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    int[][] mat2 = {
      {1, 1, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    int[][] expectedResult = {
      {10, 10, 10, 10},
      {20, 20, 20, 20},
      {30, 30, 30, 30},
      {40, 40, 40, 40}
    };

    int[][] result = MatrixMultiplication.multiply(mat1, mat2);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testMultiply_InvalidMatrices() {
    int[][] mat1 = {
      {1, 1},
      {2, 2},
      {3, 3},
    };

    int[][] mat2 = {
      {1, 1, 1},
      {2, 2, 1},
      {2, 2, 1}
    };

    assertThrows(
        RuntimeException.class,
        () -> MatrixMultiplication.multiply(mat1, mat2),
        "Multiplication not possible");
  }
}
