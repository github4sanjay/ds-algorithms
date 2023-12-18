package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DuplicateBracketsTest {

  @Test
  public void testHasExtra() {
    assertFalse(DuplicateBrackets.hasExtra("((a+(b))+(c+d))"));
    assertTrue(DuplicateBrackets.hasExtra("(((a+(b)))+(c+d))"));
    assertTrue(DuplicateBrackets.hasExtra("((a+b)+((c+d)))"));

    assertFalse(DuplicateBrackets.hasExtra("((a+b)+(c+d))"));
    assertFalse(DuplicateBrackets.hasExtra("((a+(b))+(c+d))"));
    assertTrue(DuplicateBrackets.hasExtra("(((a+(b)))+c+d))"));
  }
}
