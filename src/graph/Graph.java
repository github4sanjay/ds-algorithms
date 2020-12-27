package graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Edge>[] edges;

    public Graph(int[][] edges, int vertices) {
        this.edges = new ArrayList[vertices];
        for (int i=0;i< vertices;i++){
            this.edges[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            var edge1 = this.edges[edge[0]];
            edge1.add(new Edge(edge[0], edge[1], edge.length >= 3 ? edge[2] : 0)); //  put 0 when weight not passed

            var edge2 = this.edges[edge[1]];
            edge2.add(new Edge(edge[1], edge[0], edge.length >= 3 ? edge[2]: 0)); //  put 0 when weight not passed
        }
    }

    public Graph(int[][] edges, int vertices, boolean isDirected) {
        this.edges = new ArrayList[vertices];
        for (int i=0;i< vertices;i++){
            this.edges[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            var edge1 = this.edges[edge[0]];
            edge1.add(new Edge(edge[0], edge[1], edge.length >= 3 ? edge[2] : 0)); //  put 0 when weight not passed

            if (!isDirected){
                var edge2 = this.edges[edge[1]];
                edge2.add(new Edge(edge[1], edge[0], edge.length >= 3 ? edge[2]: 0)); //  put 0 when weight not passed
            }
        }
    }

    public List<Edge>[] getEdges() {
        return edges;
    }

    public static class Edge {
        private int src;
        private int nbr;
        private int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

        public int getSrc() {
            return src;
        }

        public void setSrc(int src) {
            this.src = src;
        }

        public int getNbr() {
            return nbr;
        }

        public void setNbr(int nbr) {
            this.nbr = nbr;
        }

        public int getWt() {
            return wt;
        }

        public void setWt(int wt) {
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int vertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i=0;i< vertices;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,3,40));
        graph[0].add(new Edge(0,1,10));

        graph[0].add(new Edge(1,0,10));
        graph[0].add(new Edge(1,2,10));

        graph[0].add(new Edge(2,3,10));
        graph[0].add(new Edge(2,1,10));

        graph[0].add(new Edge(3,0,40));
        graph[0].add(new Edge(3,2,10));
        graph[0].add(new Edge(3,4,2));

        graph[0].add(new Edge(4,3,2));
        graph[0].add(new Edge(4,5,3));
        graph[0].add(new Edge(4,6,3));

        graph[0].add(new Edge(5,4,3));
        graph[0].add(new Edge(5,6,3));

        graph[0].add(new Edge(6,4,3));
        graph[0].add(new Edge(6,5,8));

    }
}
