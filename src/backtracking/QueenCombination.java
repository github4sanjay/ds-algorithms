package backtracking;

import util.AlgoUtil;

public class QueenCombination {


    public static void main(String[] args) {
        QueenCombination.find(3);
    }

    private static void find(int n) {
        // find(n, 0, 0, 0, "");
        // findAsPermutation(n, 0, -1, 0, new int[n][n]);
        findAs1DArrayPermutation(n);
    }

    // combination way
    private static void find(int n, int placedSoFar, int row, int col, String answer) {

        if (row == n){
            if (placedSoFar == n){
                System.out.print(answer);
            }
            return;
        }
        int nextRow = row;
        int nextCol = col+1;
        String yasf = answer + "q";
        String nasf = answer + "-";
        if (col == n-1){
            nextRow = row+1;
            nextCol = 0;
            yasf = answer + "q\n";
            nasf = answer + "-\n";

        }

        find(n, placedSoFar, nextRow, nextCol, nasf); // said no
        find(n, placedSoFar+1, nextRow, nextCol, yasf); // said yes
    }

    // as permutation
    public static void findAsPermutation(int n, int row, int col, int placedSoFar, int[][] placed){

        if (placedSoFar == n){
            AlgoUtil.print(placed);
            System.out.println();
            return;
        }

        for (int j= col+1; j < n; j++){
            placed[row][j] = 1;
            findAsPermutation(n, row, j, placedSoFar+1, placed);
            placed[row][j] = 0;
        }

        for (int i=row+1; i< n; i++){
            for (int j=0; j< n; j++){
                placed[i][j] = 1;
                findAsPermutation(n, i, j, placedSoFar+1, placed);
                placed[i][j] = 0;
            }
        }
    }

    /**
     * as 1-d array
     * row = index/n
     * col = index%n
     * index = row*n +col
     */
    public static void findAs1DArrayCombination(int n){
        findAs1DArrayCombination(n,n*n, 0, 0, new int[n][n]);
    }

    private static void findAs1DArrayCombination(int n, int totalBoxes, int placedSoFar, int index, int[][] placed) {

        if (index == totalBoxes){
            if (n == placedSoFar) {
                AlgoUtil.print(placed);
                System.out.println();
            }
            return;
        }

        findAs1DArrayCombination(n, totalBoxes, placedSoFar, index+1,  placed);
        placed[index/n][index%n] = 1;
        findAs1DArrayCombination(n, totalBoxes, placedSoFar+1, index+1,  placed);
        placed[index/n][index%n] = 0;
    }


    /**
     * as 1-d array
     * row = index/n
     * col = index%n
     * index = row*n +col
     */
    public static void findAs1DArrayPermutation(int n){
        findAs1DArrayPermutation(n,n*n, 0, -1, new int[n*n]);
    }

    private static void findAs1DArrayPermutation(int n, int totalBoxes, int placedSoFar, int lastIndex, int[] placed) {

        if (placedSoFar == n){
            int[][] chess = new int[n][n];
            for (int i=0; i< placed.length; i++){
                chess[i/n][i%n] = placed[i];
            }
            AlgoUtil.print(chess);
            System.out.println();
            return;
        }

        for (int i=lastIndex+1; i< totalBoxes; i++){
            if (placed[i] == 0){
                placed[i] = 1;
                findAs1DArrayPermutation(n, totalBoxes, placedSoFar+1, i,  placed);
                placed[i] = 0;
            }
        }
    }
}
