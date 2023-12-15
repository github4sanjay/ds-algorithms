package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FindPivotInSortedRotatedArrayTest {

  @Test
  public void testPivotedBinarySearch() {
    int[] arr1 = {50, 10, 20, 30, 40};
    assertEquals(10, FindPivotInSortedRotatedArray.pivotedBinarySearch(arr1));

    int[] arr2 = {50, 60, 70, 80, 90, 100, 110, 120, 5, 10, 20, 30, 40};
    assertEquals(5, FindPivotInSortedRotatedArray.pivotedBinarySearch(arr2));
  }
}
