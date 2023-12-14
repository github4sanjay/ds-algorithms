package com.github4sanjay.dsalgo.maths;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnyBaseAdditionTest {

  @Test
  public void testAdd() {
    assertEquals(1000, AnyBaseAddition.add(8, 777, 1));
    assertEquals(401, AnyBaseAddition.add(6, 123, 234));
    assertEquals(805, AnyBaseAddition.add(9, 546, 248));
  }

  @Test
  public void testAddWithZero() {
    // Test when one of the numbers is zero
    assertEquals(123, AnyBaseAddition.add(6, 123, 0));
    assertEquals(234, AnyBaseAddition.add(6, 0, 234));
  }

  @Test
  public void testAddWithSameNumber() {
    // Test when both numbers are the same
    assertEquals(777, AnyBaseAddition.add(8, 777, 0));
    assertEquals(888, AnyBaseAddition.add(9, 444, 444));
  }

  @Test
  public void testAddWithLargeNumbers() {
    // Test with larger numbers
    assertEquals(100000, AnyBaseAddition.add(10, 99999, 1));
    assertEquals(999999, AnyBaseAddition.add(10, 123456, 876543));
  }
}
