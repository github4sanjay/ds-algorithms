package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

public class KeyPadCombination {

  public static void main(String[] args) {
    String[] keys =
        new String[] {";;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    // [ptv, ptw, ptx, puv, puw, pux, qtv, qtw, qtx, quv, quw, qux, rtv, rtw, rtx, ruv, ruw, rux,
    // stv, stw, stx, suv, suw, sux]
    System.out.println(find(keys, "678"));

    print(keys, "678", "");
  }

  public static List<String> find(String[] keys, String input) {
    if (input.length() == 0) {
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

  public static void print(String[] keys, String question, String answer) {
    if (question.length() == 0) {
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
