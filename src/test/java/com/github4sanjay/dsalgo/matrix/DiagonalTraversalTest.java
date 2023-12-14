package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiagonalTraversalTest {

  @Test
  @DisplayName("Test Diagonal Traversal right")
  public void testDiagonalTraversalRight() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    var expectedResult = Arrays.asList(1, 6, 11, 16, 2, 7, 12, 3, 8, 4);
    var result = DiagonalTraversal.traverseRight(matrix);
    assertEquals(expectedResult, result);
  }

  @Test
  @DisplayName("Test Diagonal Traversal left")
  public void testDiagonalTraversalLeft() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    var expectedResult = Arrays.asList(1, 6, 11, 16, 5, 10, 15, 9, 14, 13);
    var result = DiagonalTraversal.traverseLeft(matrix);
    assertEquals(expectedResult, result);
  }
}
