package dynamic.category1;

/**
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Example:
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 *
 * Complexity Analysis:
 *
 *     Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
 *     Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n.
 */
public class TargetSumSubsets {

    public static void main(String[] args) {
        int[] set = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (isSubsetSum(set, sum))
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }

    private static boolean isSubsetSum(int[] set, int sum) {
        boolean[][] dp = new boolean[set.length+1][sum+1];

        for (int i=0; i< dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][0] = true; // sum 0 is possible by all subsets
                } else if (i == 0) {
                    dp[0][j] = false;
                } else if (j == 0) {
                    dp[i][0] = true; // sum 0 is possible by all subsets
                } else {
                    // if item from set not taken
                    boolean ifNotTaken = dp[i - 1][j];
                    boolean ifTaken = false;
                    if (j - set[i - 1] >= 0) { // i-1 as set is 1 lesser in length
                        ifTaken = dp[i - 1][j - set[i - 1]];
                    }
                    if (ifNotTaken || ifTaken) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[set.length][sum];
    }
}
