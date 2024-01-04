package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestBitonicSubsequenceTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        6, LongestBitonicSubsequence.find(new int[] {1, 11, 2, 10, 4, 5, 2, 1}));
    Assertions.assertEquals(5, LongestBitonicSubsequence.find(new int[] {12, 11, 40, 5, 3, 1}));
    Assertions.assertEquals(5, LongestBitonicSubsequence.find(new int[] {80, 60, 30, 40, 20, 10}));
  }
}
