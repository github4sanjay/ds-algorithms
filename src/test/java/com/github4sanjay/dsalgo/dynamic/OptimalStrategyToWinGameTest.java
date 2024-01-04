package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OptimalStrategyToWinGameTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(15, OptimalStrategyToWinGame.recursion(new int[] {5, 3, 7, 10}));
    Assertions.assertEquals(22, OptimalStrategyToWinGame.recursion(new int[] {8, 15, 3, 7}));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(15, OptimalStrategyToWinGame.memoization(new int[] {5, 3, 7, 10}));
    Assertions.assertEquals(22, OptimalStrategyToWinGame.memoization(new int[] {8, 15, 3, 7}));
    Assertions.assertEquals(
        42, OptimalStrategyToWinGame.memoization(new int[] {20, 30, 2, 2, 2, 10}));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(15, OptimalStrategyToWinGame.tabulation(new int[] {5, 3, 7, 10}));
    Assertions.assertEquals(22, OptimalStrategyToWinGame.tabulation(new int[] {8, 15, 3, 7}));
    Assertions.assertEquals(
        42, OptimalStrategyToWinGame.tabulation(new int[] {20, 30, 2, 2, 2, 10}));
  }
}
