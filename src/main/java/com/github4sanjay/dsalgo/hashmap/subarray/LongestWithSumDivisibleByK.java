package com.github4sanjay.dsalgo.hashmap.subarray;

import java.util.HashMap;

/**
 * Longest Subarray With Sum Divisible By K Easy
 *
 * <p>1. You are given an array of integers(arr) and a number K. 2. You have to find length of the
 * longest subarray whose sum is divisible by K.
 *
 * <p>Constraints 1 <= N,K <= 10^5 -1000 <= arr[i] <= 1000
 *
 * <p>Format Input A number N arr1 arr2.. N numbers A number K
 *
 * <p>Output A number representing length of the longest subarray whose sum is divisible by K.
 *
 * <p>Example Sample Input
 *
 * <p>6 2 7 6 1 4 5 3
 *
 * <p>Sample Output 4
 */
public class LongestWithSumDivisibleByK {

  public static int find(int[] array, int divisor) {
    int length = 0;
    var map = new HashMap<Integer, Integer>(); // remainder and index
    int currentSum = 0;
    map.put(0, -1);
    for (int i = 0; i < array.length; i++) {
      currentSum = currentSum + array[i];
      if (map.containsKey(currentSum % divisor)) {
        var lastIndex = map.get(currentSum % divisor);
        length = Math.max(length, i - lastIndex);
      } else {
        map.put(currentSum % divisor, i);
      }
    }
    return length;
  }
}
