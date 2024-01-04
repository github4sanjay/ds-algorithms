package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EggDroppingProblemTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(2, EggDroppingProblem.recursion(1, 2));
    Assertions.assertEquals(4, EggDroppingProblem.recursion(2, 10));
    Assertions.assertEquals(3, EggDroppingProblem.recursion(2, 6));
    Assertions.assertEquals(4, EggDroppingProblem.recursion(3, 14));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(2, EggDroppingProblem.memoization(1, 2));
    Assertions.assertEquals(4, EggDroppingProblem.memoization(2, 10));
    Assertions.assertEquals(3, EggDroppingProblem.memoization(2, 6));
    Assertions.assertEquals(4, EggDroppingProblem.memoization(3, 14));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(2, EggDroppingProblem.tabulation(1, 2));
    Assertions.assertEquals(4, EggDroppingProblem.tabulation(2, 10));
    Assertions.assertEquals(3, EggDroppingProblem.tabulation(2, 6));
    Assertions.assertEquals(4, EggDroppingProblem.tabulation(3, 14));
  }
}
