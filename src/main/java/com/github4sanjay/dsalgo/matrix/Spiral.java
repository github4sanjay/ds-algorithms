package com.github4sanjay.dsalgo.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Print a given matrix in spiral form Given a 2D array, print it in spiral form. See the following
 * examples.
 *
 * <p>Examples:
 *
 * <p>Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * Explanation: The output is matrix in spiral format.
 *
 * <p>Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7
 * 8 9 10 11 Explanation :The output is matrix in spiral format.
 */
public class Spiral {

  public static void main(String[] args) {
    System.out.println(
        Spiral.antiClockWise(
            new int[][] {
              {1, 2, 3, 4, 5, 6},
              {7, 8, 9, 10, 11, 12},
              {13, 14, 15, 16, 17, 18}
            }));

    System.out.println(
        Spiral.clockWise(
            new int[][] {
              {1, 2, 3, 4, 5, 6},
              {7, 8, 9, 10, 11, 12},
              {13, 14, 15, 16, 17, 18}
            }));
  }

  private static List<Integer> clockWise(int[][] mat) {
    var list = new ArrayList<Integer>();

    var count = 1;
    int minR = 0, minC = 0;
    int maxR = mat.length - 1, maxC = mat[0].length - 1;
    var total = mat.length * mat[0].length;
    while (count <= total) {

      for (int k = minC; k <= maxC && count <= total; k++) {
        list.add(mat[minR][k]);
        count++;
      }
      minR++;

      for (int k = minR; k <= maxR && count <= total; k++) {
        list.add(mat[k][maxC]);
        count++;
      }
      maxC--;

      for (int k = maxC; k >= minC && count <= total; k--) {
        list.add(mat[maxR][k]);
        count++;
      }
      maxR--;

      for (int k = maxR; k >= minR && count <= total; k--) {
        list.add(mat[k][minC]);
        count++;
      }
      minC++;
    }
    return list;
  }

  private static List<Integer> antiClockWise(int[][] mat) {
    var list = new ArrayList<Integer>();

    var count = 1;
    int minR = 0, minC = 0;
    int maxR = mat.length - 1, maxC = mat[0].length - 1;
    var total = mat.length * mat[0].length;
    while (count <= total) {
      for (int k = minR; k <= maxR && count <= total; k++) {
        list.add(mat[k][minC]);
        count++;
      }
      minC++;

      for (int k = minC; k <= maxC && count <= total; k++) {
        list.add(mat[maxR][k]);
        count++;
      }
      maxR--;

      for (int k = maxR; k >= minR && count <= total; k--) {
        list.add(mat[k][maxC]);
        count++;
      }
      maxC--;

      for (int k = maxC; k >= minC && count <= total; k--) {
        list.add(mat[minR][k]);
        count++;
      }
      minR++;
    }
    return list;
  }
}
