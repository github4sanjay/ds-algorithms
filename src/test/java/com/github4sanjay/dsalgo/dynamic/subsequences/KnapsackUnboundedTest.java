package com.github4sanjay.dsalgo.dynamic.subsequences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KnapsackUnboundedTest {

  @Test
  public void testRecursion() {
    int[] val = new int[] {15, 14, 10, 45, 30};
    int[] wt = new int[] {2, 5, 1, 3, 4};
    Assertions.assertEquals(100, KnapsackUnbounded.recursion(wt, val, 7));

    val = new int[] {10, 40, 50, 70};
    wt = new int[] {1, 3, 4, 5};
    Assertions.assertEquals(110, KnapsackUnbounded.recursion(wt, val, 8));
  }

  @Test
  public void testMemoization() {
    int[] val = new int[] {15, 14, 10, 45, 30};
    int[] wt = new int[] {2, 5, 1, 3, 4};
    Assertions.assertEquals(100, KnapsackUnbounded.memoization(wt, val, 7));

    val = new int[] {10, 40, 50, 70};
    wt = new int[] {1, 3, 4, 5};
    Assertions.assertEquals(110, KnapsackUnbounded.memoization(wt, val, 8));
  }

  @Test
  public void testTabulation() {
    int[] val = new int[] {15, 14, 10, 45, 30};
    int[] wt = new int[] {2, 5, 1, 3, 4};
    Assertions.assertEquals(100, KnapsackUnbounded.tabulation(wt, val, 7));

    val = new int[] {10, 40, 50, 70};
    wt = new int[] {1, 3, 4, 5};
    Assertions.assertEquals(110, KnapsackUnbounded.tabulation(wt, val, 8));
  }
}
