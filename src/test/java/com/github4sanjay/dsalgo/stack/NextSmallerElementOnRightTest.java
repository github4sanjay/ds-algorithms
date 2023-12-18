package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NextSmallerElementOnRightTest {

  @Test
  public void testFind() {
    int[] input1 = {13, 7, 6, 12};
    int[] expected1 = {7, 6, -1, -1};
    assertArrayEquals(expected1, NextSmallerElementOnRight.find(input1));

    int[] input2 = {4, 5, 2, 25};
    int[] expected2 = {2, 2, -1, -1};
    assertArrayEquals(expected2, NextSmallerElementOnRight.find(input2));

    int[] input3 = {5, 3, 8, -2, 7};
    int[] expected3 = {3, -2, -2, -1, -1};
    assertArrayEquals(expected3, NextSmallerElementOnRight.find(input3));
  }
}
