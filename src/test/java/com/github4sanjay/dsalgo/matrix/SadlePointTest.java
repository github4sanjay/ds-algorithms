package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SadlePointTest {

  @Test
  public void testFind() {
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {10, 18, 4}};

    assertEquals(7, SadlePoint.find(matrix1));
    assertThrows(RuntimeException.class, () -> SadlePoint.find(matrix2));
  }
}
