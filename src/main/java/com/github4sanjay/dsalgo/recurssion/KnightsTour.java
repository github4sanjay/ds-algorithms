package com.github4sanjay.dsalgo.recurssion;

import com.github4sanjay.dsalgo.util.ArrayUtil;
import java.util.ArrayList;

/*
 * 1. You are given a number n, the size of a chess board.
 * 2. You are given a row and a column, as a starting point for a knight piece.
 * 3. You are required to generate the all moves of a knight
 * starting in (row, col) such that knight visits all cells of the board exactly once.
 * 4. Complete the body of printKnightsTour function - without changing signature - to calculate and print all
 * configurations of the chess board representing the route of knight through the chess board. Use
 * sample input and output to get more idea.
 *
 * Note -> When moving from (r, c) to the possible 8 options give first precedence to
 * (r - 2, c + 1) and move in clockwise manner to explore other options.
 */
public class KnightsTour {

  public static ArrayList<int[][]> go(int n, int row, int col) {
    var list = new ArrayList<int[][]>();
    go(new int[n][n], row, col, 1, list);
    return list;
  }

  private static void go(int[][] chess, int row, int col, int move, ArrayList<int[][]> list) {
    if (row < 0 || col < 0 || col >= chess.length || row >= chess.length || chess[row][col] > 0) {
      return;
    } else if (move == chess.length * chess.length) {
      chess[row][col] = move;
      list.add(ArrayUtil.copy2DArray(chess));
      chess[row][col] = 0;
    }
    chess[row][col] = move;
    go(chess, row - 2, col + 1, move + 1, list);
    go(chess, row - 1, col + 2, move + 1, list);
    go(chess, row + 1, col + 2, move + 1, list);
    go(chess, row + 2, col + 1, move + 1, list);
    go(chess, row + 2, col - 1, move + 1, list);
    go(chess, row + 1, col - 2, move + 1, list);
    go(chess, row - 1, col - 2, move + 1, list);
    go(chess, row - 2, col - 1, move + 1, list);
    chess[row][col] = 0;
  }
}
