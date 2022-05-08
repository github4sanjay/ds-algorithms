package com.github4sanjay.dsalgo.backtracking;

import java.util.Arrays;
import java.util.HashMap;

public class WordsKSelectionRepeatationAllowed {

  public static void main(String[] args) {
    WordsKSelectionRepeatationAllowed.find("aaabb", 3);
  }

  private static void find(String str, int k) {
    var frequencyMap = new HashMap<Character, Integer>();
    var ustr = "";
    for (char ch : str.toCharArray()) {
      var frequency = frequencyMap.get(ch);
      if (frequency == null) {
        frequencyMap.put(ch, 1);
        ustr = ustr + ch;
      } else {
        frequencyMap.put(ch, frequency + 1);
      }
    }

    findWhenBoxChoosesWhoCanSit(k, new Character[k], 0, frequencyMap);
  }

  private static void findWhenBoxChoosesWhoCanSit(
      int k, Character[] placed, int currentBox, HashMap<Character, Integer> frequencyMap) {

    if (currentBox == k) {
      System.out.println(Arrays.toString(placed));
      return;
    }

    for (Character character : frequencyMap.keySet()) {
      int frequency = frequencyMap.get(character);
      if (placed[currentBox] == null && frequency > 0) {
        char currentCharacter = character;
        placed[currentBox] = currentCharacter;
        frequencyMap.put(character, frequency - 1);
        findWhenBoxChoosesWhoCanSit(k, placed, currentBox + 1, frequencyMap);
        placed[currentBox] = null;
        frequencyMap.put(character, frequency);
      }
    }
  }
}
