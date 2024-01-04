package com.github4sanjay.dsalgo.dynamic.stocks;

/*
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed a single transaction.
 *9 days
 * 11
 * 6
 * 7
 * 19
 * 4
 * 1
 * 6
 * 18
 * 4
 *
 * output : 17
 */
public class BuySellStocks1TxnAllowed {

  public static int find(int[] stockPrices) {
    int min = Integer.MAX_VALUE;
    int maxProfit = Integer.MIN_VALUE;
    for (int stockPrice : stockPrices) {
      min = Math.min(min, stockPrice);
      maxProfit = Math.max(maxProfit, stockPrice - min);
    }
    return maxProfit;
  }
}
