package com.github4sanjay.dsalgo.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

  public static Map<Character, Integer> stringToFrequencyMap(String pattern) {
    var patternFreqMap = new HashMap<Character, Integer>();

    for (char ch : pattern.toCharArray()) {
      patternFreqMap.put(ch, patternFreqMap.getOrDefault(ch, 0) + 1);
    }
    return patternFreqMap;
  }

  public static boolean isSame(
      Map<Character, Integer> currentFreqMap, Map<Character, Integer> patternFreqMap) {
    for (var entry : patternFreqMap.entrySet()) {
      if (!entry.getValue().equals(currentFreqMap.getOrDefault(entry.getKey(), 0))) {
        return false;
      }
    }
    return true;
  }
}
