package com.github4sanjay.dsalgo.hashmap.subarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubArrayWithEqualNumberOf0sAnd1sTest {

  @Test
  public void find() {
    Assertions.assertEquals(
        6, LongestSubArrayWithEqualNumberOf0sAnd1s.find(new int[] {1, 0, 1, 1, 1, 0, 0}));
    Assertions.assertEquals(
        0, LongestSubArrayWithEqualNumberOf0sAnd1s.find(new int[] {1, 1, 1, 1}));
    Assertions.assertEquals(
        4, LongestSubArrayWithEqualNumberOf0sAnd1s.find(new int[] {0, 0, 1, 1, 0}));
  }
}
