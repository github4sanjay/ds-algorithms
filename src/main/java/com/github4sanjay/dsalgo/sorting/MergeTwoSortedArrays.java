package com.github4sanjay.dsalgo.sorting;

public class MergeTwoSortedArrays {

  public static int[] merge(int[] a, int[] b) {
    int[] merged = new int[a.length + b.length];
    int i = 0, j = 0;
    int counter = 0;
    while (i < a.length && j < b.length) {
      if (a[i] < b[j]) {
        merged[counter] = a[i];
        i++;
      } else {
        merged[counter] = b[j];
        j++;
      }
      counter++;
    }
    while (i < a.length) {
      merged[counter] = a[i];
      counter++;
      i++;
    }
    while (j < b.length) {
      merged[counter] = b[j];
      counter++;
      j++;
    }
    return merged;
  }

  /*
   * 1) Iterate through every element of ar2[] starting from last element. Do following for every element ar2[i]
   *      a) Store last element of ar1[i]: last = ar1[i]
   *      b) Loop from last element of ar1[] while element ar1[j] is greater than ar2[i].
   *         ar1[j+1] = ar1[j] // Move element one  position ahead j--
   *      c) If any element of ar1[] was moved or (j != m-1) ar1[j+1] = ar2[i] ar2[i] = last
   */
  public static void mergeWithoutSpace(int[] a, int[] b) {
    for (int i = b.length - 1; i >= 0; i--) {
      boolean moved = false;
      int j, last = a[a.length - 1];
      for (j = a.length - 2; j >= 0 && b[i] < a[j]; j--) {
        a[j + 1] = a[j];
        moved = true;
      }
      if (moved) {
        a[j + 1] = b[i];
        b[i] = last;
      }
    }
  }
}
