package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxNonOverlappingBridgeTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        2, MaxNonOverlappingBridge.find(new int[] {6, 4, 2, 1}, new int[] {2, 3, 6, 5}));
    Assertions.assertEquals(
        5,
        MaxNonOverlappingBridge.find(
            new int[] {8, 1, 4, 3, 5, 2, 6, 7}, new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
  }
}
