package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseSubstringsBetweenEachPairOfParenthesesTest {

  @Test
  public void find() {
    Assertions.assertEquals("dcba", ReverseSubstringsBetweenEachPairOfParentheses.find("(abcd)"));
    Assertions.assertEquals(
        "iloveu", ReverseSubstringsBetweenEachPairOfParentheses.find("(u(love)i)"));
    Assertions.assertEquals(
        "leetcode", ReverseSubstringsBetweenEachPairOfParentheses.find("(ed(et(oc))el)"));
  }
}
