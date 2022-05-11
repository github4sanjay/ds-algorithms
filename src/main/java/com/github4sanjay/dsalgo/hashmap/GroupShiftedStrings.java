package com.github4sanjay.dsalgo.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1. You are given an array of strings. 2. You have to group the given strings in such a way that
 * all strings in a group are shifted versions of each other. 3. Two strings s1 and s2 are shifted
 * if - -> Length of both the strings is the same. -> The difference between ASCII values of every
 * character of s1 and s2 is constant.
 *
 * <p>Note -> Every string consists of lower-case English letters only.
 *
 * <p>Constraints 1 <= N <= 10^4 1 <= length of a string <= 100
 *
 * <p>Format Input A number N str1 str2.. N space-separated strings
 *
 * <p>Output Every line of output contains space-separated strings which represents a group of
 * shifted strings.
 *
 * <p>Example Sample Input
 *
 * <p>9 acd dfg wyz yab mop bdfh a x moqs
 *
 * <p>Sample Output acd dfg mop wyz yab a x bdfh moqs
 */
public class GroupShiftedStrings {

  /*
     we can solve it easily by calculating difference of the index of characters in string and use it as a key of the map
     for example acd -----> 2#1
                 dfg -----> 2#1
                 wyz -----> 2#1
                 bdfh ----> 3#2#1
                 mpqs ----> 3#2#1
  */
  public static List<List<String>> find(List<String> input) {
    var map = new HashMap<String, List<String>>();
    for (var str : input) {
      var characters = str.toCharArray();
      StringBuilder key = new StringBuilder();
      for (int i = 1; i < characters.length; i++) {
        int diff = characters[i] - characters[i - 1];
        key.append("#").append(diff > 0 ? diff : 26 - Math.abs(diff));
      }
      if (map.containsKey(key.toString())) {
        var list = map.get(key.toString());
        list.add(str);
      } else {
        var list = new ArrayList<String>();
        list.add(str);
        map.put(key.toString(), list);
      }
    }
    return new ArrayList<>(map.values());
  }
}
