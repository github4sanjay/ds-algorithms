package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RadixSortTest {

  @Test
  public void testRadixSort() {
    int[] arr1 = {64434, 23435, 312, 22, 11};
    int[] expected1 = {11, 22, 312, 23435, 64434};
    RadixSort.sort(arr1);
    assertArrayEquals(expected1, arr1);

    int[] arr2 = {4, 31, 143, 1, 2};
    int[] expected2 = {1, 2, 4, 31, 143};
    RadixSort.sort(arr2);
    assertArrayEquals(expected2, arr2);
  }
}
