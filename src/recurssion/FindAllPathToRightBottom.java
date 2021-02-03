package recurssion;

public class FindAllPathToRightBottom {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 0, 0, 1, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0}
        };
        /**
         * Output:
         * rdddrrdr
         * rdddrrrd
         * rddrdrdr
         * rddrdrrd
         * rdrdldrrdr
         * rdrdldrrrd
         * rdrddrdr
         * rdrddrrd
         * rrdlddrrdr
         * rrdlddrrrd
         * rrdldrdrdr
         * rrdldrdrrd
         * rrddldrrdr
         * rrddldrrrd
         * rrdddrdr
         * rrdddrrd
         */
        FindAllPathToRightBottom.fill(arr);
    }

    private static void fill(int[][] arr) {
       fill(arr, 0, 0, "", new int[arr.length][arr[0].length]);
    }

    private static void fill(int[][] arr, int srcRow, int srcCol, String ans, int[][] visited){
        if (srcRow < 0 || srcCol < 0 || srcRow == arr.length || srcCol == arr[0].length ||
                arr[srcRow][srcCol] == 1 || visited[srcRow][srcCol] == 1){
            return;
        }

        if (srcRow == arr.length-1 && srcCol == arr[0].length-1){
            System.out.println(ans);
            return;
        }

        visited[srcRow][srcCol] = 1;

        fill(arr, srcRow-1, srcCol, ans + "t", visited);
        fill(arr, srcRow, srcCol-1, ans + "l", visited);
        fill(arr, srcRow+1, srcCol, ans + "d", visited);
        fill(arr, srcRow, srcCol+1, ans + "r", visited);

        visited[srcRow][srcCol] = 0;
    }
}
