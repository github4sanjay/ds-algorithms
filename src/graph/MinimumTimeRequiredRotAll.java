package graph;

import java.util.LinkedList;

/**
 * Given a matrix of dimension m*n where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
 *
 * 0: Empty cell
 * 1: Cells have fresh oranges
 * 2: Cells have rotten oranges
 * Determine what is the minimum time required so that all the oranges become rotten.
 * A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right).
 * If it is impossible to rot every orange then simply return -1.
 *
 * Examples:
 *
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {1, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges can become rotten in 2-time frames.
 * Explanation:
 * At 0th time frame:
 *  {2, 1, 0, 2, 1}
 *  {1, 0, 1, 2, 1}
 *  {1, 0, 0, 2, 1}
 *
 * At 1st time frame:
 *  {2, 2, 0, 2, 2}
 *  {2, 0, 2, 2, 2}
 *  {1, 0, 0, 2, 2}
 *
 * At 2nd time frame:
 *  {2, 2, 0, 2, 2}
 *  {2, 0, 2, 2, 2}
 *  {2, 0, 0, 2, 2}
 *
 *
 * Input:  arr[][C] = { {2, 1, 0, 2, 1},
 *                      {0, 0, 1, 2, 1},
 *                      {1, 0, 0, 2, 1}};
 * Output:
 * All oranges cannot be rotten.
 * Explanation:
 * At 0th time frame:
 * {2, 1, 0, 2, 1}
 * {0, 0, 1, 2, 1}
 * {1, 0, 0, 2, 1}
 *
 * At 1st time frame:
 * {2, 2, 0, 2, 2}
 * {0, 0, 2, 2, 2}
 * {1, 0, 0, 2, 2}
 *
 * At 2nd time frame:
 * {2, 2, 0, 2, 2}
 * {0, 0, 2, 2, 2}
 * {1, 0, 0, 2, 2}
 * ...
 * The 1 at the bottom left corner of the matrix is never rotten.
 */
public class MinimumTimeRequiredRotAll {

    public static void main(String[] args) {
        System.out.println(MinimumTimeRequiredRotAll.smart(new int[][]{
                {2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        }));

        System.out.println(MinimumTimeRequiredRotAll.smart(new int[][]{
                {2, 1, 0, 2, 1},
                {0, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}
        }));
    }

    /**
     * Do BFS
     * First add all the rotten fruits in the queue
     * then keep on adding new fruits which are not rotten increasing the level
     * Once queue is empty if all the fruits are 2 then return count else return -1
     */
    private static int smart(int[][] fruits) {
        var queue = new LinkedList<Pair>();
        var visited = new boolean[fruits.length][fruits[0].length];
        // first put all the rotten at level 0
        for (int i=0; i<fruits.length;i++){
            for (int j=0; j< fruits[i].length; j++){
                if (fruits[i][j] == 2){
                    queue.offer(new Pair(i, j, 0));
                }
            }
        }

        int count = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            var pair = queue.poll();
            int row = pair.i;
            int col = pair.j;
            if (visited[row][col]){
                continue;
            }

            visited[row][col] = true;
            if (canVisit(row-1, col, fruits, visited)){
                fruits[row-1][col] = 2;
                queue.offer(new Pair(row-1, col, pair.level+1));
                count = Math.max(pair.level+1, count); // increase the counter
            }

            if (canVisit(row+1, col, fruits, visited)){
                fruits[row+1][col] = 2;
                queue.offer(new Pair(row+1, col, pair.level+1));
                count = Math.max(pair.level+1, count);
            }

            if (canVisit(row, col-1, fruits, visited)){
                fruits[row][col-1] = 2;
                queue.offer(new Pair(row, col-1, pair.level+1));
                count = Math.max(pair.level+1, count);
            }

            if (canVisit(row, col+1, fruits, visited)){
                fruits[row][col+1] = 2;
                queue.offer(new Pair(row, col+1, pair.level+1));
                count = Math.max(pair.level+1, count);
            }
        }

        for (int i=0; i<fruits.length;i++){
            for (int j=0; j< fruits[i].length; j++){
                if (fruits[i][j] == 1){ // if any left
                    return -1;
                }
            }
        }

        return count;
    }

    private static boolean canVisit(int row, int col, int[][] fruits, boolean[][] visited) {
        if (row >=0 && col >=0 && row < fruits.length
                && col < fruits[row].length && fruits[row][col] == 1
                && !visited[row][col]){
            return true;
        }
        return false;
    }

    private static class Pair {
        int i;
        int j;
        int level;

        public Pair(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
}
