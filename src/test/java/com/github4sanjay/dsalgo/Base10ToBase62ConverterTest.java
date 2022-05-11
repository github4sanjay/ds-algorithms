package com.github4sanjay.dsalgo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Base10ToBase62ConverterTest {

  @Test
  @DisplayName("test")
  public void test() {
    Assertions.assertEquals("1Vn", Base10ToBase62Converter.fromBase10(5815));
    Assertions.assertEquals("6laZE", Base10ToBase62Converter.fromBase10(100000000));
  }
}
