package com.github4sanjay.dsalgo.recurssion;

public class PrintPower {

  public static void main(String[] args) {
    System.out.println(PrintPower.printPower(5, 3)); // 125
    System.out.println(PrintPower.printPower(2, 4)); // 16
  }

  private static int printPower(int x, int n) {
    if (n == 1) {
      return x;
    }
    return x * printPower(x, n - 1);
  }
}
