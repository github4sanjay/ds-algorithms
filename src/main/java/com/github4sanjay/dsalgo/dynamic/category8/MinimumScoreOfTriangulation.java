package com.github4sanjay.dsalgo.dynamic.category8;

/**
 * 1. You are given an array of integers, which represents the vertices of an N-sided convex polygon
 * in clockwise order. 2. You have to triangulate the given polygon into N-2 triangles. 3. The value
 * of a triangle is the product of the labels of vertices of that triangle. 4. The total score of
 * the triangulation is the sum of the value of all the triangles. 5. You have to find the minimum
 * score of the triangulation of the given polygon.
 *
 * <p>input 1 2 3
 *
 * <p>output 6
 */
public class MinimumScoreOfTriangulation {

  public static void main(String[] args) {
    System.out.println(MinimumScoreOfTriangulation.find(new int[] {1, 2, 3}));
  }

  /**
   * b __________ c b __________ c b __________ c | | | .'| | | join bd | | ---------> | . ' | | | a
   * |_________|d a |'________|d a |_________|d keep ab as base abcd = adc + cd + abc abd + ab + bcd
   *
   * <p>Always keep first and last vertices as base and then look how many variations are possible.
   *
   * <p>| a | b | c | d | e | ____|_________|_________|__________|_________|__________| a a | 0 | 0
   * | abc | abcd | abcde | /\ ____|_________|_________|__________|_________|__________| e / \ b b |
   * x | 0 | 0 | bcd | bcde | | | ____|_________|_________|__________|_________|__________| d |___|
   * c c | x | x | 0 | 0 | cde | ae ____|_________|_________|__________|_________|__________| as
   * base d | x | x | x | 0 | 0 | ____|_________|_________|__________|_________|__________| e | x |
   * x | x | x | 0 | ____|_________|_________|__________|_________|__________|
   *
   * <p>abcde = max {abe + ab + bcde, ace + abc + cde, ade + abcd + ce} Here abe, ace, ade will come
   * from vertices values and rest from DP
   */
  private static int find(int[] verticesValues) {

    int[][] dp = new int[verticesValues.length][verticesValues.length];

    for (int gap = 0; gap < verticesValues.length; gap++) {
      for (int i = 0, j = gap; j < verticesValues.length; i++, j++) {
        if (gap == 0 || gap == 1) {
          dp[i][j] = 0;
        } else if (gap == 2) { // a*bc*, b*c*d, c*d*e
          dp[i][j] = verticesValues[i] * verticesValues[i + 1] * verticesValues[i + 2];
        } else {
          int min = Integer.MAX_VALUE;
          for (int k = i + 1; k <= j - 1; k++) {
            int triangleConsidered = verticesValues[i] * verticesValues[k] * verticesValues[j];
            int oneSideOfTriangle = dp[i][k];
            int otherSideOfTriangle = dp[k][j];
            min = Math.min(min, triangleConsidered + oneSideOfTriangle + otherSideOfTriangle);
          }
          dp[i][j] = min;
        }
      }
    }
    return dp[0][verticesValues.length - 1];
  }
}
