package graph;

import util.AlgoUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFS {

    public static void main(String[] args) {
        AlgoUtil.print(BFS.traverse(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10},
        }, 7, 2));
    }

    private static List<Pair> traverse(int[][] array, int vertices, int sourceVertex) {
        var list = new ArrayList<Pair>();
        var graph = new Graph(array, 7);
        var queue = new LinkedList<Pair>();
        var path = new ArrayList<Integer>();
        path.add(sourceVertex);
        queue.offer(new Pair(sourceVertex, path));
        var visited = new boolean[vertices];
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (visited[node.vertex]){
                continue;
            }
            visited[node.vertex] = true;
            list.add(node);

            for (var edge : graph.getEdges()[node.vertex]){
                if (!visited[edge.getNbr()]){
                    var newPath = new ArrayList<>(node.pathSoFar);
                    newPath.add(edge.getNbr());
                    queue.offer(new Pair(edge.getNbr(), newPath));
                }
            }
        }
        return list;
    }

    public static class Pair {
        int vertex;
        List<Integer> pathSoFar;

        public Pair(int vertex, List<Integer> pathSoFar) {
            this.vertex = vertex;
            this.pathSoFar = pathSoFar;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "vertex=" + vertex +
                    ", pathSoFar=" + pathSoFar +
                    '}';
        }
    }
}
