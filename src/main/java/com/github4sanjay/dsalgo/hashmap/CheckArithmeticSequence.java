package com.github4sanjay.dsalgo.hashmap;

import java.util.HashSet;

/**
 * A sequence of numbers is called an arithmetic progression if the difference between any two
 * consecutive elements is the same.
 *
 * <p>Given an array of numbers arr, return true if the array can be rearranged to form an
 * arithmetic progression. Otherwise, return false.
 *
 * <p>Example 1:
 *
 * <p>Input: arr = [3,5,1] Output: true Explanation: We can reorder the elements as [1,3,5] or
 * [5,3,1] with differences 2 and -2 respectively, between each consecutive elements. Example 2:
 *
 * <p>Input: arr = [1,2,4] Output: false Explanation: There is no way to reorder the elements to
 * obtain an arithmetic progression.
 *
 * <p>Constraints:
 *
 * <p>2 <= arr.length <= 1000 -106 <= arr[i] <= 106
 */
public class CheckArithmeticSequence {

  public static boolean check(int[] input) {
    var set = new HashSet<Integer>();
    var smallest = Integer.MAX_VALUE;
    var secondSmallest = Integer.MAX_VALUE;
    var largest = Integer.MIN_VALUE;
    for (var element : input) {
      if (smallest > element) {
        secondSmallest = smallest;
        smallest = element;
      } else if (secondSmallest > element) {
        secondSmallest = element;
      }
      if (largest < element) {
        largest = element;
      }
      set.add(element);
    }

    var diff = secondSmallest - smallest;
    for (int current : input) {
      if (current == largest) continue;
      if (!set.contains(current + diff)) {
        return false;
      }
    }
    return true;
  }
}
