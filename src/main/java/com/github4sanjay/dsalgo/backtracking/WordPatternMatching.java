package com.github4sanjay.dsalgo.backtracking;

import java.util.HashMap;
import java.util.HashSet;

public class WordPatternMatching {

  public static void main(String[] args) {
    String pattern = "abcb";
    String str = "mzaddytzaddy";

    /**
     * Pattern is : a --> m b --> zaddy c --> t
     *
     * <p>Pattern is : a --> mz b --> addy c --> tz
     *
     * <p>Pattern is : a --> mza b --> ddy c --> tza
     *
     * <p>Pattern is : a --> mzad b --> dy c --> tzad
     *
     * <p>Pattern is : a --> mzadd b --> y c --> tzadd
     */
    WordPatternMatching.match(pattern, str);
  }

  private static void match(String pattern, String str) {
    match(pattern, str, new HashMap<>(), pattern);
  }

  private static void match(
      String currentPattern,
      String str,
      HashMap<Character, String> characterStringMap,
      String actualPattern) {

    if (currentPattern.length() == 0) {
      if (str.length() == 0) {
        System.out.println("Pattern is :");
        var alreadyAdded = new HashSet<>();
        for (char ch : actualPattern.toCharArray()) {
          if (!alreadyAdded.contains(ch)) {
            alreadyAdded.add(ch);
            System.out.println(ch + " --> " + characterStringMap.get(ch));
          }
        }
        System.out.println("");
      }
      return;
    }
    char patternFirstChar = currentPattern.charAt(0);
    String newPattern = currentPattern.substring(1);
    String previousMapping = characterStringMap.get(patternFirstChar);
    if (previousMapping == null) { // if character not already mapped then all are possible
      for (int i = 0; i < str.length(); i++) {
        String stringChosen = str.substring(0, i + 1);
        String newStr = str.substring(i + 1);
        characterStringMap.put(patternFirstChar, stringChosen);
        match(newPattern, newStr, characterStringMap, actualPattern);
        characterStringMap.remove(patternFirstChar);
      }
    } else { // if character already mapped only starting characters should be same as previous
      // mapping
      if (str.length() >= previousMapping.length()) {
        String left = str.substring(0, previousMapping.length());
        if (previousMapping.equals(left)) {
          String right = str.substring(previousMapping.length());
          match(newPattern, right, characterStringMap, actualPattern);
        }
      }
    }
  }
}
