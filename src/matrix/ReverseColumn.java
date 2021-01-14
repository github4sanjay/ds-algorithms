package matrix;

import util.AlgoUtil;

/**
 * { 1, 2, 3, 4 }                      [1, 5, 9, 13]
 * { 5, 6, 7, 8 }                      [2, 6, 10, 14]
 * { 9, 10, 11, 12 }     ------->      [3, 7, 11, 15]
 * { 13, 14, 15, 16 }                  [4, 8, 12, 16]
 */
public class ReverseColumn {

    public static void main(String[] args) {
        AlgoUtil.print(reverse(new int[][]{
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        }));
    }

    public static int[][] reverse(int[][] mat) {
        int minC = 0, maxC = mat[0].length-1;
        int count = mat[0].length/2;
        while (count > 0){
            for (int i=0; i< mat.length; i++){
                int temp = mat[i][minC];
                mat[i][minC] = mat[i][maxC];
                mat[i][maxC] = temp;
            }
            minC++; maxC--;
            count--;
        }
        return mat;
    }
}
