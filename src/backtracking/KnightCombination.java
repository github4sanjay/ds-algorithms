package backtracking;

import util.AlgoUtil;

public class KnightCombination {


    public static void main(String[] args) {
        KnightCombination.find(3);
    }

    private static void find(int n) {
        findAs1DArrayPermutation(n);
    }

    /**
     * as 1-d array
     * row = index/n
     * col = index%n
     * index = row*n +col
     */
    public static void findAs1DArrayPermutation(int n){
        findAs1DArrayPermutation(n,n*n, 0, -1, new boolean[n][n]);
    }

    private static void findAs1DArrayPermutation(int n, int totalBoxes, int placedSoFar, int lastIndex, boolean[][] placed) {

        if (placedSoFar == n){
            AlgoUtil.print(placed);
            System.out.println();
            return;
        }

        for (int i=lastIndex+1; i< totalBoxes; i++){
            int row = i/n;
            int col = i%n;
            if (!placed[row][col] && isSafe(row, col, placed, n)){
                placed[row][col] = true;
                findAs1DArrayPermutation(n, totalBoxes, placedSoFar+1, i,  placed);
                placed[row][col] = false;
            }
        }
    }

    private static boolean isSafe(int row, int col, boolean[][] placed, int n) {

        int row1 = row-1;
        int col1 = col-2;

        if (row1 >= 0 && col1 >= 0 && placed[row1][col1]){
          return false;
        }

        int row2 = row-2;
        int col2 = col-1;
        if (row2 >= 0 && col2 >= 0 && placed[row2][col2]){
            return false;
        }


        int row3 = row-2;
        int col3 = col+1;
        if (row3 >= 0 && col3 < n && placed[row3][col3]){
            return false;
        }

        int row4 = row-1;
        int col4 = col+2;
        if (row4 >= 0 && col4 < n && placed[row4][col4]){
            return false;
        }

        return true;
    }
}
