package com.github4sanjay.dsalgo.maths;

public class AnyBaseToDecimal {

  public static int find(int number, int base) {
    int dividend = number;
    int sum = 0;
    int p = 1;
    while (dividend > 0) {
      var remainder = dividend % 10;
      dividend = dividend / 10;
      sum = sum + p * remainder;
      p = p * base;
    }
    return sum;
  }
}
