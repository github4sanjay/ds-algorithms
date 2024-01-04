package com.github4sanjay.dsalgo.dynamic.printresults;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Question 1. You are given a number n, representing the count of elements. 2. You are given n
 * numbers. 3. You are given a number "tar". 4. You are required to calculate and print true or
 * false, if there is a subset the elements of which add up to "tar" or not. 5. Also, you have to
 * print the indices of elements that should be selected to achieve the given target. 6. You have to
 * print all such configurations.
 *
 * <p>Input Format A number n n1 n2 .. n number of elements A number tar
 *
 * <p>Sample Input 5 4 2 7 1 3 10
 *
 * <p>Sample Output true 2 4 1 2 3 0 1 3 4
 */
public class FindAllPathsWithTargetSumSubset {

  public static boolean recursion(int[] set, int targetSum) {
    return recursion(set, set.length - 1, targetSum);
  }

  private static boolean recursion(int[] set, int index, int targetSum) {
    if (index == 0) {
      if (targetSum == set[index]) {
        return true;
      } else {
        return false;
      }
    }
    var notTake = recursion(set, index - 1, targetSum);
    var take = false;
    if (set[index] <= targetSum) {
      take = recursion(set, index - 1, targetSum - set[index]);
    }
    return take || notTake;
  }

  public static boolean memoization(int[] set, int targetSum) {
    var dp = new Boolean[set.length][targetSum + 1];
    return memoization(set, set.length - 1, targetSum, dp);
  }

  private static boolean memoization(int[] set, int index, int targetSum, Boolean[][] dp) {
    if (index == 0) {
      if (targetSum == set[index]) {
        return true;
      } else {
        return false;
      }
    }

    if (dp[index][targetSum] != null) {
      return dp[index][targetSum];
    }
    var notTake = memoization(set, index - 1, targetSum, dp);
    var take = false;
    if (set[index] <= targetSum) {
      take = memoization(set, index - 1, targetSum - set[index], dp);
    }
    dp[index][targetSum] = take || notTake;
    return dp[index][targetSum];
  }

  public static boolean tabulation(int[] set, int targetSum) {
    var dp = new Boolean[set.length + 1][targetSum + 1];
    dp[set.length - 1][targetSum] = tabulation(set, set.length - 1, targetSum, dp);
    return dp[set.length - 1][targetSum];
  }

  private static boolean tabulation(int[] set, int INDEX, int TARGET_SUM, Boolean[][] dp) {
    for (int index = 0; index <= INDEX; index++) {
      for (int targetSum = 0; targetSum <= TARGET_SUM; targetSum++) {
        if (index == 0) {
          if (targetSum == 0) {
            dp[index][targetSum] = true;
            continue;
          }

          if (set[index] == targetSum) {
            dp[index][targetSum] = true;
            continue;
          } else {
            dp[index][targetSum] = false;
            continue;
          }
        }

        var notTake = dp[index - 1][targetSum];
        var take = false;
        if (set[index] <= targetSum) {
          take = dp[index - 1][targetSum - set[index]];
        }
        dp[index][targetSum] = take || notTake;
      }
    }
    return dp[INDEX][TARGET_SUM];
  }

  public static Answer find(int[] set, int targetSum) {
    var dp = new Boolean[set.length][targetSum + 1];
    dp[set.length - 1][targetSum] = tabulation(set, set.length - 1, targetSum, dp);
    var list = new ArrayList<List<Integer>>();
    var queue = new LinkedList<Node>();
    var path = new ArrayList<Integer>();
    queue.add(new Node(dp.length - 1, targetSum, path));
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.target == set[node.index] && node.index == 0) {
        node.path.add(node.index);
        list.add(node.path);
      } else if (node.target == 0 && node.index == 0) {
        list.add(node.path);
      } else {
        if (node.index - 1 < 0) {
          System.out.println();
        }
        if (node.index - 1 >= 0 && dp[node.index - 1][node.target]) { // excluded
          var newPath = new ArrayList<>(node.path);
          queue.add(new Node(node.index - 1, node.target, newPath));
        }

        if (node.index - 1 < 0) {
          System.out.println();
        }
        if (node.index - 1 >= 0 && node.target - set[node.index] >= 0) {
          if (dp[node.index - 1][node.target - set[node.index]]) {
            var newPath = new ArrayList<>(node.path);
            newPath.add(node.index);
            queue.add(new Node(node.index - 1, node.target - set[node.index], newPath));
          }
        }
      }
    }
    return new Answer(dp[dp.length - 1][dp[0].length - 1], list);
  }

  public static Answer findWithExtraAdding0(int[] arr, int targetSum) {
    boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][0] = true; // sum 0 is possible by all subsets
        } else if (i == 0) {
          dp[0][j] = false;
        } else if (j == 0) {
          dp[i][0] = true; // sum 0 is possible by all subsets
        } else {
          boolean ifNotTaken = dp[i - 1][j];
          boolean ifTaken = false;
          if (j - arr[i - 1] >= 0 && dp[i - 1][j - arr[i - 1]]) {
            ifTaken = true;
          }
          if (ifNotTaken || ifTaken) {
            dp[i][j] = true;
          }
        }
      }
    }

    var list = new ArrayList<List<Integer>>();
    var queue = new LinkedList<Node>();
    var path = new ArrayList<Integer>();
    queue.add(new Node(dp.length - 1, targetSum, path));
    while (!queue.isEmpty()) {
      var node = queue.pop();
      if (node.target == 0 && node.index == 0) {
        list.add(node.path);
      } else {
        if (dp[node.index - 1][node.target]) { // excluded
          var newPath = new ArrayList<>(node.path);
          queue.add(new Node(node.index - 1, node.target, newPath));
        }

        if (node.target - arr[node.index - 1] >= 0) {
          if (dp[node.index - 1][node.target - arr[node.index - 1]]) {
            var newPath = new ArrayList<>(node.path);
            newPath.add(node.index - 1);
            queue.add(new Node(node.index - 1, node.target - arr[node.index - 1], newPath));
          }
        }
      }
    }
    return new Answer(dp[dp.length - 1][dp[0].length - 1], list);
  }

  public static class Node {
    int index;
    int target;
    List<Integer> path;

    public Node(int index, int target, List<Integer> path) {
      this.index = index;
      this.target = target;
      this.path = path;
    }
  }

  public static class Answer {
    boolean available;
    List<List<Integer>> path;

    public Answer(boolean maxGold, List<List<Integer>> path) {
      this.available = maxGold;
      this.path = path;
    }

    @Override
    public String toString() {
      return "Answer{" + "available=" + available + ", path=" + path + '}';
    }
  }
}
