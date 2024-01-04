package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PaintFenceTest {

  @Test
  public void test() {
    Assertions.assertEquals(3672, PaintFence.find(8, 3));
    Assertions.assertEquals(16, PaintFence.find(2, 4));
    Assertions.assertEquals(6, PaintFence.find(3, 2));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(3672, PaintFence.recursion(8, 3));
    Assertions.assertEquals(16, PaintFence.recursion(2, 4));
    Assertions.assertEquals(6, PaintFence.recursion(3, 2));
  }

  @Test
  public void testBruteForce() {
    Assertions.assertEquals(16, PaintFence.findBruteForce(2, 4));
    Assertions.assertEquals(6, PaintFence.findBruteForce(3, 2));
  }
}
