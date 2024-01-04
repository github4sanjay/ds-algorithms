package com.github4sanjay.dsalgo.dynamic.subsequences;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RodCuttingTest {

  @Test
  public void test() {
    Assertions.assertEquals(22, RodCutting.find(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    Assertions.assertEquals(24, RodCutting.find(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(22, RodCutting.recursion(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    Assertions.assertEquals(24, RodCutting.recursion(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(22, RodCutting.memoization(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    Assertions.assertEquals(24, RodCutting.memoization(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(22, RodCutting.tabulation(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    Assertions.assertEquals(24, RodCutting.tabulation(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));
    Assertions.assertEquals(10, RodCutting.tabulation(new int[] {1, 5, 8, 9}));
  }
}
