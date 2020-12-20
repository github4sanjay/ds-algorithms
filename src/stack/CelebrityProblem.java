package stack;

import java.util.Stack;

/**
 * In a party of N people, only one person is known to everyone.
 * Such a person may be present in the party, if yes, (s)he doesn’t know anyone in the party.
 * We can only ask questions like “does A know B? “. Find the stranger (celebrity) in the minimum number of questions.
 * We can describe the problem input as an array of numbers/characters representing persons in the party.
 * We also have a hypothetical function HaveAcquaintance(A, B) which returns true if A knows B, false otherwise. How can we solve the problem.
 *
 * Examples:
 *
 * Input:
 * MATRIX = { {0, 0, 1, 0},
 *            {0, 0, 1, 0},
 *            {0, 0, 0, 0},
 *            {0, 0, 1, 0} }
 * Output:id = 2
 * Explanation: The person with ID 2 does not
 * know anyone but everyone knows him
 *
 * Input:
 * MATRIX = { {0, 0, 1, 0},
 *            {0, 0, 1, 0},
 *            {0, 1, 0, 0},
 *            {0, 0, 1, 0} }
 * Output: No celebrity
 * Explanation: There is no celebrity.
 */
public class CelebrityProblem {

    public static void main(String[] args) {
        System.out.println(CelebrityProblem.find(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        })); // 2
        System.out.println(CelebrityProblem.find(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0}
        }));  // null
    }


    /**
     * This can be solved by elimination technique in O(n) time complexity
     * 1. First put all candidate in stack
     * 2. Pop two elements check if first knows second
     *      a. if yes first cannot be celebrity push second
     *      b. if no then second cannot be celebrity push first
     * 3. when last element left in stack then possibility that this can be celebrity
     * 4. Pop last element and check in row and column if everyone knows it and he does not know everyone.
     */
    public static Integer find(int[][] matrix) {
        var stack = new Stack<Integer>();
        for (int i=0; i< matrix.length; i++){
            stack.push(i);
        }
        while (stack.size() != 1){
            var first = stack.pop();
            var second = stack.pop();
            if (matrix[first][second] == 1){
                stack.push(second);
            } else {
                stack.push(first);
            }
        }

        var last = stack.pop();
        for (int i=0; i<matrix.length; i++){
            if (i == last) continue;
            if (matrix[i][last] == 0){
                return null;
            }
        }

        for (int j=0; j<matrix.length; j++){
            if (j == last) continue;
            if (matrix[last][j] == 1){
                return null;
            }
        }
        return last;
    }
}
