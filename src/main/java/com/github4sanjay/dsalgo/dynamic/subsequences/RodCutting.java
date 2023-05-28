package com.github4sanjay.dsalgo.dynamic.subsequences;

/*
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 *
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */
public class RodCutting {

  public static void main(String[] args) {
    System.out.println(RodCutting.find(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    System.out.println(RodCutting.find(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));

    System.out.println(RodCutting.recursive(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    System.out.println(RodCutting.recursive(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));

    System.out.println(RodCutting.memoization(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    System.out.println(RodCutting.memoization(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));

    System.out.println(RodCutting.tabular(new int[] {1, 5, 8, 9, 10, 17, 17, 20}));
    System.out.println(RodCutting.tabular(new int[] {3, 5, 8, 9, 10, 17, 17, 20}));
  }

  /*
   * length  0  |  1   |    2   |    3   |    4   |   5    |   6   |   7    |    8  |
   * price   0  |  1   |    5   |    8   |    9   |  10    |  17   |  17    |   20  |
   * ___________|______|________|________|________|________|_______|________|_______|
   * dp      0  |  1   |   1+1  |   5+1  |   8+1  |  10+1  | 13+1  | 17+1   |  18+1 |
   *            |      |    vs  |   vs   |   vs   |   vs   |  vs   |  vs    |   vs  |
   *            |      |    5   |   1+5  |   5+5  |  8+5   | 10+5  | 13+5   |  17+5 |
   *            |      |   =5   |   vs   |   vs   |   vs   |  vs   |  vs    |   vs  |
   *            |      |        |   8    |   1+8  |  5+8   | 8+8   | 10+8   |  13+8 |
   *            |      |        |   =8   |   vs   |   vs   |  vs   |  vs    |   vs  |
   *            |      |        |        |    9   |  1+9   | 5+9   | 8+9    |  10+9 |
   *            |      |        |        |  =10   |   vs   |  vs   |  vs    |   vs  |
   *            |      |        |        |        |   10   | 1+10  | 5+10   |  8+10 |
   *            |      |        |        |        |  =13   |  vs   |  vs    |   vs  |
   *            |      |        |        |        |        |  17   | 1+17   |  5+17 |
   *            |      |        |        |        |        | =17   |  vs    |   vs  |
   *            |      |        |        |        |        |       |  17    |  1+17 |
   *            |      |        |        |        |        |       | =18    |   vs  |
   *            |      |        |        |        |        |       |        |   20  |
   *            |      |        |        |        |        |       |        |  =22  |
   *
   *
   * dp[i] = max profit at length i
   *        cutting length of j=0 to j=i from i
   *       ____________________________________________________________________
   *      |                                                                    |
   *      |  dp[4]=  8+1 when cut in length 3 and 1 = max in 3 + price of 1    |
   *      |          vs                                                        |
   *      |          5+5 when cut in length 2 and 2 = max in 2 + price of 2    |
   *      |          vs                                                        |
   *      |          1+8 when cut in length 1 and 3 = max in 1 + price of 3    |
   *      |          vs                                                        |
   *      |           9  when cut in length 4 and 0 = max in 0 + price of 4    |
   *      |         =10                                                        |
   *      |____________________________________________________________________|
   */
  public static int find(int[] prices) {

    int[] dp = new int[prices.length + 1];
    int[] newPrices = new int[prices.length + 1];
    for (int i = 1; i < newPrices.length; i++) {
      newPrices[i] = prices[i - 1];
    }

    dp[0] = 0;
    dp[1] = newPrices[1];
    for (int i = 2; i < dp.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = 0; j < i; j++) {
        int profit = dp[j] + newPrices[i - j];
        max = Math.max(max, profit);
      }
      dp[i] = max;
    }

    return dp[dp.length - 1];
  }

  public static int recursive(int[] prices) {
    return recursive(prices.length - 1, prices.length, prices);
  }

  private static int recursive(int i, int j, int[] prices) {
    if (j == 0) return 0;
    if (i == 0) return prices[0] * j;
    var notTake = recursive(i - 1, j, prices);
    var take = Integer.MIN_VALUE;
    int rodLength = i + 1;
    if (rodLength <= j) {
      take = prices[i] + recursive(i, j - rodLength, prices);
    }
    return Math.max(notTake, take);
  }

  public static int memoization(int[] prices) {
    return memoization(
        prices.length - 1, prices.length, prices, new Integer[prices.length][prices.length + 1]);
  }

  private static int memoization(int i, int j, int[] prices, Integer[][] dp) {
    if (j == 0) return 0;
    if (i == 0) return prices[0] * j;

    if (dp[i][j] != null) return dp[i][j];
    var notTake = recursive(i - 1, j, prices);
    var take = Integer.MIN_VALUE;
    int rodLength = i + 1;
    if (rodLength <= j) {
      take = prices[i] + recursive(i, j - rodLength, prices);
    }
    var result = Math.max(notTake, take);
    dp[i][j] = result;
    return result;
  }

  public static int tabular(int[] prices) {
    var dp = new int[prices.length][prices.length + 1];
    for (int i = 0; i < dp.length; i++) dp[i][0] = 0;
    for (int j = 0; j < dp[0].length; j++) dp[0][j] = prices[0] * j;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[0].length; j++) {
        var notTake = dp[i - 1][j];
        var take = Integer.MIN_VALUE;
        int rodLength = i + 1;
        if (rodLength <= j) {
          take = prices[i] + dp[i][j - rodLength];
        }
        var result = Math.max(notTake, take);
        dp[i][j] = result;
      }
    }

    return dp[prices.length - 1][prices.length];
  }
}
