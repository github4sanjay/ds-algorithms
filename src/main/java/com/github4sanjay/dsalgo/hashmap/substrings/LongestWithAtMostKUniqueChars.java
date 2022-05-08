package com.github4sanjay.dsalgo.hashmap.substrings;

import java.util.HashMap;

/**
 * 1. You are given a string(str) and a number K. 2. You have to find the length of longest
 * substring of the given string that contains at most K unique characters.
 *
 * <p>Sample Input aabcbcdbca 2
 *
 * <p>Sample Output 4
 */
public class LongestWithAtMostKUniqueChars {

  public static void main(String[] args) {
    System.out.println(LongestWithAtMostKUniqueChars.find("aabcbcdbca", 2));
    System.out.println(LongestWithAtMostKUniqueChars.find("aabcbcdbcaaaaaabbbbb", 2)); // 11
    System.out.println(LongestWithAtMostKUniqueChars.find("aabcbcdbcaaaaaabbbbb", 4)); // 20
  }

  private static int find(String str, int k) {
    var hasMap = new HashMap<Character, Integer>();
    int maxLength = Integer.MIN_VALUE;
    int i = 0, j = -1;
    while (i < str.length()) {
      hasMap.put(str.charAt(i), hasMap.getOrDefault(str.charAt(i), 0) + 1);
      while (hasMap.size() > k) {
        j++;
        var charAtJ = str.charAt(j);
        var frequency = hasMap.getOrDefault(charAtJ, 0);
        if (frequency == 1) {
          hasMap.remove(charAtJ);
        } else {
          hasMap.put(charAtJ, frequency - 1);
        }
      }
      maxLength = Math.max(maxLength, i - j);
      i++;
    }
    return maxLength;
  }
}
