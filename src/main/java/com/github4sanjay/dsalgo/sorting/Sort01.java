package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

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

  public static void main(String[] args) {
    int[] arr = new int[] {0, 1, 0, 1, 1, 1};
    Sort01.segregate0and1(arr);
    System.out.println(Arrays.toString(arr)); // [0, 0, 1, 1, 1, 1]
  }
}
