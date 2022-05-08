package com.github4sanjay.dsalgo.hashmap.substrings;

import com.github4sanjay.dsalgo.util.MapUtil;
import java.util.HashMap;

/**
 * Find the smallest window in a string containing all characters of another string Given two
 * strings string1 and string2, the task is to find the smallest substring in string1 containing all
 * characters of string2 efficiently.
 *
 * <p>Examples:
 *
 * <p>Input: string = “this is a test string”, pattern = “tist” Output: Minimum window is “t stri”
 * Explanation: “t stri” contains all the characters of pattern.
 *
 * <p>Input: string = “geeksforgeeks”, pattern = “ork” Output: Minimum window is “ksfor”
 */
public class MinimumWindowSubstring {

  public static void main(String[] args) {
    System.out.println(find("geeksforgeeks", "ork"));
    System.out.println(find("this is a test string", "tist"));
  }

  public static String find(String str, String pattern) {
    var frequencyMapPattern = MapUtil.stringToFrequencyMap(pattern);
    var frequencyMapString = new HashMap<Character, Integer>();
    int count = 0;
    int i = 0;
    int j = 0;
    String finalSubString = null;
    var acquired = true;
    var released = true;
    while (acquired || released) {
      acquired = false;
      released = false;
      if (count < pattern.length() && i < str.length()) { // acquire
        char currentChar = str.charAt(i);
        var requiredFreq = frequencyMapPattern.getOrDefault(currentChar, 0);
        var currentFreq = frequencyMapString.getOrDefault(currentChar, 0);
        if (requiredFreq > currentFreq) {
          count++;
        }
        frequencyMapString.put(currentChar, currentFreq + 1);
        i++;
        acquired = true;
      }
      if (count >= pattern.length() && j < str.length()) { // collect substring and release
        var newString = str.substring(j, i);
        if (finalSubString == null || newString.length() < finalSubString.length()) {
          finalSubString = str.substring(j, i);
        }
        char currentChar = str.charAt(j);

        var requiredFreq = frequencyMapPattern.getOrDefault(currentChar, 0);
        var currentFreq = frequencyMapString.getOrDefault(currentChar, 0);

        if (requiredFreq >= currentFreq) {
          count--;
        }
        frequencyMapString.put(currentChar, currentFreq - 1);
        j++;
        released = true;
      }
    }
    return finalSubString;
  }
}
