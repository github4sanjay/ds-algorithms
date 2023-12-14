package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotateBy90DegreeTest {

  @Test
  public void testRotateAntiClockWise() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] expectedResult = {
      {4, 8, 12, 16},
      {3, 7, 11, 15},
      {2, 6, 10, 14},
      {1, 5, 9, 13}
    };

    int[][] result = RotateBy90Degree.rotateAntiClockWise(matrix);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  public void testRotateClockWise() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] expectedResult = {
      {13, 9, 5, 1},
      {14, 10, 6, 2},
      {15, 11, 7, 3},
      {16, 12, 8, 4}
    };

    int[][] result = RotateBy90Degree.rotateClockWise(matrix);

    assertArrayEquals(expectedResult, result);
  }
}
