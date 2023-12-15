package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeSortTest {

  @Test
  @DisplayName("Test Merge Sort")
  public void testMergeSort() {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    int[] expectedSortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    assertArrayEquals(expectedSortedArr, MergeSort.sort(arr));

    int[] arr1 = {2};
    int[] expectedSortedArr1 = {2};
    assertArrayEquals(expectedSortedArr1, MergeSort.sort(arr1));

    int[] arr2 = {};
    int[] expectedSortedArr2 = {};
    assertArrayEquals(expectedSortedArr2, MergeSort.sort(arr2));

    int[] arr3 = {64, 25, 12, 22, 11};
    int[] expectedSortedArr3 = {11, 12, 22, 25, 64};
    assertArrayEquals(expectedSortedArr3, MergeSort.sort(arr3));

    int[] arr4 = {4, 31, 143, 1, 2};
    int[] expectedSortedArr4 = {1, 2, 4, 31, 143};
    assertArrayEquals(expectedSortedArr4, MergeSort.sort(arr4));
  }
}
