package com.github4sanjay.dsalgo.maths;

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

  public static int add(int base, int n1, int n2) {
    int dividend1 = n1;
    int dividend2 = n2;
    int carry = 0;

    int p = 1;
    int sum = 0;
    while (dividend1 > 0 || dividend2 > 0 || carry > 0) {
      int remainder1 = dividend1 % 10;
      dividend1 = dividend1 / 10;

      int remainder2 = dividend2 % 10;
      dividend2 = dividend2 / 10;

      int digitSum = remainder1 + remainder2 + carry;
      if (digitSum >= base) {
        carry = digitSum / base;
        digitSum = digitSum % base;
      } else {
        carry = 0;
      }

      sum += digitSum * p;
      p = p * 10;
    }
    return sum;
  }
}
