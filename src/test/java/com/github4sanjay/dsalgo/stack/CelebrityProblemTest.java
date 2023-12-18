package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class CelebrityProblemTest {

  @Test
  void testCelebrityFound() {
    int[][] matrix1 = {
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 0, 0},
      {0, 0, 1, 0}
    };
    assertEquals(2, CelebrityProblem.find(matrix1));
  }

  @Test
  void testNoCelebrity() {
    int[][] matrix2 = {
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 1, 0, 0},
      {0, 0, 1, 0}
    };
    assertNull(CelebrityProblem.find(matrix2));
  }
}
