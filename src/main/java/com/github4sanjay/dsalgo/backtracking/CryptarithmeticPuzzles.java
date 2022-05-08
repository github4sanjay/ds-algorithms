package com.github4sanjay.dsalgo.backtracking;

import java.util.HashMap;

public class CryptarithmeticPuzzles {

  public static void main(String[] args) {
    /**
     * Newspapers and magazines often have crypt-arithmetic puzzles of the form:
     *
     * <p>SEND + MORE -------- MONEY --------
     */
    find("send", "more", "money");
  }

  private static void find(String s1, String s2, String s3) {
    var map = new HashMap<Character, Integer>();
    StringBuilder uniqueString = new StringBuilder();
    for (char ch : s1.toCharArray()) {
      if (!map.containsKey(ch)) {
        map.put(ch, -1);
        uniqueString.append(ch);
      }
    }

    for (char ch : s2.toCharArray()) {
      if (!map.containsKey(ch)) {
        map.put(ch, -1);
        uniqueString.append(ch);
      }
    }

    for (char ch : s3.toCharArray()) {
      if (!map.containsKey(ch)) {
        map.put(ch, -1);
        uniqueString.append(ch);
      }
    }

    boolean[] usedNumbers = new boolean[10];
    find(uniqueString, 0, map, usedNumbers, s1, s2, s3);
  }

  private static void find(
      StringBuilder uniqueString,
      int index,
      HashMap<Character, Integer> map,
      boolean[] usedNumbers,
      String s1,
      String s2,
      String s3) {

    if (index == uniqueString.length()) {
      int num1 = getStringNumber(s1, map);
      int num2 = getStringNumber(s2, map);
      int num3 = getStringNumber(s3, map);
      if (num1 + num2 == num3) {
        for (int i = 0; i < 26; i++) { // map can also be printed
          char ch = (char) ('a' + i);
          if (map.containsKey(ch)) {
            System.out.print(ch + "-" + map.get(ch) + " ");
          }
        }
        System.out.println("");
      }
      return;
    }

    char ch = uniqueString.charAt(index);
    for (int i = 0; i <= 9; i++) {
      if (!usedNumbers[i]) {
        map.put(ch, i);
        usedNumbers[i] = true;
        find(uniqueString, index + 1, map, usedNumbers, s1, s2, s3);
        usedNumbers[i] = false;
        map.put(ch, -1);
      }
    }
  }

  private static int getStringNumber(String str, HashMap<Character, Integer> map) {
    StringBuilder number = new StringBuilder();
    for (char ch : str.toCharArray()) {
      int value = map.get(ch);
      number.append(value);
    }
    return Integer.parseInt(number.toString());
  }
}
