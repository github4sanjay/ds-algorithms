package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InfixConversionTest {

  @Test
  public void testPostfixConversion() {
    assertEquals("abcd^e-fgh*+^*+i-", InfixConversion.postfix("a+b*(c^d-e)^(f+g*h)-i"));
    assertEquals("abc/-ak/l-*", InfixConversion.postfix("(a-b/c)*(a/k-l)"));
  }

  @Test
  public void testPrefixConversion() {
    assertEquals("*-a/bc-/akl", InfixConversion.prefix("(a-b/c)*(a/k-l)"));
    assertEquals("-+a*/bcde", InfixConversion.prefix("a+b/c*d-e"));
  }
}
