package com.github4sanjay.dsalgo.dynamic.category3;

/**
 * 1. You are given a number n, representing the number of days. 2. You are given n numbers, where
 * ith number represents price of stock on ith day. 3. You are required to print the maximum profit
 * you can make if you are allowed two transactions at-most. Note - There can be no overlapping
 * transaction. One transaction needs to be closed (a buy followed by a sell) before opening another
 * transaction (another buy).
 *
 * <p>11 6 7 19 4 1 6 18 4
 *
 * <p>output 30
 */
public class BuySellStocks2TxnAllowed {

  public static void main(String[] args) {
    System.out.println(BuySellStocks2TxnAllowed.find(new int[] {11, 6, 7, 19, 4, 1, 6, 18, 4}));
  }

  private static int find(int[] stockPrices) {
    int[] maxProfitLeftToRight = getMaxProfitFromLeftToRight(stockPrices);
    int[] maxProfitRightToLeft = getMaxProfitFromRightToLeft(stockPrices);
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < stockPrices.length; i++) {
      max = Math.max(max, maxProfitLeftToRight[i] + maxProfitRightToLeft[i]);
    }
    return max;
  }

  private static int[] getMaxProfitFromLeftToRight(int[] stockPrices) {
    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    int[] maxProfits = new int[stockPrices.length];
    for (int i = 0; i < stockPrices.length; i++) {
      min = Math.min(min, stockPrices[i]);
      maxProfit = Math.max(maxProfit, stockPrices[i] - min);
      maxProfits[i] = maxProfit;
    }
    return maxProfits;
  }

  private static int[] getMaxProfitFromRightToLeft(int[] stockPrices) {
    int max = Integer.MIN_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    int[] maxProfits = new int[stockPrices.length];
    for (int i = stockPrices.length - 1; i >= 0; i--) {
      max = Math.max(max, stockPrices[i]);
      maxProfit = Math.max(maxProfit, max - stockPrices[i]);
      maxProfits[i] = maxProfit;
    }
    return maxProfits;
  }
}
