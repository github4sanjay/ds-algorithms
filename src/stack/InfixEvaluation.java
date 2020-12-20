package stack;

import java.util.Stack;

/**
 * 1. You are given an infix expression.
 * 2. You are required to evaluate and print it's value.
 *
 * Constraints
 * 1. Expression is balanced
 * 2. The only operators used are +, -, *, /
 * 3. Opening and closing brackets - () - are used to impact precedence of operations
 * 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
 * 5. In two operators of equal precedence give preference to the one on left.
 * 6. All operands are single digit numbers.
 *
 * Sample Input
 * 2 + 6 * 4 / 8 - 3
 * Sample Output
 * 2
 */
public class InfixEvaluation {

    public static void main(String[] args) {
        System.out.println(InfixEvaluation.calculate("2 + 6 * 4 / 8 - 3"));
        System.out.println(InfixEvaluation.calculate("1 * ( 2 + 2 ) / 4"));
    }

    /**
     * Keep two stacks : operand stack which will store integers and operator stack which store brackets and operators
     * Iterate over each character in expression
     * 1. if digit just push in operand stack
     * 2. if space ignore
     * 3. if opening bracket push in operator stack
     * 4. if closing bracket, pop until opening bracket and evaluate popping two operands from operand stack and
     *    push the result back in operand stack, pop closing bracket as well
     * 5. if an operator, pop higher or equal precedence operator from operator stack and evaluate operands from
     *     operand stack
     * 6. Once iteration on each character is over, check if operator stack is empty or not
     *    if not empty, pop operators one by one and evaluate them with operands.
     * 7. once operator stack is empty, pop result from operand stack and return.
     */
    private static int calculate(String expression) {
        var operandStack = new Stack<Integer>();
        var operatorStack = new Stack<Character>();
        for (char ch : expression.toCharArray()) {
            if (ch == ')') { // pop until opening bracket
                while (!operatorStack.isEmpty()){
                    var operator = operatorStack.pop();
                    if (operator == '(') {
                        break;
                    }
                    var firstOperand = operandStack.pop();
                    var secondOperand = operandStack.pop();
                    int evaluate = evaluate(secondOperand, firstOperand, operator);
                    operandStack.push(evaluate);
                }
            } else if (ch == '('){
                operatorStack.push(ch);
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && isHigherOrEqualPrecedence(ch, operatorStack.peek())){
                    var operator = operatorStack.pop();
                    var firstOperand = operandStack.pop();
                    var secondOperand = operandStack.pop();
                    int evaluate = evaluate(secondOperand, firstOperand, operator);
                    operandStack.push(evaluate);
                }
                operatorStack.push(ch);
            } else if (Character.isDigit(ch)){
                operandStack.push(ch-'0'); // char to integer
            }
        }
        if (!operatorStack.isEmpty()){
            var operator = operatorStack.pop();
            var firstOperand = operandStack.pop();
            var secondOperand = operandStack.pop();
            int evaluate = evaluate(secondOperand, firstOperand, operator);
            operandStack.push(evaluate);
        }
        return operandStack.pop();
    }

    private static boolean isHigherOrEqualPrecedence(char ch, Character peek) {
        if (operatorPrecedence(peek) >= operatorPrecedence(ch)) {
            return true;
        } else {
            return false;
        }
    }

    private static int operatorPrecedence(char operator) {
        if (operator == '*') {
            return 2;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '+') {
            return 1;
        } else if (operator == '/'){
            return 2;
        } else { // for the case where '(' brackets come so they are not popped as its less precedence
            return -1;
        }
    }

    private static boolean isOperator(char ch) {
        return  (ch == '*' || ch == '+' || ch == '-' || ch == '/');
    }

    private static int evaluate(Integer secondOperand, Integer firstOperand, Character operator) {
        if (operator == '*') {
            return secondOperand*firstOperand;
        } else if (operator == '-') {
            return secondOperand-firstOperand;
        } else if (operator == '+') {
            return secondOperand+firstOperand;
        } else if (operator == '/') {
            return secondOperand/firstOperand;
        }
        return 0;
    }
}
