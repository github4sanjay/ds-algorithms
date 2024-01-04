package com.github4sanjay.dsalgo.dynamic.printresults;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindAllPathsWithTargetSumSubsetTest {

  @Test
  public void test() {
    Assertions.assertEquals(
        "Answer{available=true, path=[[3, 2, 1], [4, 2], [4, 3, 1, 0]]}",
        FindAllPathsWithTargetSumSubset.find(new int[] {4, 2, 7, 1, 3}, 10).toString());
    Assertions.assertEquals(
        "Answer{available=true, path=[[3, 2], [4, 3, 0]]}",
        FindAllPathsWithTargetSumSubset.find(new int[] {4, 2, 7, 1, 3}, 8).toString());
  }

  @Test
  public void testFindWithExtraAdding0() {
    Assertions.assertEquals(
        "Answer{available=true, path=[[3, 2, 1], [4, 2], [4, 3, 1, 0]]}",
        FindAllPathsWithTargetSumSubset.findWithExtraAdding0(new int[] {4, 2, 7, 1, 3}, 10)
            .toString());
    Assertions.assertEquals(
        "Answer{available=true, path=[[3, 2], [4, 3, 0]]}",
        FindAllPathsWithTargetSumSubset.findWithExtraAdding0(new int[] {4, 2, 7, 1, 3}, 8)
            .toString());
  }

  @Test
  public void testRecursion() {
    Assertions.assertTrue(FindAllPathsWithTargetSumSubset.recursion(new int[] {4, 2, 7, 1, 3}, 10));
    Assertions.assertFalse(
        FindAllPathsWithTargetSumSubset.recursion(new int[] {4, 2, 7, 1, 3}, 20));
    Assertions.assertTrue(FindAllPathsWithTargetSumSubset.recursion(new int[] {4, 2, 7, 1, 3}, 8));
  }

  @Test
  public void testMemoization() {
    Assertions.assertTrue(
        FindAllPathsWithTargetSumSubset.memoization(new int[] {4, 2, 7, 1, 3}, 10));
    Assertions.assertFalse(
        FindAllPathsWithTargetSumSubset.memoization(new int[] {4, 2, 7, 1, 3}, 20));
    Assertions.assertTrue(
        FindAllPathsWithTargetSumSubset.memoization(new int[] {4, 2, 7, 1, 3}, 8));
  }

  @Test
  public void testTabulation() {
    Assertions.assertTrue(
        FindAllPathsWithTargetSumSubset.tabulation(new int[] {4, 2, 7, 1, 3}, 10));
    Assertions.assertFalse(
        FindAllPathsWithTargetSumSubset.tabulation(new int[] {4, 2, 7, 1, 3}, 20));
    Assertions.assertTrue(FindAllPathsWithTargetSumSubset.tabulation(new int[] {4, 2, 7, 1, 3}, 8));
  }
}
