package com.github4sanjay.dsalgo.recurssion;

public class LogrithmicPower {

  public static void main(String[] args) {
    System.out.println(LogrithmicPower.printPower(5, 3)); // 125
    System.out.println(LogrithmicPower.printPower(2, 4)); // 16
  }

  private static int printPower(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int xpn2 = printPower(x, n / 2);
    int xn = xpn2 * xpn2;
    if (n % 2 == 1) {
      xn = xn * x;
    }
    return xn;
  }
}
