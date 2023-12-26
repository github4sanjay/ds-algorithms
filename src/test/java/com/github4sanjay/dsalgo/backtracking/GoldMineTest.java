package com.github4sanjay.dsalgo.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoldMineTest {

  @Test
  public void test() {
    int[][] mine =
        new int[][] {
          {1, 0, 7},
          {2, 0, 6},
          {3, 4, 5},
          {0, 3, 0},
          {9, 0, 20}
        };
    Assertions.assertEquals(28, GoldMine.collect(mine));

    int[][] mine2 =
        new int[][] {
          {0, 1, 4, 2, 8, 2},
          {4, 3, 6, 5, 0, 4},
          {1, 2, 4, 1, 4, 6},
          {2, 0, 7, 3, 2, 2},
          {3, 1, 5, 9, 2, 4},
          {2, 7, 0, 8, 5, 1}
        };
    Assertions.assertEquals(120, GoldMine.collect(mine2));

    int[][] mine3 = new int[][] {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
    Assertions.assertEquals(24, GoldMine.collect(mine3));
  }
}
