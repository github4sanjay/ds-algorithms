package com.github4sanjay.dsalgo.sorting;

public class Sort01 {
  public static void segregate0and1(int[] arr) {
    int i = 0, j = 0;
    while (i < arr.length && j < arr.length) {
      if (arr[i] == 1) {
        i++;
      } else {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j++;
      }
    }
  }
}
