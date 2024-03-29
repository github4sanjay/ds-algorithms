package com.github4sanjay.dsalgo.matrix;

/*
 * Inplace rotate square matrix by 90 degrees | Set 1
 *
 * Given a square matrix, turn it by 90 degrees in anti-clockwise direction without using any
 * extra space.
 *
 * Examples :
 *
 * Input: Matrix: 1 2 3
 *                4 5 6
 *                7 8 9
 * Output: 3 6 9
 *         2 5 8
 *         1 4 7
 * The given matrix is rotated by 90 degree in anti-clockwise direction.
 *
 * Input: 1 2 3 4
 *        5 6 7 8
 *        9 10 11 12
 *        13 14 15 16
 * Output: 4 8 12 16
 *         3 7 11 15
 *         2 6 10 14
 *         1 5 9 13
 * The given matrix is rotated by 90 degree in anti-clockwise direction.
 */
public class RotateBy90Degree {

  public static int[][] rotateAntiClockWise(int[][] mat) {
    TransPose.transPose(mat);
    ReverseRow.reverse(mat);
    return mat;
  }

  public static int[][] rotateClockWise(int[][] mat) {
    TransPose.transPose(mat);
    ReverseColumn.reverse(mat);
    return mat;
  }
}
