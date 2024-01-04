package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BurstBalloonsTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(167, BurstBalloons.recursion(new int[] {3, 1, 5, 8}));
    Assertions.assertEquals(10, BurstBalloons.recursion(new int[] {1, 5}));
  }
}
