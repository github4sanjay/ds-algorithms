package com.github4sanjay.dsalgo.dynamic.arrangements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountEncodingsTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(3, CountEncodings.recursion("124"));
    Assertions.assertEquals(4, CountEncodings.recursion("231011"));
    Assertions.assertEquals(3, CountEncodings.recursion("1234"));
    Assertions.assertEquals(2, CountEncodings.recursion("655196"));
    Assertions.assertEquals(3, CountEncodings.recursion("226"));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(3, CountEncodings.memoization("124"));
    Assertions.assertEquals(3, CountEncodings.memoization("1234"));
    Assertions.assertEquals(2, CountEncodings.memoization("655196"));
    Assertions.assertEquals(3, CountEncodings.memoization("226"));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(3, CountEncodings.tabulation("124"));
    Assertions.assertEquals(3, CountEncodings.tabulation("1234"));
    Assertions.assertEquals(2, CountEncodings.tabulation("655196"));
    Assertions.assertEquals(3, CountEncodings.tabulation("226"));
  }
}
