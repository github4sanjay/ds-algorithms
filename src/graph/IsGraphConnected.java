package graph;

/**
 * Given a directed graph. The task is to check if the given graph is connected or not.
 *
 *
 *   Not Connected Graph
 *   0---1 2---3  4---5---6
 *                |______|
 *
 *
 *   Connected Graph
 *   0---1---2---3  4---6---7 5 8---9
 *           |______|   |__________|
 *
 */
public class IsGraphConnected {

    public static void main(String[] args) {

        System.out.println(IsGraphConnected.get(new Graph(new int[][]{
                {0, 1, 10},
                {2, 3, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10},
        }, 7))); // false

        System.out.println(IsGraphConnected.get(new Graph(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {0, 3, 10},
                {3, 4, 10},
                {4, 5, 10},
                {5, 6, 10},
                {4, 6, 10}
        }, 7)));  // true

        System.out.println(IsGraphConnected.get(new Graph(new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {4, 6, 10},
                {6, 7, 10},
                {8, 9, 10}
        }, 10)));  // false
    }

    private static boolean get(Graph graph) {
        return GetConnectedComponentsInGraph.get(graph).size() == 1;
    }
}
