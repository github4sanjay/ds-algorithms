package com.github4sanjay.dsalgo.dynamic.arrangements;

import java.util.*;

/**
 * 1. You are given a string str. 2. You are required to calculate and print the count of
 * subsequences of the nature a+b+c+. For abbc -> there are 3 subsequences. abc, abc, abbc For
 * abcabc -> there are 7 subsequences. abc, abc, abbc, aabc, abcc, abc, abc.
 */
public class CountABCSubsequences {

  public static int variableDP(String str) {
    int a = 0;
    int ab = 0;
    int abc = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == 'a') {
        a = a + a + 1; // if not join, if join and separate
      } else if (ch == 'b') {
        ab = ab + ab + a;
      } else if (ch == 'c') {
        abc = abc + abc + ab;
      }
    }

    return abc;
  }

  // [abc, abbcc, aabcc, aabbc, aabbcc, abcc, aabc, abbc]
  public static List<String> recursion(String str) {
    var list = new ArrayList<String>();

    var map = new HashMap<Character, Integer>();
    for (char ch : str.toCharArray()) {
      map.merge(ch, 1, Integer::sum);
    }
    count("abc", "", map, list);

    return list;
  }

  private static void count(
      String question, String answer, Map<Character, Integer> frequencyMap, List<String> list) {

    if (question.isEmpty()) {
      if (answer.startsWith("a")) {
        boolean correct = true;
        char previousChar = answer.charAt(0);
        var set = new HashSet<Character>();
        set.add(previousChar);
        if (answer.equals("abca")) {
          System.out.println();
        }
        for (int i = 1; i < answer.length(); i++) {
          char currentChar = answer.charAt(i);
          if (previousChar != currentChar) {
            if (set.contains(currentChar)) {
              correct = false;
              break;
            } else {
              set.add(currentChar);
              previousChar = currentChar;
            }
          }
        }

        if (correct && set.contains('b') && set.contains('c')) list.add(answer);
      }
      return;
    }

    for (int i = 0; i < question.length(); i++) {
      var frequency = frequencyMap.get(question.charAt(i));
      for (int j = 0; j < frequency; j++) {
        String addition = "";
        for (int k = 0; k < j + 1; k++) {
          addition = addition + question.charAt(i);
        }
        System.out.println(addition);
        count(question.substring(1), answer + addition, frequencyMap, list);
      }
    }
  }
}
