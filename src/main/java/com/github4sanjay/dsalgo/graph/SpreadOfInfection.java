package com.github4sanjay.dsalgo.graph;

import java.util.LinkedList;

/**
 * 1. You are given a graph, representing people and their connectivity. 2. You are also given a src
 * person (who got infected) and time t. 3. You are required to find how many people will get
 * infected in time t, if the infection spreads to neighbors of infected person in 1 unit of time.
 */
public class SpreadOfInfection {

  public static void main(String[] args) {
    System.out.println(
        SpreadOfInfection.find(
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
            7,
            6,
            3));
  }

  /**
   * Do BFS and remove from queue increase the counter if element is lesser level than given time
   */
  private static int find(int[][] ints, int vertices, int src, int time) {
    var graph = new Graph(ints, vertices);
    var queue = new LinkedList<Pair>();
    queue.offer(new Pair(src, 0));
    var visited = new boolean[vertices];
    int count = 0;
    while (!queue.isEmpty()) {
      var pair = queue.poll();
      if (visited[pair.vertex]) {
        continue;
      }
      visited[pair.vertex] = true;
      if (pair.level < time) {
        count++;
      } else { // no need to explore further deep
        break;
      }

      for (var edge : graph.getEdges()[pair.vertex]) {
        if (!visited[edge.getNbr()]) {
          queue.offer(new Pair(edge.getNbr(), pair.level + 1));
        }
      }
    }
    return count;
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
