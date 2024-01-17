package com.github4sanjay.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if
 *                     for all directed edges uv, u appears before v in the graph
 *                                               ___________________
 *                                              |  Topological sort |
 *            ----------->   <-----             |         4         |
 *           0--------------3-------4           |         5         |
 *       |   |              |  ^  | | \     |   |         6         |
 *       |   |              |  |  | |  \    |   |         0         |
 *       V   |______________|  |  V |___\   V   |         1         |
 *           1             2       5     6      |         2         |
 *             --------->            --->       |         3         |
 *                                              |___________________|
 *                                                                              Stack
 *                                                                           |'''''''|
 *                                                                           |   4   |
 *             0                                                4            |   5   |
 *           /  \                                              / \           |   6   |
 *          1    3 <--- this will not be visited              5   6          |   0   |
 *          |               as already visited                |              |   1   |
 *          2                                                 6              |   2   |
 *          |                                                                |   3   |
 *          3 <--- once arrive here start putting in stack                   |_______|
 *
 *
 *
 */
public class TopologicalSort {

  public static void main(String[] args) {
    System.out.println(
        TopologicalSort.execute(
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

  public static List<Integer> execute(int[][] ints, int vertices) {
    var graph = new Graph(ints, vertices, true);
    var visited = new boolean[vertices];
    var stack = new Stack<Integer>();
    for (int i = 0; i < vertices; i++) {
      if (visited[i]) {
        continue;
      }
      dfs(graph, i, visited, stack);
    }
    var list = new ArrayList<Integer>();
    while (!stack.isEmpty()) {
      list.add(stack.pop());
    }
    return list;
  }

  private static void dfs(Graph graph, int src, boolean[] visited, Stack<Integer> stack) {
    visited[src] = true;
    for (var edge : graph.getEdges()[src]) {
      if (!visited[edge.getNbr()]) {
        dfs(graph, edge.getNbr(), visited, stack);
      }
    }
    stack.push(src); // all dependent are done now add this to stack
  }
}
