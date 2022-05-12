package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveOutermostParenthesesTest {

  @Test
  public void find() {
    Assertions.assertEquals("()()()()(())", RemoveOutermostParentheses.find("(()())(())(()(()))"));
    Assertions.assertEquals("()()()", RemoveOutermostParentheses.find("(()())(())"));
    Assertions.assertEquals("", RemoveOutermostParentheses.find("()()"));
  }
}
