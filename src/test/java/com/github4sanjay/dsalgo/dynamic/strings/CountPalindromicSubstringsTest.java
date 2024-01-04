package com.github4sanjay.dsalgo.dynamic.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountPalindromicSubstringsTest {

  @Test
  public void test() {
    Assertions.assertEquals(3, CountPalindromicSubstrings.count("abc"));
    Assertions.assertEquals(6, CountPalindromicSubstrings.count("aaa"));
    Assertions.assertEquals(9, CountPalindromicSubstrings.count("abccbc")); // 9
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(3, CountPalindromicSubstrings.recursion("abc"));
    Assertions.assertEquals(6, CountPalindromicSubstrings.recursion("aaa"));
    Assertions.assertEquals(9, CountPalindromicSubstrings.recursion("abccbc")); // 9
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(3, CountPalindromicSubstrings.memoization("abc"));
    Assertions.assertEquals(6, CountPalindromicSubstrings.memoization("aaa"));
    Assertions.assertEquals(9, CountPalindromicSubstrings.memoization("abccbc")); // 9
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(3, CountPalindromicSubstrings.tabulation("abc"));
    Assertions.assertEquals(6, CountPalindromicSubstrings.tabulation("aaa"));
    Assertions.assertEquals(9, CountPalindromicSubstrings.tabulation("abccbc")); // 9
  }
}
