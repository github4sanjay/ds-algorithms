package com.github4sanjay.dsalgo.maths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DecimalToAnyBaseTest {

  @Test
  public void test() {
    Assertions.assertEquals(77, DecimalToAnyBase.find(63, 8));
    Assertions.assertEquals(1172, DecimalToAnyBase.find(634, 8));
  }
}
