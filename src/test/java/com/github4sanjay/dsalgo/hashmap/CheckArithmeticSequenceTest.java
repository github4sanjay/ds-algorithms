package com.github4sanjay.dsalgo.hashmap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CheckArithmeticSequenceTest {

  @Test
  public void check() {
    Assertions.assertTrue(CheckArithmeticSequence.check(new int[] {3, 5, 1}));
    Assertions.assertFalse(CheckArithmeticSequence.check(new int[] {1, 2, 4}));
    Assertions.assertTrue(CheckArithmeticSequence.check(new int[] {1, 1, 1}));
  }
}
