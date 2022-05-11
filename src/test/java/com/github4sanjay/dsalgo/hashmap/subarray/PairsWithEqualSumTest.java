package com.github4sanjay.dsalgo.hashmap.subarray;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PairsWithEqualSumTest {

  @Test
  void find() {
    Assertions.assertFalse(PairsWithEqualSum.find(new int[] {1, 2, 998, 72, 87576, 21, 45, -1}));
    Assertions.assertTrue(PairsWithEqualSum.find(new int[] {2, 9, 3, 5, 8, 6, 4}));
  }
}
