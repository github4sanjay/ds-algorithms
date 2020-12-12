package recurssion;

import java.util.Arrays;

public class KnightsTour {

    public static void main(String[] args) {
        KnightsTour.go(5, 2, 3);
    }

    private static void go(int n, int row, int col) {
        go(new int[n][n], row, col, 1);
    }

    private static void go(int[][] chess, int row, int col, int move) {
        if (row < 0 || col < 0 || col >= chess.length || row >= chess.length || chess[row][col] > 0){
            return;
        } else if (move == chess.length * chess.length){
            chess[row][col] = move;
            displayChess(chess);
            chess[row][col] = 0;
        }
        chess[row][col] = move;
        go(chess, row-2, col+1, move+1);
        go(chess, row-1, col+2, move+1);
        go(chess, row+1, col+2, move+1);
        go(chess, row+2, col+1, move+1);
        go(chess, row+2, col-1, move+1);
        go(chess, row+1, col-2, move+1);
        go(chess, row-1, col-2, move+1);
        go(chess, row-2, col-1, move+1);
        chess[row][col] = 0;
    }

    private static void displayChess(int[][] chess) {
        System.out.println(Arrays.deepToString(chess));
    }
}
