package com.github4sanjay.dsalgo.dynamic.subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TargetSumSubsetsTest {

  @Test
  public void testRecursion() {
    Assertions.assertTrue(TargetSumSubsets.recursion(new int[] {3, 34, 4, 12, 5, 2}, 43));
    Assertions.assertTrue(TargetSumSubsets.recursion(new int[] {3, 34, 4, 12, 5, 2}, 9));
    Assertions.assertTrue(TargetSumSubsets.recursion(new int[] {3, 34, 4, 12, 5, 2}, 7));
    Assertions.assertFalse(TargetSumSubsets.recursion(new int[] {3, 34, 4, 12, 5, 2}, 91));
    Assertions.assertFalse(TargetSumSubsets.recursion(new int[] {3, 34, 4, 12, 5, 2}, 30));
    Assertions.assertTrue(TargetSumSubsets.recursion(new int[] {43, 30}, 30));
  }

  @Test
  public void testMemoization() {
    Assertions.assertTrue(TargetSumSubsets.memoization(new int[] {3, 34, 4, 12, 5, 2}, 43));
    Assertions.assertTrue(TargetSumSubsets.memoization(new int[] {3, 34, 4, 12, 5, 2}, 9));
    Assertions.assertTrue(TargetSumSubsets.memoization(new int[] {3, 34, 4, 12, 5, 2}, 7));
    Assertions.assertFalse(TargetSumSubsets.memoization(new int[] {3, 34, 4, 12, 5, 2}, 91));
    Assertions.assertFalse(TargetSumSubsets.memoization(new int[] {3, 34, 4, 12, 5, 2}, 30));
    Assertions.assertTrue(TargetSumSubsets.memoization(new int[] {43, 30}, 30));
  }

  @Test
  public void testTabular() {
    Assertions.assertTrue(TargetSumSubsets.tabular(new int[] {3, 34, 4, 12, 5, 2}, 43));
    Assertions.assertTrue(TargetSumSubsets.tabular(new int[] {3, 34, 4, 12, 5, 2}, 9));
    Assertions.assertTrue(TargetSumSubsets.tabular(new int[] {3, 34, 4, 12, 5, 2}, 7));
    Assertions.assertFalse(TargetSumSubsets.tabular(new int[] {3, 34, 4, 12, 5, 2}, 91));
    Assertions.assertFalse(TargetSumSubsets.tabular(new int[] {3, 34, 4, 12, 5, 2}, 30));
    Assertions.assertTrue(TargetSumSubsets.tabular(new int[] {43, 30}, 30));
  }
}
