package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InsertionSortTest {

  @Test
  @DisplayName("Test insertion Sort")
  public void testInsertionSort() {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    int[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    InsertionSort.sort(arr);
    assertArrayEquals(expectedArr, arr);

    int[] arr1 = {2};
    int[] expectedArr1 = {2};
    InsertionSort.sort(arr1);
    assertArrayEquals(expectedArr1, arr1);

    int[] arr2 = {};
    int[] expectedArr2 = {};
    InsertionSort.sort(arr2);
    assertArrayEquals(expectedArr2, arr2);

    int[] arr3 = {1, 2, 1, 1};
    int[] expectedArr3 = {1, 1, 1, 2};
    InsertionSort.sort(arr3);
    assertArrayEquals(expectedArr3, arr3);

    int[] arr4 = {4, 31, 32, 1, 2};
    int[] expectedArr4 = {1, 2, 4, 31, 32};
    InsertionSort.sort(arr4);
    assertArrayEquals(expectedArr4, arr4);
  }
}
