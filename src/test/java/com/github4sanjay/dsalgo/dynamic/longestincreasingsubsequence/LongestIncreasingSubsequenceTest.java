package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.recursion(new int[] {10, 22, 9, 33, 21, 50, 41, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.recursion(new int[] {10}));

    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.recursion(new int[] {10, 22, 33, 50, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.recursion(new int[] {10, 9, 8}));
    Assertions.assertEquals(
        4,
        LongestIncreasingSubsequence.recursion(
            new int[] {10, 9, 2, 5, 3, 7, 101, 18})); // [2,3,7,101]
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.memoization(new int[] {10, 22, 9, 33, 21, 50, 41, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.memoization(new int[] {10}));

    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.memoization(new int[] {10, 22, 33, 50, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.memoization(new int[] {10, 9, 8}));
    Assertions.assertEquals(
        4,
        LongestIncreasingSubsequence.memoization(
            new int[] {10, 9, 2, 5, 3, 7, 101, 18})); // [2,3,7,101]
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.tabulation(new int[] {10, 22, 9, 33, 21, 50, 41, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.tabulation(new int[] {10}));

    Assertions.assertEquals(
        5, LongestIncreasingSubsequence.tabulation(new int[] {10, 22, 33, 50, 60}));
    Assertions.assertEquals(1, LongestIncreasingSubsequence.tabulation(new int[] {10, 9, 8}));
    Assertions.assertEquals(
        4,
        LongestIncreasingSubsequence.tabulation(
            new int[] {10, 9, 2, 5, 3, 7, 101, 18})); // [2,3,7,101]

    Assertions.assertEquals(
        6,
        LongestIncreasingSubsequence.tabulation(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80, 3}));
  }
}
