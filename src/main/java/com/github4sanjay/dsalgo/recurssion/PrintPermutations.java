package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class PrintPermutations {
  public static void main(String[] args) {
    /** cba bca cbb bcb bac abc */
    PrintPermutations.print("abc", "");
    System.out.println(PrintPermutations.get("abc"));
  }

  private static void print(String question, String answer) {
    if (question.length() == 0) {
      System.out.println(answer);
      return;
    }
    for (int i = 0; i < question.length(); i++) {
      String chosenChar = question.substring(i, i + 1);
      String rightPart = question.substring(i + 1);
      String leftPart = question.substring(0, i);
      print(leftPart + rightPart, chosenChar + answer);
    }
  }

  private static List<String> get(String question) {
    if (question.length() == 0) {
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
