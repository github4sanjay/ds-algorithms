package com.github4sanjay.dsalgo.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordKLength {

  public static void main(String[] args) {
    WordKLength.find("aabbbccdde", 3);
  }

  private static void find(String str, int k) {

    var alreadyUsed = new HashSet<Character>();
    var unique = "";
    for (char ch : str.toCharArray()) {
      if (!alreadyUsed.contains(ch)) {
        alreadyUsed.add(ch);
        unique = unique + ch;
      }
    }
    // findAsCombination(unique, k, 0, 0, new Character[k], new HashSet<>());
    findAsPermutation(unique, k, 0, new Character[k], new HashSet<>());
  }

  // combination
  private static void findAsCombination(
      String str,
      int k,
      int currentItemIndex,
      int placedSoFar,
      Character[] placed,
      Set<Character> alreadyUsed) {

    if (currentItemIndex == str.length()) {
      if (placedSoFar == k) {
        System.out.println(Arrays.toString(placed));
      }
      return;
    }

    for (int i = 0; i < k; i++) {
      char currentCharacter = str.charAt(currentItemIndex);
      if (placed[i] == null && !alreadyUsed.contains(currentCharacter)) {
        placed[i] = currentCharacter;
        alreadyUsed.add(currentCharacter);
        findAsCombination(str, k, currentItemIndex + 1, placedSoFar + 1, placed, alreadyUsed);
        alreadyUsed.remove(currentCharacter);
        placed[i] = null;
      }
    }

    findAsCombination(str, k, currentItemIndex + 1, placedSoFar, placed, alreadyUsed);
  }

  // permutation
  private static void findAsPermutation(
      String str, int k, int currentBox, Character[] placed, Set<Character> alreadyUsed) {

    if (currentBox == k) {
      System.out.println(Arrays.toString(placed));
      return;
    }

    for (int i = 0; i < str.length(); i++) {
      char currentCharacter = str.charAt(i);
      if (placed[currentBox] == null && !alreadyUsed.contains(currentCharacter)) {
        placed[currentBox] = currentCharacter;
        alreadyUsed.add(currentCharacter);
        findAsPermutation(str, k, currentBox + 1, placed, alreadyUsed);
        alreadyUsed.remove(currentCharacter);
        placed[currentBox] = null;
      }
    }
  }
}
