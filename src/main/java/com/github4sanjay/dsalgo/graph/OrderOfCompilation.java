package com.github4sanjay.dsalgo.graph;

import java.util.List;

/**
 * 1. You are given a directed acyclic graph. The vertices represent tasks and edges represent
 * dependencies between tasks. 2. You are required to find and print the order in which tasks could
 * be done. The task that should be done at last should be printed first and the task which should
 * be done first should be printed last.
 */
public class OrderOfCompilation {

  public static void main(String[] args) {
    System.out.println(
        OrderOfCompilation.find(
            new int[][] {
              {0, 1},
              {1, 2},
              {2, 3},
              {0, 3},
              {4, 5},
              {5, 6},
              {4, 6},
            },
            7));
  }

  private static List<Integer> find(int[][] dependencies, int tasks) {
    return TopologicalSort.execute(dependencies, tasks);
  }
}
