package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

  public static void main(String[] args) {
    // [, a, b, ab, c, ac, bc, abc]
    System.out.println(Subsequence.get("abc"));
  }

  private static ArrayList<String> create(String s) {
    ArrayList<String> strings = new ArrayList<>();
    create(s, s.length(), new int[s.length()], strings);
    return strings;
  }

  private static void create(String s, int i, int[] index, ArrayList<String> strings) {
    if (i < 1) {
      String string = getString(s, index);
      strings.add(string);
    } else {
      index[i - 1] = 0;
      create(s, i - 1, index, strings);

      index[i - 1] = 1;
      create(s, i - 1, index, strings);
    }
  }

  private static String getString(String s, int[] index) {
    String temp = "";
    for (int j = 0; j < index.length; j++) {
      if (index[j] == 1) {
        temp = temp.concat(s.substring(j, j + 1));
      }
    }
    return temp;
  }

  // 2^n time complexity
  public static List<String> get(String str) {
    var list = new ArrayList<String>();
    get(str, "", 0, list);
    return list;
  }

  private static void get(String str, String answer, int index, ArrayList<String> list) {
    if (index == str.length()) {
      if (!answer.equals("")) {
        list.add(answer);
      }
      return;
    }

    char ch = str.charAt(index);
    get(str, answer, index + 1, list);
    get(str, answer + ch, index + 1, list);
  }
}
