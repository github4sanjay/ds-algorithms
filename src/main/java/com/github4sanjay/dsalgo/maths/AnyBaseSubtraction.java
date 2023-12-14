package com.github4sanjay.dsalgo.maths;

public class AnyBaseSubtraction {

  public static int subtract(int base, int n1, int n2) {
    int dividend1 = n1;
    int dividend2 = n2;
    int carry = 0;

    int sum = 0;
    int p = 1;
    while (dividend2 > 0) {
      int remainder1 = dividend1 % 10;
      dividend1 = dividend1 / 10;

      int remainder2 = dividend2 % 10;
      dividend2 = dividend2 / 10;

      remainder2 = remainder2 + carry;

      int digitSub = 0;
      if (remainder2 >= remainder1) {
        carry = 0;
        digitSub = remainder2 - remainder1;
      } else {
        carry = -1;
        digitSub = remainder2 + base - remainder1;
      }

      sum = sum + p * digitSub;
      p = p * 10;
    }

    return sum;
  }
}
