package com.github4sanjay.dsalgo.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PartitioningArrayTest {

  @Test
  @DisplayName("Test Partitioning Array with pivot method")
  public void testPartitionWithPivot() {
    int[] array = {3, 8, 2, 5, 1, 4, 6};
    int pivot = 4;

    PartitioningArray.partition(array, pivot);

    int j = 0;
    while (j < array.length && array[j] <= pivot) {
      j++;
    }

    while (j < array.length) {
      assertTrue(array[j] > pivot);
      j++;
    }
  }

  @Test
  @DisplayName("Test Partitioning Array with pivot, low, high method")
  public void testPartitionWithPivotLowHigh() {
    int[] array = {3, 8, 2, 5, 1, 4, 6};
    int pivot = 4;
    int low = 0;
    int high = array.length - 1;

    int pivotIndex = PartitioningArray.partition(array, pivot, low, high);

    assertTrue(pivotIndex >= low && pivotIndex <= high);
    for (int i = low; i < pivotIndex; i++) {
      assertTrue(array[i] <= pivot);
    }
    for (int i = pivotIndex + 1; i <= high; i++) {
      assertTrue(array[i] > pivot);
    }
  }
}
