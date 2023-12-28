package com.github4sanjay.dsalgo.dynamic.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeTraversalMinCostTest {

  @Test
  public void testRecursion() {

    Assertions.assertEquals(
        8,
        MazeTraversalMinCost.recursion(
            new int[][] {
              {1, 2, 3},
              {4, 8, 2},
              {1, 5, 3}
            }));
    Assertions.assertEquals(
        13,
        MazeTraversalMinCost.recursion(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1},
            }));
  }

  @Test
  public void testMemoization() {

    Assertions.assertEquals(
        8,
        MazeTraversalMinCost.memoization(
            new int[][] {
              {1, 2, 3},
              {4, 8, 2},
              {1, 5, 3}
            }));
    Assertions.assertEquals(
        13,
        MazeTraversalMinCost.memoization(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1},
            }));
  }

  @Test
  public void testTabulation() {

    Assertions.assertEquals(
        8,
        MazeTraversalMinCost.tabulation(
            new int[][] {
              {1, 2, 3},
              {4, 8, 2},
              {1, 5, 3}
            }));
    Assertions.assertEquals(
        13,
        MazeTraversalMinCost.tabulation(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1},
            }));
  }
}
