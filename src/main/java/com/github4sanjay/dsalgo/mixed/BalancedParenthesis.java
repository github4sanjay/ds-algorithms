package com.github4sanjay.dsalgo.mixed;

/**
 * Given a string that consists of left and right parentheses, '(' and ')', balance the parentheses
 * by inserting parentheses as necessary. Determine the minimum number of characters that must be
 * inserted.
 *
 * <p>Example
 *
 * <p>s = '(()))'
 *
 * <p>Insert 1 left parenthesis at the left end of the string to get '((()))'. The string is
 * balanced after 1 insertion.
 *
 * <p>Sample Input
 *
 * <p>STDIN Function ----- ----- ())) → s = '()))'
 *
 * <p>Sample Output
 *
 * <p>2
 *
 * <p>Explanation
 *
 * <p>Insert a '(' 2 times at the beginning of the string to make it valid: '((()))'.
 */
public class BalancedParenthesis {

  public static void main(String[] args) {
    System.out.println(find(")()((((())))(())))())))(())))(())))()(()))(())))()"));
    System.out.println(find(")))()()()())())())))))())))))))())()))()()()))))))"));
    System.out.println(find("()))"));
    System.out.println(find("()))(("));
  }

  private static int find(String s) {
    int left = 0;
    int count = 0;
    for (char c : s.toCharArray()) {
      if (c == '(') {
        left++;
      } else {
        left--;
      }
      if (left < 0) {
        count++;
        left++;
      }
    }
    return count + left;
  }
}
