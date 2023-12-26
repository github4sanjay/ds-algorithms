package com.github4sanjay.dsalgo.backtracking;

import java.util.Arrays;

public class Sudoku {

  public static void fill(int[][] grid) {
    fill(grid, 0, 0);
  }

  private static void fill(int[][] grid, int row, int col) {

    if (row == grid.length) {
      for (int[] ints : grid) {
        System.out.println(Arrays.toString(ints));
      }
      System.out.println();
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
