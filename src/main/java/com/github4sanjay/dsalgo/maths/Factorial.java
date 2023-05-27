package com.github4sanjay.dsalgo.maths;

public class Factorial {

  public static int find(int n) {
    int fact = 1;
    for (int i = 1; i <= n; i++) {
      fact *= i;
    }
    return fact;
  }

  public static void main(String[] args) {
    System.out.println(find(5)); // 120
  }
}
