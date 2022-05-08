package com.github4sanjay.dsalgo.search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a program that, given an array A[] of n numbers and another number x, determines whether or
 * not there exist two elements in S whose sum is exactly x. Examples:
 *
 * <p>Input: arr[] = {0, -1, 2, -3, 1} sum = -2 Output: -3, 1 If we calculate the sum of the output,
 * 1 + (-3) = -2
 *
 * <p>Input: arr[] = {1, -2, 1, 0, 5} sum = 0 Output: -1 No valid pair exists.
 */
public class PairSumInArray {

  public static void main(String[] args) {
    System.out.println(PairSumInArray.bruteForce(new int[] {0, -1, 2, -3, 1}, -2));
    System.out.println(PairSumInArray.withSorting(new int[] {0, -1, 2, -3, 1}, -2));
    System.out.println(PairSumInArray.withHashing(new int[] {0, -1, 2, -3, 1}, -2));
  }

  private static Pair withHashing(int[] array, int sum) {
    var table = new HashSet<Integer>();
    var pair = new Pair();
    for (int j : array) {
      if (table.contains(sum - j)) {
        pair.data1 = j;
        pair.data2 = sum - j;
        return pair;
      } else {
        table.add(j);
      }
    }
    return pair;
  }

  private static Pair withSorting(int[] array, int sum) {
    Arrays.sort(array);
    var pair = new Pair();
    int i = 0;
    int j = array.length - 1;
    while (i < j) {
      if (array[i] + array[j] < sum) {
        i++;
      } else if (array[i] + array[j] > sum) {
        j--;
      } else {
        pair.data1 = array[i];
        pair.data2 = array[j];
        return pair;
      }
    }
    return pair;
  }

  private static Pair bruteForce(int[] array, int sum) {
    var pair = new Pair();
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] + array[i] == sum) {
          pair.data1 = array[i];
          pair.data2 = array[j];
          return pair;
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
