package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ZigZagTraversalTest {

  @Test
  @DisplayName("Test ZigZag Traversal")
  public void testZigZagTraversal() {
    int[][] matrix1 = {
      {1, 1, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    var expectedResult1 = Arrays.asList(1, 1, 2, 3, 2, 1, 1, 2, 3, 4, 4, 3, 2, 3, 4, 4);

    var result1 = ZigZagTraversal.traverseOnlySquareMatrix(matrix1);

    assertEquals(expectedResult1, result1);

    int[][] matrix2 = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    var expectedResult2 = Arrays.asList(1, 2, 4, 7, 5, 3, 6, 8, 9);

    var result2 = ZigZagTraversal.traverseOnlySquareMatrix(matrix2);

    assertEquals(expectedResult2, result2);
  }

  @Test
  @DisplayName("Test ZigZag Traversal for non square matrix")
  public void testZigZagTraversalNonSquareMatrix() {
    int[][] matrix1 = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9},
      {10, 11, 12},
      {13, 14, 15}
    };

    var expectedResult1 = Arrays.asList(1, 2, 4, 7, 5, 3, 6, 8, 10, 13, 11, 9, 12, 14, 15);
    var result1 = ZigZagTraversal.traverse(matrix1);
    assertEquals(expectedResult1, result1);
  }
}
