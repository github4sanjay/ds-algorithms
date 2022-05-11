package com.github4sanjay.dsalgo.hashmap.subarray;

import java.util.HashSet;

/**
 * Pairs With Equal Sum Easy
 *
 * <p>1. You are given an array(arr) of distinct integers. 2. You have to find if there are two
 * pairs(A, B) and (C, D) present in the given array which satisfies the condition A+B = C+D.
 *
 * <p>Constraints 1 <= N <= 10^3 -10^9 <= arr[i] <= 10^9
 *
 * <p>Format Input A number N arr1 arr2.. N numbers
 *
 * <p>Output true/false
 *
 * <p>Example Sample Input
 *
 * <p>8 1 2 998 72 87576 21 45 -1
 *
 * <p>Sample Output false
 */
public class PairsWithEqualSum {

  public static boolean find(int[] array) {
    var set = new HashSet<Integer>(); // pair sum
    // check all the pair
    for (int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        int sum = array[i] + array[j];
        if (set.contains(sum)) {
          return true;
        } else {
          set.add(sum);
        }
      }
    }
    return false;
  }
}
