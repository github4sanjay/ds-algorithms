package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

public class FindHighestFrequencyCharacter {

  public static void main(String[] args) {
    System.out.println(
        FindHighestFrequencyCharacter.find("zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc"));
  }

  private static char find(String str) {
    var map = new HashMap<Character, Integer>();
    Character maxFreqChar = null;
    int maxFrequency = Integer.MIN_VALUE;
    for (var ch : str.toCharArray()) {
      var frequency = map.get(ch);
      if (frequency == null) {
        frequency = 1;
        map.put(ch, frequency);

      } else {
        frequency = frequency + 1;
        map.put(ch, frequency);
      }
      if (frequency > maxFrequency) {
        maxFrequency = frequency;
        maxFreqChar = ch;
      }
    }

    return maxFreqChar;
  }
}
