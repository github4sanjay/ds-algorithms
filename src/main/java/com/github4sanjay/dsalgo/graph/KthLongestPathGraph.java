package com.github4sanjay.dsalgo.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLongestPathGraph {

  public static void main(String[] args) {
    int[][] array =
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
        };
    int vertices = 7;

    var path = FindAllPathGraph.findPath(array, vertices, 0, 6);

    /*
     Answer{path=[0, 1, 2, 5, 6], weight=28}
     Answer{path=[0, 1, 2, 5, 4, 6], weight=36}
     Answer{path=[0, 1, 2, 3, 4, 5, 6], weight=38}
     Answer{path=[0, 1, 2, 3, 4, 6], weight=40}
     Answer{path=[0, 3, 4, 5, 6], weight=48}
     Answer{path=[0, 3, 4, 6], weight=50}
     Answer{path=[0, 3, 2, 5, 6], weight=58}
     Answer{path=[0, 3, 2, 5, 4, 6], weight=66}
    */
    for (int i = path.size(); i > 0; i--) {
      System.out.println(KthLongestPathGraph.findPath(array, vertices, 0, 6, i));
    }
  }

  /**
   * if source and destination are equal then check 1. if size of priority queue is greater than k
   * then check if peek's weight is less than current weight a. if yes then remove and add current
   * b. otherwise current path's weight is lesser than already k element in the queue so don't do
   * anything 2. if k is greater than size of priority queue than add this path to queue other wise
   * check in all neighbour with the source = neighbour and same destination
   */
  public static Answer findPath(int[][] array, int vertices, int vertex1, int vertex2, int k) {
    var graph = new Graph(array, vertices);
    var visited = new boolean[vertices];
    var currentPath = new ArrayList<Integer>();
    var priorityQueue = new PriorityQueue<Answer>();
    currentPath.add(vertex1);
    findPath(graph, vertex1, vertex2, k, visited, currentPath, 0, priorityQueue);
    return priorityQueue.remove();
  }

  private static void findPath(
      Graph graph,
      int src,
      int dest,
      int k,
      boolean[] visited,
      List<Integer> currentPath,
      int currentWeight,
      PriorityQueue<Answer> priorityQueue) {

    if (src == dest) {
      if (k > priorityQueue.size()) {
        var answer = new Answer();
        answer.path = new ArrayList<>(currentPath);
        answer.weight = currentWeight;
        priorityQueue.add(answer);
      } else {
        var peek = priorityQueue.peek();
        if (peek.weight < currentWeight) {
          priorityQueue.remove();
          var answer = new Answer();
          answer.path = new ArrayList<>(currentPath);
          answer.weight = currentWeight;
          priorityQueue.add(answer);
        }
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
            k,
            visited,
            currentPath,
            currentWeight + edge.getWt(),
            priorityQueue);
        currentPath.remove(currentPath.size() - 1);
      }
    }
    visited[src] = false;
  }

  public static class Answer implements Comparable<Answer> {
    List<Integer> path;
    Integer weight;

    @Override
    public String toString() {
      return "Answer{" + "path=" + path + ", weight=" + weight + '}';
    }

    @Override
    public int compareTo(Answer o) { // ascending order
      return this.weight.compareTo(o.weight);
    }
  }
}
