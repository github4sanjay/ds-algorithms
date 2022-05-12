package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidateStackSequencesTest {

  @Test
  public void check() {
    Assertions.assertTrue(
        ValidateStackSequences.check(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}));
    Assertions.assertFalse(
        ValidateStackSequences.check(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}));
  }
}
