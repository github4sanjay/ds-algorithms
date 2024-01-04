package com.github4sanjay.dsalgo.dynamic.printresults;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 1. You are given a number n, representing the number of rows.
 2. You are given a number m, representing the number of columns.
 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
 6. Each cell has a value that is the amount of gold available in the cell.
 7. You are required to identify the maximum amount of gold that can be dug out from the mine.
 8. Also, you have to print all paths with maximum gold.

 Input Format
 A number n
 A number m
 e11
 e12..
 e21
 e22..
 .. n * m number of elements

 Sample Input
 6
 6
 0 1 4 2 8 2
 4 3 6 5 0 4
 1 2 4 1 4 6
 2 0 7 3 2 2
 3 1 5 9 2 4
 2 7 0 8 5 1

 Sample Output
 33
 4 d3 d1 d2 d3 d1

*/
public class FindAllPathsWithMaxGold {

  public static void main(String[] args) {
    System.out.println(
        FindAllPathsWithMaxGold.find(
            new int[][] {
              {0, 1, 4, 2, 8, 2},
              {4, 3, 6, 5, 0, 4},
              {1, 2, 4, 1, 4, 6},
              {2, 0, 7, 3, 2, 2},
              {3, 1, 5, 9, 2, 4},
              {2, 7, 0, 8, 5, 1}
            }));
  }

  private static Answer find(int[][] golds) {

    int[][] dp = new int[golds.length][golds[0].length];

    for (int j = dp[0].length - 1; j >= 0; j--) {
      for (int i = 0; i < dp.length; i++) {
        int max;
        if (j == dp[0].length - 1) {
          max = 0;
        } else if (i == 0) {
          max = Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
        } else if (i == dp.length - 1) {
          max = Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
        } else {
          max = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
        }
        dp[i][j] = golds[i][j] + max;
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < dp.length; i++) {
      max = Math.max(max, dp[i][0]);
    }

    var queue = new LinkedList<Node>();
    for (int i = 0; i < dp.length; i++) {
      if (dp[i][0] == max) {
        var path = new ArrayList<String>();
        path.add(String.valueOf(i));
        queue.push(new Node(i, 0, path));
      }
    }

    var list = new ArrayList<List<String>>();
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.col == dp[0].length - 1) {
        list.add(node.paths);
      } else if (node.row == 0) {
        var path = new ArrayList<>(node.paths);
        if (dp[node.row][node.col + 1] > dp[node.row + 1][node.col + 1]) {
          path.add("D2");
          queue.add(new Node(node.row, node.col + 1, path));
        } else {
          path.add("D3");
          queue.add(new Node(node.row + 1, node.col + 1, path));
        }
      } else if (node.row == dp.length - 1) {
        var path = new ArrayList<>(node.paths);
        if (dp[node.row][node.col + 1] > dp[node.row - 1][node.col + 1]) {
          path.add("D2");
          queue.add(new Node(node.row, node.col + 1, path));
        } else {
          path.add("D1");
          queue.add(new Node(node.row - 1, node.col + 1, path));
        }
      } else {
        var path = new ArrayList<>(node.paths);
        if (dp[node.row + 1][node.col + 1] > dp[node.row - 1][node.col + 1]) {
          if (dp[node.row + 1][node.col + 1] > dp[node.row][node.col + 1]) {
            path.add("D3");
            queue.add(new Node(node.row + 1, node.col + 1, path));
          } else {
            path.add("D2");
            queue.add(new Node(node.row, node.col + 1, path));
          }
        } else {
          if (dp[node.row - 1][node.col + 1] > dp[node.row][node.col + 1]) {
            path.add("D2");
            queue.add(new Node(node.row - 1, node.col + 1, path));
          } else {
            path.add("D2");
            queue.add(new Node(node.row, node.col + 1, path));
          }
        }
      }
    }
    return new Answer(max, list);
  }

  public static class Node {
    int row;
    int col;
    List<String> paths;

    public Node(int row, int col, List<String> paths) {
      this.row = row;
      this.col = col;
      this.paths = paths;
    }
  }

  public static class Answer {
    int maxGold;
    List<List<String>> path;

    public Answer(int maxGold, List<List<String>> path) {
      this.maxGold = maxGold;
      this.path = path;
    }

    @Override
    public String toString() {
      return "Answer{" + "maxGold=" + maxGold + ", path=" + path + '}';
    }
  }
}
