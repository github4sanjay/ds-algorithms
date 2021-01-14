package matrix;

import util.AlgoUtil;

/**
 * { 1, 2, 3, 4 }                    [13, 14, 15, 16]
 * { 5, 6, 7, 8 }                    [9, 10, 11, 12]
 * { 9, 10, 11, 12 }     ------->    [5, 6, 7, 8]
 * { 13, 14, 15, 16 }                [1, 2, 3, 4]
 */
public class ReverseRow {

    public static void main(String[] args) {
        AlgoUtil.print(reverse(new int[][]{
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        }));
    }

    public static int[][] reverse(int[][] mat) {
        int minR = 0, maxR = mat.length-1;
        int count = mat.length/2;
        while (count > 0){
            for (int j=0; j< mat[0].length; j++){
                int temp = mat[minR][j];
                mat[minR][j] = mat[maxR][j];
                mat[maxR][j] = temp;
            }
            minR++; maxR--;
            count--;
        }
        return mat;
    }
}
