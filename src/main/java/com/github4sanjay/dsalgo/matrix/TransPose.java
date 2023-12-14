package com.github4sanjay.dsalgo.matrix;

/*
 * { 1, 2, 3, 4 }              [1, 5, 9, 13]
 * { 5, 6, 7, 8 }              [2, 6, 10, 14]
 * { 9, 10, 11, 12 } -------> [3, 7, 11, 15]
 * { 13, 14, 15, 16 }         [4, 8, 12, 16]
 */
public class TransPose {

  public static int[][] transPose(int[][] mat) {
    for (int i = 0; i < mat.length; i++) {
      for (int j = i; j < mat[0].length; j++) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
      }
    }
    return mat;
  }
}
