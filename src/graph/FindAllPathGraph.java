package graph;

import java.util.ArrayList;
import java.util.List;
public class FindAllPathGraph {

    public static void main(String[] args) {

        System.out.println(FindAllPathGraph.findPath(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10}
        }, 7, 0, 6));

    }

    /**
     * if source and destination are equal then add current path to final list
     * other wise check in all neighbour
     * with the source = neighbour and same destination
     */
    public static List<List<Integer>> findPath(int[][] array, int vertices, int vertex1, int vertex2) {
        var graph = new Graph(array, vertices);
        var visited = new boolean[graph.getEdges().length];
        var currentPath = new ArrayList<Integer>();
        var allPaths = new ArrayList<List<Integer>>();
        currentPath.add(vertex1);
        findPath(graph, vertex1, vertex2, visited, currentPath, allPaths);
        return allPaths;
    }

    private static void findPath(Graph graph, int src, int dest, boolean[] visited, List<Integer> currentPath, List<List<Integer>> paths) {

        if (src == dest){
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        visited[src] = true;

        var edges = graph.getEdges();
        var vertex1Edges = edges[src];
        for (var edge : vertex1Edges){
            if (!visited[edge.getNbr()]){
                currentPath.add(edge.getNbr());
                findPath(graph, edge.getNbr(), dest, visited, currentPath, paths);
                currentPath.remove(currentPath.size()-1);
            }
        }
        visited[src] = false;
    }
}
