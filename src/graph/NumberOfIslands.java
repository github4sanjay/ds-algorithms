package graph;

/**
 * You are given a 2d array where 0's represent land and 1's represent water.
 * Assume every cell is linked to it's north, east, west and south cell.
 *
 * Find and count the number of islands.
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        System.out.println(NumberOfIslands.find(new int[][]{
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
        })); // 3

        System.out.println(NumberOfIslands.findAlt(new int[][]{
                {0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
        })); // 3
    }

    /**
     * Must fulfill:
     * 1. safe row and col
     * 2. should not be visited
     * 2. should be land i.e array[i][j] = 0
     */
    private static boolean canVisit(int[][] array, int row, int col, boolean[][] visited) {
        return isSafe(array, row, col) && !visited[row][col] && array[row][col] == 0;
    }

    private static boolean isSafe(int[][] array, int row, int col) {
        return row >= 0 && col >= 0 && row <= array.length - 1 && col <= array[row].length - 1;
    }

    public static int find(int[][] array) {
        boolean[][] visited = new boolean[array.length][array[0].length];
        int count = 0;
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j] == 0 && !visited[i][j]){
                    find(array, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void find(int[][] array, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        // up
        if (canVisit(array, row-1, col, visited)){
            find(array, row-1, col, visited);
        }

        // right
        if (canVisit(array, row, col+1, visited)){
            find(array, row, col+1, visited);
        }

        // down
        if (canVisit(array, row+1, col, visited)){
            find(array, row+1, col, visited);
        }

        // left
        if (canVisit(array, row, col-1, visited)){
            find(array, row, col-1, visited);
        }
    }

    public static int findAlt(int[][] array) {
        boolean[][] visited = new boolean[array.length][array[0].length];
        int count = 0;
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j] == 0 && !visited[i][j]){
                    findAlt(array, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void findAlt(int[][] array, int row, int col, boolean[][] visited) {
        if (!canVisit(array, row, col, visited)){
            return;
        }
        visited[row][col] = true;
        findAlt(array, row-1, col, visited);
        findAlt(array, row, col+1, visited);
        findAlt(array, row+1, col, visited);
        findAlt(array, row, col-1, visited);
    }
}
