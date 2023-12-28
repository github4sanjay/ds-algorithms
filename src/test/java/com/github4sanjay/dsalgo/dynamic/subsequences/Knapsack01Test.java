package com.github4sanjay.dsalgo.dynamic.subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Knapsack01Test {

  @Test
  public void testRecursion() {

    Assertions.assertEquals(3, Knapsack01.recursion(new int[] {4, 5, 1}, new int[] {1, 2, 3}, 4));

    Assertions.assertEquals(0, Knapsack01.recursion(new int[] {4, 5, 6}, new int[] {1, 2, 3}, 3));

    Assertions.assertEquals(
        13, Knapsack01.recursion(new int[] {1, 2, 4, 5}, new int[] {5, 4, 8, 6}, 5));

    Assertions.assertEquals(
        220, Knapsack01.recursion(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 50));
    Assertions.assertEquals(
        280, Knapsack01.recursion(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 60));
  }

  @Test
  public void testMemoization() {

    Assertions.assertEquals(3, Knapsack01.memoization(new int[] {4, 5, 1}, new int[] {1, 2, 3}, 4));

    Assertions.assertEquals(0, Knapsack01.memoization(new int[] {4, 5, 6}, new int[] {1, 2, 3}, 3));

    Assertions.assertEquals(
        13, Knapsack01.memoization(new int[] {1, 2, 4, 5}, new int[] {5, 4, 8, 6}, 5));

    Assertions.assertEquals(
        220, Knapsack01.memoization(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 50));
    Assertions.assertEquals(
        280, Knapsack01.memoization(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 60));

    Assertions.assertEquals(
        7534,
        Knapsack01.memoization(
            new int[] {
              7, 0, 30, 22, 80, 94, 11, 81, 70, 64, 59, 18, 0, 36, 3, 8, 15, 42, 9, 0, 42, 47, 52,
                  32,
              26, 48, 55, 6, 29, 84, 2, 4, 18, 56, 7, 29, 93, 44, 71, 3, 86, 66, 31, 65, 0, 79, 20,
                  65,
              52, 13
            },
            new int[] {
              360, 83, 59, 130, 431, 67, 230, 52, 93, 125, 670, 892, 600, 38, 48, 147, 78, 256, 63,
              17, 120, 164, 432, 35, 92, 110, 22, 42, 50, 323, 514, 28, 87, 73, 78, 15, 26, 78, 210,
              36, 85, 189, 274, 43, 33, 10, 19, 389, 276, 312
            },
            850));
  }

  @Test
  public void testTabulation() {

    Assertions.assertEquals(3, Knapsack01.tabulation(new int[] {4, 5, 1}, new int[] {1, 2, 3}, 4));

    Assertions.assertEquals(0, Knapsack01.tabulation(new int[] {4, 5, 6}, new int[] {1, 2, 3}, 3));

    Assertions.assertEquals(
        13, Knapsack01.tabulation(new int[] {1, 2, 4, 5}, new int[] {5, 4, 8, 6}, 5));

    Assertions.assertEquals(
        220, Knapsack01.tabulation(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 50));
    Assertions.assertEquals(
        280, Knapsack01.tabulation(new int[] {10, 20, 30}, new int[] {60, 100, 120}, 60));

    Assertions.assertEquals(
        7534,
        Knapsack01.tabulation(
            new int[] {
              7, 0, 30, 22, 80, 94, 11, 81, 70, 64, 59, 18, 0, 36, 3, 8, 15, 42, 9, 0, 42, 47, 52,
              32, 26, 48, 55, 6, 29, 84, 2, 4, 18, 56, 7, 29, 93, 44, 71, 3, 86, 66, 31, 65, 0, 79,
              20, 65, 52, 13
            },
            new int[] {
              360, 83, 59, 130, 431, 67, 230, 52, 93, 125, 670, 892, 600, 38, 48, 147, 78, 256, 63,
              17, 120, 164, 432, 35, 92, 110, 22, 42, 50, 323, 514, 28, 87, 73, 78, 15, 26, 78, 210,
              36, 85, 189, 274, 43, 33, 10, 19, 389, 276, 312
            },
            850));
  }
}
