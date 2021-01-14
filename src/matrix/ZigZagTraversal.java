package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Print matrix in zag-zag fashion
 * Given a matrix of 2D array of n rows and m coloumns. Print this matrix in ZIG-ZAG fashion as shown in figure.
 * matrix_zag-zag
 *
 * Example:
 *
 * Input:
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Output:
 * 1 2 4 7 5 3 6 8 9
 */
public class ZigZagTraversal {

    public static void main(String[] args) {
        System.out.println(ZigZagTraversal.traverse(new int[][]{
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 }
        })); // [1, 1, 2, 3, 2, 1, 1, 2, 3, 4, 4, 3, 2, 3, 4, 4]

        System.out.println(ZigZagTraversal.traverse(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        }));
    }

    private static List<Integer> traverse(int[][] ints) {
        var result = new ArrayList<Integer>();

        for (int gap=0; gap < ints.length;gap++){
            if (gap % 2 == 1){
                for (int i=0, j=gap; j>=0; i++, j--){
                    result.add(ints[i][j]);
                }
            } else {
                for (int j=0, i=gap; i>=0; i--, j++){
                    result.add(ints[i][j]);
                }
            }
        }

        for (int gap=1; gap < ints.length; gap++){
            if (gap % 2 == 1) {
                for (int i = ints.length-1, j = gap; j < ints[0].length; i--, j++) {
                    result.add(ints[i][j]);
                }
            } else {
                for (int i = gap, j = ints[0].length-1; i < ints.length; i++, j--) {
                    result.add(ints[i][j]);
                }
            }
        }

        return result;
    }
}
