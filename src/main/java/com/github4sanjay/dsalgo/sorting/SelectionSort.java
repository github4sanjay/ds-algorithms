package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

public class SelectionSort {
  public static void sort(int[] A) {
    for (int i = 0; i < A.length; i++) {
      int min = i;
      for (int j = i + 1; j < A.length; j++) {
        if (A[j] < A[min]) {
          min = j;
        }
      }
      int temp = A[i];
      A[i] = A[min];
      A[min] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    SelectionSort.sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {2};
    SelectionSort.sort(arr1);
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {};
    SelectionSort.sort(arr2);
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = {64, 25, 12, 22, 11};
    SelectionSort.sort(arr3);
    System.out.println(Arrays.toString(arr3));

    int[] arr4 = {4, 31, 143, 1, 2};
    SelectionSort.sort(arr4);
    System.out.println(Arrays.toString(arr4));
  }
}
