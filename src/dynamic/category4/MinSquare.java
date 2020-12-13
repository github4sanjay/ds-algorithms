package dynamic.category4;

/**
 * Minimum number of squares whose sum equals to given number n
 *
 * A number can always be represented as a sum of squares of other numbers.
 * Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …).
 * Given a number n, find the minimum number of squares that sum to X.
 * Examples :
 *
 * Input:  n = 100
 * Output: 1
 * 100 can be written as 10^2. Note that 100 can also be
 * written as 5^2 + 5^2 + 5^2 + 5^2, but this
 * representation requires 4 squares.
 *
 * Input:  n = 6
 * Output: 3
 */
public class MinSquare {

    public static void main(String[] args) {
        System.out.println(getMinSquares(6));
        System.out.println(getMinSquares(100));
        System.out.println(getMinSquares(35));
    }

    /**
     * dp[i] = min {dp[i-1] for 1^2, dp[i-4] for 2^2, ....} + 1
     */
    private static int getMinSquares(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<= n; i++){
            int localMin= Integer.MAX_VALUE;
            int j=1;
            while (true){
                if (i - j*j >= 0){
                    localMin = Math.min(localMin, dp[i-j*j]);
                    j++;
                } else {
                    break;
                }
            }

            if (localMin == Integer.MIN_VALUE){
                dp[i] = 1;
            } else {
                dp[i] = localMin + 1;
            }
        }
        return dp[n];
    }
}
