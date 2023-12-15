package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SelectionSortTest {

  @Test
  @DisplayName("Test Selection Sort")
  public void testSelectionSort() {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    int[] expectedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    SelectionSort.sort(arr);
    assertArrayEquals(expectedArr, arr);

    int[] arr1 = {2};
    int[] expectedArr1 = {2};
    SelectionSort.sort(arr1);
    assertArrayEquals(expectedArr1, arr1);

    int[] arr2 = {};
    int[] expectedArr2 = {};
    SelectionSort.sort(arr2);
    assertArrayEquals(expectedArr2, arr2);

    int[] arr3 = {1, 2, 1, 1};
    int[] expectedArr3 = {1, 1, 1, 2};
    SelectionSort.sort(arr3);
    assertArrayEquals(expectedArr3, arr3);

    int[] arr4 = {4, 31, 32, 1, 2};
    int[] expectedArr4 = {1, 2, 4, 31, 32};
    SelectionSort.sort(arr4);
    assertArrayEquals(expectedArr4, arr4);
  }
}
