package com.github4sanjay.dsalgo.graph;

/**
 * 1. You are given a graph and a source vertex. The vertices represent computers and the edges
 * represent length of LAN wire required to connect them. 2. You are required to find the minimum
 * length of wire required to connect all PCs over a network.
 */
public class MinimumWireRequiredToConnectAllPcs {

  public static void main(String[] args) {
    System.out.println(
        MinimumWireRequiredToConnectAllPcs.find(
            new int[][] {
              {0, 1, 10},
              {1, 2, 10},
              {2, 3, 10},
              {0, 3, 40},
              {3, 4, 2},
              {4, 5, 3},
              {5, 6, 3},
              {4, 6, 8},
            },
            7));
  }

  private static int find(int[][] costs, int pcs) {
    var list = PrimsAlgorithm.find(costs, pcs);
    int sum = 0;
    for (var pair : list) {
      sum = sum + pair.weight;
    }
    return sum;
  }
}
