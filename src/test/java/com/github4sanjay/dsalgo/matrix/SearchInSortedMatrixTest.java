package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchInSortedMatrixTest {

  @Test
  @DisplayName("Test Search in Sorted Matrix")
  public void testSearchInSortedMatrix() {
    int[][] matrix = {
      {10, 20, 30, 40},
      {15, 25, 35, 45},
      {27, 29, 37, 48},
      {32, 33, 39, 50}
    };

    int target1 = 29;
    SearchInSortedMatrix.Point expectedResult1 = new SearchInSortedMatrix.Point(2, 1);

    SearchInSortedMatrix.Point result1 = SearchInSortedMatrix.find(matrix, target1);

    assertEquals(expectedResult1.x, result1.x);
    assertEquals(expectedResult1.y, result1.y);

    int target2 = 100;
    SearchInSortedMatrix.Point expectedResult2 = null;

    SearchInSortedMatrix.Point result2 = SearchInSortedMatrix.find(matrix, target2);

    assertNull(result2);
  }
}
