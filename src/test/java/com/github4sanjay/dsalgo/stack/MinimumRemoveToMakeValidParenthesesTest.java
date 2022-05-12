package com.github4sanjay.dsalgo.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumRemoveToMakeValidParenthesesTest {

  @Test
  public void find() {
    Assertions.assertEquals(
        "lee(t(c)o)de", MinimumRemoveToMakeValidParentheses.find("lee(t(c)o)de)"));
    Assertions.assertEquals("ab(c)d", MinimumRemoveToMakeValidParentheses.find("a)b(c)d"));
    Assertions.assertEquals("", MinimumRemoveToMakeValidParentheses.find("))(("));
  }
}
