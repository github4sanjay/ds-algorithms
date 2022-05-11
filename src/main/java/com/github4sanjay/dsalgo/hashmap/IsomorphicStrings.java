package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

/**
 * 1. You are given two strings s1 and s2. 2. You have to determine if they are isomorphic or not.
 * 3. Two strings are called isomorphic if - -> Every character of s1 can be mapped with characters
 * of s2. -> A character of s1 can be mapped to only one character. -> All occurrences of a
 * character must be replaced with another character while preserving the order of characters.
 *
 * <p>Note -> Length of s1 is equal to the length of s2.
 *
 * <p>Constraints 1 <= length of strings <= 1000
 *
 * <p>Format Input Two strings s1 and s2
 *
 * <p>Output true/false
 *
 * <p>Example Sample Input
 *
 * <p>pepcoding sosherlok
 *
 * <p>Sample Output false
 */
public class IsomorphicStrings {

  public static boolean check(String str1, String str2) {
    var map1 = new HashMap<Character, Character>();
    var map2 = new HashMap<Character, Boolean>();
    for (int i = 0; i < str1.length(); i++) {
      var char1 = str1.charAt(i);
      var char2 = str2.charAt(i);
      if (map2.getOrDefault(char1, false)) {
        if (map1.get(char1) != char2) {
          return false;
        }
      } else {
        if (map2.getOrDefault(char2, false)) {
          return false;
        } else {
          map1.put(char1, char2);
          map2.put(char2, true);
        }
      }
    }
    return true;
  }
}
