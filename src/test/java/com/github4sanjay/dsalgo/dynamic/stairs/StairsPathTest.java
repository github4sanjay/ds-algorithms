package com.github4sanjay.dsalgo.dynamic.stairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StairsPathTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(1, StairsPath.recursion(1, 2));
    Assertions.assertEquals(2, StairsPath.recursion(2, 2));
    Assertions.assertEquals(5, StairsPath.recursion(4, 2));
    Assertions.assertEquals(7, StairsPath.recursion(4, 3));
    Assertions.assertEquals(4, StairsPath.recursion(3, 3));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(1, StairsPath.memoization(1, 2));
    Assertions.assertEquals(2, StairsPath.memoization(2, 2));
    Assertions.assertEquals(5, StairsPath.memoization(4, 2));
    Assertions.assertEquals(7, StairsPath.memoization(4, 3));
    Assertions.assertEquals(4, StairsPath.memoization(3, 3));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(1, StairsPath.tabulation(1, 2));
    Assertions.assertEquals(2, StairsPath.tabulation(2, 2));
    Assertions.assertEquals(5, StairsPath.tabulation(4, 2));
    Assertions.assertEquals(7, StairsPath.tabulation(4, 3));
    Assertions.assertEquals(4, StairsPath.tabulation(3, 3));
  }
}
