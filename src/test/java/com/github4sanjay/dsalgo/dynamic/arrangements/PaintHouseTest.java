package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaintHouseTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        8,
        PaintHouse.recursion(
            new int[][] {
              {1, 5, 7},
              {5, 8, 4},
              {3, 2, 9},
              {1, 2, 4}
            }));
    Assertions.assertEquals(
        3,
        PaintHouse.recursion(
            new int[][] {
              {1, 2, 3},
              {1, 4, 6}
            }));
    Assertions.assertEquals(
        10,
        PaintHouse.recursion(
            new int[][] {
              {14, 2, 11},
              {11, 14, 5},
              {14, 3, 10}
            }));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        8,
        PaintHouse.memoization(
            new int[][] {
              {1, 5, 7},
              {5, 8, 4},
              {3, 2, 9},
              {1, 2, 4}
            }));
    Assertions.assertEquals(
        3,
        PaintHouse.memoization(
            new int[][] {
              {1, 2, 3},
              {1, 4, 6}
            }));
    Assertions.assertEquals(
        10,
        PaintHouse.memoization(
            new int[][] {
              {14, 2, 11},
              {11, 14, 5},
              {14, 3, 10}
            }));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        8,
        PaintHouse.tabulation(
            new int[][] {
              {1, 5, 7},
              {5, 8, 4},
              {3, 2, 9},
              {1, 2, 4}
            }));
    Assertions.assertEquals(
        3,
        PaintHouse.tabulation(
            new int[][] {
              {1, 2, 3},
              {1, 4, 6}
            }));
    Assertions.assertEquals(
        10,
        PaintHouse.tabulation(
            new int[][] {
              {14, 2, 11},
              {11, 14, 5},
              {14, 3, 10}
            }));
  }
}
