package com.github4sanjay.dsalgo.graph;

import java.util.*;

/**
 * A Bipartite Graph is a graph whose vertices can be divided into two independent sets, U and V
 * such that every edge (u, v) either connects a vertex from U to V or a vertex from V to U. In
 * other words, for every edge (u, v), either u belongs to U and v to V, or u belongs to V and v to
 * U. We can also say that there is no edge that connects vertices of same set.
 *
 * <p>Set 1 Set2 0--------------3 0 1 | | | | 2 3 |______________| 1 2
 *
 * <p>here edge 0---1, 0---3, 2----3 and 1----2 are across set1 and set2 there is no edge between 0
 * & 2 and 1 & 3
 *
 * <p>If it is possible to divide vertices into two subsets such that both are mutually exclusive
 * and exhaustive such that all edges are across sets.
 */
public class IsGraphBipartite {

  public static void main(String[] args) {
    System.out.println(
        IsGraphBipartite.find(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 10},
              {3, 4, 10},
              {4, 5, 10},
              {5, 6, 10},
              {4, 6, 10},
            },
            7));

    System.out.println(
        IsGraphBipartite.find(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 10},
            },
            4)); // true
  }

  /**
   * If graph is : acyclic - Bipartite cyclic with even size - Bipartite cyclic with odd size - Non
   * Bipartite _____________________________________________________ | So not bipartite as 2 is not
   * exclusive | Example 1 BFS |____________________________________________________| 0 0--0--0 |
   * set1 | set2 | | \ / \ |________________________|___________________________| | \ 1--01--1
   * 2--02--1 | 0 (first level) | 1, 2 (second level) | | \ /
   * |________________________|___________________________| |____\ 2-012--2 | 2 (third level) | | 1
   * 2 |________________________|___________________________|
   *
   * <p>Example 2 BFS 0--------------3 0--0--0 _____________________________________________________
   * | | / \ | So not bipartite as 2 is not exclusive | | | 1--01--1 3--03--1
   * |____________________________________________________| |______________| / | | set1 | set2 | 1 2
   * 2-012--2 2-032--2 |________________________|___________________________| | 0 (first level) | 1,
   * 3 (second level) | |________________________|___________________________| both 2 at same level
   * so no ------>| 2, 2 (third level) | | issue take one
   * |________________________|___________________________|
   *
   * <p>Conclusion : If some vertex try to belong to both the sets than its non bipartite
   */
  private static boolean find(int[][] array, int vertices) {
    var graph = new Graph(array, vertices);
    var visited = new int[vertices];
    Arrays.fill(visited, -1); // -1 not visited
    for (int i = 0; i < vertices; i++) {
      if (visited[i] != -1) continue;
      if (isNonBipartite(graph, i, visited)) { // if any non-bipartite graph is non-bipartite
        return false;
      }
    }
    return true;
  }

  private static boolean isNonBipartite(Graph graph, int src, int[] visited) {
    var queue = new LinkedList<Pair>();
    queue.offer(new Pair(src, 0));
    while (!queue.isEmpty()) {
      var pair = queue.poll();
      if (visited[pair.vertex] != -1) {
        // if cyclic check already in other set
        var previousVisitedLevel = visited[pair.vertex];
        if (previousVisitedLevel % 2 != pair.level % 2) {
          return true;
        }
      }

      visited[pair.vertex] = pair.level; // set visited level for this vertex

      for (var edge : graph.getEdges()[pair.vertex]) {
        if (visited[edge.getNbr()] == -1) {
          queue.offer(new Pair(edge.getNbr(), pair.level + 1));
        }
      }
    }
    return false;
  }

  private static class Pair {
    int vertex;
    int level;

    public Pair(int vertex, int level) {
      this.vertex = vertex;
      this.level = level;
    }
  }
}
