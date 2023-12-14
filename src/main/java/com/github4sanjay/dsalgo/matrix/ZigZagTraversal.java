package com.github4sanjay.dsalgo.matrix;

import java.util.ArrayList;
import java.util.List;

/*
 * Print matrix in zag-zag fashion Given a matrix of 2D array of n rows and m coloumns. Print this
 * matrix in ZIG-ZAG fashion as shown in figure. matrix_zag-zag
 *
 * Example:
 * Input: 1 2 3
 *        4 5 6
 *        7 8 9
 * Output: 1 2 4 7 5 3 6 8 9
 */
public class ZigZagTraversal {

  public static List<Integer> traverseOnlySquareMatrix(int[][] ints) {
    var result = new ArrayList<Integer>();

    boolean up = true;
    for (int gap = 0; gap < ints.length; gap++) {
      if (!up) {
        for (int i = 0, j = gap; j >= 0; i++, j--) {
          result.add(ints[i][j]);
        }
        up = true;
      } else {
        for (int j = 0, i = gap; i >= 0; i--, j++) {
          result.add(ints[i][j]);
        }
        up = false;
      }
    }

    for (int gap = 1; gap < ints.length; gap++) {
      if (up) {
        for (int i = ints.length - 1, j = gap; j < ints[0].length; i--, j++) {
          result.add(ints[i][j]);
        }
        up = false;
      } else {
        for (int i = gap, j = ints[0].length - 1; i < ints.length; i++, j--) {
          result.add(ints[i][j]);
        }
        up = true;
      }
    }

    return result;
  }

  public static List<Integer> traverse(int[][] ints) {
    var list = new ArrayList<Integer>();
    int row = ints.length;
    int column = ints[0].length;
    int currentRow = 0;
    int currentCol = 0;
    boolean up = true;
    while (currentRow < row && currentCol < column) {
      if (up) {
        while (currentRow > 0 && currentCol < column - 1) {
          list.add(ints[currentRow][currentCol]);
          currentRow--;
          currentCol++;
        }
        // add edge element here
        list.add(ints[currentRow][currentCol]);
        // increase current row/ column accordingly
        if (currentCol == column - 1) {
          currentRow++;
        } else {
          currentCol++;
        }
      } else {
        while (currentRow < row - 1 && currentCol > 0) {
          list.add(ints[currentRow][currentCol]);
          currentRow++;
          currentCol--;
        }
        list.add(ints[currentRow][currentCol]);
        if (currentRow == row - 1) {
          currentCol++;
        } else {
          currentRow++;
        }
      }
      up = !up;
    }
    return list;
  }
}
