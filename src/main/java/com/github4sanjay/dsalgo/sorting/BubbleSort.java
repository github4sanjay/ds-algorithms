package com.github4sanjay.dsalgo.sorting;

public class BubbleSort {

  public static void sort(int[] A) {
    for (int i = 1; i < A.length; i++) {
      for (int j = 0; j < A.length - i; j++) {
        if (A[j] > A[j + 1]) {
          int temp = A[j];
          A[j] = A[j + 1];
          A[j + 1] = temp;
        }
      }
    }
  }
}
