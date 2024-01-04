package com.github4sanjay.dsalgo.dynamic.printresults;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindAllResultsIn01KnapsackTest {

  @Test
  public void testFind() {
    Assertions.assertEquals(
        "Answer{max=75, itemIndexes=[[4, 3]]}",
        FindAllResultsIn01Knapsack.find(
                new int[] {15, 14, 10, 45, 30}, new int[] {2, 5, 1, 3, 4}, 7)
            .toString());
    Assertions.assertEquals(
        "Answer{max=75, itemIndexes=[[5], [4, 3]]}",
        FindAllResultsIn01Knapsack.find(
                new int[] {15, 14, 10, 45, 30, 75}, new int[] {2, 5, 1, 3, 4, 7}, 7)
            .toString());
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.recursion(
            new int[] {15, 14, 10, 45, 30}, new int[] {2, 5, 1, 3, 4}, 7));
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.recursion(
            new int[] {15, 14, 10, 45, 30, 75}, new int[] {2, 5, 1, 3, 4, 7}, 7));

    Assertions.assertEquals(
        3, FindAllResultsIn01Knapsack.recursion(new int[] {1, 2, 3}, new int[] {4, 5, 1}, 4));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.memoization(
            new int[] {15, 14, 10, 45, 30}, new int[] {2, 5, 1, 3, 4}, 7));
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.memoization(
            new int[] {15, 14, 10, 45, 30, 75}, new int[] {2, 5, 1, 3, 4, 7}, 7));

    Assertions.assertEquals(
        3, FindAllResultsIn01Knapsack.memoization(new int[] {1, 2, 3}, new int[] {4, 5, 1}, 4));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.tabulation(
            new int[] {15, 14, 10, 45, 30}, new int[] {2, 5, 1, 3, 4}, 7));
    Assertions.assertEquals(
        75,
        FindAllResultsIn01Knapsack.tabulation(
            new int[] {15, 14, 10, 45, 30, 75}, new int[] {2, 5, 1, 3, 4, 7}, 7));

    Assertions.assertEquals(
        3, FindAllResultsIn01Knapsack.tabulation(new int[] {1, 2, 3}, new int[] {4, 5, 1}, 4));
  }
}
