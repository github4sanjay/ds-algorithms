package com.github4sanjay.dsalgo.search;

import java.util.Arrays;

/**
 * An Array of integers is given, both +ve and -ve. You need to find the two elements such that
 * their sum is closest to zero. For the below array, program should print -80 and 85.
 *
 * <p>int arr[] = {1, 60, -10, 70, -80, 85};
 */
public class TwoElementSumClosestTo0 {

  public static void main(String[] args) {
    System.out.println(withSorting(new int[] {1, 60, -10, 70, -80, 85}));
    System.out.println(withSorting(new int[] {-21, -67, -37, -18, 4, -65}));

    System.out.println(bruteForce(new int[] {1, 60, -10, 70, -80, 85}));
    System.out.println(bruteForce(new int[] {-21, -67, -37, -18, 4, -65}));
  }

  private static Pair withSorting(int[] array) {
    Arrays.sort(array);
    var pair = new Pair();
    int minSum = Integer.MAX_VALUE;
    int i = 0, j = array.length - 1;
    while (i < j) {
      int sum = array[j] + array[i];
      if (Math.abs(sum) < Math.abs(minSum)) {
        minSum = sum;
        pair.data1 = array[i];
        pair.data2 = array[j];
      }
      if (sum > 0) {
        j--;
      } else if (sum < 0) {
        i++;
      }
    }
    return pair;
  }

  private static Pair bruteForce(int[] array) {
    var pair = new Pair();
    int minSum = Integer.MAX_VALUE;
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int sum = Math.abs(array[j] + array[i]);
        if (sum < minSum) {
          minSum = sum;
          pair.data1 = array[i];
          pair.data2 = array[j];
        }
      }
    }
    return pair;
  }

  private static class Pair {
    Integer data1;
    Integer data2;

    @Override
    public String toString() {
      return "Pair{" + "data1=" + data1 + ", data2=" + data2 + '}';
    }
  }
}
