package com.github4sanjay.dsalgo.graph;

import com.github4sanjay.dsalgo.util.AlgoUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 1. You are given a graph and a source vertex. The vertices represent cities and the edges
 * represent distance in kms. 2. You are required to find the shortest path to each city (in terms
 * of kms) from the source city along with the total distance on path from source to destinations.
 */
public class DijkstraAlgorithm {

  public static void main(String[] args) {
    AlgoUtil.print(
        DijkstraAlgorithm.find(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 40},
              {3, 4, 2},
              {4, 5, 3},
              {5, 6, 3},
              {4, 6, 8},
              {2, 5, 5},
            },
            7,
            0));
  }

  /**
   * Same as BFS but here we use priority queue because we want to visit path which has less weight
   */
  private static List<Pair> find(int[][] ints, int vertices, int source) {
    var list = new ArrayList<Pair>();
    var graph = new Graph(ints, vertices);
    var visited = new boolean[vertices];
    var priorityQueue =
        new PriorityQueue<Pair>(); // pair is removed based on weight (smallest first)
    priorityQueue.add(new Pair(source, List.of(source), 0));
    while (!priorityQueue.isEmpty()) {
      var pair = priorityQueue.remove();
      if (visited[pair.vertex]) {
        continue;
      }
      visited[pair.vertex] = true;
      list.add(pair);
      for (var edge : graph.getEdges()[pair.vertex]) {
        if (!visited[edge.getNbr()]) {
          var newPath = new ArrayList<>(pair.path);
          newPath.add(edge.getNbr());
          priorityQueue.add(new Pair(edge.getNbr(), newPath, pair.weight + edge.getWt()));
        }
      }
    }
    return list;
  }

  private static class Pair implements Comparable<Pair> {
    Integer vertex;
    List<Integer> path;
    Integer weight;

    public Pair(int vertex, List<Integer> path, int weight) {
      this.vertex = vertex;
      this.path = path;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "Pair{" + "vertex=" + vertex + ", path=" + path + ", weight=" + weight + '}';
    }

    @Override
    public int compareTo(Pair o) {
      return this.weight.compareTo(o.weight);
    }
  }
}
