package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * You are given a string s that consists of lower case English letters and brackets.
 *
 * <p>Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * <p>Your result should not contain any brackets.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "(abcd)" Output: "dcba" Example 2:
 *
 * <p>Input: s = "(u(love)i)" Output: "iloveu" Explanation: The substring "love" is reversed first,
 * then the whole string is reversed. Example 3:
 *
 * <p>Input: s = "(ed(et(oc))el)" Output: "leetcode" Explanation: First, we reverse the substring
 * "oc", then "etco", and finally, the whole string.
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 2000 s only contains lower case English characters and parentheses. It is
 * guaranteed that all parentheses are balanced.
 */
public class ReverseSubstringsBetweenEachPairOfParentheses {

  public static String find(String input) {
    var stack = new LinkedList<Character>();
    for (var character : input.toCharArray()) {
      if (character != ')') {
        stack.push(character);
      } else {
        var queue = new LinkedList<Character>();
        while (!stack.isEmpty() && stack.peek() != '(') {
          queue.offer(stack.pop());
        }
        if (!stack.isEmpty()) {
          stack.pop();
        }
        while (!queue.isEmpty()) {
          stack.push(queue.poll());
        }
      }
    }
    var answer = new StringBuilder();
    while (!stack.isEmpty()) {
      answer.append(stack.pop());
    }
    return answer.reverse().toString();
  }
}
