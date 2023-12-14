package com.github4sanjay.dsalgo.maths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnyBaseToDecimalTest {

  @Test
  public void test() {
    Assertions.assertEquals(63, AnyBaseToDecimal.find(77, 8));
    Assertions.assertEquals(634, AnyBaseToDecimal.find(1172, 8));
  }
}
