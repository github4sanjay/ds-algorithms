package com.github4sanjay.dsalgo.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsomorphicStringsTest {

  @Test
  public void test() {
    /* Assertions.assertTrue(IsomorphicStrings.check("abacba", "xyxzyx"));
    Assertions.assertFalse(IsomorphicStrings.check("abacba", "xyxzyw"));*/
    Assertions.assertFalse(IsomorphicStrings.check("abacba", "xyxyyx"));
    Assertions.assertFalse(IsomorphicStrings.check("pepcoding", "sosherlok"));
  }
}
