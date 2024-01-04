package com.github4sanjay.dsalgo.dynamic.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EditDistanceTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(3, EditDistance.recursion("horse", "ros"));
    Assertions.assertEquals(5, EditDistance.recursion("intention", "execution"));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(3, EditDistance.memoization("horse", "ros"));
    Assertions.assertEquals(5, EditDistance.memoization("intention", "execution"));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(3, EditDistance.tabulation("horse", "ros"));
    Assertions.assertEquals(5, EditDistance.tabulation("intention", "execution"));
  }
}
