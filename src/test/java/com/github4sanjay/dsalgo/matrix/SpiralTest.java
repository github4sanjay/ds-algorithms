package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SpiralTest {

  @Test
  public void testClockWise() {
    int[][] matrix = {
      {1, 2, 3, 4, 5, 6},
      {7, 8, 9, 10, 11, 12},
      {13, 14, 15, 16, 17, 18}
    };

    var expectedResult =
        Arrays.asList(1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11);

    var result = Spiral.clockWise(matrix);

    assertEquals(expectedResult, result);
  }

  @Test
  public void testAntiClockWise() {
    int[][] matrix = {
      {1, 2, 3, 4, 5, 6},
      {7, 8, 9, 10, 11, 12},
      {13, 14, 15, 16, 17, 18}
    };

    var expectedResult =
        Arrays.asList(1, 7, 13, 14, 15, 16, 17, 18, 12, 6, 5, 4, 3, 2, 8, 9, 10, 11);

    var result = Spiral.antiClockWise(matrix);

    assertEquals(expectedResult, result);
  }
}
