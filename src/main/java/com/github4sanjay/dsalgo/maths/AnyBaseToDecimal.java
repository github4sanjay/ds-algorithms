package com.github4sanjay.dsalgo.maths;

public class AnyBaseToDecimal {

  public static void main(String[] args) {
    System.out.println(AnyBaseToDecimal.find(111001, 2));
    System.out.println(AnyBaseToDecimal.find(1172, 8));
  }

  public static int find(int number, int base) {
    int dividend = number;
    int sum = 0;
    int p = 1;
    while (dividend > 0) {
      var qoutient = dividend % 10;
      dividend = dividend / 10;
      sum = sum + p * qoutient;
      p = p * base;
    }
    return sum;
  }
}
