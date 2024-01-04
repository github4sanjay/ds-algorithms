package com.github4sanjay.dsalgo.dynamic.printresults;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 1. You are given a number n, representing the number of rows.
 2. You are given a number m, representing the number of columns.
 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
 4. You are standing in top-left cell and are required to move to bottom-right cell.
 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
 7. You are required to traverse through the matrix and print the cost of the path which is least costly.
 8. Also, you have to print all the paths with minimum cost.

 input

 0 1 4 2 8 2
 4 3 6 5 0 4
 1 2 4 1 4 6
 2 0 7 3 2 2
 3 1 5 9 2 4
 2 7 0 8 5 1

 output

 23
 HVVHHVHVHV
 HVVHHVHHVV

*/
public class FindAllPathsWithMinCost {

  public static int recursion(int[][] maze) {
    return recursion(maze, maze.length - 1, maze[0].length - 1);
  }

  private static int recursion(int[][] maze, int destinationRow, int destinationColumn) {
    if (destinationRow < 0 || destinationColumn < 0) {
      return Integer.MAX_VALUE;
    }
    if (destinationRow == 0 && destinationColumn == 0) {
      return maze[0][0];
    }

    return maze[destinationRow][destinationColumn]
        + Math.min(
            recursion(maze, destinationRow - 1, destinationColumn),
            recursion(maze, destinationRow, destinationColumn - 1));
  }

  public static int memoization(int[][] maze) {
    var dp = new Integer[maze.length][maze[0].length];
    dp[maze.length - 1][maze[0].length - 1] =
        memoization(maze, maze.length - 1, maze[0].length - 1, dp);
    return dp[maze.length - 1][maze[0].length - 1];
  }

  private static int memoization(
      int[][] maze, int destinationRow, int destinationColumn, Integer[][] dp) {
    if (destinationRow < 0 || destinationColumn < 0) {
      return Integer.MAX_VALUE;
    }
    if (destinationRow == 0 && destinationColumn == 0) {
      return maze[0][0];
    }

    if (dp[destinationRow][destinationColumn] != null) {
      return dp[destinationRow][destinationColumn];
    }

    dp[destinationRow][destinationColumn] =
        maze[destinationRow][destinationColumn]
            + Math.min(
                memoization(maze, destinationRow - 1, destinationColumn, dp),
                memoization(maze, destinationRow, destinationColumn - 1, dp));
    return dp[destinationRow][destinationColumn];
  }

  public static int tabulation(int[][] maze) {
    var dp = new Integer[maze.length][maze[0].length];
    dp[0][0] = tabulation(maze, maze.length - 1, maze[0].length - 1, dp);
    return dp[0][0];
  }

  private static int tabulation(
      int[][] maze, int DESTINATION_ROW, int DESTINATION_COLUMN, Integer[][] dp) {
    for (int destinationRow = DESTINATION_ROW; destinationRow >= 0; destinationRow--) {
      for (int destinationColumn = DESTINATION_COLUMN;
          destinationColumn >= 0;
          destinationColumn--) {
        if (destinationRow == DESTINATION_ROW && destinationColumn == DESTINATION_COLUMN) {
          dp[destinationRow][destinationColumn] = maze[destinationRow][destinationColumn];
          continue;
        }

        if (destinationRow + 1 > DESTINATION_ROW) {
          dp[destinationRow][destinationColumn] =
              maze[destinationRow][destinationColumn] + dp[destinationRow][destinationColumn + 1];
        } else if (destinationColumn + 1 > DESTINATION_COLUMN) {
          dp[destinationRow][destinationColumn] =
              maze[destinationRow][destinationColumn] + dp[destinationRow + 1][destinationColumn];
        } else {
          dp[destinationRow][destinationColumn] =
              maze[destinationRow][destinationColumn]
                  + Math.min(
                      dp[destinationRow + 1][destinationColumn],
                      dp[destinationRow][destinationColumn + 1]);
        }
      }
    }
    return dp[0][0];
  }

  /*
   [23, 23, 24, 20, 21, 19],
   [24, 22, 23, 18, 13, 17],
   [20, 19, 17, 13, 13, 13],
   [21, 19, 19, 12, 9, 7],
   [23, 20, 19, 16, 7, 5],
   [23, 21, 14, 14, 6, 1]

   Add first move depending on cost to the queue
   23 < 24 so first add H to queue
   if both are equal then add both
  */
  public static Answer find(int[][] ints) {
    int[][] dp = new int[ints.length][ints[0].length];
    dp[ints.length - 1][ints[0].length - 1] = ints[ints.length - 1][ints[0].length - 1];

    for (int i = dp.length - 1; i >= 0; i--) {
      for (int j = dp[i].length - 1; j >= 0; j--) {
        int min = 0;
        if (i == dp.length - 1 && j == dp[i].length - 1) continue;
        if (i == dp.length - 1) {
          min = dp[i][j] + dp[i][j + 1];
        } else if (j == dp[i].length - 1) {
          min = dp[i][j] + dp[i + 1][j];
        } else {
          min = Math.min(dp[i][j + 1], dp[i + 1][j]);
        }
        dp[i][j] = min + ints[i][j];
      }
    }

    var list = new ArrayList<List<Character>>();
    var queue = new LinkedList<Node>();
    queue.push(new Node(0, 0, new ArrayList<>()));

    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node.col == dp.length - 1 && node.row == dp[0].length - 1) {
        list.add(node.paths);
        continue;
      }

      if (node.row == dp.length - 1) { // last row
        var path = new ArrayList<>(node.paths);
        path.add('H');
        queue.push(new Node(node.row, node.col + 1, path));
      } else if (node.col == dp[0].length - 1) { // last col
        var path = new ArrayList<>(node.paths);
        path.add('V');
        queue.push(new Node(node.row + 1, node.col, path));
      } else {
        if (dp[node.row][node.col + 1] > dp[node.row + 1][node.col]) {
          var path = new ArrayList<>(node.paths);
          path.add('V');
          queue.push(new Node(node.row + 1, node.col, path));
        } else if (dp[node.row][node.col + 1] < dp[node.row + 1][node.col]) {
          var path = new ArrayList<>(node.paths);
          path.add('H');
          queue.push(new Node(node.row, node.col + 1, path));
        } else {
          var path1 = new ArrayList<>(node.paths);
          path1.add('V');
          queue.push(new Node(node.row + 1, node.col, path1));

          var path = new ArrayList<>(node.paths);
          path.add('H');
          queue.push(new Node(node.row, node.col + 1, path));
        }
      }
    }

    return new Answer(dp[0][0], list);
  }

  public static class Node {
    int row;
    int col;
    int cost;
    List<Character> paths;

    public Node(int row, int col, List<Character> paths) {
      this.row = row;
      this.col = col;
      this.paths = paths;
    }
  }

  public static class Answer {
    int cost;
    List<List<Character>> paths;

    public Answer(int cost, List<List<Character>> paths) {
      this.cost = cost;
      this.paths = paths;
    }

    @Override
    public String toString() {
      return "Answer{" + "cost=" + cost + ", paths=" + paths + '}';
    }
  }
}
