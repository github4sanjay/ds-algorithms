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

  public static int recursion(int[] arr) {
    return recursion(arr, arr.length - 1, arr.length);
  }

  private static int recursion(int[] arr, int index, int size) {

    if (index == 0) {
      return arr[index] * size;
    }
    var notCut = recursion(arr, index - 1, size);
    var rodLength = index + 1;
    var cut = Integer.MIN_VALUE;
    if (rodLength <= size) {
      cut = arr[index] + recursion(arr, index, size - rodLength);
    }
    return Math.max(notCut, cut);
  }

  public static int memoization(int[] arr) {
    var dp = new Integer[arr.length][arr.length + 1];
    dp[arr.length - 1][arr.length] = memoization(arr, arr.length - 1, arr.length, dp);
    return dp[arr.length - 1][arr.length];
  }

  private static int memoization(int[] arr, int index, int size, Integer[][] dp) {
    if (index == 0) {
      return arr[index] * size;
    }

    if (dp[index][size] != null) {
      return dp[index][size];
    }
    var notCut = memoization(arr, index - 1, size, dp);
    var rodLength = index + 1;
    var cut = Integer.MIN_VALUE;
    if (rodLength <= size) {
      cut = arr[index] + memoization(arr, index, size - rodLength, dp);
    }
    dp[index][size] = Math.max(notCut, cut);
    return dp[index][size];
  }

  public static int tabulation(int[] arr) {
    var dp = new Integer[arr.length][arr.length + 1];
    dp[arr.length - 1][arr.length] = tabulation(arr, arr.length - 1, arr.length, dp);
    return dp[arr.length - 1][arr.length];
  }

  private static int tabulation(int[] arr, int INDEX, int SIZE, Integer[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int size = 0; size <= SIZE; size++) {
        if (index == 0) {
          dp[index][size] = arr[index] * size;
          continue;
        }
        var notCut = dp[index - 1][size];
        var rodLength = index + 1;
        var cut = Integer.MIN_VALUE;
        if (rodLength <= size) {
          cut = arr[index] + dp[index][size - rodLength];
        }
        dp[index][size] = Math.max(notCut, cut);
      }
    }
    return dp[INDEX][SIZE];
  }
}
