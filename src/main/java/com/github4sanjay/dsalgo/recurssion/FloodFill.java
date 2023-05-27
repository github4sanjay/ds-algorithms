package com.github4sanjay.dsalgo.recurssion;

import com.github4sanjay.dsalgo.util.AlgoUtil;

/*
 Flood fill Algorithm – how to implement fill() in paint? In MS-Paint, when we take the brush to a
 pixel and click, the color of the region of that pixel is replaced with a new selected color.
 Following is the problem statement to do this task. Given a 2D screen, location of a pixel in the
 screen and a color, replace color of the given pixel and all adjacent same colored pixels with
 the given color.

 <p>Example:

 <p>Input: screen[M][N] = {
 {1, 1, 1, 1, 1, 1, 1, 2},
 {1, 1, 1, 1, 1, 1, 0, 0},
 {1, 0, 0, 1, 1, 0, 1, 1},
 {1, 2, 2, 2, 2, 0, 1, 0},
 {1, 1, 1, 2, 2, 0, 1, 0},
 {1, 1, 1, 2, 2, 2, 2, 0},
 {1, 1, 1, 1,1, 2, 1, 1},
 {1, 1, 1, 1, 1, 2, 2, 1},
 };
 x = 4, y = 4, newColor = 3 The values in the given 2D
 screen indicate colors of the pixels. x and y are coordinates of the brush, newColor is the color
 that should replace the previous color on screen[x][y] and all surrounding pixels with same
 color.

 <p>Output: Screen should be changed to following. screen[M][N] = {
 {1, 1, 1, 1, 1, 1, 1, 1},
 {1, 1, 1, 1, 1, 1, 0, 0},
 {1, 0, 0, 1, 1, 0, 1, 1},
 {1, 3, 3, 3, 3, 0, 1, 0},
 {1, 1, 1, 3, 3, 0, 1,0},
 {1, 1, 1, 3, 3, 3, 3, 0},
 {1, 1, 1, 1, 1, 3, 1, 1},
 {1, 1, 1, 1, 1, 3, 3, 1},
 };
*/
public class FloodFill {

  public static void main(String[] args) {
    var matrix =
        new int[][] {
          {1, 1, 1, 1, 1, 1, 1, 2},
          {1, 1, 1, 1, 1, 1, 0, 0},
          {1, 0, 0, 1, 1, 0, 1, 1},
          {1, 2, 2, 2, 2, 0, 1, 0},
          {1, 1, 1, 2, 2, 0, 1, 0},
          {1, 1, 1, 2, 2, 2, 2, 0},
          {1, 1, 1, 1, 1, 2, 1, 1},
          {1, 1, 2, 1, 1, 2, 2, 1},
        };
    FloodFill.fill(matrix, 4, 4, 3);
    AlgoUtil.print(matrix);
  }

  private static void fill(int[][] ints, int srcRow, int srcCol, int newColor) {
    var visited = new boolean[ints.length][ints[0].length];
    var oldColor = ints[srcRow][srcCol];
    ints[srcRow][srcCol] = newColor;
    fill(ints, srcRow, srcCol, oldColor, newColor, visited);
  }

  private static void fill(
      int[][] matrix, int srcRow, int srcCol, int oldColor, int newColor, boolean[][] visited) {

    if (visited[srcRow][srcCol]) {
      return;
    }

    visited[srcRow][srcCol] = true;
    if (canVisit(matrix, srcRow - 1, srcCol, oldColor, visited)) {
      matrix[srcRow - 1][srcCol] = newColor;
      fill(matrix, srcRow - 1, srcCol, oldColor, newColor, visited);
    }

    if (canVisit(matrix, srcRow, srcCol - 1, oldColor, visited)) {
      matrix[srcRow][srcCol - 1] = newColor;
      fill(matrix, srcRow, srcCol - 1, oldColor, newColor, visited);
    }

    if (canVisit(matrix, srcRow + 1, srcCol, oldColor, visited)) {
      matrix[srcRow + 1][srcCol] = newColor;
      fill(matrix, srcRow + 1, srcCol, oldColor, newColor, visited);
    }

    if (canVisit(matrix, srcRow, srcCol + 1, oldColor, visited)) {
      matrix[srcRow][srcCol + 1] = newColor;
      fill(matrix, srcRow, srcCol + 1, oldColor, newColor, visited);
    }
  }

  private static boolean canVisit(
      int[][] matrix, int row, int col, int oldColor, boolean[][] visited) {
    return isSafe(row, col, matrix.length - 1, matrix[0].length - 1)
        && !visited[row][col]
        && matrix[row][col] == oldColor;
  }

  private static boolean isSafe(int row, int col, int rowLength, int colLength) {
    return row >= 0 && col >= 0 && row <= rowLength && col <= colLength;
  }
}
