package mixed;

/**
 * Given a string that consists of left and right parentheses, '(' and ')',
 * balance the parentheses by inserting parentheses as necessary.
 * Determine the minimum number of characters that must be inserted.
 *
 *
 *
 * Example
 *
 * s = '(()))'
 *
 *
 *
 * Insert 1 left parenthesis at the left end of the string to get '((()))'.
 * The string is balanced after 1 insertion.
 *
 * Sample Input
 *
 * STDIN     Function
 * -----     -----
 * ()))   →  s = '()))'
 *
 *
 * Sample Output
 *
 * 2
 *
 *
 * Explanation
 *
 * Insert a '(' 2 times at the beginning of the string to make it valid: '((()))'.
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
        for(char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else {
                left--;
            }
            if(left < 0){
                count++;
                left++;
            }
        }
        return count + left;
    }
}
