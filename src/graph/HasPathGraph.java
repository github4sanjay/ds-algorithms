package graph;

public class HasPathGraph {

    public static void main(String[] args) {
        var graph = new Graph(new int[][]{
            {0, 1, 10},
            {1, 2, 10},
            {2, 3, 10},
            {0, 3, 10},
            {3, 4, 10},
            {4, 5, 10},
            {5, 6, 10},
            {4, 6, 10}
        }, 7);

        System.out.println(HasPathGraph.hasPath(graph, 0, 6));
    }

    /**
     * if source and destination are equal then return true
     * other wise check in all neighbour
     * with the source = neighbour and same destination
     */
    public static boolean hasPath(Graph graph, int vertex1, int vertex2) {
        var visited = new boolean[graph.getEdges().length];
        return hasPath(graph, vertex1, vertex2, visited);
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
}
