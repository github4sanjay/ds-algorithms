package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublePairArrayTest {

  @Test
  public void check() {
    Assertions.assertFalse(DoublePairArray.check(new int[] {3, 1, 3, 6}));
    Assertions.assertFalse(DoublePairArray.check(new int[] {2, 1, 2, 6}));
    Assertions.assertTrue(DoublePairArray.check(new int[] {4, -2, 2, -4}));
  }
}
