package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountBinaryStringsWithoutTwoConsecutiveZeroesTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(21, CountBinaryStringsWithoutTwoConsecutiveZeroes.recursion(6));
    Assertions.assertEquals(3, CountBinaryStringsWithoutTwoConsecutiveZeroes.recursion(2));
    Assertions.assertEquals(5, CountBinaryStringsWithoutTwoConsecutiveZeroes.recursion(3));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(21, CountBinaryStringsWithoutTwoConsecutiveZeroes.memoization(6));
    Assertions.assertEquals(3, CountBinaryStringsWithoutTwoConsecutiveZeroes.memoization(2));
    Assertions.assertEquals(5, CountBinaryStringsWithoutTwoConsecutiveZeroes.memoization(3));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(21, CountBinaryStringsWithoutTwoConsecutiveZeroes.tabulation(6));
    Assertions.assertEquals(3, CountBinaryStringsWithoutTwoConsecutiveZeroes.tabulation(2));
    Assertions.assertEquals(5, CountBinaryStringsWithoutTwoConsecutiveZeroes.tabulation(3));
  }
}
