package com.github4sanjay.dsalgo.matrix;

import com.github4sanjay.dsalgo.util.AlgoUtil;

/**
 * Inplace rotate square matrix by 90 degrees | Set 1
 *
 * <p>Given a square matrix, turn it by 90 degrees in anti-clockwise direction without using any
 * extra space.
 *
 * <p>Examples :
 *
 * <p>Input: Matrix: 1 2 3 4 5 6 7 8 9 Output: 3 6 9 2 5 8 1 4 7 The given matrix is rotated by 90
 * degree in anti-clockwise direction.
 *
 * <p>Input: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 Output: 4 8 12 16 3 7 11 15 2 6 10 14 1 5 9 13
 * The given matrix is rotated by 90 degree in anti-clockwise direction.
 */
public class RotateBy90Degree {

  public static void main(String[] args) {

    /** 4 8 12 16 3 7 11 15 2 6 10 14 1 5 9 13 */
    AlgoUtil.print(
        rotateAntiClockWise(
            new int[][] {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}
            }));

    /** [13, 9, 5, 1] [14, 10, 6, 2] [15, 11, 7, 3] [16, 12, 8, 4] */
    AlgoUtil.print(
        rotateClockWise(
            new int[][] {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}
            }));
  }

  private static int[][] rotateAntiClockWise(int[][] mat) {
    TransPose.transPose(mat);
    ReverseRow.reverse(mat);
    return mat;
  }

  private static int[][] rotateClockWise(int[][] mat) {
    TransPose.transPose(mat);
    ReverseColumn.reverse(mat);
    return mat;
  }
}
