package util;

import java.util.Arrays;

public class ArrayUtil {

    public static int [][] copy2DArray(int[][] matrix){
        return Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
    }
}
