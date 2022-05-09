package com.github4sanjay.dsalgo.hashmap;

import com.github4sanjay.dsalgo.hashmap.structure.HashMap;

/**
 * 1. You are given an array(arr) of integers and a number K. 2. You have to find if the given array
 * can be divided into pairs such that the sum of every pair is divisible by k.
 *
 * <p>Sample Input 4 9 7 5 3 6
 *
 * <p>Sample Output true
 */
public class CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {
  public static void main(String[] args) {
    System.out.println(
        CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK.check(new int[] {9, 7, 5, 3}, 6));
    System.out.println(
        CheckIfAnArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK.check(
            new int[] {9, 7, 5, 3, 7}, 6));
  }

  private static boolean check(int[] array, int k) {
    var map = new HashMap<Integer, Integer>();
    for (int element : array) {
      int remainder = element % k;
      Integer frequency = map.get(remainder);
      if (frequency == null) {
        map.put(remainder, 1);
      } else {
        map.put(remainder, frequency + 1);
      }
    }
    for (var key : map.keySet()) {
      int frequency = map.get(key);
      if (key == 0 && frequency % 2 != 0) {
        return false;
      }
      if (frequency != map.get(k - key)) {
        return false;
      }
    }
    return true;
  }
}
