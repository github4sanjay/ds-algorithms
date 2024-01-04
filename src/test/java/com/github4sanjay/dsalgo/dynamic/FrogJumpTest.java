package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FrogJumpTest {

  @Test
  public void testRecursion() {
    Assertions.assertTrue(FrogJump.recursion(new int[] {0, 1, 3, 5, 6, 8, 12, 17}));
    Assertions.assertFalse(FrogJump.recursion(new int[] {0, 1, 2, 3, 4, 8, 9, 11}));
  }

  @Test
  public void testMemoization() {
    Assertions.assertTrue(FrogJump.dp(new int[] {0, 1, 3, 5, 6, 8, 12, 17}));
    Assertions.assertFalse(FrogJump.dp(new int[] {0, 1, 2, 3, 4, 8, 9, 11}));
  }
}
