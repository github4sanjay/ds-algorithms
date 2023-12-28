package com.github4sanjay.dsalgo.dynamic.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoldMineProblemTest {

  @Test
  public void testRecursion() {

    Assertions.assertEquals(
        16,
        GoldMineProblem.recursion(
            new int[][] {
              {1, 3, 1, 5},
              {2, 2, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 1, 2}
            }));

    Assertions.assertEquals(
        83,
        GoldMineProblem.recursion(
            new int[][] {
              {10, 33, 13, 15},
              {22, 21, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 14, 2}
            }));
  }

  @Test
  public void testMemoization() {

    Assertions.assertEquals(
        16,
        GoldMineProblem.memoization(
            new int[][] {
              {1, 3, 1, 5},
              {2, 2, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 1, 2}
            }));

    Assertions.assertEquals(
        83,
        GoldMineProblem.memoization(
            new int[][] {
              {10, 33, 13, 15},
              {22, 21, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 14, 2}
            }));
  }

  @Test
  public void testTabular() {

    Assertions.assertEquals(
        16,
        GoldMineProblem.tabular(
            new int[][] {
              {1, 3, 1, 5},
              {2, 2, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 1, 2}
            }));

    Assertions.assertEquals(
        83,
        GoldMineProblem.tabular(
            new int[][] {
              {10, 33, 13, 15},
              {22, 21, 4, 1},
              {5, 0, 2, 3},
              {0, 6, 14, 2}
            }));
  }
}
