package com.github4sanjay.dsalgo.dynamic.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LargestSquareSubmatrixTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        3,
        LargestSquareSubmatrix.recursion(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 0},
              {1, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {0, 0, 0, 0, 0}
            }));

    Assertions.assertEquals(
        4,
        LargestSquareSubmatrix.recursion(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {0, 1, 1, 1, 1}
            }));

    Assertions.assertEquals(
        2,
        LargestSquareSubmatrix.recursion(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {0, 1, 1, 0, 1},
            }));

    Assertions.assertEquals(
        2,
        LargestSquareSubmatrix.recursion(
            new int[][] {
              {0, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {1, 0, 1, 1, 1},
              {0, 1, 1, 1, 0},
            }));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        3,
        LargestSquareSubmatrix.memoization(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 0},
              {1, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {0, 0, 0, 0, 0}
            }));

    Assertions.assertEquals(
        4,
        LargestSquareSubmatrix.memoization(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {0, 1, 1, 1, 1}
            }));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        3,
        LargestSquareSubmatrix.tabulation(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 0},
              {1, 1, 1, 1, 0},
              {1, 1, 1, 1, 1},
              {0, 0, 0, 0, 0}
            }));

    Assertions.assertEquals(
        4,
        LargestSquareSubmatrix.tabulation(
            new int[][] {
              {0, 1, 1, 0, 1},
              {1, 1, 0, 1, 0},
              {0, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {1, 1, 1, 1, 1},
              {0, 1, 1, 1, 1}
            }));
  }
}
