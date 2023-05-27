package com.github4sanjay.dsalgo.maths;

public class CheckIfFibonacci {

  private static boolean isPerfectSquare(int x) {
    int s = (int) Math.sqrt(x);
    return (s * s == x);
  }

  public static boolean isFibonacci(int n) {
    return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
  }

  public static void main(String[] args) {
    System.out.println(isFibonacci(10));
    System.out.println(isFibonacci(11));
  }
}
