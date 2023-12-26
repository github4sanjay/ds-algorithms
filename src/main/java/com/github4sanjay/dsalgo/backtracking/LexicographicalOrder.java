package com.github4sanjay.dsalgo.backtracking;

public class LexicographicalOrder {

  public static void print(int n) {
    for (int i = 1; i <= 9; i++) {
      print(i, n);
    }
  }

  private static void print(int i, int n) {
    if (i > n) {
      return;
    }
    System.out.println(i);
    for (int j = 0; j <= 9; j++) {
      print(i * 10 + j, n);
    }
  }
}
