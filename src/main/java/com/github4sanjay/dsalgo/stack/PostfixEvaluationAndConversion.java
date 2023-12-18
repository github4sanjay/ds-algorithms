package com.github4sanjay.dsalgo.stack;

import java.util.Stack;

/*
 * 1. You are given a postfix expression.
 * 2. You are required to evaluate it and print it's value.
 * 3. You are required to convert it to infix and print it.
 * 4. You are required to convert it to prefix and print it.
 *
 * Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.
 *
 * Input Format
 * expression
 *
 * Output Format
 * value, a number
 * infix
 * prefix
 *
 * Constraints
 * 1. Expression is a valid postfix expression
 * 2. The only operators used are +, -, *, /
 * 3. All operands are single digit numbers.
 *
 * Sample Input
 * 264*8/+3-
 *
 * Sample Output
 * 2
 * ((2+((6*4)/8))-3)
 * -+2/*6483
 */
public class PostfixEvaluationAndConversion {

  public static void main(String[] args) {
    System.out.println(PostfixEvaluationAndConversion.execute("264*8/+3-"));
  }

  /*
   * For value evaluation :
   *     |     |                                                              |     |
   *     | 4   |                                                              |     |
   *     | 6   | --->  current character is operator and equal to '*'  ---->  | 24  |
   *     | 2   |       then pop '4' and '6' and push 6*4 = 24                 | 2   |
   *     |_____|                                                              |_____|
   *
   * For infix evaluation :
   *     |     |                                                              |     |
   *     | 4   |                                                              |     |
   *     | 6   | --->  current character is operator and equal to '*'  ---->  |(6*4)|
   *     | 2   |       then pop '4' and '6' and push (6*4)                    | 2   |
   *     |_____|                                                              |_____|
   *
   * For prefix evaluation :
   *     |     |                                                              |     |
   *     | 4   |                                                              |     |
   *     | 6   | --->  current character is operator and equal to '*'  ---->  | *64 |
   *     | 2   |       then pop '4' and '6' and push *64                      | 2   |
   *     |_____|                                                              |_____|
   *
   */
  private static Answer execute(String expression) {
    var valueStack = new Stack<Integer>();
    var infixStack = new Stack<String>();
    var prefixStack = new Stack<String>();

    for (char ch : expression.toCharArray()) {
      if (isOperator(ch)) {
        evaluateValue(valueStack, ch);
        evaluateInfix(infixStack, ch);
        evaluatePrefix(prefixStack, ch);
      } else if (Character.isDigit(ch)) {
        valueStack.push(ch - '0');
        infixStack.push(String.valueOf(ch));
        prefixStack.push(String.valueOf(ch));
      }
    }

    return new Answer(valueStack.pop(), infixStack.pop(), prefixStack.pop());
  }

  private static void evaluatePrefix(Stack<String> prefixStack, char operator) {
    var first = prefixStack.pop();
    var second = prefixStack.pop();
    prefixStack.push(evaluatePrefix(first, second, operator));
  }

  private static String evaluatePrefix(String first, String second, char operator) {
    return operator + second + first;
  }

  private static void evaluateInfix(Stack<String> infixStack, char operator) {
    var first = infixStack.pop();
    var second = infixStack.pop();
    infixStack.push(evaluateInfix(first, second, operator));
  }

  private static String evaluateInfix(String first, String second, char operator) {
    return "(" + second + operator + first + ")";
  }

  private static void evaluateValue(Stack<Integer> valueStack, char operator) {
    var first = valueStack.pop();
    var second = valueStack.pop();
    valueStack.push(evaluateValue(first, second, operator));
  }

  private static int evaluateValue(Integer firstOperand, Integer secondOperand, char operator) {
    if (operator == '*') {
      return secondOperand * firstOperand;
    } else if (operator == '-') {
      return secondOperand - firstOperand;
    } else if (operator == '+') {
      return secondOperand + firstOperand;
    } else if (operator == '/') {
      return secondOperand / firstOperand;
    }
    return 0;
  }

  private static boolean isOperator(char ch) {
    return (ch == '*' || ch == '+' || ch == '-' || ch == '/');
  }

  public static class Answer {
    int value;
    String infix;
    String prefix;

    public Answer(int value, String infix, String prefix) {
      this.value = value;
      this.infix = infix;
      this.prefix = prefix;
    }

    @Override
    public String toString() {
      return "Answer{"
          + "value="
          + value
          + ", infix='"
          + infix
          + '\''
          + ", prefix='"
          + prefix
          + '\''
          + '}';
    }
  }
}
