package com.github4sanjay.dsalgo.matrix;

/**
 * Saddle point in a matrix
 *
 * <p>Given a matrix of n x n size, the task is to find the saddle point of the matrix. A saddle
 * point is an element of the matrix such that it is the minimum element in its row and maximum in
 * its column. Examples :
 *
 * <p>Input: Mat[3][3] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}} Output: 7 7 is minimum in its row and
 * maximum in its column.
 *
 * <p>Input: Mat[3][3] = {{1, 2, 3}, {4, 5, 6}, {10, 18, 4}} Output: No saddle point
 */
public class SadlePoint {

  public static void main(String[] args) {
    System.out.println(SadlePoint.find(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
  }

  public static int find(int[][] ints) {

    for (int i = 0; i < ints.length; i++) {
      int minCol = 0;
      for (int j = 0; j < ints[0].length; j++) {
        if (ints[i][minCol] > ints[i][j]) {
          minCol = j;
        }
      }
      var found = true;
      for (int k = 0; k < ints[0].length; k++) {
        if (ints[i][minCol] < ints[k][minCol]) {
          found = false;
          break;
        }
      }
      if (found) {
        return ints[i][minCol];
      }
    }
    throw new RuntimeException("not found");
  }
}
