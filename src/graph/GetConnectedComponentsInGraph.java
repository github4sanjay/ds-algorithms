package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected graph, print all connected components line by line. For example consider the following graph.
 *
 *   Example 1 : [[0, 1], [2, 3], [4, 5, 6]]
 *
 *   0---1 2---3  4---5---6
 *                |______|
 *
 *   Example 2 : [[0, 1, 2, 3], [4, 6, 7], [5], [8, 9]]
 *
 *   0---1---2---3  4---6---7 5 8---9
 *
 *
 */
public class GetConnectedComponentsInGraph {

    public static void main(String[] args) {
        var graph = new Graph(new int[][]{
                {0, 1, 10},
                {2, 3, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10},
        }, 7);

        System.out.println(GetConnectedComponentsInGraph.get(graph)); // [[0, 1], [2, 3], [4, 5, 6]]

        System.out.println(GetConnectedComponentsInGraph.get(new Graph(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10}
        }, 7)));  // [[0, 1, 2, 3, 4, 5, 6]]

        System.out.println(GetConnectedComponentsInGraph.get(new Graph(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {4, 6, 10},
                {6, 7, 10},
                {8, 9, 10}
        }, 10)));  // [[0, 1, 2, 3], [4, 6, 7], [5], [8, 9]]

    }

    /**
     * Find for all vertices all connected vertices and keep track of visited
     * if vertex already visited dont visit again
     */
    public static List<List<Integer>> get(Graph graph) {
        var visited = new boolean[graph.getEdges().length];
        var list = new ArrayList<List<Integer>>();
        for (int i=0; i<graph.getEdges().length; i++){
            if (visited[i]){
                continue;
            }
            var components = new ArrayList<Integer>();
            components.add(i);
            getComponent(graph, i, visited, components); // get components for vertex i
            list.add(components);
        }

        return list;
    }

    private static void getComponent(Graph graph, int src, boolean[] visited, List<Integer> components) {

        var edges = graph.getEdges()[src];
        visited[src] = true;
        for (var edge : edges){
            if (!visited[edge.getNbr()]){
                components.add(edge.getNbr());
                getComponent(graph, edge.getNbr(), visited, components);
            }
        }
    }
}
