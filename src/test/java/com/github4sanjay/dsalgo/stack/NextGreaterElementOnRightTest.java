package com.github4sanjay.dsalgo.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NextGreaterElementOnRightTest {

  @Test
  public void testFind() {
    assertArrayEquals(
        new int[] {-1, 12, 12, -1}, NextGreaterElementOnRight.find(new int[] {13, 7, 6, 12}));
    assertArrayEquals(
        new int[] {5, 25, 25, -1}, NextGreaterElementOnRight.find(new int[] {4, 5, 2, 25}));
    assertArrayEquals(
        new int[] {8, 8, -1, 7, -1}, NextGreaterElementOnRight.find(new int[] {5, 3, 8, -2, 7}));
    assertArrayEquals(new int[] {-1}, NextGreaterElementOnRight.find(new int[] {9}));
    assertArrayEquals(
        new int[] {-1, -1, -1, -1}, NextGreaterElementOnRight.find(new int[] {4, 3, 2, 1}));
  }
}
