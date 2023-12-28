package com.github4sanjay.dsalgo.dynamic.stairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StairsPathMinMovesTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        6, StairsPathMinMoves.recursion(new int[] {3, 3, 1, 1, 4, 1, 1, 0, 1, 1, 1}));
    Assertions.assertEquals(
        4, StairsPathMinMoves.recursion(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        6, StairsPathMinMoves.memoization(new int[] {3, 3, 1, 1, 4, 1, 1, 0, 1, 1, 1}));
    Assertions.assertEquals(
        4, StairsPathMinMoves.memoization(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        6, StairsPathMinMoves.tabulation(new int[] {3, 3, 1, 1, 4, 1, 1, 0, 1, 1, 1}));
    Assertions.assertEquals(
        4, StairsPathMinMoves.tabulation(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
  }
}
