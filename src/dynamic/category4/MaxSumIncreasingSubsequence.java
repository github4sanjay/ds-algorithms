package dynamic.category4;

/**
 * Given an array of n positive integers.
 * Write a program to find the sum of maximum sum subsequence of the given array
 * such that the integers in the subsequence are sorted in increasing order.
 *
 * For example,
 *
 * if input is {1, 101, 2, 3, 100, 4, 5},
 * then output should be 106 (1 + 2 + 3 + 100),
 *
 * if the input array is {3, 4, 5, 10},
 * then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 */
public class MaxSumIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(MaxSumIncreasingSubsequence.find(new int[]{10,22,9,33,21,50,41,60,80,3}));
    }

    // time -> n^2, space -> n
    private static int find(int[] arr) {

        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int maxSum = arr[0];

        for (int i=1; i < arr.length; i++){
            int sum = Integer.MIN_VALUE;
            for (int j=0;  j< i; j++){
                if (arr[i] > arr[j]){ // increasing
                    sum = Math.max(sum, dp[j]);
                }
            }

            if (sum == Integer.MIN_VALUE){ // handle element if it is the smallest till now
                dp[i] = arr[i];
            } else {
                dp[i] = sum + arr[i];
            }

            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
