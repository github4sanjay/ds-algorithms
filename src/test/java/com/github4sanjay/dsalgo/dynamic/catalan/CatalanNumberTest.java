package com.github4sanjay.dsalgo.dynamic.catalan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CatalanNumberTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(14, CatalanNumber.recursion(4));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(14, CatalanNumber.memoization(4));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(14, CatalanNumber.tabulation(4));
    Assertions.assertEquals(42, CatalanNumber.tabulation(5));
    Assertions.assertEquals(132, CatalanNumber.tabulation(6));
    Assertions.assertEquals(429, CatalanNumber.tabulation(7));
  }
}
