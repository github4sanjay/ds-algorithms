package com.github4sanjay.dsalgo;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NonAttackingRooks {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 2, 14},
                {8, 3, 15}
        }));
    }

    public static int solution(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[] rowMax1 = new int[rows];  // First maximum value in each row
        int[] rowMax2 = new int[rows];  // Second maximum value in each row
        int[] colMax1 = new int[cols];  // First maximum value in each column
        int[] colMax2 = new int[cols];  // Second maximum value in each column

        // Find the first and second maximum values in each row
        for (int i = 0; i < rows; i++) {
            rowMax1[i] = Integer.MIN_VALUE;
            rowMax2[i] = Integer.MIN_VALUE;

            for (int j = 0; j < cols; j++) {
                if (A[i][j] >= rowMax1[i]) {
                    rowMax2[i] = rowMax1[i];
                    rowMax1[i] = A[i][j];
                } else if (A[i][j] > rowMax2[i]) {
                    rowMax2[i] = A[i][j];
                }
            }
        }

        // Find the first and second maximum values in each column
        for (int j = 0; j < cols; j++) {
            colMax1[j] = Integer.MIN_VALUE;
            colMax2[j] = Integer.MIN_VALUE;

            for (int i = 0; i < rows; i++) {
                if (A[i][j] >= colMax1[j]) {
                    colMax2[j] = colMax1[j];
                    colMax1[j] = A[i][j];
                } else if (A[i][j] > colMax2[j]) {
                    colMax2[j] = A[i][j];
                }
            }
        }

        // Find the maximum sum of two non-attacking rooks
        int maxSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currentSum = 0;
                if (A[i][j] == rowMax1[i]) {
                    currentSum += rowMax2[i];
                } else {
                    currentSum += rowMax1[i];
                }

                if (A[i][j] == colMax1[j]) {
                    currentSum += colMax2[j];
                } else {
                    currentSum += colMax1[j];
                }

                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

}
