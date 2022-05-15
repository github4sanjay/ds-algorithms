package com.github4sanjay.dsalgo.dynamic.category3;

/*
 * 1. You are given a number n, representing the number of days.
 * 2. You are given n numbers, where ith number represents price of stock on ith day.
 * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
 * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
 * 9 - > days
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
 * output : 30
 */
public class BuySellStocksInfiniteTxnAllowed {

  public static void main(String[] args) {
    System.out.println(
        BuySellStocksInfiniteTxnAllowed.findAlt(new int[] {6, 7, 19, 4, 1, 6, 18, 4})); // 30
    System.out.println(
        BuySellStocksInfiniteTxnAllowed.findAlt(
            new int[] {100, 180, 260, 310, 40, 535, 695})); // 865
    System.out.println(
        BuySellStocksInfiniteTxnAllowed.findAlt(
            new int[] {100, 10, 260, 310, 40, 535, 640})); // 900
    System.out.println(BuySellStocksInfiniteTxnAllowed.findAlt(new int[] {10, 9, 8, 7})); // 0
    System.out.println(
        BuySellStocksInfiniteTxnAllowed.findAlt(new int[] {100, 200, 300, 400})); // 300
  }

  private static int findAlt(int[] stockPrices) {
    int bd = 0;
    int sd = 0;
    int profit = 0;

    for (int i = 1; i < stockPrices.length; i++) {
      if (stockPrices[i] >= stockPrices[i - 1]) {
        sd++;
      } else {
        profit += stockPrices[sd] - stockPrices[bd];
        bd = sd = i;
      }
    }

    profit += stockPrices[sd] - stockPrices[bd];
    return profit;
  }

  private static int find(int[] stockPrices) {

    boolean sell = false;
    boolean buy = false;
    int boughtAt = 0;
    int profit = 0;
    int i = 2;
    if (stockPrices[0] < stockPrices[1]) {
      sell = true;
      boughtAt = stockPrices[0];
    } else {
      buy = true;
      i = 1;
    }

    while (i < stockPrices.length) {
      if (i == stockPrices.length - 1) {
        if (sell) {
          profit += stockPrices[i] - boughtAt;
        }
        break;
      }
      if (buy && stockPrices[i] < stockPrices[i + 1] && stockPrices[i] < stockPrices[i - 1]) {
        boughtAt = stockPrices[i];
        sell = true;
        buy = false;
      } else if (sell
          && stockPrices[i] > stockPrices[i + 1]
          && stockPrices[i - 1] < stockPrices[i]) {
        profit += stockPrices[i] - boughtAt;
        buy = true;
        sell = false;
      }
      i++;
    }
    return profit;
  }
}
