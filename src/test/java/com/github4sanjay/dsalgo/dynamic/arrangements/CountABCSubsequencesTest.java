package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountABCSubsequencesTest {

  @Test
  public void testVariableDP() {
    Assertions.assertEquals(7, CountABCSubsequences.variableDP("abcabc"));
    Assertions.assertEquals(3, CountABCSubsequences.variableDP("abbc"));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(
        "[abc, abcc, abbc, abbcc, aabc, aabcc, aabbc, aabbcc]",
        CountABCSubsequences.recursion("abcabc").toString());
    Assertions.assertEquals("[abc, abbc]", CountABCSubsequences.recursion("abbc").toString());
  }
}
