package com.github4sanjay.dsalgo.array;

import java.util.Arrays;

public class ReverseArray {
  public static void main(String[] args) {
    var arr = new int[] {9, 5, 4, 9};
    ReverseArray.reverse(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void reverse(int[] arr) {
    int i = 0;
    int j = arr.length - 1;
    while (i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      i++;
      j--;
    }
  }

  public static void reverse(int i, int j, int[] arr) {
    while (i < j) {
      int temp = arr[j];
      arr[j] = arr[i];
      arr[i] = temp;
      i++;
      j--;
    }
  }
}
