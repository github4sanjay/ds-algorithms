package com.github4sanjay.dsalgo.maths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnyBaseSubtractionTest {

  @Test
  public void testSubtract() {
    assertEquals(77, AnyBaseSubtraction.subtract(8, 1, 100));
    assertEquals(9, AnyBaseSubtraction.subtract(10, 11, 20));
    assertEquals(100, AnyBaseSubtraction.subtract(10, 356, 456));
    assertEquals(0, AnyBaseSubtraction.subtract(10, 100, 100));
  }

  @Test
  public void testSubtractWithZero() {
    // Test when one of the numbers is zero
    assertEquals(123, AnyBaseSubtraction.subtract(6, 0, 123));
    assertEquals(234, AnyBaseSubtraction.subtract(6, 0, 234));
  }

  @Test
  public void testSubtractWithSameNumber() {
    // Test when both numbers are the same
    assertEquals(0, AnyBaseSubtraction.subtract(8, 777, 777));
    assertEquals(0, AnyBaseSubtraction.subtract(9, 123, 123));
  }

  @Test
  public void testSubtractWithLargeNumbers() {
    // Test with larger numbers
    assertEquals(99999, AnyBaseSubtraction.subtract(10, 1, 100000));
    assertEquals(753, AnyBaseSubtraction.subtract(10, 246, 999));
  }
}
