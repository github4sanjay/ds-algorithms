package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSumIncreasingSubsequenceTest {

  @Test
  public void test() {
    System.out.println(
        MaxSumIncreasingSubsequence.find(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80, 3}));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        255,
        MaxSumIncreasingSubsequence.recursion(new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80, 3}));
  }
}
