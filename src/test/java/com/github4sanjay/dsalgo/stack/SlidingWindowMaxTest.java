package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SlidingWindowMaxTest {

  @Test
  public void testFindWithHelpOfMaxHeap() {
    int[] input1 = {1, 3, -1, -3, 5, 3, 6, 7};
    int window1 = 3;
    int[] expected1 = {3, 3, 5, 5, 6, 7};
    // assertArrayEquals(expected1, SlidingWindowMax.findWithHelpOfMaxHeap(input1, window1));

    int[] input2 = {9, 7, 2, 4, 6, 8, 2, 1, 5};
    int window2 = 4;
    int[] expected2 = {9, 7, 8, 8, 8, 8};
    assertArrayEquals(expected2, SlidingWindowMax.findWithHelpOfMaxHeap(input2, window2));

    // Add more test cases as needed
  }
}
