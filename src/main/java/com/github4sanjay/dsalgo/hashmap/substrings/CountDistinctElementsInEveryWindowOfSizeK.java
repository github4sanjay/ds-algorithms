package com.github4sanjay.dsalgo.hashmap.substrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1. You are given an array(arr) of integers and a number K. 2. You have to find the count of
 * distinct numbers in all windows of size k.
 *
 * <p>Sample Input
 *
 * <p>7 1 2 1 3 4 2 3 4
 *
 * <p>Sample Output 3 4 4 3
 */
public class CountDistinctElementsInEveryWindowOfSizeK {
  public static void main(String[] args) {
    System.out.println(
        CountDistinctElementsInEveryWindowOfSizeK.find(new int[] {1, 2, 1, 3, 4, 2, 3}, 4));
  }

  private static List<Integer> find(int[] array, int k) {
    var list = new ArrayList<Integer>();
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < array.length; i++) {
      var frequency = map.getOrDefault(array[i], 0);
      map.put(array[i], frequency + 1);

      if (i >= k - 1) {
        list.add(map.size());
        var outOfWindowElement = array[i - k + 1];
        var frequencyOfOutOfWindowElement = map.get(outOfWindowElement);
        if (frequencyOfOutOfWindowElement == 1) {
          map.remove(outOfWindowElement);
        } else {
          map.put(array[i - k + 1], frequencyOfOutOfWindowElement - 1);
        }
      }
    }

    return list;
  }
}
