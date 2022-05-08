package com.github4sanjay.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;

public class CeilPathGraph {

  public static void main(String[] args) {
    var graph =
        new Graph(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 40},
              {3, 4, 2},
              {4, 5, 3},
              {5, 6, 3},
              {4, 6, 8},
              {2, 5, 5}
            },
            7);

    System.out.println(
        CeilPathGraph.findPath(graph, 0, 6, 30)); // Answer{path=[0, 1, 2, 5, 4, 6], weight=36}
  }

  /**
   * if source and destination are equal then check 1. if current weight is greater than ceil 2. and
   * smaller than previous path weight other wise check in all neighbour with the source = neighbour
   * and same destination
   */
  public static Answer findPath(Graph graph, int vertex1, int vertex2, int ceil) {
    var visited = new boolean[graph.getEdges().length];
    var currentPath = new ArrayList<Integer>();
    var answer = new Answer();
    answer.weight = Integer.MAX_VALUE;
    currentPath.add(vertex1);
    findPath(graph, vertex1, vertex2, ceil, visited, currentPath, 0, answer);
    return answer;
  }

  private static void findPath(
      Graph graph,
      int src,
      int dest,
      int ceil,
      boolean[] visited,
      List<Integer> currentPath,
      int currentWeight,
      Answer answer) {

    if (src == dest) {
      if (currentWeight < answer.weight && currentWeight > ceil) {
        answer.path = new ArrayList<>(currentPath);
        answer.weight = currentWeight;
      }
      return;
    }

    visited[src] = true;

    var edges = graph.getEdges();
    var vertex1Edges = edges[src];
    for (var edge : vertex1Edges) {
      if (!visited[edge.getNbr()]) {
        currentPath.add(edge.getNbr());
        findPath(
            graph,
            edge.getNbr(),
            dest,
            ceil,
            visited,
            currentPath,
            currentWeight + edge.getWt(),
            answer);
        currentPath.remove(currentPath.size() - 1);
      }
    }
    visited[src] = false;
  }

  public static class Answer {
    List<Integer> path;
    int weight;

    @Override
    public String toString() {
      return "Answer{" + "path=" + path + ", weight=" + weight + '}';
    }
  }
}
