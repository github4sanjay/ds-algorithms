package dynamic.category1;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively.
 * Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights
 * of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 */
public class Knapsack01 {

    public static void main(String[] args) {
        int[] val = new int[] { 60, 100, 120 };
        int[] wt = new int[] { 10, 20, 30 };
        int W = 50;
        System.out.println(knapsack(W, wt, val)); // 220
    }

    private static int knapsack(int w, int[] wt, int[] val) {
        int[][] dp = new int[wt.length+1][w+1];

        for (int i=0; i< dp.length; i++){
            for (int j=0; j< dp[0].length; j++){
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else if (j < wt[i-1]){
                  dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1]+dp[i-1][j-wt[i-1]]);
                }
            }
        }
        return dp[wt.length][w];
    }
}
