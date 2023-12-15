package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CountSortTest {

  @Test
  @DisplayName("Test count sort")
  public void testSortIntArray() {
    int[] arr = {4, 2, 7, 1, 5, 3};
    int[] expected = {1, 2, 3, 4, 5, 7};
    assertArrayEquals(expected, CountSort.sort(arr));
  }

  @Test
  @DisplayName("Test based on 10th position of all the elements")
  public void testSortIntArrayWithExp() {
    int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
    int[] expected = {802, 2, 24, 45, 66, 170, 75, 90};
    CountSort.sort(arr, 10);
    assertArrayEquals(expected, arr);

    int[] arr1 = {17, 45, 75, 90, 80, 24, 20, 66};
    int[] expected1 = {17, 24, 20, 45, 66, 75, 80, 90};
    CountSort.sort(arr1, 10);
    assertArrayEquals(expected1, arr1);
  }

  @Test
  public void testSortStringArray() {
    String[] arr =
        new String[] {"20012014", "25032010", "03122000", "18112001", "19042015", "09072005"};
    String[] expected = {"03122000", "18112001", "09072005", "25032010", "20012014", "19042015"};
    CountSort.sort(arr, 1, 10000, 2016);
    assertArrayEquals(expected, arr);
  }
}
