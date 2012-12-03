package Grafos;

import Graph.*;
import java.util.Iterator;

public class DepthFirstSearch {

    private Graph graph;
    private int[] parent;
    private boolean[] visited;
    private int[] discoveryOrder;
    private int[] finishOrder;
    private int discoverIndex = 0;
    private int finishIndex = 0;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                depthFirstSearch(i);
            }
        }
    }

    public DepthFirstSearch(Graph graph, int[] order) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[order[i]]) {
                depthFirstSearch(i);
            }
        }
    }

    public void depthFirstSearch(int current) {
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;
        Iterator<Edge> itr = graph.edgeIterator(current);
        while (itr.hasNext()) {
            int neighbor = itr.next().getDest();
            if (!visited[neighbor]) {
                parent[neighbor] = current;
                depthFirstSearch(neighbor);
            }
        }
        finishOrder[finishIndex++] = current;
    }

    public int[] getFinishOrder() {
        return finishOrder;
    }

    public int[] getDiscoveryOrder() {
        return discoveryOrder;
    }

    public int[] getParent() {
        return parent;
    }
}
