package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

/**
 * Given an array of integers, find the length of the longest sub-sequence such that elements in the
 * subsequence are consecutive integers, the consecutive numbers can be in any order.
 *
 * <p>Examples:
 *
 * <p>Input: arr[] = {1, 9, 3, 10, 4, 20, 2} Output: 4 Explanation: The subsequence 1, 3, 4, 2 is
 * the longest subsequence of consecutive elements
 *
 * <p>Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42} Output: 5 Explanation: The
 * subsequence 36, 35, 33, 34, 32 is the longest subsequence of consecutive elements.
 */
public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    System.out.println(LongestConsecutiveSequence.find(new int[] {1, 9, 3, 10, 4, 20, 2}));
    System.out.println(
        LongestConsecutiveSequence.find(new int[] {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
  }

  private static int find(int[] array) {
    var map = new HashMap<Integer, Boolean>();
    int maxSize = Integer.MIN_VALUE;
    for (int i : array) {
      map.put(i, true);
    }

    for (int i : array) {
      if (map.containsKey(i - 1)) {
        map.put(i, false);
      }
    }

    for (int i : map.keySet()) {
      if (map.get(i)) {
        int size = 1;
        while (true) {
          if (map.containsKey(i + size)) {
            size++;
          } else {
            break;
          }
        }
        maxSize = Math.max(maxSize, size);
      }
    }
    return maxSize;
  }
}
