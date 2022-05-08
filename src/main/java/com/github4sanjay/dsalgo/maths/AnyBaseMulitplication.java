package com.github4sanjay.dsalgo.maths;

import java.util.ArrayList;

public class AnyBaseMulitplication {

  public static void main(String[] args) {
    System.out.println(AnyBaseMulitplication.multiply(5, 1220, 31)); // 43320
  }

  public static int multiply(int base, int n1, int n2) {
    int sum = 0;
    int place = 1;
    while (n2 > 0) {
      int digit2 = n2 % 10;
      n2 = n2 / 10;

      int multiplyWithSingleDigit = multiplyWithSingleDigit(base, n1, digit2);
      sum = AnyBaseAddition.add(base, sum, multiplyWithSingleDigit * place);
      place = place * 10;
    }
    return sum;
  }

  private static int multiplyWithSingleDigit(int base, int n, int digit) {
    int sum = 0;
    int dividend = n;
    int carry = 0;
    var list = new ArrayList<Integer>();
    while (dividend > 0) {
      var lastDigit = dividend % 10;
      dividend = dividend / 10;

      int multiply = lastDigit * digit + carry;
      if (multiply >= base) {
        carry = multiply / 8;
        multiply = multiply % 8;
      }

      list.add(multiply);
    }
    list.add(carry);
    return GetNumberFromList.getNumberFromList(list);
  }
}
