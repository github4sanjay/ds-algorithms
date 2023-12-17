package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("QuickSelect Test")
public class QuickSelectTest {

  @Test
  @DisplayName("Finds the Kth largest element in an unsorted array")
  public void testSelectKthLargestElement() {
    int[] arr = {5, 2, 9, 1, 5, 6};
    int k = 3;
    int expected = 5;

    int result = QuickSelect.selectKthLargestElement(arr, k);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Finds the largest element in an unsorted array")
  public void testSelectLargestElement() {
    int[] arr = {5, 2, 9, 1, 5, 6};
    int k = 1;
    int expected = 2;

    int result = QuickSelect.selectKthLargestElement(arr, k);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Finds the smallest element in an unsorted array")
  public void testSelectSmallestElement() {
    int[] arr = {5, 2, 9, 1, 5, 6};
    int k = arr.length - 1;
    int expected = 9;

    int result = QuickSelect.selectKthLargestElement(arr, k);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Finds the Kth largest element in a sorted array")
  public void testSelectKthLargestElementInSortedArray() {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    int k = 4;
    int expected = 5;

    int result = QuickSelect.selectKthLargestElement(arr, k);
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("Finds the Kth largest element in a reverse-sorted array")
  public void testSelectKthLargestElementInReverseSortedArray() {
    int[] arr = {7, 6, 5, 4, 3, 2, 1};
    int k = 2;
    int expected = 3;

    int result = QuickSelect.selectKthLargestElement(arr, k);
    assertEquals(expected, result);
  }
}
