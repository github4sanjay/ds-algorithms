package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

/** 1/2/3 steps are allowed */
public class StairsPath {

  public static List<String> get(int n) {
    if (n == 0) { // if 0 already reached destination
      var initialList = new ArrayList<String>();
      initialList.add("");
      return initialList;
    } else if (n < 0) { // if negative this path not possible
      return new ArrayList<>();
    }
    var stairsPath1 = get(n - 1);
    var stairsPath2 = get(n - 2);
    var stairsPath3 = get(n - 3);
    List<String> finalList = new ArrayList<>();
    for (String stairPath : stairsPath1) {
      finalList.add(1 + stairPath);
    }
    for (String stairPath : stairsPath2) {
      finalList.add(2 + stairPath);
    }
    for (String stairPath : stairsPath3) {
      finalList.add(3 + stairPath);
    }
    return finalList;
  }

  public static void print(int n) {
    justPrintPaths(n, "");
  }

  private static void justPrintPaths(int n, String answer) {
    if (n == 0) { // if 0 already reached destination
      System.out.println(answer);
      return;
    } else if (n < 0) { // if negative this path not possible
      return;
    }
    justPrintPaths(n - 1, 1 + answer);
    justPrintPaths(n - 2, 2 + answer);
    justPrintPaths(n - 3, 3 + answer);
  }
}
