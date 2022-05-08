package com.github4sanjay.dsalgo.matrix;

import com.github4sanjay.dsalgo.util.AlgoUtil;

/**
 * { 1, 2, 3, 4 } [4, 3, 2, 1] { 5, 6, 7, 8 } [8, 7, 6, 5] { 9, 10, 11, 12 } -------> [12, 11, 10,
 * 9] { 13, 14, 15, 16 } [16, 15, 14, 13]
 */
public class ReverseColumn {

  public static void main(String[] args) {
    AlgoUtil.print(
        reverse(
            new int[][] {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}
            }));
  }

  public static int[][] reverse(int[][] mat) {
    int minC = 0, maxC = mat[0].length - 1;
    int count = mat[0].length / 2;
    while (count > 0) {
      for (int i = 0; i < mat.length; i++) {
        int temp = mat[i][minC];
        mat[i][minC] = mat[i][maxC];
        mat[i][maxC] = temp;
      }
      minC++;
      maxC--;
      count--;
    }
    return mat;
  }
}
