package dynamic.category1;

/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti,
 * we need to calculate the maximum amount that could make up this quantity exactly.
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * Examples:
 *
 * Input : W = 100
 *        val[]  = {1, 30}
 *        wt[] = {1, 50}
 * Output : 100
 * There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50
 *    instances of 1 unit weight items.
 * We get maximum value with option 2.
 *
 * Input : W = 8
 *        val[] = {10, 40, 50, 70}
 *        wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class KnapsackUnbounded {

    public static void main(String[] args) {
        int[] val = new int[] {15, 14, 10, 45, 30};
        int[] wt = new int[] {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(knapsack(W, wt, val)); // 220
    }

    //  with 2d array
    private static int knapsack(int w, int[] wt, int[] val) {
        int[][] dp = new int[wt.length+1][w+1];

        for (int i=0; i< dp.length; i++){
            for (int j=0; j< dp[0].length; j++){
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    int noOfTimesWtCanBeTaken = j/wt[i-1];
                    int max = Integer.MIN_VALUE;
                    for (int k=0; k<=noOfTimesWtCanBeTaken; k++) {
                        if (k==0){
                            max = dp[i-1][j];
                        } else {
                            max = Math.max(max, val[i-1]*k+dp[i-1][j-wt[i-1]*k]);
                        }
                    }
                    dp[i][j] = max;
                }
            }
        }
        return dp[wt.length][w];
    }


    //  with 1d array
    private static int knapsackIn1DArray(int w, int[] wt, int[] val) {
        int[] dp = new int[w+1];
        dp[0] = 0;
        for (int i=1; i< dp.length; i++){
            for (int j=0; j< wt.length; j++){
                if (i < wt[j]) continue;
                dp[i] = Math.max(dp[i], val[j]+dp[i-wt[j]]);
            }
        }
        return dp[w];
    }
}
