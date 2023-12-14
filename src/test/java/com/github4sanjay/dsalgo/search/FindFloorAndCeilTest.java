package com.github4sanjay.dsalgo.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindFloorAndCeilTest {

  @Test
  public void testFind() {
    var result1 = FindFloorAndCeil.find(new int[] {5, 10, 15, 22, 33, 40, 42, 55}, 25);
    assertEquals(22, result1.floor);
    assertEquals(33, result1.ceil);

    var result2 = FindFloorAndCeil.find(new int[] {5, 10, 15, 22, 33, 40, 42, 55}, 22);
    assertEquals(22, result2.floor);
    assertEquals(22, result2.ceil);

    var result3 = FindFloorAndCeil.find(new int[] {5, 10, 15, 22, 33, 40, 42, 55}, 100);
    assertEquals(55, result3.floor);
    assertEquals(Integer.MIN_VALUE, result3.ceil);

    var result4 = FindFloorAndCeil.find(new int[] {}, 10); // Empty array case
    assertEquals(Integer.MIN_VALUE, result4.floor);
    assertEquals(Integer.MIN_VALUE, result4.ceil);
  }
}
