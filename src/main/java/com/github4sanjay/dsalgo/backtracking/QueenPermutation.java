package com.github4sanjay.dsalgo.backtracking;

import com.github4sanjay.dsalgo.util.AlgoUtil;

public class QueenPermutation {

  public static void main(String[] args) {
    QueenPermutation.find(2);
  }

  private static void find(int n) {

    // find(n, new int[n][n], 1);
    // findAsCombination(n, new boolean[n], 0, 0, 0, "");
    findAs1DArray(2);
  }

  // permutation
  private static void find(int n, int[][] placed, int currentQueen) {

    if (currentQueen == n + 1) {
      AlgoUtil.print(placed);
      System.out.println();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (placed[i][j] == 0) {
          placed[i][j] = currentQueen;
          find(n, placed, currentQueen + 1);
          placed[i][j] = 0;
        }
      }
    }
  }

  // as combination
  private static void findAsCombination(
      int n, boolean[] placed, int queenPlacedSoFar, int row, int col, String answer) {

    if (row == n) {
      if (queenPlacedSoFar == n) {
        System.out.println(answer);
      }
      return;
    }

    int nextRow = row;
    int nextCol = col + 1;
    char sep = '\t';
    if (col == n - 1) {
      nextRow = row + 1;
      nextCol = 0;
      sep = '\n';
    }

    for (int i = 0; i < n; i++) {
      if (!placed[i]) {
        placed[i] = true;
        findAsCombination(
            n, placed, queenPlacedSoFar + 1, nextRow, nextCol, answer + "q" + (i + 1) + sep);
        placed[i] = false;
      }
    }

    findAsCombination(n, placed, queenPlacedSoFar, nextRow, nextCol, answer + "-" + sep);
  }

  /** as 1-d array row = index/n col = index%n index = row*n +col */
  public static void findAs1DArray(int n) {
    findAs1DArray(n, n * n, 0, 1, new int[n * n]);
  }

  private static void findAs1DArray(
      int n, int totalBoxes, int placedSoFar, int currentItem, int[] placed) {

    if (currentItem > n) {
      if (n == placedSoFar) {
        int[][] chess = new int[n][n];
        for (int i = 0; i < placed.length; i++) {
          chess[i / n][i % n] = placed[i];
        }
        AlgoUtil.print(chess);
        System.out.println();
      }
      return;
    }

    for (int i = 0; i < totalBoxes; i++) {
      if (placed[i] == 0) {
        placed[i] = currentItem;
        findAs1DArray(n, totalBoxes, placedSoFar + 1, currentItem + 1, placed);
        placed[i] = 0;
      }
    }
  }
}
