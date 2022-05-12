package com.github4sanjay.dsalgo.hashmap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given an integer array of even length arr, return true if it is possible to reorder arr such that
 * arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.
 *
 * <p>Example 1:
 *
 * <p>Input: arr = [3,1,3,6] Output: false Example 2:
 *
 * <p>Input: arr = [2,1,2,6] Output: false Example 3:
 *
 * <p>Input: arr = [4,-2,2,-4] Output: true Explanation: We can take two groups, [-2,-4] and [2,4]
 * to form [-2,-4,2,4] or [2,4,-2,-4].
 *
 * <p>Constraints:
 *
 * <p>2 <= arr.length <= 3 * 104 arr.length is even. -105 <= arr[i] <= 105
 */
public class DoublePairArray {

  public static boolean check(int[] arr) {
    Integer[] input = new Integer[arr.length];
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      input[i] = arr[i];
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    Arrays.sort(input, Comparator.comparingInt(Math::abs));
    for (var element : input) {
      if (map.containsKey(element)) {
        var oldFrequency = map.get(element);
        if (oldFrequency != 0) {
          map.put(element, oldFrequency - 1);
        } else {
          continue;
        }
      } else {
        return false;
      }
      var pair = element * 2;
      if (map.containsKey(pair)) {
        var oldFrequency = map.get(pair);
        if (oldFrequency != 0) {
          map.put(pair, oldFrequency - 1);
        }
      } else {
        return false;
      }
    }
    return true;
  }
}
