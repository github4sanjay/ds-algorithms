package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("QuickSort Test")
public class QuickSortTest {

  @Test
  @DisplayName("Sorts an unsorted array")
  public void testQuickSort() {
    int[] arr = {5, 2, 9, 1, 5, 6};
    int[] expected = {1, 2, 5, 5, 6, 9};

    QuickSort.sort(arr);
    assertArrayEquals(expected, arr);
  }

  @Test
  @DisplayName("Sorts an empty array")
  public void testEmptyArray() {
    int[] arr = {};
    int[] expected = {};

    QuickSort.sort(arr);
    assertArrayEquals(expected, arr);
  }

  @Test
  @DisplayName("Sorts a single-element array")
  public void testSingleElementArray() {
    int[] arr = {42};
    int[] expected = {42};

    QuickSort.sort(arr);
    assertArrayEquals(expected, arr);
  }

  @Test
  @DisplayName("Sorts an already sorted array")
  public void testAlreadySortedArray() {
    int[] arr = {1, 2, 3, 4, 5};
    int[] expected = {1, 2, 3, 4, 5};

    QuickSort.sort(arr);
    assertArrayEquals(expected, arr);
  }

  @Test
  @DisplayName("Sorts a reverse sorted array")
  public void testReverseSortedArray() {
    int[] arr = {5, 4, 3, 2, 1};
    int[] expected = {1, 2, 3, 4, 5};

    QuickSort.sort(arr);
    assertArrayEquals(expected, arr);
  }
}
