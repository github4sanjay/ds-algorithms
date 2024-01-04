package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TilingWithKX1Test {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(61, TilingWithKX1.recursion(39, 16));
    Assertions.assertEquals(1, TilingWithKX1.recursion(9, 16));
    Assertions.assertEquals(2, TilingWithKX1.recursion(9, 9));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(61, TilingWithKX1.memoization(39, 16));
    Assertions.assertEquals(1, TilingWithKX1.memoization(9, 16));
    Assertions.assertEquals(2, TilingWithKX1.memoization(9, 9));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(61, TilingWithKX1.tabulation(39, 16));
    Assertions.assertEquals(1, TilingWithKX1.tabulation(9, 16));
    Assertions.assertEquals(2, TilingWithKX1.tabulation(9, 9));
  }
}
