package com.github4sanjay.dsalgo.hashmap;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction
 * in string format.
 *
 * <p>If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * <p>If multiple answers are possible, return any of them.
 *
 * <p>It is guaranteed that the length of the answer string is less than 104 for all the given
 * inputs.
 *
 * <p>Example 1:
 *
 * <p>Input: numerator = 1, denominator = 2 Output: "0.5" Example 2:
 *
 * <p>Input: numerator = 2, denominator = 1 Output: "2" Example 3:
 *
 * <p>Input: numerator = 4, denominator = 333 Output: "0.(012)"
 *
 * <p>Constraints:
 *
 * <p>-231 <= numerator, denominator <= 231 - 1 denominator != 0
 */
public class FractionToRecurringDecimal {

  public static String find(int numerator, int denominator) {
    var sb = new StringBuilder();
    int quotient = numerator / denominator;
    var remainder = numerator % denominator;
    sb.append(quotient);
    if (remainder == 0) return sb.toString();
    else {
      var remainders = new HashMap<Integer, String>(); // remainder to answer
      sb.append(".");
      while (remainder != 0) {
        if (remainders.containsKey(remainder)) {
          sb.insert(remainders.get(remainder).length(), "(");
          sb.append(")");
          break;
        } else {
          remainders.put(remainder, sb.toString());
          quotient = remainder * 10;
          remainder = quotient % denominator;
          quotient = quotient / denominator;
          sb.append(quotient);
        }
      }
    }
    return sb.toString();
  }
}
