package com.github4sanjay.dsalgo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumRectangleTest {

  @Test
  public void find() {
    Assertions.assertEquals(
        3, MaximumRectangle.find(new int[][] {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}}));
    Assertions.assertEquals(
        6, MaximumRectangle.find(new int[][] {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}}));
    Assertions.assertEquals(
        8,
        MaximumRectangle.find(
            new int[][] {
              {0, 1, 1, 0},
              {1, 1, 1, 1},
              {1, 1, 1, 1},
              {1, 1, 0, 0},
            }));
  }
}
