package graph;

import util.AlgoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Prim’s Minimum Spanning Tree (MST)
 * Prim’s algorithm is also a Greedy algorithm. It starts with an empty spanning tree.
 * MST is
 * 1. subgraph
 * 2. connected and acyclic
 * 3. all vertices included
 */
public class PrimsAlgorithm {

    public static void main(String[] args) {
        AlgoUtil.print(PrimsAlgorithm.find(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 40},
                {3, 4, 2 },
                {4, 5, 3 },
                {5, 6, 3 },
                {4, 6, 8 },
        }, 7));
    }

    /**
     *
     * Vertices, edges and weights are given, start with 0 vertex with -1 as previous vertex
     *
     *             40          2                 Represent vertex/from vertex/weight
     *      0--------------3-------4                       0/-1/0
     *      |              |       | \                     /    \
     *  10  |              |10    3|  \8              1/0/10  3/0/40
     *      |______________|       |___\                |
     *      1     10      2       5  3  6            2/1/10
     *                                                  |
     *                                               3/2/10
     *                                                  |
     *                                               4/3/2
     *            after 4 this                       /    \
     *             one chosen -------------------->5/4/3  6/4/8
     *               as                             |
     *           weight is lesser                 6/5/3
     *
     *  Conclusion : Prims is same as dijkstra but priority will be based on weight
     */
    public static List<Pair> find(int[][] ints, int vertices) {
        var list = new ArrayList<Pair>();
        var graph = new Graph(ints, vertices);
        var queue = new PriorityQueue<Pair>();
        queue.add(new Pair(0, -1, 0));
        var visited = new boolean[vertices];
        while (!queue.isEmpty()){
            var pair = queue.remove();
            if (visited[pair.vertex]){
                continue;
            }
            visited[pair.vertex] = true;

            if (pair.previousVertex != -1){
                list.add(pair);
            }

            for (var edge : graph.getEdges()[pair.vertex]){
                if (!visited[edge.getNbr()]){
                    queue.add(new Pair(edge.getNbr(), pair.vertex, edge.getWt()));
                }
            }
        }
        return list;
    }


    public static class Pair implements Comparable<Pair>{
        int vertex;
        int previousVertex;
        Integer weight;

        public Pair(int vertex, int previousVertex, int weight) {
            this.vertex = vertex;
            this.previousVertex = previousVertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "vertex=" + vertex +
                    ", previousVertex=" + previousVertex +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight.compareTo(o.weight);
        }
    }

}
