package com.github4sanjay.dsalgo.sorting;

/** stable count sort means does not change the order of equal weight elements */
public class CountSort {
  public static int[] sort(int[] A) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int value : A) {
      if (value <= min) {
        min = value;
      }
      if (value >= max) {
        max = value;
      }
    }

    int range = max - min + 1;
    int[] tempArray = new int[range];
    for (int i = 0; i < A.length; i++) {
      tempArray[A[i] - min]++;
    }
    int sum = -1;
    for (int i = 0; i < tempArray.length; i++) {
      sum = sum + tempArray[i];
      tempArray[i] = sum;
    }
    int[] finalArray = new int[A.length];
    for (int i = A.length - 1; i >= 0; i--) {
      finalArray[tempArray[A[i] - min]] = A[i];
      tempArray[A[i] - min]--;
    }
    return finalArray;
  }

  /** min = 0, array length = 10 as digits */
  public static void sort(int[] A, int exp) {

    int[] tempArray = new int[10];
    for (int value : A) {
      // important to note here min = 0, so (value/exp%10) - 0 = value/exp%10
      tempArray[value / exp % 10]++;
    }
    int sum = -1;
    for (int i = 0; i < tempArray.length; i++) {
      sum = sum + tempArray[i];
      tempArray[i] = sum;
    }
    int[] finalArray = new int[A.length];
    for (int i = A.length - 1; i >= 0; i--) {
      finalArray[tempArray[A[i] / exp % 10]] = A[i];
      tempArray[A[i] / exp % 10]--;
    }
    System.arraycopy(finalArray, 0, A, 0, finalArray.length);
  }

  public static void sort(String[] A, int div, int mod, int range) {

    int[] tempArray = new int[range];
    for (int i = 0; i < A.length; i++) {
      tempArray[
          Integer.parseInt(A[i], 10)
              / div
              % mod]++; // starts with 0 so can be assumed octal so give base 10
    }

    for (int i = 1; i < tempArray.length; i++) {
      tempArray[i] += tempArray[i - 1];
    }
    String[] finalArray = new String[A.length];
    for (int i = A.length - 1; i >= 0; i--) {
      int pos = tempArray[(Integer.parseInt(A[i], 10) / div % mod)] - 1;
      finalArray[pos] = A[i];
      tempArray[Integer.parseInt(A[i], 10) / div % mod]--;
    }
    System.arraycopy(finalArray, 0, A, 0, finalArray.length);
  }
}
