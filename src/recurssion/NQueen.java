package recurssion;

public class NQueen {

    public static void main(String[] args) {
        /**
         * 0-1, 1-3, 2-0, 3-2,
         * 0-2, 1-0, 2-3, 3-1,
         */
        NQueen.place(4);
    }

    private static void place(int n) {
        place(new int[n][n], 0, "", new int[n], new int[2*n-1], new int[2*n-1]);
    }

    private static void place(int[][] chess, int row, String answer, int[] unsafeCol, int[] unsafeRightDia, int[] unsafeLeftDia) {
        if (row == chess.length){
            System.out.println(answer);
            return;
        }
        for (int col=0; col< chess.length; col++){
            if (isSafe(row, col, unsafeCol, unsafeRightDia, unsafeLeftDia)){
                chess[row][col] = 1;
                unsafeCol[col] = 1;
                unsafeRightDia[row+col] = 1;
                /**
                 * row+col
                 * 0 1 2 3
                 * 1 2 3 4
                 * 2 3 4 5
                 * 3 4 5 6
                 */
                unsafeLeftDia[row-col+ chess.length-1] = 1;
                /**
                 * row-col+ chess.length-1
                 * 3 2 1 0
                 * 4 3 2 1
                 * 5 4 3 2
                 * 6 5 4 3
                 */
                place(chess, row+1, answer+row+"-"+col+", ", unsafeCol, unsafeRightDia, unsafeLeftDia);
                chess[row][col] = 0;
                unsafeCol[col] = 0;
                unsafeRightDia[row+col] = 0;
                unsafeLeftDia[row-col+ chess.length-1] = 0;
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] unsafeCol, int[] unsafeRightDia, int[] unsafeLeftDia) {
        if (unsafeCol[col] == 1) return false;
        if (unsafeRightDia[row+col] == 1) return false;
        if (unsafeLeftDia[row-col+ unsafeCol.length-1] == 1) return false;
        return true;
    }
}
