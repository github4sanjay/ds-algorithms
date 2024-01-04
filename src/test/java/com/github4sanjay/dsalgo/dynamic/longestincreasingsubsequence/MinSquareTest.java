package com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence;

import static com.github4sanjay.dsalgo.dynamic.longestincreasingsubsequence.MinSquare.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinSquareTest {

  @Test
  public void test() {
    Assertions.assertEquals(3, getMinSquares(6));
    Assertions.assertEquals(1, getMinSquares(100));
    Assertions.assertEquals(3, getMinSquares(35));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(3, recursion(6));
    // Assertions.assertEquals(1, recursion(100)); // TLE
    Assertions.assertEquals(3, recursion(35));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(3, memoization(6));
    Assertions.assertEquals(1, memoization(100));
    Assertions.assertEquals(3, memoization(35));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(3, tabulation(6));
    Assertions.assertEquals(1, tabulation(100));
    Assertions.assertEquals(3, tabulation(35));
  }
}
