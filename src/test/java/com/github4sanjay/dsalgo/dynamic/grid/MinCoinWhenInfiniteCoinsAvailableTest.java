package com.github4sanjay.dsalgo.dynamic.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinCoinWhenInfiniteCoinsAvailableTest {

  @Test
  public void testRecursion() {

    Assertions.assertEquals(
        1, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {43, 30, 56}, 30));

    Assertions.assertEquals(3, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {3, 2}, 8));

    Assertions.assertEquals(2, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {2, 5, 3, 6}, 10));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {25, 10, 5}, 30));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {9, 6, 5, 1}, 11));
    Assertions.assertEquals(
        3, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {1, 2, 5}, 11));
    Assertions.assertEquals(0, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {1}, 0));
    Assertions.assertEquals(
        Integer.MAX_VALUE, MinCoinWhenInfiniteCoinsAvailable.recursion(new int[] {2}, 3));
  }

  @Test
  public void testMemoization() {

    Assertions.assertEquals(3, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {3, 2}, 8));

    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {2, 5, 3, 6}, 10));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {25, 10, 5}, 30));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {9, 6, 5, 1}, 11));
    Assertions.assertEquals(
        3, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {1, 2, 5}, 11));
    Assertions.assertEquals(0, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {1}, 0));
    Assertions.assertEquals(
        Integer.MAX_VALUE, MinCoinWhenInfiniteCoinsAvailable.memoization(new int[] {2}, 3));
  }

  @Test
  public void testTabulation() {

    Assertions.assertEquals(3, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {3, 2}, 8));

    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {2, 5, 3, 6}, 10));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {25, 10, 5}, 30));
    Assertions.assertEquals(
        2, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {9, 6, 5, 1}, 11));
    Assertions.assertEquals(
        3, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {1, 2, 5}, 11));
    Assertions.assertEquals(0, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {1}, 0));
    Assertions.assertEquals(
        Integer.MAX_VALUE, MinCoinWhenInfiniteCoinsAvailable.tabulation(new int[] {2}, 3));
  }
}
