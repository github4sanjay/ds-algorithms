package dynamic.category8;

/**
 *Count all possible paths from top left to bottom right of a Matrix without crossing the diagonal
 *
 * Given an integer N which denotes the size of a matrix, the task is to find the number of possible ways
 * to reach the bottom-right corner from the top-left corner of the matrix without crossing the diagonal of the matrix.
 * The possible movements from any cell (i, j) from the matrix are (i, j + 1) (Right) or (i + 1, j) (Down).
 */
public class WaysInMazeWithoutCrossingDiagonal {

    public static void main(String[] args) {
        System.out.println(WaysInMazeWithoutCrossingDiagonal.find(5));
    }

    /**
     * same as valley and mountains
     */
    private static int find(int n) {
        return CatalanNumber.find(n-1);
    }
}
