package com.github4sanjay.dsalgo.hashmap.subarray;

import com.github4sanjay.dsalgo.hashmap.structure.HashMap;

/**
 * Longest Subarray With Equal Number Of Zeroes And Ones Easy
 *
 * <p>1. You are given an array that contains only 0s and 1s. 2. You have to find length of the
 * longest subarray with equal number of 0s and 1s.
 *
 * <p>Constraints 1 <= N <= 10^5 0 <= arr[i] <= 1
 *
 * <p>Format Input A number N arr1 arr2.. N numbers
 *
 * <p>Output A number representing length of the longest subarray with equal number of 0s and 1s.
 *
 * <p>Example Sample Input
 *
 * <p>6 0 1 1 0 1 1
 *
 * <p>Sample Output 4
 */
public class LongestSubArrayWithEqualNumberOf0sAnd1s {

  public static int find(int[] array) {
    var sum = 0;
    var length = 0;
    var sumMap = new HashMap<Integer, Integer>(); // sum and index
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        sum = sum - 1;
      } else {
        sum = sum + 1;
      }
      if (sumMap.containsKey(sum)) {
        length = Math.max(length, i - sumMap.get(sum));
      } else {
        sumMap.put(sum, i);
      }
    }
    return length;
  }
}
