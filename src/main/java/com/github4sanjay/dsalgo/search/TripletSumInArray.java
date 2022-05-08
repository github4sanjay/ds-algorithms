package com.github4sanjay.dsalgo.search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array and a value, find if there is a triplet in array whose sum is equal to the given
 * value. If there is such a triplet present in array, then print the triplet and return true. Else
 * return false. Example:
 *
 * <p>Input: array = {12, 3, 4, 1, 6, 9}, sum = 24; Output: 12, 3, 9 Explanation: There is a triplet
 * (12, 3 and 9) present in the array whose sum is 24.
 *
 * <p>Input: array = {1, 2, 3, 4, 5}, sum = 9 Output: 5, 3, 1 Explanation: There is a triplet (5, 3
 * and 1) present in the array whose sum is 9.
 */
public class TripletSumInArray {

  public static void main(String[] args) {
    System.out.println(TripletSumInArray.bruteForce(new int[] {1, 4, 45, 6, 10, 8}, 22));
    System.out.println(TripletSumInArray.withSorting(new int[] {1, 4, 45, 6, 10, 8}, 22));
    System.out.println(TripletSumInArray.withHashing(new int[] {1, 4, 45, 6, 10, 8}, 22));
  }

  // fix first element with outer loop and then use two pointer technique
  private static Pair withHashing(int[] array, int sum) {
    var table = new HashSet<Integer>();
    var pair = new Pair();
    for (int i = 0; i < array.length; i++) {
      int currentSum = sum - array[i];
      for (int j = i + 1; j < array.length; j++) {
        if (table.contains(currentSum - array[j])) {
          pair.data1 = array[i];
          pair.data2 = array[j];
          pair.data3 = currentSum - array[j];
          return pair;
        } else {
          table.add(array[j]);
        }
      }
    }

    return pair;
  }

  // fix first element and then use two pointer technique
  private static Pair withSorting(int[] array, int sum) {
    Arrays.sort(array);
    var pair = new Pair();
    for (int k = 0; k < array.length; k++) {
      int i = k + 1;
      int j = array.length - 1;
      while (i < j) {
        if (array[k] + array[i] + array[j] < sum) {
          i++;
        } else if (array[k] + array[i] + array[j] > sum) {
          j--;
        } else {
          pair.data1 = array[k];
          pair.data2 = array[i];
          pair.data3 = array[j];
          return pair;
        }
      }
    }
    return pair;
  }

  private static Pair bruteForce(int[] array, int sum) {
    var pair = new Pair();
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        for (int k = j + 1; k < array.length; k++) {
          if (array[j] + array[i] + array[k] == sum) {
            pair.data1 = array[i];
            pair.data2 = array[j];
            pair.data3 = array[k];
            return pair;
          }
        }
      }
    }
    return pair;
  }

  private static class Pair {
    Integer data1;
    Integer data2;
    Integer data3;

    @Override
    public String toString() {
      return "Pair{" + "data1=" + data1 + ", data2=" + data2 + ", data3=" + data3 + '}';
    }
  }
}
