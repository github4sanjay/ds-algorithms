package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReverseRowTest {

  @Test
  @DisplayName("Test Reverse Rows")
  public void testReverse() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] expectedResult = {
      {13, 14, 15, 16},
      {9, 10, 11, 12},
      {5, 6, 7, 8},
      {1, 2, 3, 4}
    };

    int[][] result = ReverseRow.reverse(matrix);

    assertArrayEquals(expectedResult, result);
  }
}
