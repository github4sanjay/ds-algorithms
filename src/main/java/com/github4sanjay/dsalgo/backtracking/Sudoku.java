package com.github4sanjay.dsalgo.backtracking;

import java.util.Arrays;

public class Sudoku {

  public static void main(String[] args) {
    int[][] grid = {
      {3, 0, 6, 5, 0, 8, 4, 0, 0},
      {5, 2, 0, 0, 0, 0, 0, 0, 0},
      {0, 8, 7, 0, 0, 0, 0, 3, 1},
      {0, 0, 3, 0, 1, 0, 0, 8, 0},
      {9, 0, 0, 8, 6, 3, 0, 0, 5},
      {0, 5, 0, 0, 9, 0, 6, 0, 0},
      {1, 3, 0, 0, 0, 0, 2, 5, 0},
      {0, 0, 0, 0, 0, 0, 0, 7, 4},
      {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    /**
     * Output: [3, 1, 6, 5, 7, 8, 4, 9, 2] [5, 2, 9, 1, 3, 4, 7, 6, 8] [4, 8, 7, 6, 2, 9, 5, 3, 1]
     * [2, 6, 3, 4, 1, 5, 9, 8, 7] [9, 7, 4, 8, 6, 3, 1, 2, 5] [8, 5, 1, 7, 9, 2, 6, 4, 3] [1, 3, 8,
     * 9, 4, 7, 2, 5, 6] [6, 9, 2, 3, 5, 1, 8, 7, 4] [7, 4, 5, 2, 8, 6, 3, 1, 9]
     */
    Sudoku.fill(grid);
  }

  private static void fill(int[][] grid) {
    fill(grid, 0, 0);
  }

  private static void fill(int[][] grid, int row, int col) {

    if (row == grid.length) {
      for (int[] ints : grid) {
        System.out.println(Arrays.toString(ints));
      }
      System.out.println("");
      return;
    }
    int nextRow = 0;
    int nextCol = 0;
    if (col == grid.length - 1) {
      nextRow = row + 1;
      nextCol = 0;
    } else {
      nextRow = row;
      nextCol = col + 1;
    }

    if (grid[row][col] != 0) {
      fill(grid, nextRow, nextCol);
    } else {
      for (int k = 1; k < 10; k++) {
        if (isSafe(grid, row, col, k)) {
          grid[row][col] = k;
          fill(grid, nextRow, nextCol);
          grid[row][col] = 0;
        }
      }
    }
  }

  private static boolean isSafe(int[][] grid, int row, int col, int num) {
    for (int j = 0; j < grid[0].length; j++) {
      if (grid[row][j] == num) {
        return false;
      }
    }

    for (int j = 0; j < grid.length; j++) {
      if (grid[j][col] == num) {
        return false;
      }
    }

    int startRow = 3 * (row / 3), startCol = 3 * (col / 3);
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (grid[i + startRow][j + startCol] == num) {
          return false;
        }
      }
    }

    return true;
  }
}
