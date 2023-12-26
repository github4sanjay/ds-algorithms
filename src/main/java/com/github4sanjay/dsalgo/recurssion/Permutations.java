package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

  public static void print(String input) {
    print(input, "");
  }

  private static void print(String question, String answer) {
    if (question.isEmpty()) {
      System.out.println(answer);
      return;
    }
    for (int i = 0; i < question.length(); i++) {
      String chosenChar = question.substring(i, i + 1);
      String leftPart = question.substring(0, i);
      String rightPart = question.substring(i + 1);
      print(leftPart + rightPart, chosenChar + answer);
    }
  }

  public static List<String> get(String question) {
    if (question.isEmpty()) {
      var list = new ArrayList<String>();
      list.add("");
      return list;
    }

    var finalList = new ArrayList<String>();
    for (int i = 0; i < question.length(); i++) {
      String chosenChar = question.substring(i, i + 1);
      String rightPart = question.substring(i + 1);
      String leftPart = question.substring(0, i);
      var list = get(leftPart + rightPart);
      for (var item : list) {
        finalList.add(chosenChar + item);
      }
    }
    return finalList;
  }
}
