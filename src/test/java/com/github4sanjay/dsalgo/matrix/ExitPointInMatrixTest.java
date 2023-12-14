package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExitPointInMatrixTest {

  @Test
  public void testFind() {
    int[][] matrix1 = {
      {0, 1, 0, 1},
      {0, 0, 0, 0},
      {1, 0, 0, 1},
      {0, 0, 0, 0}
    };

    ExitPointInMatrix.Point expectedPoint = new ExitPointInMatrix.Point(3, 1);
    ExitPointInMatrix.Point result = ExitPointInMatrix.find(matrix1);

    assertEquals(expectedPoint.row, result.row);
    assertEquals(expectedPoint.col, result.col);
  }
}
