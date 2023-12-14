package com.github4sanjay.dsalgo.matrix;

/*
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
 * 4. Consider this array a maze and a player enters from top-left corner in east direction.
 * 5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
 * 6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.
 */
public class ExitPointInMatrix {

  /*
   *              N
   *              ^
   *              |
   *              |
   * W <---------|-----------> E
   *            |
   *            |
   *            |
   *            v
   *            S
   *
   *  E = row, col+1
   *  S = row+1, col
   *  W = row, col-1
   *  N = row-1, col
   *
   * direction -->
   *  0 = E
   *  1 = S
   *  2 = W
   *  3 = N
   */
  public static Point find(int[][] mat) {
    int direction = 0; // initial east
    int i = 0, j = 0;
    while (true) {
      if (mat[i][j] == 1) {
        direction++;
        if (direction == 4) {
          direction = 0;
        }
      }

      if (direction == 0) {
        j++;
      } else if (direction == 1) {
        i++;
      } else if (direction == 2) {
        j--;
      } else {
        i--;
      }

      if (i < 0) {
        return new Point(0, j);
      } else if (i > mat.length - 1) {
        return new Point(mat.length - 1, j);
      } else if (j < 0) {
        return new Point(i, 0);
      } else if (j > mat[0].length - 1) {
        return new Point(i, mat[0].length - 1);
      }
    }
  }

  public static class Point {
    int row;
    int col;

    public Point(int row, int col) {
      this.row = row;
      this.col = col;
    }

    @Override
    public String toString() {
      return "Point{" + "row=" + row + ", col=" + col + '}';
    }
  }
}
