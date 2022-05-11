package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordPatternTest {

  @Test
  public void check() {
    Assertions.assertTrue(WordPattern.check("abba", "dog cat cat dog"));
    Assertions.assertFalse(WordPattern.check("abba", "dog cat cat fish"));
    Assertions.assertFalse(WordPattern.check("aaaa", "dog cat cat dog"));
  }
}
