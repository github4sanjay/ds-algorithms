package com.github4sanjay.dsalgo.dynamic.patternmatching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegularExpressionMatchingTest {

  @Test
  public void test() {
    Assertions.assertFalse(RegularExpressionMatching.find("mississippi", "mis*is*p*.")); // false
    Assertions.assertTrue(RegularExpressionMatching.find("aab", "c*a*b")); // true
    Assertions.assertFalse(RegularExpressionMatching.find("aa", "a")); // false
    Assertions.assertTrue(RegularExpressionMatching.find("aa", "a*")); // true
    Assertions.assertTrue(RegularExpressionMatching.find("ab", ".*")); // true
    Assertions.assertTrue(RegularExpressionMatching.find("mississippi", "mis*i.*p*i")); // true
    Assertions.assertFalse(RegularExpressionMatching.find("mississippi", "mip*i.*p*i")); // true
    Assertions.assertFalse(RegularExpressionMatching.find("mississippi", "mip*i.*p*i*")); // true
  }

  @Test
  public void testRecursion() {
    Assertions.assertFalse(RegularExpressionMatching.recursion("mississippi", "mis*is*p*."));
    Assertions.assertTrue(RegularExpressionMatching.recursion("aab", "c*a*b")); // true
    Assertions.assertFalse(RegularExpressionMatching.recursion("aa", "a")); // false
    Assertions.assertTrue(RegularExpressionMatching.recursion("aa", "a*")); // true
    Assertions.assertTrue(RegularExpressionMatching.recursion("ab", ".*")); // true
    Assertions.assertTrue(RegularExpressionMatching.recursion("mississippi", "mis*i.*p*i")); // true
    Assertions.assertFalse(
        RegularExpressionMatching.recursion("mississippi", "mip*i.*p*i")); // true
    Assertions.assertFalse(RegularExpressionMatching.find("mississippi", "mip*i.*p*i*")); // true
  }

  @Test
  public void testMemoization() {
    Assertions.assertFalse(RegularExpressionMatching.memoization("mississippi", "mis*is*p*."));
    Assertions.assertTrue(RegularExpressionMatching.memoization("aab", "c*a*b")); // true
    Assertions.assertFalse(RegularExpressionMatching.memoization("aa", "a")); // false
    Assertions.assertTrue(RegularExpressionMatching.memoization("aa", "a*")); // true
    Assertions.assertTrue(RegularExpressionMatching.memoization("ab", ".*")); // true
    Assertions.assertTrue(
        RegularExpressionMatching.memoization("mississippi", "mis*i.*p*i")); // true
    Assertions.assertFalse(
        RegularExpressionMatching.memoization("mississippi", "mip*i.*p*i")); // true
    Assertions.assertFalse(RegularExpressionMatching.find("mississippi", "mip*i.*p*i*")); // true
  }
}
