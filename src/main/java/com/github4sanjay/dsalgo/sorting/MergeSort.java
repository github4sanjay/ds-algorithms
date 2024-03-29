package com.github4sanjay.dsalgo.sorting;

public class MergeSort {
  public static int[] sort(int[] A) {
    if (A.length > 0) return mergeSort(A, 0, A.length - 1);
    return A;
  }

  private static int[] mergeSort(int[] a, int low, int high) {
    if (low == high) {
      return new int[] {a[low]};
    }
    int mid = low + (high - low) / 2; // (low+high)/2
    int[] firstHalf = mergeSort(a, low, mid);
    int[] secondHalf = mergeSort(a, mid + 1, high);
    return MergeTwoSortedArrays.merge(firstHalf, secondHalf);
  }
}
