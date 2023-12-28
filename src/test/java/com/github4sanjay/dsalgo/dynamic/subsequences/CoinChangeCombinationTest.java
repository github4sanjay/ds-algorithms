package com.github4sanjay.dsalgo.dynamic.subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangeCombinationTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(4, CoinChangeCombination.recursion(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangeCombination.recursion(new int[] {2, 5, 3, 6}, 10));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(4, CoinChangeCombination.memoization(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangeCombination.memoization(new int[] {2, 5, 3, 6}, 10));
  }

  @Test
  public void testTabular() {
    Assertions.assertEquals(4, CoinChangeCombination.tabular(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangeCombination.tabular(new int[] {2, 5, 3, 6}, 10));
  }
}
