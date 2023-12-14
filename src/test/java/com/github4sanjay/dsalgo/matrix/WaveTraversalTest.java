package com.github4sanjay.dsalgo.matrix;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class WaveTraversalTest {

  @Test
  public void testTraverse() {
    int[][] mat = {
      {1, 1, 1, 1},
      {2, 2, 2, 2},
      {3, 3, 3, 3},
      {4, 4, 4, 4}
    };

    var expectedResult = Arrays.asList(1, 2, 3, 4, 4, 3, 2, 1, 1, 2, 3, 4, 4, 3, 2, 1);
    var result = WaveTraversal.traverse(mat);
    assertEquals(expectedResult, result);
  }
}
