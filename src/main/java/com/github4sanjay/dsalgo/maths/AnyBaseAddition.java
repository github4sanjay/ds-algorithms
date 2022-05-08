package com.github4sanjay.dsalgo.maths;

import static com.github4sanjay.dsalgo.maths.GetNumberFromList.getNumberFromList;

import java.util.ArrayList;

/**
 * Given three integers X, Y and B, where X and Y are Base-B integers. The task is to find the sum
 * of integers X and Y.
 *
 * <p>Examples:
 *
 * <p>Input: X = 123, Y = 234, B = 6 Output: 401 Explanation: Sum of two integers in base 6 - 1 1 1
 * 2 3 + 2 3 4 ------------- 4 0 1
 *
 * <p>Input: X = 546, Y = 248 B = 9 Output: 805 Explanation: Sum of two integers in base 9 - 1 1 5 4
 * 6 + 2 4 8 ------------- 8 0 5
 */
public class AnyBaseAddition {

  public static void main(String[] args) {
    System.out.println(AnyBaseAddition.add(8, 777, 1)); // 1000
    System.out.println(AnyBaseAddition.add(6, 123, 234)); // 401
    System.out.println(AnyBaseAddition.add(9, 546, 248)); // 805
  }

  public static int add(int base, int n1, int n2) {
    int dividend1 = n1;
    int dividend2 = n2;
    int carry = 0;

    var list = new ArrayList<Integer>();

    while (dividend1 > 0 || dividend2 > 0) {
      int quotient1 = dividend1 / 10;
      int remainder1 = dividend1 % 10;

      int quotient2 = dividend2 / 10;
      int remainder2 = dividend2 % 10;

      int digitSum = remainder1 + remainder2 + carry;
      if (digitSum >= base) {
        carry = 1;
        digitSum = digitSum % base;
      } else {
        carry = 0;
      }

      list.add(digitSum);
      dividend1 = quotient1;
      dividend2 = quotient2;
    }
    list.add(carry);

    return getNumberFromList(list);
  }
}
