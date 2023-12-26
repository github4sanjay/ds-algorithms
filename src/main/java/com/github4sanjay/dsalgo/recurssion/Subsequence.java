package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

  // 2^n time complexity
  public static List<String> get(String str) {
    var list = new ArrayList<String>();
    get(str, "", 0, list);
    return list;
  }

  private static void get(String str, String answer, int index, ArrayList<String> list) {
    if (index == str.length()) {
      if (!answer.isEmpty()) {
        list.add(answer);
      }
      return;
    }

    char ch = str.charAt(index);
    get(str, answer, index + 1, list);
    get(str, answer + ch, index + 1, list);
  }

  public static void print(String input) {
    print(input, "");
  }

  private static void print(String question, String answer) {
    if (question.isEmpty()) {
      System.out.println(answer);
      return;
    }

    var c = question.charAt(0);
    var newQuestion = question.substring(1);
    print(newQuestion, answer);
    print(newQuestion, answer + c);
  }
}
