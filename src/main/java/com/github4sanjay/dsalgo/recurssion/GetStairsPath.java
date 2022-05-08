package com.github4sanjay.dsalgo.recurssion;

import java.util.ArrayList;
import java.util.List;

/** 1/2/3 steps are allowed */
public class GetStairsPath {
  public static void main(String[] args) {
    // [11111, 1112, 1121, 113, 1211, 122, 131, 2111, 212, 221, 23, 311, 32]
    System.out.println(getStairsPath(5));
    justPrintPaths(5, "");
  }

  private static List<String> getStairsPath(int n) {
    if (n == 0) { // if 0 already reached destination
      var initialList = new ArrayList<String>();
      initialList.add("");
      return initialList;
    } else if (n < 0) { // if negative this path not possible
      return new ArrayList<>();
    }
    var stairsPath1 = getStairsPath(n - 1);
    var stairsPath2 = getStairsPath(n - 2);
    var stairsPath3 = getStairsPath(n - 3);
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
