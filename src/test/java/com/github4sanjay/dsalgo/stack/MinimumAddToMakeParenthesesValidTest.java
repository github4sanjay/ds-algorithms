package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumAddToMakeParenthesesValidTest {

  @Test
  public void find() {
    Assertions.assertEquals(1, MinimumAddToMakeParenthesesValid.find("())"));
    Assertions.assertEquals(3, MinimumAddToMakeParenthesesValid.find("((("));
  }
}
