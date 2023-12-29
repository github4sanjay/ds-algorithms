package com.github4sanjay.dsalgo.dynamic.category2;

/*
 * 1. You are given a number n, representing the number of houses.
 * 2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
 * 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.
 *
 * Given :
 * R G B
 * 1 5 7
 * 5 8 4
 * 3 2 9
 * 1 2 4
 *
 * Answer 8
 *
 */
public class PaintHouse {

  /*
   * Base Case:
   * If i == -1, then return 0. It denotes that we don’t have any house to paint so the cost will be 0.
   *
   * Now, if we are choosing to paint the i-th house with j-th colour then we can’t paint the (i - 1)-th house with j-th colour.
   * Create a variable “ans” which will store the answer to the current sub-problem and initialise it with a very large integer.
   *
   * Start traversing through the possible colours using a variable ‘k’.
   * If (j != k) then we can choose the k-th colour to paint the (i - 1)-th house.
   * Therefore, ans = min(ans, cost[i][j] + getMinCost(i - 1, k))
   * Return the “ans”.
   */
  public static int recursion(int[][] colorCost) {
    var min = Integer.MAX_VALUE;
    for (int i = 0; i < colorCost[0].length; i++) {
      var cost = recursion(colorCost, colorCost.length - 1, i);
      min = Math.min(min, cost);
    }
    return min;
  }

  private static int recursion(int[][] colorCost, int houseIndex, int chosenColor) {

    if (houseIndex == 0) {
      return colorCost[houseIndex][chosenColor];
    }

    var min = Integer.MAX_VALUE;
    for (int k = 0; k < colorCost[0].length; k++) {
      if (k != chosenColor) {
        var currentCost =
            colorCost[houseIndex][chosenColor] + recursion(colorCost, houseIndex - 1, k);
        min = Math.min(min, currentCost);
      }
    }
    return min;
  }

  public static int memoization(int[][] colorCost) {
    var min = Integer.MAX_VALUE;
    var dp = new Integer[colorCost.length][colorCost[0].length];
    for (int i = 0; i < colorCost[0].length; i++) {
      var cost = memoization(colorCost, colorCost.length - 1, i, dp);
      min = Math.min(min, cost);
    }
    return min;
  }

  private static int memoization(
      int[][] colorCost, int houseIndex, int chosenColor, Integer[][] dp) {

    if (houseIndex == 0) {
      return colorCost[houseIndex][chosenColor];
    }

    if (dp[houseIndex][chosenColor] != null) {
      return dp[houseIndex][chosenColor];
    }

    var min = Integer.MAX_VALUE;
    for (int k = 0; k < colorCost[0].length; k++) {
      if (k != chosenColor) {
        var currentCost =
            colorCost[houseIndex][chosenColor] + memoization(colorCost, houseIndex - 1, k, dp);
        min = Math.min(min, currentCost);
      }
    }
    dp[houseIndex][chosenColor] = min;
    return min;
  }

  public static int tabulation(int[][] colorCost) {
    var min = Integer.MAX_VALUE;
    var dp = new Integer[colorCost.length][colorCost[0].length];
    for (int i = 0; i < colorCost.length; i++) {
      for (int j = 0; j < colorCost[0].length; j++) {
        if (i == 0) {
          dp[i][j] = colorCost[i][j];
          continue;
        }
        var cost = tabulation(colorCost, i, j, dp);
        if (i == colorCost.length - 1) { // answer is always stored in the last row(house)
          min = Math.min(min, cost);
        }
      }
    }
    return min;
  }

  private static int tabulation(
      int[][] colorCost, int houseIndex, int chosenColor, Integer[][] dp) {

    var min = Integer.MAX_VALUE;
    for (int k = 0; k < colorCost[0].length; k++) {
      if (k != chosenColor) {
        var currentCost = colorCost[houseIndex][chosenColor] + dp[houseIndex - 1][k];
        min = Math.min(min, currentCost);
      }
    }
    dp[houseIndex][chosenColor] = min;
    return dp[houseIndex][chosenColor];
  }
}
