package com.github4sanjay.dsalgo.sorting;

public class QuickSort {
  public static void sort(int[] A) {
    quickSort(A, 0, A.length - 1);
  }

  private static void quickSort(int[] a, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivot = a[high];
    int pivotIndex = PartitioningArray.partition(a, pivot, low, high);
    quickSort(a, low, pivotIndex - 1);
    quickSort(a, pivotIndex + 1, high);
  }
}
