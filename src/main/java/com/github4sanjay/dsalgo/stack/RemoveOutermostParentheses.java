package com.github4sanjay.dsalgo.stack;

import java.util.LinkedList;

/**
 * A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid
 * parentheses strings, and + represents string concatenation.
 *
 * <p>For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings. A valid
 * parentheses string s is primitive if it is nonempty, and there does not exist a way to split it
 * into s = A + B, with A and B nonempty valid parentheses strings.
 *
 * <p>Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... +
 * Pk, where Pi are primitive valid parentheses strings.
 *
 * <p>Return s after removing the outermost parentheses of every primitive string in the primitive
 * decomposition of s.
 *
 * <p>Example 1:
 *
 * <p>Input: s = "(()())(())" Output: "()()()" Explanation: The input string is "(()())(())", with
 * primitive decomposition "(()())" + "(())". After removing outer parentheses of each part, this is
 * "()()" + "()" = "()()()". Example 2:
 *
 * <p>Input: s = "(()())(())(()(()))" Output: "()()()()(())" Explanation: The input string is
 * "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))". After removing
 * outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())". Example 3:
 *
 * <p>Input: s = "()()" Output: "" Explanation: The input string is "()()", with primitive
 * decomposition "()" + "()". After removing outer parentheses of each part, this is "" + "" = "".
 *
 * <p>Constraints:
 *
 * <p>1 <= s.length <= 105 s[i] is either '(' or ')'. s is a valid parentheses string.
 */
public class RemoveOutermostParentheses {

  public static String find(String input) {
    var stack = new LinkedList<Character>();
    StringBuilder answer = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      var item = input.charAt(i);
      if (item == '(') {
        if (!stack.isEmpty()) {
          answer.append(item);
        }
        stack.push(item);
      } else {
        stack.pop();
        if (!stack.isEmpty()) {
          answer.append(item);
        }
      }
    }
    return answer.toString();
  }
}
