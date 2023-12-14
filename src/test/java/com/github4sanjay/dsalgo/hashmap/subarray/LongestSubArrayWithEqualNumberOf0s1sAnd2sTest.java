package com.github4sanjay.dsalgo.hashmap.subarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubArrayWithEqualNumberOf0s1sAnd2sTest {

  @Test
  public void find() {
    Assertions.assertEquals(
        3, LongestSubArrayWithEqualNumberOf0s1sAnd2s.find(new int[] {0, 1, 0, 2, 0, 1, 0}));
    /*Assertions.assertEquals(
    10, LongestSubArrayWithEqualNumberOf0s1sAnd2s.find(new int[] {0, 1, 0, 2, 2, 0, 1, 0}));*/
  }
}
