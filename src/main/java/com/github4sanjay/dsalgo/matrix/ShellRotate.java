package com.github4sanjay.dsalgo.matrix;

import com.github4sanjay.dsalgo.array.Rotate;
import com.github4sanjay.dsalgo.util.AlgoUtil;

/**
 * You are given a n*m matrix where n are the number of rows and m are the number of columns. You
 * are also given n*m numbers representing the elements of the matrix. You will be given a ring
 * number 's' representing the ring of the matrix.
 *
 * <p>You will be given a number 'r' representing number of rotations in an anti-clockwise manner of
 * the specified ring. You are required to rotate the 's'th ring by 'r' rotations and display the
 * rotated matrix.
 */
public class ShellRotate {

  public static void main(String[] args) {
    AlgoUtil.print(
        rotateAntiClockWise(
            new int[][] {
              {1, 2, 3, 4},
              {5, 6, 7, 8},
              {9, 10, 11, 12},
              {13, 14, 15, 16}
            },
            2,
            2));

    AlgoUtil.print(
        rotateAntiClockWise(
            new int[][] {
              {1, 2, 3, 9, 4},
              {1, 2, 3, 9, 4},
              {5, 6, 7, 9, 8},
              {9, 10, 11, 9, 12},
              {13, 14, 15, 9, 16}
            },
            2,
            2));
  }

  private static int[][] rotateAntiClockWise(int[][] matrix, int shell, int rotate) {
    int[] shellAs1DArray = getShellAs1DArray(matrix, shell);
    Rotate.rotate(shellAs1DArray, rotate);
    fillShellFrom1DArray(matrix, shell, shellAs1DArray);
    return matrix;
  }

  private static void fillShellFrom1DArray(int[][] matrix, int shell, int[] shellAs1DArray) {
    int minR = shell - 1, minC = shell - 1;
    int maxR = matrix.length - shell, maxC = matrix[0].length - shell;
    int count = 0;
    for (int i = minR; i <= maxR; i++) {
      matrix[i][minC] = shellAs1DArray[count++];
    }
    minC++;

    for (int i = minC; i <= maxC; i++) {
      matrix[maxR][i] = shellAs1DArray[count++];
      ;
    }
    maxR--;

    for (int i = maxR; i >= minR; i--) {
      matrix[i][maxC] = shellAs1DArray[count++];
    }
    maxC--;

    for (int i = maxC; i >= minC; i--) {
      matrix[minR][i] = shellAs1DArray[count++];
    }
  }

  private static int[] getShellAs1DArray(int[][] matrix, int shell) {
    int minR = shell - 1, minC = shell - 1;
    int maxR = matrix.length - shell, maxC = matrix[0].length - shell;
    int[] result = new int[2 * (maxR - minR + maxC - minC)];
    int count = 0;
    for (int i = minR; i <= maxR; i++) {
      result[count++] = matrix[i][minC];
    }
    minC++;

    for (int i = minC; i <= maxC; i++) {
      result[count++] = matrix[maxR][i];
    }
    maxR--;

    for (int i = maxR; i >= minR; i--) {
      result[count++] = matrix[i][maxC];
    }
    maxC--;

    for (int i = maxC; i >= minC; i--) {
      result[count++] = matrix[minR][i];
    }

    return result;
  }
}
