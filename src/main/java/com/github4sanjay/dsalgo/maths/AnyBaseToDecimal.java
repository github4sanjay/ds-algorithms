package com.github4sanjay.dsalgo.maths;

import java.util.ArrayList;

public class AnyBaseToDecimal {

  public static void main(String[] args) {
    System.out.println(AnyBaseToDecimal.find(111001, 2));
  }

  public static int find(int number, int base) {
    int dividend = number;
    var remainders = new ArrayList<Integer>();
    while (dividend > 0) {
      int quotient = dividend / 10;
      remainders.add(dividend % 10);
      dividend = quotient;
    }
    int sum = 0;
    for (int i = remainders.size() - 1; i >= 0; i--) {
      int h = 1;
      for (int k = 0; k < i; k++) {
        h = h * base;
      }
      sum = sum + remainders.get(i) * h;
    }
    return sum;
  }
}
