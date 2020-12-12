package backtracking;

public class GoldMine {
    public static void main(String[] args) {
        /**
         * Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
         * Output: 28
         * Explanation:
         * [[1,0,7],
         *  [2,0,6],
         *  [3,4,5],
         *  [0,3,0],
         *  [9,0,20]]
         * Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
         */
        int[][] mine = new int[][]{
                {1,0,7},
                {2,0,6},
                {3,4,5},
                {0,3,0},
                {9,0,20}
        };
        System.out.println(GoldMine.collect(mine));
    }

    private static int collect(int[][] mine) {

        int max = Integer.MIN_VALUE;
        for (int i=0; i< mine.length; i++){
            for (int j=0; j< mine.length; j++){
                int collected = collect(mine, i, j, new boolean[mine.length][mine[0].length], 0);
                if (collected > max){
                    max = collected;
                }
            }
        }
        return max;
    }

    private static int collect(int[][] mine, int row, int col, boolean[][] visited, int sum) {
        if (row < 0 || col< 0 || row >= mine.length || col >= mine[0].length){
            return sum;
        }
        if (visited[row][col]) return 0;
        if (mine[row][col] == 0){
            return sum;
        }
        visited[row][col] = true;
        int top = collect(mine, row-1, col, visited, sum + mine[row][col]);
        int left = collect(mine, row, col-1, visited, sum + mine[row][col]);
        int down = collect(mine, row+1, col, visited, sum + mine[row][col]);
        int right = collect(mine, row, col+1, visited, sum + mine[row][col]);
        visited[row][col] = false;
        int max = top;
        if (left > max){
            max = left;
        }
        if (down > max){
            max = down;
        }
        if (right > max){
            max = right;
        }
        return max;
    }

}
