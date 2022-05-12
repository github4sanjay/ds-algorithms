package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreOfParenthesesTest {

  @Test
  public void find() {
    Assertions.assertEquals(2, ScoreOfParentheses.find("(())"));
    Assertions.assertEquals(2, ScoreOfParentheses.find("()()"));
    Assertions.assertEquals(6, ScoreOfParentheses.find("(()(()))"));
  }
}
