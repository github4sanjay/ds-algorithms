package com.github4sanjay.dsalgo.string.matching;

import java.util.HashMap;
import java.util.Map;

/**
 * Boyer Moore algorithm also preprocesses the pattern. Boyer Moore is a combination of following
 * two approaches. 1) Bad Character Heuristic 2) Good Suffix Heuristic
 *
 * <p>Both of the above heuristics can also be used independently to search a pattern in a text. Let
 * us first understand how two independent approaches work together in the Boyer Moore algorithm. If
 * we take a look at the Naive algorithm, it slides the pattern over the text one by one. KMP
 * algorithm does preprocessing over the pattern so that the pattern can be shifted by more than
 * one.
 *
 * <p>The Boyer Moore algorithm does preprocessing for the same reason. It processes the pattern and
 * creates different arrays for both heuristics. At every step, it slides the pattern by the max of
 * the slides suggested by the two heuristics. So it uses best of the two heuristics at every step.
 * Unlike the previous pattern searching algorithms, Boyer Moore algorithm starts matching from the
 * last character of the pattern.
 */
public class BoyerMoore {

  public static void main(String[] args) {
    System.out.println(check("THIS IS A TEST", "TEST"));
    System.out.println(check("THIS IS A TEST", "TESTS"));
    System.out.println(
        check("The Boyer Moore algorithm does preprocessing for the same reason", "preprocessing"));
    System.out.println(
        check("The Boyer Moore algorithm does preprocessing for the same reason", "Boyer"));
  }

  // This solution is with bad character heuristic.
  public static boolean check(String word, String pattern) {
    var table = badMatchTable(pattern);
    var window = pattern.length() - 1;
    int i = window;
    while (i < word.length()) { // starts comparing from end
      if (word.charAt(i) == pattern.charAt(window)) {
        var j = window;
        var found = true;
        while (j >= 0) {
          if (word.charAt(i - (window - j)) != pattern.charAt(j)) {
            found = false;
            break;
          }
          j--;
        }
        if (found) return true;
      } else {
        var position =
            table.getOrDefault(
                word.charAt(i), pattern.length()); // if not found take default as pattern length
        i = i + position;
      }
    }
    return false;
  }

  /**
   * table[i] = pattern.length() - i - 1 for all character except last character table[i] =
   * pattern.length()
   */
  private static Map<Character, Integer> badMatchTable(String pattern) {
    var table = new HashMap<Character, Integer>();
    for (int i = 0; i < pattern.length(); i++) {
      table.put(pattern.charAt(i), pattern.length() - i - 1);
    }
    table.put(pattern.charAt(pattern.length() - 1), pattern.length());
    return table;
  }
}
