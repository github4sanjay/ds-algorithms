package com.github4sanjay.dsalgo.maths;

public class Npr {

  public static int find(int n, int r) {
    return Factorial.find(n) / Factorial.find(n - r);
  }

  public static void main(String[] args) {
    System.out.println(find(5, 2)); // 20
  }
}
