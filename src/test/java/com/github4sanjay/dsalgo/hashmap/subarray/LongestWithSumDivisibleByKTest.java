package com.github4sanjay.dsalgo.hashmap.subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestWithSumDivisibleByKTest {

  @Test
  public void find() {
    Assertions.assertEquals(4, LongestWithSumDivisibleByK.find(new int[] {2, 7, 6, 1, 4, 5}, 3));
    Assertions.assertEquals(
        5, LongestWithSumDivisibleByK.find(new int[] {-2, 2, -5, 12, -11, -1, 7}, 3));
  }
}
