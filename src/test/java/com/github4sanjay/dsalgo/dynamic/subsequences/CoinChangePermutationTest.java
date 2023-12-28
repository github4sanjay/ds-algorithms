package com.github4sanjay.dsalgo.dynamic.subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangePermutationTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(7, CoinChangePermutation.recursion(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangePermutation.recursion(new int[] {2, 5, 3, 6}, 7));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(7, CoinChangePermutation.memoization(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangePermutation.memoization(new int[] {2, 5, 3, 6}, 7));
  }

  @Test
  public void testTabular() {
    Assertions.assertEquals(7, CoinChangePermutation.tabular(new int[] {1, 2, 3}, 4));
    Assertions.assertEquals(5, CoinChangePermutation.tabular(new int[] {2, 5, 3, 6}, 7));
  }
}
