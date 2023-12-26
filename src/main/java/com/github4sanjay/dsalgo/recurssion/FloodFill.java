package com.github4sanjay.dsalgo.recurssion;

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

  public static void fill(int[][] matrix, int srcR, int srcC, int newColor) {
    fill(
        matrix,
        srcR,
        srcC,
        matrix[srcR][srcC],
        newColor,
        new boolean[matrix.length][matrix[0].length]);
  }

  private static void fill(
      int[][] matrix, int srcR, int srcC, int oldColor, int newColor, boolean[][] visited) {
    if (srcR < 0 || srcC < 0 || srcR > matrix.length - 1 || srcC > matrix[0].length - 1) {
      return;
    }
    if (visited[srcR][srcC]) return;
    visited[srcR][srcC] = true;
    if (matrix[srcR][srcC] == oldColor) {
      matrix[srcR][srcC] = newColor;
      fill(matrix, srcR + 1, srcC, oldColor, newColor, visited);
      fill(matrix, srcR, srcC + 1, oldColor, newColor, visited);
      fill(matrix, srcR - 1, srcC, oldColor, newColor, visited);
      fill(matrix, srcR, srcC - 1, oldColor, newColor, visited);
    }
    visited[srcR][srcC] = false;
  }
}
