package com.github4sanjay.dsalgo.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * { 1, 2, 3, 4 }
 * { 5, 6, 7, 8 }
 * { 9, 10, 11, 12 }
 * { 13, 14, 15, 16 }
 *
 * [1, 6, 11, 16, 2, 7, 12, 3, 8, 4]
 */
public class DiagonalTraversal {

  public static List<Integer> traverseRight(int[][] mat) {
    var list = new ArrayList<Integer>();
    for (int gap = 0; gap < mat.length; gap++) {
      for (int i = 0, j = gap; j < mat[0].length; i++, j++) {
        list.add(mat[i][j]);
      }
    }
    return list;
  }

  public static List<Integer> traverseLeft(int[][] mat) {
    var list = new ArrayList<Integer>();
    for (int gap = 0; gap < mat.length; gap++) {
      for (int i = gap, j = 0; i < mat.length; i++, j++) {
        list.add(mat[i][j]);
      }
    }
    return list;
  }
}
