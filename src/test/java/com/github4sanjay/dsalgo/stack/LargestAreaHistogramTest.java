package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LargestAreaHistogramTest {

  @Test
  public void testFind() {
    int[] input1 = {6, 2, 5, 4, 5, 1, 6};
    int expected1 = 12;
    assertEquals(expected1, LargestAreaHistogram.find(input1));

    int[] input2 = {2, 4, 2, 1, 10, 6, 12, 3, 5};
    int expected2 = 18;
    assertEquals(expected2, LargestAreaHistogram.find(input2));

    int[] input3 = {6, 2, 3, 4, 5, 6};
    int expected3 = 12;
    assertEquals(expected3, LargestAreaHistogram.find(input3));
  }
}
