package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Check132PatternTest {

  @Test
  public void check() {
    Assertions.assertFalse(Check132Pattern.check(new int[] {1, 2, 3, 4}));
    Assertions.assertTrue(Check132Pattern.check(new int[] {3, 1, 4, 2}));
    Assertions.assertTrue(Check132Pattern.check(new int[] {-1, 3, 2, 0}));
  }
}
