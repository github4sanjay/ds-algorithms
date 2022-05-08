package com.github4sanjay.dsalgo.hashmap.substrings;

import java.util.HashMap;

/**
 * Given a string, print the longest substring without repeating characters. For example, the
 * longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with
 * length 6. For “BBBB” the longest substring is “B”, with length 1. The desired time complexity is
 * O(n) where n is the length of the string. Prerequisite: Length of longest substring without
 * repeating characters Examples:
 *
 * <p>Input : GEEKSFORGEEKS Output : EKSFORG
 *
 * <p>Input : ABDEFGABEF Output : BDEFGA
 */
public class LongestWithoutRepeatingChars {

  public static void main(String[] args) {
    System.out.println(find("GEEKSFORGEEKS"));
    System.out.println(find("ABDEFGABEF"));
    System.out.println(find("aabcbcdbca"));
    System.out.println(find("BBBB"));
  }

  public static String find(String str) {
    var map = new HashMap<Character, Integer>(); // character and its last index
    int i = 0;
    int j = 0;
    String finalString = "";
    while (i < str.length()) {
      var currentChar = str.charAt(i);
      if (!map.containsKey(currentChar)) {
        var newString = str.substring(j, i + 1);
        if (newString.length() >= finalString.length()) {
          finalString = newString;
        }
        map.put(currentChar, i);
      } else {
        while (str.charAt(j) != currentChar) {
          map.remove(str.charAt(j));
          j++;
        }
        map.put(currentChar, i);
        j++;
      }
      i++;
    }
    return finalString;
  }
}
