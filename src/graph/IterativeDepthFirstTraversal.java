package graph;

import util.AlgoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeDepthFirstTraversal {

    public static void main(String[] args) {
        AlgoUtil.print(IterativeDepthFirstTraversal.traverse(new int[][]{
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

    // Same as BFS but instead of using queue here we use stack
    public static List<Pair> traverse(int[][] ints, int vertices, int source) {
        var graph = new Graph(ints, vertices);
        var visited = new boolean[vertices];
        var stack = new Stack<Pair>();
        stack.push(new Pair(source, List.of(source)));
        var list = new ArrayList<Pair>();
        while (!stack.isEmpty()){
            var pair = stack.pop();
            if (visited[pair.vertex]){
                continue;
            }
            visited[pair.vertex] = true;
            list.add(pair);
            for (var edge : graph.getEdges()[pair.vertex]){
                if (!visited[edge.getNbr()]){
                    var newPath = new ArrayList<>(pair.path);
                    newPath.add(edge.getNbr());
                    stack.push(new Pair(edge.getNbr(), newPath));
                }
            }
        }
        return list;
    }

    public static class Pair {
        int vertex;
        List<Integer> path;

        public Pair(int vertex, List<Integer> path) {
            this.vertex = vertex;
            this.path = path;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "vertex=" + vertex +
                    ", path=" + path +
                    '}';
        }
    }
}
