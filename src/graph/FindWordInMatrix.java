package graph;

import javax.annotation.processing.SupportedSourceVersion;

/**
 * Given a 2D grid of characters and a word, find all occurrences of the given word in the grid.
 * A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form).
 *
 * The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up and 4 Diagonal directions.
 *
 * Example:
 *
 * Input:  grid[][] = {"GEEKSFORGEEKS",
 *                     "GEEKSQUIZGEEK",
 *                     "IDEQAPRACTICE"};
 *         word = "GEEKS"
 *
 * Output: pattern found at 0, 0
 *         pattern found at 0, 8
 *         pattern found at 1, 0
 * Explanation: 'GEEKS' can be found as prefix of
 * 1st 2 rows and suffix of first row
 *
 * Input:  grid[][] = {"GEEKSFORGEEKS",
 *                     "GEEKSQUIZGEEK",
 *                     "IDEQAPRACTICE"};
 *         word = "EEE"
 *
 * Output: pattern found at 0, 2
 *         pattern found at 0, 10
 *         pattern found at 2, 2
 *         pattern found at 2, 12
 * Explanation: EEE can be found in first row
 * twice at index 2 and index 10
 * and in second row at 2 and 12
 */
public class FindWordInMatrix {

    public static void main(String[] args) {
        System.out.println(FindWordInMatrix.find(new int[][]{
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        }, "GEEKS"));

        System.out.println(FindWordInMatrix.find(new int[][]{
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'},
                {'G','E','E','K','S','F','O','R','E','E','E','K','S'},
                {'G','E','E','K','S','Q','U','L','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','U','A','C','T','I','C','E'},
                {'G','E','E','K','S','C','O','R','G','E','E','K','S'},
                {'G','E','E','K','E','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','L','A','P','R','A','C','T','I','C','E'},
                {'G','E','O','K','S','F','O','R','G','E','E','K','S'},
                {'G','M','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        }, "MOLECULE"));

        System.out.println(FindWordInMatrix.find(new int[][]{
                {'G','E','E','K','S','F','O','R','G','E','E','K','S'},
                {'G','E','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'},
                {'G','E','E','K','S','F','O','R','E','E','E','K','S'},
                {'G','E','E','K','S','Q','U','L','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','U','A','C','T','I','C','E'},
                {'G','E','E','K','S','C','O','R','G','E','E','K','S'},
                {'G','E','E','K','E','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','L','A','P','R','A','C','T','I','C','E'},
                {'G','E','O','K','S','F','O','R','G','E','E','K','S'},
                {'G','M','E','K','S','Q','U','I','Z','G','E','E','K'},
                {'I','D','E','Q','A','P','R','A','C','T','I','C','E'}
        }, "MICRO"));
    }

    private static boolean find(int[][] matrix, String word) {
        var visited = new boolean[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                if (find(matrix, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean find(int[][] matrix, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()){
            return true;
        } else if (word.charAt(index) != matrix[row][col]){
            return false;
        } else if (visited[row][col]){
            return false;
        } else {
            visited[row][col] = true;
        }

        if (canVisit(matrix, word, row-1, col, visited)){
            if (find(matrix, word, row-1, col, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row-1, col+1, visited)){
            if (find(matrix, word, row-1, col+1, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row, col+1, visited)){
            if (find(matrix, word, row, col+1, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row+1, col+1, visited)){
            if (find(matrix, word, row+1, col+1, index+1, visited)){
                return true;
            }
        }


        if (canVisit(matrix, word, row+1, col, visited)){
            if (find(matrix, word, row+1, col, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row+1, col-1, visited)){
            if (find(matrix, word, row+1, col-1, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row, col-1, visited)){
            if (find(matrix, word, row, col-1, index+1, visited)){
                return true;
            }
        }

        if (canVisit(matrix, word, row-1, col-1, visited)){
            if (find(matrix, word, row-1, col-1, index+1, visited)){
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }

    private static boolean canVisit(int[][] matrix, String word, int row, int col, boolean[][] visited) {
        if (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length && !visited[row][col]){
            return true;
        }
        return false;
    }
}
