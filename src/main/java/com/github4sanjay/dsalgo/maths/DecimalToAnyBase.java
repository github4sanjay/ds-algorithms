package com.github4sanjay.dsalgo.maths;

public class DecimalToAnyBase {

  public static void main(String[] args) {
    System.out.println(DecimalToAnyBase.find(63, 8)); // 77
  }

  public static int find(int decimal, int base) {
    int dividend = decimal;
    int sum = 0;
    int p = 1;
    while (dividend > 0) {
      var digit = dividend % base;
      dividend = dividend / base;
      sum = sum + digit * p;
      p = p * 10;
    }
    return sum;
  }
}
