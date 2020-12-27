package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HasPathGraph {

    public static void main(String[] args) {

        System.out.println(HasPathGraph.hasPath(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10}
        }, 7, 0, 6));

        System.out.println(HasPathGraph.hasPathIterative(new int[][]{
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
     * if source and destination are equal then return true
     * other wise check in all neighbour
     * with the source = neighbour and same destination
     */
    public static boolean hasPath(int[][] array, int vertices, int src, int dest) {
        var graph = new Graph(array, vertices);
        var visited = new boolean[vertices];
        return hasPath(graph, src, dest, visited);
    }

    private static boolean hasPath(Graph graph, int src, int dest, boolean[] visited) {

        if (src == dest){
            return true;
        }

        visited[src] = true;

        var edges = graph.getEdges();
        var vertex1Edges = edges[src];
        for (var edge : vertex1Edges){
            if (!visited[edge.getNbr()]){
                return hasPath(graph, edge.getNbr(), dest, visited);
            }
        }

        return false;
    }

    private static boolean hasPathIterative(int[][] array, int vertices, int src, int dest) {
        var graph = new Graph(array, vertices);
        var visited = new boolean[graph.getEdges().length];
        var stack = new Stack<IterativeDepthFirstTraversal.Pair>();
        stack.push(new IterativeDepthFirstTraversal.Pair(src, List.of(src)));
        while (!stack.isEmpty()){
            var pair = stack.pop();
            if (visited[pair.vertex]){
                continue;
            }

            if (pair.vertex == dest){
                return true;
            }

            visited[pair.vertex] = true;
            for (var edge : graph.getEdges()[pair.vertex]){
                if (!visited[edge.getNbr()]){
                    var newPath = new ArrayList<>(pair.path);
                    newPath.add(edge.getNbr());
                    stack.push(new IterativeDepthFirstTraversal.Pair(edge.getNbr(), newPath));
                }
            }
        }

        return false;
    }
}
