package com.github4sanjay.dsalgo.dynamic.category2;

/**
 * 1. You are given a number n, representing the number of houses. 2. In the next n rows, you are
 * given 3 space separated numbers representing the cost of painting nth house with red or blue or
 * green color. 3. You are required to calculate and print the minimum cost of painting all houses
 * without painting any consecutive house with same color.
 *
 * <p>Given : R G B 1 5 7 5 8 4 3 2 9 1 2 4
 *
 * <p>Answer 8
 */
public class PaintHouse {

  public static void main(String[] args) {
    int[][] colorCost = {
      {1, 5, 7},
      {5, 8, 4},
      {3, 2, 9},
      {1, 2, 4}
    };

    System.out.println(PaintHouse.findMinCost(colorCost));
  }

  private static int findMinCost(int[][] colorCost) {
    return findMinCostDP(colorCost);
    // return findMinCostBruteForce(colorCost, 0, -1, 0);
  }

  private static int findMinCostDP(int[][] colorCost) {
    int[][] dp = new int[colorCost.length][colorCost[0].length];
    for (int i = 0; i < colorCost.length; i++) {
      for (int j = 0; j < colorCost[0].length; j++) {
        if (i == 0) {
          dp[i][j] = colorCost[i][j];
        } else {
          int minOfAllOtherColors = Integer.MAX_VALUE;
          for (int k = 0; k < colorCost[0].length; k++) { // find minimum of all other colors
            if (k == j) continue;
            minOfAllOtherColors = Math.min(minOfAllOtherColors, dp[i - 1][k]);
          }
          dp[i][j] = colorCost[i][j] + minOfAllOtherColors;
        }
      }
    }
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < colorCost[0].length; j++) {
      min = Math.min(min, dp[colorCost.length - 1][j]);
    }
    return min;
  }

  private static int findMinCostBruteForce(
      int[][] colorCost, int houseIndex, int previousColorChosen, int cost) {
    if (houseIndex == colorCost.length) {
      return cost;
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < colorCost[0].length; i++) {
      if (i != previousColorChosen || previousColorChosen == -1) {
        int currentCost =
            findMinCostBruteForce(colorCost, houseIndex + 1, i, cost + colorCost[houseIndex][i]);
        if (currentCost < min) {
          min = currentCost;
        }
      }
    }
    return min;
  }
}
