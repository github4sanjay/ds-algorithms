package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NextGreaterElementOnLeftTest {

  @Test
  public void testFind() {
    int[] input1 = {5, 3, 8, -2, 7};
    int[] expected1 = {-1, 5, -1, 8, 8};
    assertArrayEquals(expected1, NextGreaterElementOnLeft.find(input1));

    int[] input2 = {4, 5, 2, 25};
    int[] expected2 = {-1, -1, 5, -1};
    assertArrayEquals(expected2, NextGreaterElementOnLeft.find(input2));

    int[] input3 = {10, 20, 30, 40, 50};
    int[] expected3 = {-1, -1, -1, -1, -1};
    assertArrayEquals(expected3, NextGreaterElementOnLeft.find(input3));
  }
}
