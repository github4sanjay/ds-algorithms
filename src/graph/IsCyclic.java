package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IsCyclic {

    public static void main(String[] args) {
        System.out.println(IsCyclic.find(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
        }, 7)); // false

        System.out.println(IsCyclic.find(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10},
                {2, 5, 10},
        }, 7)); // true
    }

    /**
     *   Example :
     *
     *   0----------1    3-----------4
     *
     *       4----------5
     *        \        /
     *         \      /
     *          \    /
     *            6
     *
     *   When loop reaches vertex 4 :
     *   then 4 either go 5 or 6 first:
     *   if chooses 5 first then path would 4---5---6 then stop
     *   then it start for 6 but since six already visited so there are two paths to 6 from 4 so cyclic
     */
    private static boolean find(int[][] array, int vertices) {
        var graph = new Graph(array, vertices);

        var visited = new boolean[vertices];
        for (int i=0; i< vertices; i++){ // for every vertex need to do BFS
            if (visited[i]){
                continue;
            }

            if (doBFS(graph, i, visited)){
                return true;
            }
        }
        return false;
    }

    private static boolean doBFS(Graph graph, int src, boolean[] visited) {
        var queue = new LinkedList<Pair>();
        queue.offer(new Pair(src, List.of(src)));
        while (!queue.isEmpty()){
            var pair = queue.remove();
            if (visited[pair.vertex]){ // already visited this from some other route so cyclic
                return true;
            }
            visited[pair.vertex] = true;

            for (var edge : graph.getEdges()[pair.vertex]){
                if (!visited[edge.getNbr()]){
                    var newPath = new ArrayList<>(pair.pathSoFar);
                    newPath.add(edge.getNbr());
                    queue.offer(new Pair(edge.getNbr(), newPath));
                }
            }

        }
        return false;
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
