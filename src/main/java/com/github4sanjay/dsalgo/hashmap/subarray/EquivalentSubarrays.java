package com.github4sanjay.dsalgo.hashmap.subarray;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given an array of n integers. Count total number of sub-array having total distinct elements same
 * as that of total distinct elements of original array.
 *
 * <p>Examples:
 *
 * <p>Input : arr[] = {2, 1, 3, 2, 3} Output : 5 Total distinct elements in array is 3 Total
 * sub-arrays that satisfy the condition are: Subarray from index 0 to 2 Subarray from index 0 to 3
 * Subarray from index 0 to 4 Subarray from index 1 to 3 Subarray from index 1 to 4
 *
 * <p>Input : arr[] = {2, 4, 5, 2, 1} Output : 2
 *
 * <p>Input : arr[] = {2, 4, 4, 2, 4} Output : 9
 */
public class EquivalentSubarrays {

  public static void main(String[] args) {
    System.out.println(EquivalentSubarrays.find(new int[] {2, 1, 3, 2, 3})); // 5
    System.out.println(EquivalentSubarrays.find(new int[] {2, 4, 5, 2, 1})); // 2
    System.out.println(EquivalentSubarrays.find(new int[] {2, 4, 4, 2, 4})); // 9
  }

  private static int find(int[] array) {
    var set = new HashSet<Integer>();
    for (var element : array) {
      set.add(element);
    }
    int totalUniqueElements = set.size();

    var map = new HashMap<Integer, Integer>(); // frequency map
    int i = 0, j = 0, count = 0;
    var acquired = true;
    var released = true;
    while (acquired || released) {
      acquired = false;
      released = false;
      if (i < array.length && map.size() < totalUniqueElements) {
        map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        i++;
        acquired = true;
      }
      if (map.size() >= totalUniqueElements && j < array.length) {
        count = count + (array.length - i + 1);
        int elementAtJ = array[j];
        var frequency = map.get(elementAtJ);
        if (frequency == 1) {
          map.remove(elementAtJ);
        } else {
          map.put(elementAtJ, frequency - 1);
        }
        j++;
        released = true;
      }
    }
    return count;
  }
}
