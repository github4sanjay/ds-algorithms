package com.github4sanjay.dsalgo.dynamic.category3;

/**
 * 1. You are given a number n, representing the number of days. 2. You are given n numbers, where
 * ith number represents price of stock on ith day. 3. You are given a number k, representing the
 * number of transactions allowed. 3. You are required to print the maximum profit you can make if
 * you are allowed k transactions at-most. Note - There can be no overlapping transaction. One
 * transaction needs to be closed (a buy followed by a sell) before opening another transaction
 * (another buy).
 *
 * <p>{11,6 ,7 ,19,4 ,1 ,6 ,18,4} output 30
 */
public class BuySellStocksKTxnAllowed {

  public static void main(String[] args) {
    System.out.println(
        BuySellStocksKTxnAllowed.findAlt(new int[] {11, 6, 7, 19, 4, 1, 6, 18, 4}, 2));
  }

  private static int find(int[] stockPrices, int k) {
    int[][] dp = new int[k + 1][stockPrices.length];
    for (int i = 0; i <= k; i++) {
      for (int j = 0; j < stockPrices.length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          int max = Integer.MIN_VALUE;
          for (int t = 0;
              t < j;
              t++) { // 0 to j-1 is i-1 transaction, ith transaction can be between current j and
            // any of 0 to j-1
            max = Math.max(max, dp[i - 1][t] + stockPrices[j] - stockPrices[t]);
          }
          dp[i][j] = Math.max(max, dp[i][j - 1]);
        }
      }
    }
    return dp[k][stockPrices.length - 1];
  }

  private static int findAlt(int[] stockPrices, int k) {
    int[][] dp = new int[k + 1][stockPrices.length];
    for (int i = 0; i <= k; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < stockPrices.length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          /*
           stockPrices[j] is common in n^3 solution
           So better calculate max of all dp[i-1][j-1] - stockPrices[j-1]
           and add stockPrices[j] in max
          */
          max = Math.max(max, dp[i - 1][j - 1] - stockPrices[j - 1]);
          dp[i][j] = Math.max(max + stockPrices[j], dp[i][j - 1]);
        }
      }
    }
    return dp[k][stockPrices.length - 1];
  }
}
