package com.github4sanjay.dsalgo.hashmap.subarray;

import com.github4sanjay.dsalgo.hashmap.structure.HashMap;

/**
 * Longest Subarray With Equal Number Of 0s 1s And 2s Easy
 *
 * <p>1. You are given an array that contains only 0s, 1s, and 2s. 2. You have to find length of the
 * longest subarray with equal number of 0s, 1s, and 2s.
 *
 * <p>Constraints 1 <= N <= 10^5 0 <= arr[i] <= 2
 *
 * <p>Format Input A number N arr1 arr2.. N numbers
 *
 * <p>Output A number representing length of the longest subarray with equal number of 0s, 1s, and
 * 2s.
 *
 * <p>Example Sample Input
 *
 * <p>7 0 1 0 2 0 1 0
 *
 * <p>Sample Output 3
 */
public class LongestSubArrayWithEqualNumberOf0s1sAnd2s {

  public static int find(int[] array) {
    var count0 = 0;
    var count1 = 0;
    var count2 = 0;
    var length = 0;
    var sumMap = new HashMap<String, Integer>(); // c1-c0#c2-c1, index
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        count0++;
      } else if (array[i] == 1) {
        count1++;
      } else {
        count2++;
      }
      var key = (count1 - count0) + "#" + (count2 - count1);
      if (sumMap.containsKey(key)) {
        var lastIndex = sumMap.get(key);
        length = Math.max(length, i - lastIndex);
      } else {
        sumMap.put(key, i);
      }
    }
    return length;
  }
}
