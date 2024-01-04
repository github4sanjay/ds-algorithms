package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSumNonAdjacentElementsTest {

  @Test
  public void test() {
    int arr[] = new int[] {5, 10, 10, 100, 10, 6};
    Assertions.assertEquals(116, MaxSumNonAdjacentElements.recursion(arr));
    Assertions.assertEquals(116, MaxSumNonAdjacentElements.memoization(arr));
    Assertions.assertEquals(116, MaxSumNonAdjacentElements.tabulation(arr));
    Assertions.assertEquals(116, MaxSumNonAdjacentElements.tabulationSpaceOptimized(arr));
    Assertions.assertEquals(116, MaxSumNonAdjacentElements.variableDP(arr));
  }
}
