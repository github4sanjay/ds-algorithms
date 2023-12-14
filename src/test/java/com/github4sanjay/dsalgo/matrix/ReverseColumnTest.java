package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseColumnTest {

  @Test
  @DisplayName("Test Reverse Columns")
  public void testReverse() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] expectedResult = {
      {4, 3, 2, 1},
      {8, 7, 6, 5},
      {12, 11, 10, 9},
      {16, 15, 14, 13}
    };

    int[][] result = ReverseColumn.reverse(matrix);

    assertArrayEquals(expectedResult, result);
  }
}
