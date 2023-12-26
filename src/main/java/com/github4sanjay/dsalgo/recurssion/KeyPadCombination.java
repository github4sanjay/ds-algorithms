package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {

  public static List<String> find(String[] keys, String input) {
    if (input.isEmpty()) {
      var initialList = new ArrayList<String>();
      initialList.add("");
      return initialList;
    }
    var c = input.charAt(0);
    var ros = input.substring(1);
    var stringFromKeysAfterC = find(keys, ros);
    var finalList = new ArrayList<String>();
    var strInC = keys[c - 48];
    for (int i = 0; i < strInC.length(); i++) {
      char charInStrInC = strInC.charAt(i);
      for (String str : stringFromKeysAfterC) {
        finalList.add(charInStrInC + str);
      }
    }
    return finalList;
  }

  public static void print(String[] keys, String input) {
    print(keys, input, "");
  }

  private static void print(String[] keys, String question, String answer) {
    if (question.isEmpty()) {
      System.out.println(answer);
      return;
    }
    var c = question.charAt(0);
    var ros = question.substring(1);
    var strInC = keys[c - 48];
    for (int i = 0; i < strInC.length(); i++) {
      char charInStrInC = strInC.charAt(i);
      print(keys, ros, answer + charInStrInC);
    }
  }
}
