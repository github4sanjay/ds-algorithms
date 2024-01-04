package com.github4sanjay.dsalgo.dynamic.patternmatching;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WildCardPatternMatchingTest {

  @Test
  public void test() {
    Assertions.assertTrue(WildCardPatternMatching.find("baaabab", "ba*a?"));
    Assertions.assertTrue(WildCardPatternMatching.find("baaabab", "baaa?ab"));
    Assertions.assertTrue(WildCardPatternMatching.find("cab", "?ab"));
    Assertions.assertFalse(WildCardPatternMatching.find("cab", "?cb"));
  }

  @Test
  public void testRecursion() {
    Assertions.assertTrue(WildCardPatternMatching.recursion("baaabab", "ba*a?"));
    Assertions.assertTrue(WildCardPatternMatching.recursion("baaabab", "baaa?ab"));
    Assertions.assertTrue(WildCardPatternMatching.recursion("cab", "?ab"));
    Assertions.assertFalse(WildCardPatternMatching.recursion("cab", "?cb"));
    Assertions.assertTrue(WildCardPatternMatching.recursion("cab", "***b"));
    Assertions.assertTrue(WildCardPatternMatching.recursion("cab", "*c*b"));
  }

  @Test
  public void testMemoization() {
    Assertions.assertTrue(WildCardPatternMatching.memoization("baaabab", "ba*a?"));
    Assertions.assertTrue(WildCardPatternMatching.memoization("baaabab", "baaa?ab"));
    Assertions.assertTrue(WildCardPatternMatching.memoization("cab", "?ab"));
    Assertions.assertFalse(WildCardPatternMatching.memoization("cab", "?cb"));
    Assertions.assertTrue(WildCardPatternMatching.memoization("cab", "***b"));
    Assertions.assertTrue(WildCardPatternMatching.memoization("cab", "*c*b"));
  }

  @Test
  public void testTabulation() {
    Assertions.assertTrue(WildCardPatternMatching.tabulation("baaabab", "ba*a?"));
    Assertions.assertTrue(WildCardPatternMatching.tabulation("baaabab", "baaa?ab"));
    Assertions.assertTrue(WildCardPatternMatching.tabulation("cab", "?ab"));
    Assertions.assertFalse(WildCardPatternMatching.tabulation("cab", "?cb"));
    Assertions.assertTrue(WildCardPatternMatching.tabulation("cab", "***b"));
    Assertions.assertTrue(WildCardPatternMatching.tabulation("cab", "*c*b"));
  }
}
