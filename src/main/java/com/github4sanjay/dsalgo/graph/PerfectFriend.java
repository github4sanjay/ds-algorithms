package com.github4sanjay.dsalgo.graph;

/**
 * 1. You are given a number n (representing the number of students). Each student will have an id
 * from 0 to n - 1. 2. You are given a number k (representing the number of clubs) 3. In the next k
 * lines, two numbers are given separated by a space. The numbers are ids of students belonging to
 * same club. 4. You have to find in how many ways can we select a pair of students such that both
 * students are from different clubs.
 */
public class PerfectFriend {

  public static void main(String[] args) {
    System.out.println(
        PerfectFriend.find(
            new int[][] {
              {0, 1},
              {2, 3},
              {4, 5},
              {5, 6},
              {4, 6},
            },
            7));
  }

  private static int find(int[][] relations, int number) {
    var graph = new Graph(relations, number);
    var clubs = GetConnectedComponentsInGraph.get(graph);

    int count = 0;
    for (int i = 0; i < clubs.size(); i++) {
      for (int j = i + 1; j < clubs.size(); j++) {
        count = count + clubs.get(i).size() * clubs.get(j).size();
      }
    }
    return count;
  }
}
