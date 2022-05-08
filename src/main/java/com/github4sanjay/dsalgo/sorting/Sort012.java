package com.github4sanjay.dsalgo.sorting;

import java.util.Arrays;

public class Sort012 {
  public static void segregate01And2(int[] arr) {
    int i = 0, j = 0, k = arr.length - 1;
    while (i <= k) {
      if (arr[i] == 1) {
        i++;
      } else if (arr[i] == 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j++;
      } else {
        int temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
        k--; // only decrease k as i can be 0 which needs to move in space between 0 to j
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {0, 1, 0, 2, 1, 2, 2, 1, 1, 0};
    Sort012.segregate01And2(arr);
    System.out.println(Arrays.toString(arr)); // [0, 0, 1, 1, 1, 1]
  }
}
