package com.github4sanjay.dsalgo.hashmap.substrings;

import java.util.HashSet;

/**
 * Given a string, find the smallest window length with all distinct characters of the given string.
 * For eg. str = “aabcbcdbca”, then the result would be 4 as of the smallest window will be “dbca” .
 *
 * <p>Examples:
 *
 * <p>Input: aabcbcdbca Output: dbca Explanation: Possible substrings= {aabcbcd, abcbcd, bcdbca,
 * dbca....} Of the set of possible substrings 'dbca' is the shortest substring having all the
 * distinct characters of given string.
 *
 * <p>Input: aaab Output: ab Explanation: Possible substrings={aaab, aab, ab} Of the set of possible
 * substrings 'ab' is the shortest substring having all the distinct characters of given string.
 */
public class SmallestHasAllUniqueCharsOfItself {

  public static void main(String[] args) {
    System.out.println(find("aabcbcdbca"));
  }

  public static String find(String str) {
    var pattern = new StringBuilder();
    var set = new HashSet<Character>();
    for (char ch : str.toCharArray()) {
      if (set.contains(ch)) {
        continue;
      }
      set.add(ch);
      pattern.append(ch);
    }
    return MinimumWindowSubstring.find(str, pattern.toString());
  }
}
