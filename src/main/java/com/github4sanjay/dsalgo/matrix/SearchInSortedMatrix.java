package com.github4sanjay.dsalgo.matrix;

/**
 * Search in a row wise and column wise sorted matrix
 *
 * <p>Given an n x n matrix and a number x, find the position of x in the matrix if it is present in
 * it. Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in
 * increasing order. The designed algorithm should have linear time complexity. Example:
 *
 * <p>Input: mat[4][4] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
 * x = 29 Output: Found at (2, 1) Explanation: Element at (2,1) is 29
 *
 * <p>Input : mat[4][4] = { {10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
 * x = 100 Output : Element not found Explanation: Element 100 is not found
 */
public class SearchInSortedMatrix {

  public static void main(String[] args) {
    System.out.println(
        SearchInSortedMatrix.find(
            new int[][] {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}},
            29));

    System.out.println(
        SearchInSortedMatrix.find(
            new int[][] {
              {10, 20, 30, 40},
              {15, 25, 35, 45},
              {27, 29, 37, 48},
              {32, 33, 39, 50}
            },
            100));
  }

  private static Point find(int[][] ints, int n) {
    int row = ints.length - 1;
    int col = 0;
    while (row >= 0 && row < ints.length && col >= 0 && col < ints[0].length) {
      if (n == ints[row][col]) {
        return new Point(row, col);
      } else if (n > ints[row][col]) {
        col++;
      } else {
        row--;
      }
    }

    return null;
  }

  public static class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Point{" + "x=" + x + ", y=" + y + '}';
    }
  }
}
