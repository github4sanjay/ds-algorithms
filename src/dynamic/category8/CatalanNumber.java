package dynamic.category8;

/**
 * Program for nth Catalan Number
 * Catalan numbers are a sequence of natural numbers that occurs in many interesting counting problems like following.
 * 1) Count the number of expressions containing n pairs of parentheses which are correctly matched. For n = 3, possible expressions are ((())), ()(()), ()()(), (())(), (()()).
 * 2) Count the number of possible Binary Search Trees with n keys
 * 3) Count the number of full binary trees (A rooted binary tree is full if every vertex has either two children or no children) with n+1 leaves.
 * 4) Given a number n, return the number of ways you can draw n chords in a circle with 2 x n points such that no 2 chords intersect.
 *
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 *
 * Recommended: Please solve it on “PRACTICE ” first, before moving on to the solution.
 *
 * Recursive Solution
 * Catalan numbers satisfy the following recursive formula.
 *
 *
 * C0=1 and Cn+1= sum{i=0}^{n}Ci*Cn-i for n geq 0;
 */
public class CatalanNumber {

    public static void main(String[] args) {
        System.out.println(CatalanNumber.findTabular(4));
    }

    /**
     *
     * C0 = 1
     * C1 = 1
     * C2 = C0*C1 + C1*C0 = 2
     * C3 = C0*C2 + C1*C1 + C2*C0 = 5
     * C4 = C0*C3 + C1*C2 + C2*C1 + C3*C0 = 14
     */
    private static int findByRecursion(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        int sum = 0;
        for (int i=0; i<n; i++){
            sum = sum + findByRecursion(i)*findByRecursion(n-i-1);
        }
        return sum;
    }

    private static int findTabular(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for (int i=2; i<= n;i++){
            int sum=0;
            for (int j=0; j < i; j++){
                sum = sum + dp[j]*dp[i-j-1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
