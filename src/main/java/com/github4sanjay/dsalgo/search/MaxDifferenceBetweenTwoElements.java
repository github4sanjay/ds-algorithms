package com.github4sanjay.dsalgo.search;

/**
 * Maximum difference between two elements such that larger element appears after the smaller number
 *
 * <p>Given an array arr[] of integers, find out the maximum difference between any two elements
 * such that larger element appears after the smaller number. Examples :
 *
 * <p>Input : arr = {2, 3, 10, 6, 4, 8, 1} Output : 8 Explanation : The maximum difference is
 * between 10 and 2.
 *
 * <p>Input : arr = {7, 9, 5, 6, 3, 2} Output : 2 Explanation : The maximum difference is between 9
 * and 7.
 */
public class MaxDifferenceBetweenTwoElements {

  public static void main(String[] args) {
    System.out.println(find(new int[] {2, 3, 10, 6, 4, 8, 1}));
    System.out.println(find(new int[] {7, 9, 5, 6, 3, 2}));
  }

  private static int find(int[] array) {
    var leftMinima = findLeftMinima(array);
    var rightMaxima = findRightMaxima(array);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < array.length; i++) {
      if (rightMaxima[i] > leftMinima[i]) {
        max = Math.max(max, rightMaxima[i] - leftMinima[i]);
      }
    }
    return max;
  }

  public static int[] findLeftMinima(int[] array) {
    int min = Integer.MAX_VALUE;
    int i = 0;
    var leftMinima = new int[array.length];
    for (int element : array) {
      min = Math.min(min, element);
      leftMinima[i] = min;
      i++;
    }
    return leftMinima;
  }

  public static int[] findRightMaxima(int[] array) {
    int max = Integer.MIN_VALUE;
    var rightMaxima = new int[array.length];
    for (int i = array.length - 1; i >= 0; i--) {
      max = Math.max(max, array[i]);
      rightMaxima[i] = max;
    }
    return rightMaxima;
  }
}
