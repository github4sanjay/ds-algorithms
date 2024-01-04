package com.github4sanjay.dsalgo.dynamic.printresults;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindAllPathsWithMinCostTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        "Answer{cost=23, paths=[[H, V, V, H, H, V, H, H, V, V], [H, V, V, H, H, V, H, V, H, V]]}",
        FindAllPathsWithMinCost.find(
                new int[][] {
                  {0, 1, 4, 2, 8, 2},
                  {4, 3, 6, 5, 0, 4},
                  {1, 2, 4, 1, 4, 6},
                  {2, 0, 7, 3, 2, 2},
                  {3, 1, 5, 9, 2, 4},
                  {2, 7, 0, 8, 5, 1}
                })
            .toString());
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        23,
        FindAllPathsWithMinCost.recursion(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1}
            }));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        23,
        FindAllPathsWithMinCost.memoization(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1}
            }));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        23,
        FindAllPathsWithMinCost.tabulation(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1}
            }));
  }
}
