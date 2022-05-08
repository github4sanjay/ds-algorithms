package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

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

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    QuickSort.sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {2};
    QuickSort.sort(arr1);
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {};
    QuickSort.sort(arr2);
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = {64, 25, 12, 22, 11};
    QuickSort.sort(arr3);
    System.out.println(Arrays.toString(arr3));

    int[] arr4 = {4, 31, 143, 1, 2};
    QuickSort.sort(arr4);
    System.out.println(Arrays.toString(arr4));
  }
}
