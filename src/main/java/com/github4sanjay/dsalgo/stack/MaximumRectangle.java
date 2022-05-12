package com.github4sanjay.dsalgo.stack;

/**
 * Maximal Rectangle Hard
 *
 * <p>1. Given a rows x cols binary matrix filled with 0's and 1's. 2. Find the largest rectangle
 * containing only 1's and return its area.
 *
 * <p>Constraints 1. 1 <= row, cols <= 200 2. matrix[i][j] is 0 or 1.
 *
 * <p>Format Input Input is managed for you
 *
 * <p>Output Output is managed for you
 *
 * <p>Example Sample Input
 *
 * <p>2 5 10100 10111
 *
 * <p>Sample Output 3
 */
public class MaximumRectangle {

  public static int find(int[][] input) {
    if (input.length == 0) return 0;
    var rowSum = new int[input[0].length];
    for (int i = 0; i < input[0].length; i++) {
      rowSum[i] = input[0][i];
    }
    int maxArea = LargestAreaHistogram.find(rowSum);
    for (int i = 1; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        // will add up only if it is 1 otherwise set it to 0
        if (input[i][j] == 1) {
          rowSum[j] = rowSum[j] + input[i][j];
        } else {
          rowSum[j] = 0;
        }
      }
      maxArea = Math.max(maxArea, LargestAreaHistogram.find(rowSum));
    }
    return maxArea;
  }
}
