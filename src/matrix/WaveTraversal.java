package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 1  2  3
 * 4  5  6
 * 7  8  9
 *
 * 1->4->7->8->5->2->3->6->9
 */
public class WaveTraversal {

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 1, 1 },
                { 2, 2, 2, 2 },
                { 3, 3, 3, 3 },
                { 4, 4, 4, 4 } };

        System.out.println(traverse(mat));
    }

    private static List<Integer> traverse(int[][] mat) {

        var result = new ArrayList<Integer>();
        for (int j=0; j<mat[0].length; j++){
            if (j%2 == 0){
                for (int i=0; i<mat.length; i++){
                    result.add(mat[i][j]);
                }
            } else {
                for (int i=mat.length -1; i>=0; i--){
                    result.add(mat[i][j]);
                }
            }
        }
        return result;
    }
}
