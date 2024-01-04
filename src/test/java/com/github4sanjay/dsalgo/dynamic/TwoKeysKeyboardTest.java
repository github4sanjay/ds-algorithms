package com.github4sanjay.dsalgo.dynamic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoKeysKeyboardTest {

  @Test
  public void testRecursion() {
    Assertions.assertEquals(5, TwoKeysKeyboard.recursion(5));
    Assertions.assertEquals(5, TwoKeysKeyboard.recursion(6));
    Assertions.assertEquals(3, TwoKeysKeyboard.recursion(3));
    Assertions.assertEquals(0, TwoKeysKeyboard.recursion(1));
    Assertions.assertEquals(7, TwoKeysKeyboard.recursion(7));
    Assertions.assertEquals(6, TwoKeysKeyboard.recursion(8));
  }

  @Test
  public void testDP() {
    Assertions.assertEquals(5, TwoKeysKeyboard.dp(5));
    Assertions.assertEquals(5, TwoKeysKeyboard.dp(6));
    Assertions.assertEquals(3, TwoKeysKeyboard.dp(3));
    Assertions.assertEquals(0, TwoKeysKeyboard.dp(1));
    Assertions.assertEquals(7, TwoKeysKeyboard.dp(7));
    Assertions.assertEquals(6, TwoKeysKeyboard.dp(8));
  }
}
