package com.github4sanjay.dsalgo.dynamic.strings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CountPalindromicSubsequencesTest {

  @Test
  public void test() {
    Assertions.assertEquals(4, CountPalindromicSubsequences.count("abcd"));
    Assertions.assertEquals(4, CountPalindromicSubsequences.count("aab"));
    Assertions.assertEquals(15, CountPalindromicSubsequences.count("aaaa"));
  }

  @Test
  public void testRecursion() {
    Assertions.assertEquals(4, CountPalindromicSubsequences.recursion("abcd"));
    Assertions.assertEquals(4, CountPalindromicSubsequences.recursion("aab"));
    Assertions.assertEquals(15, CountPalindromicSubsequences.recursion("aaaa"));
  }

  @Test
  public void testMemoization() {
    Assertions.assertEquals(4, CountPalindromicSubsequences.memoization("abcd"));
    Assertions.assertEquals(4, CountPalindromicSubsequences.memoization("aab"));
    Assertions.assertEquals(15, CountPalindromicSubsequences.memoization("aaaa"));
  }

  @Test
  public void testTabulation() {
    Assertions.assertEquals(4, CountPalindromicSubsequences.tabular("abcd"));
    Assertions.assertEquals(4, CountPalindromicSubsequences.tabular("aab"));
    Assertions.assertEquals(15, CountPalindromicSubsequences.tabular("aaaa"));
  }
}
