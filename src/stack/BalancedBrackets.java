package stack;

import java.util.Stack;

/**
 * Check for Balanced Brackets in an expression (well-formedness) using Stack
 *
 * Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 *
 * Example:
 *
 * Input: exp = “[()]{}{[()()]()}”
 * Output: Balanced
 *
 * Input: exp = “[(])”
 * Output: Not Balanced
 *
 * [(a + b) + {(c + d) * (e / f)}] -> true
 * [(a + b) + {(c + d) * (e / f)]} -> false
 * [(a + b) + {(c + d) * (e / f)} -> false
 * ([(a + b) + {(c + d) * (e / f)}] -> false
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(BalancedBrackets.isbalanced("[(a+b)+{(c+d)*(e/f)}]")); //  true
        System.out.println(BalancedBrackets.isbalanced("[(a+b)+{(c+d)*(e/f)]}")); //  false
        System.out.println(BalancedBrackets.isbalanced("[(a+b)+{(c+d)*(e/f)}")); //  false
        System.out.println(BalancedBrackets.isbalanced("([(a+b)+{(c+d)*(e/f)}]")); //  false
    }

    /**
     * Iterate over each character
     * 1. if character is opening push in stack
     * 2. if character is closing
     *     if stack is empty it means extra closing brackets return false
     *     if peek character is not same opening then return false
     * 3. at end if stack is not empty return false meaning extra opening brackets
     *
     */
    private static boolean isbalanced(String expression) {
        var stack = new Stack<Character>();
        for (var ch : expression.toCharArray()){
            if (isOpeningBracket(ch) ){
                stack.push(ch);
            }
            if (isClosingBracket(ch)){
                if (stack.isEmpty()){ // extra closing brackets
                    return false;
                }
                var peek = stack.pop();
                if (!isOpeningClosing(peek, ch)) { //  brackets not matched
                    return false;
                }
            }
        }
        return stack.isEmpty(); // if stack empty then balanced else extra opening brackets
    }

    private static boolean isOpeningClosing(Character opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '{' && closing == '}')
                || (opening == '[' && closing == ']');
    }

    private static boolean isClosingBracket(char ch){
        return ch == ')' || ch == '}' || ch == ']';
    }

    private static boolean isOpeningBracket(char ch){
        return ch == '(' || ch == '{' || ch == '[';
    }
}
