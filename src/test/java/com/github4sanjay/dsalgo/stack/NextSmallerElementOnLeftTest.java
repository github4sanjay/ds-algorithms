package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class NextSmallerElementOnLeftTest {

  @Test
  public void testFind() {
    int[] input1 = {5, 3, 8, -2, 7};
    int[] expected1 = {-1, -1, 3, -1, -2};
    assertArrayEquals(expected1, NextSmallerElementOnLeft.find(input1));

    int[] input2 = {4, 5, 2, 25};
    int[] expected2 = {-1, 4, -1, 2};
    assertArrayEquals(expected2, NextSmallerElementOnLeft.find(input2));

    int[] input3 = {5, 3, 8, -2, 7};
    int[] expected3 = {-1, -1, 3, -1, -2};
    assertArrayEquals(expected3, NextSmallerElementOnLeft.find(input3));
  }
}
