package com.github4sanjay.dsalgo.dynamic.stairs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StairsPathWithVariableJumpsTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        5, StairsPathWithVariableJumps.recursion(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));

    Assertions.assertEquals(
        2044,
        StairsPathWithVariableJumps.recursion(new int[] {5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        5, StairsPathWithVariableJumps.memoization(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));

    Assertions.assertEquals(
        2044,
        StairsPathWithVariableJumps.memoization(new int[] {5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
  }

  @Test
  public void testTabular() {
    Assertions.assertEquals(
        5, StairsPathWithVariableJumps.tabular(new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));

    Assertions.assertEquals(
        2044,
        StairsPathWithVariableJumps.tabular(new int[] {5, 5, 2, 4, 1, 5, 9, 8, 6, 3, 8, 9, 1}));
  }
}
