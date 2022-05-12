package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * <p>Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so
 * that the resulting parentheses string is valid and return any valid string.
 *
 * <p>Formally, a parentheses string is valid if and only if:
 *
 * <p>It is the empty string, contains only lowercase characters, or It can be written as AB (A
 * concatenated with B), where A and B are valid strings, or It can be written as (A), where A is a
 * valid string.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "lee(t(c)o)de)" Output: "lee(t(c)o)de" Explanation: "lee(t(co)de)" , "lee(t(c)ode)"
 * would also be accepted. Example 2:
 *
 * <p>Input: s = "a)b(c)d" Output: "ab(c)d" Example 3:
 *
 * <p>Input: s = "))((" Output: "" Explanation: An empty string is also valid.
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 105 s[i] is either'(' , ')', or lowercase English letter.
 */
public class MinimumRemoveToMakeValidParentheses {

  public static String find(String str) {
    var input = str.toCharArray();
    var stack = new LinkedList<Integer>(); // contains index
    for (int i = 0; i < input.length; i++) {
      var character = input[i];
      if (character == '(') {
        stack.push(i);
      } else if (character == ')') {
        if (stack.isEmpty()) {
          input[i] = '.';
        } else {
          stack.pop();
        }
      }
    }
    while (!stack.isEmpty()) {
      input[stack.pop()] = '.';
    }
    var answer = new StringBuilder();
    for (var element : input) {
      if (element != '.') {
        answer.append(element);
      }
    }
    return answer.toString();
  }
}
