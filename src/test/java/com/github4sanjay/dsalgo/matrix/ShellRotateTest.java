package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShellRotateTest {

  @Test
  @DisplayName("Test Rotate Anti-Clockwise - Scenario 1")
  public void testRotateAntiClockWiseScenario1() {
    int[][] matrix = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12},
      {13, 14, 15, 16}
    };

    int[][] expectedResult = {{1, 2, 3, 4}, {5, 11, 10, 8}, {9, 7, 6, 12}, {13, 14, 15, 16}};

    int[][] result = ShellRotate.rotateAntiClockWise(matrix, 2, 2);

    assertArrayEquals(expectedResult, result);
  }

  @Test
  @DisplayName("Test Rotate Anti-Clockwise - Scenario 2")
  public void testRotateAntiClockWiseScenario2() {
    int[][] matrix = {
      {1, 2, 3, 9, 4},
      {1, 2, 3, 9, 4},
      {5, 6, 7, 9, 8},
      {9, 10, 11, 9, 12},
      {13, 14, 15, 9, 16}
    };

    int[][] expectedResult = {
      {1, 2, 3, 9, 4}, {1, 9, 9, 9, 4}, {5, 3, 7, 11, 8}, {9, 2, 6, 10, 12}, {13, 14, 15, 9, 16},
    };

    int[][] result = ShellRotate.rotateAntiClockWise(matrix, 2, 2);

    assertArrayEquals(expectedResult, result);
  }
}
