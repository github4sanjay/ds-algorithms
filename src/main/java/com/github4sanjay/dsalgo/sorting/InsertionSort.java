package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

public class InsertionSort {
  public static void sort(int[] A) {
    for (int i = 1; i < A.length; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (A[j] > A[j + 1]) {
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = {2, 3, 1, 4, 6, 7, 5, 8, 9};
    InsertionSort.sort(arr);
    System.out.println(Arrays.toString(arr));

    int[] arr1 = {2};
    InsertionSort.sort(arr1);
    System.out.println(Arrays.toString(arr1));

    int[] arr2 = {};
    InsertionSort.sort(arr2);
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = {64, 25, 12, 22, 11};
    InsertionSort.sort(arr3);
    System.out.println(Arrays.toString(arr3));

    int[] arr4 = {4, 31, 143, 1, 2};
    InsertionSort.sort(arr4);
    System.out.println(Arrays.toString(arr4));
  }
}
