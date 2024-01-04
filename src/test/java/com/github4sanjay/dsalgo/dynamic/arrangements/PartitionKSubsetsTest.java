package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionKSubsetsTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(10, PartitionKSubsets.recursion(5, 4));
    Assertions.assertEquals(6, PartitionKSubsets.recursion(4, 3));
    Assertions.assertEquals(3, PartitionKSubsets.recursion(3, 2));
    Assertions.assertEquals(1, PartitionKSubsets.recursion(3, 1));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(10, PartitionKSubsets.memoization(5, 4));
    Assertions.assertEquals(6, PartitionKSubsets.memoization(4, 3));
    Assertions.assertEquals(3, PartitionKSubsets.memoization(3, 2));
    Assertions.assertEquals(1, PartitionKSubsets.memoization(3, 1));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(10, PartitionKSubsets.tabulation(5, 4));
    Assertions.assertEquals(6, PartitionKSubsets.tabulation(4, 3));
    Assertions.assertEquals(3, PartitionKSubsets.tabulation(3, 2));
    Assertions.assertEquals(1, PartitionKSubsets.tabulation(3, 1));
  }
}
