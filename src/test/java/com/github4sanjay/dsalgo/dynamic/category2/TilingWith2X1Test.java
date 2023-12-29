package com.github4sanjay.dsalgo.dynamic.category2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TilingWith2X1Test {

  @Test
  public void test() {
    Assertions.assertEquals(13, TilingWith2X1.variableDP(6));
    Assertions.assertEquals(3, TilingWith2X1.variableDP(3));
    Assertions.assertEquals(5, TilingWith2X1.variableDP(4));
    Assertions.assertEquals(13, TilingWith2X1.variableDP(6));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(13, TilingWith2X1.recursion(6));
    Assertions.assertEquals(3, TilingWith2X1.recursion(3));
    Assertions.assertEquals(5, TilingWith2X1.recursion(4));
    Assertions.assertEquals(13, TilingWith2X1.recursion(6));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(13, TilingWith2X1.memoization(6));
    Assertions.assertEquals(3, TilingWith2X1.memoization(3));
    Assertions.assertEquals(5, TilingWith2X1.memoization(4));
    Assertions.assertEquals(13, TilingWith2X1.memoization(6));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(13, TilingWith2X1.tabulation(6));
    Assertions.assertEquals(3, TilingWith2X1.tabulation(3));
    Assertions.assertEquals(5, TilingWith2X1.tabulation(4));
    Assertions.assertEquals(13, TilingWith2X1.tabulation(6));
  }
}
