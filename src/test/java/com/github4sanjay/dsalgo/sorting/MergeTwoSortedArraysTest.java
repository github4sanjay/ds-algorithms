package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MergeTwoSortedArraysTest {

  @Test
  @DisplayName("Test Merge Two Sorted Arrays")
  public void testMerge() {
    int[] arr1 = {1, 3, 5, 7};
    int[] arr2 = {2, 4, 6, 8};
    int[] expectedMerge = {1, 2, 3, 4, 5, 6, 7, 8};
    assertArrayEquals(expectedMerge, MergeTwoSortedArrays.merge(arr1, arr2));

    int[] ar1 = {1, 5, 9, 10, 15, 20};
    int[] ar2 = {2, 3, 8, 13};
    int[] expectedMerge2 = {1, 2, 3, 5, 8, 9, 10, 13, 15, 20};
    assertArrayEquals(expectedMerge2, MergeTwoSortedArrays.merge(ar1, ar2));
  }

  @Test
  @Disabled
  @DisplayName("Test Merge Two Sorted Arrays Without Space")
  public void testMergeWithoutSpace() {
    int[] arr1 = {1, 3, 5, 7};
    int[] arr2 = {2, 4, 6, 8};

    int[] ar1Copy = new int[] {1, 2, 3, 4};
    int[] ar2Copy = new int[] {5, 6, 7, 8};
    MergeTwoSortedArrays.mergeWithoutSpace(arr1, arr2);
    assertArrayEquals(ar1Copy, arr1);
    assertArrayEquals(ar2Copy, arr2);
  }
}
