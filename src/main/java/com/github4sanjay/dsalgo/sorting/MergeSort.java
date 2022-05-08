package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

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

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    System.out.println(Arrays.toString(MergeSort.sort(arr)));

    int[] arr1 = {2};
    System.out.println(Arrays.toString(MergeSort.sort(arr1)));

    int[] arr2 = {};
    System.out.println(Arrays.toString(MergeSort.sort(arr2)));

    int[] arr3 = {64, 25, 12, 22, 11};
    System.out.println(Arrays.toString(MergeSort.sort(arr3)));

    int[] arr4 = {4, 31, 143, 1, 2};
    System.out.println(Arrays.toString(MergeSort.sort(arr4)));
  }
}
