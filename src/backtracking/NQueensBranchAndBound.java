package backtracking;

import java.util.Arrays;

/**
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * For example, following is a solution for 4 Queen problem.
 * { 0,  1,  0,  0}
 * { 0,  0,  0,  1}
 * { 1,  0,  0,  0}
 * { 0,  0,  1,  0}
 */
public class NQueensBranchAndBound {

    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];
        solveQueen(board, 0);
    }

    private static boolean solveQueen(int[][] board, int col) {
        if (col >= board.length){
            System.out.println(Arrays.deepToString(board));
            return true;
        }
        boolean res = false;
        for (int i=0;i<board.length;i++){
            if (isSafe(board,i,col)){
                board[i][col] = 1;
                res = solveQueen(board, col + 1) || res;
                board[i][col] = 0;
            }
        }
        return res;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
}
