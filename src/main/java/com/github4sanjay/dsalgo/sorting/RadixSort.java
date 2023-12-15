package com.github4sanjay.dsalgo.sorting;

/** stable count sort means does not change the order of equal weight elements */
public class RadixSort {

  public static void sort(int[] A) {
    int max = Integer.MIN_VALUE;
    for (int value : A) {
      if (value >= max) {
        max = value;
      }
    }

    int exp = 1;
    while (exp <= max) {
      CountSort.sort(A, exp);
      exp = exp * 10;
    }
  }
}
