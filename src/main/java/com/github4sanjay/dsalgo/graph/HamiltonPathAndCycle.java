package com.github4sanjay.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
 *
 * <p>A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge
 * (in the graph) from the last vertex to the first vertex of the Hamiltonian Path.
 *
 * <p>Given number of vertex, edges and a source vertex. Find paths and cycle.
 */
public class HamiltonPathAndCycle {

  public static void main(String[] args) {
    System.out.println(
        HamiltonPathAndCycle.find(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 10},
              {3, 4, 10},
              {4, 5, 10},
              {5, 6, 10},
              {4, 6, 10},
              {2, 5, 10},
            },
            7,
            0)); // Hamilton{path=[[0, 1, 2, 3, 4, 5, 6], [0, 1, 2, 3, 4, 6, 5]], cycle=[[0, 1, 2,
    // 5, 6, 4, 3], [0, 3, 4, 6, 5, 2, 1]]}
  }

  /**
   * 0_____________1 | | | | | | 3------------ 2 | _____| | | 4______5______6 |_____________|
   *
   * <p>Visit all paths starting from source until all vertices are visited if all nodes are visited
   * 1. if original source has edge to last vertex then hamilton cycle 2. else hamilton path
   */
  private static Hamilton find(int[][] array, int vertices, int sourceVertex) {
    var hamilton = new Hamilton();
    var graph = new Graph(array, vertices);
    var visited = new boolean[vertices];
    var path = new ArrayList<Integer>();
    path.add(sourceVertex);
    findHamilton(graph, sourceVertex, path, visited, hamilton);
    return hamilton;
  }

  private static void findHamilton(
      Graph graph, int src, ArrayList<Integer> path, boolean[] visited, Hamilton hamilton) {
    int count = 0;
    for (var vertex : visited) { // if don't want loop keep count
      if (vertex) {
        count++;
      }
    }
    if (count == visited.length - 1) { // if all nodes visited
      var originalSource = path.get(0);
      var originalSourceEdges = graph.getEdges()[originalSource];
      var isCycle = false;
      for (var edge : originalSourceEdges) {
        if (edge.getNbr() == src) { //  original source has edge to last vertex
          isCycle = true;
          break;
        }
      }
      if (isCycle) {
        hamilton.cycle.add(new ArrayList<>(path));
      } else {
        hamilton.path.add(new ArrayList<>(path));
      }
      return;
    }
    visited[src] = true;
    var edges = graph.getEdges()[src];
    for (var edge : edges) {
      if (!visited[edge.getNbr()]) {
        path.add(edge.getNbr());
        findHamilton(graph, edge.getNbr(), path, visited, hamilton);
        path.remove(path.size() - 1);
      }
    }
    visited[src] = false;
  }

  public static class Hamilton {
    List<List<Integer>> path;
    List<List<Integer>> cycle;

    public Hamilton() {
      this.path = new ArrayList<>();
      this.cycle = new ArrayList<>();
    }

    @Override
    public String toString() {
      return "Hamilton{" + "path=" + path + ", cycle=" + cycle + '}';
    }
  }
}
