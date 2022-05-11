package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * <p>Here follow means a full match, such that there is a bijection between a letter in pattern and
 * a non-empty word in s.
 *
 * <p>Example 1:
 *
 * <p>Input: pattern = "abba", s = "dog cat cat dog" Output: true Example 2:
 *
 * <p>Input: pattern = "abba", s = "dog cat cat fish" Output: false Example 3:
 *
 * <p>Input: pattern = "aaaa", s = "dog cat cat dog" Output: false
 *
 * <p>Constraints:
 *
 * <p>1 <= pattern.length <= 300 pattern contains only lower-case English letters. 1 <= s.length <=
 * 3000 s contains only lowercase English letters and spaces ' '. s does not contain any leading or
 * trailing spaces. All the words in s are separated by a single space.
 */
public class WordPattern {

  public static boolean check(String pattern, String word) {
    var map1 = new HashMap<Character, String>();
    var map2 = new HashMap<String, Boolean>();

    String[] words = word.split(" ");
    for (int i = 0; i < pattern.length(); i++) {
      var character = pattern.charAt(i);
      var wordAtI = words[i];
      if (map1.containsKey(character)) {
        if (!map1.get(character).equals(wordAtI)) {
          return false;
        }
      } else {
        if (map2.containsKey(wordAtI)) {
          return false;
        } else {
          map1.put(character, wordAtI);
          map2.put(wordAtI, true);
        }
      }
    }
    return true;
  }
}
