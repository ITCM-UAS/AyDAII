package Grafos;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DepthFirstSearchNR {

    private Graph graph;
    private int[] parent;
    private boolean[] visited;
    private int[] discoveryOrder;
    private int[] finishOrder;

    public DepthFirstSearchNR(Graph graph) {
        Deque<Integer> previousVertex = new ArrayDeque<Integer>();
        Deque<Iterator<Edge>> previousIterator =
                new ArrayDeque<Iterator<Edge>>();
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        int discoveryIndex = 0;
        int finishIndex = 0;
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            discoveryOrder[i] = -1;
            finishOrder[i] = -1;
            visited[i] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                previousVertex.push(i);
                previousIterator.push(graph.edgeIterator(i));
                discoveryOrder[discoveryIndex++] = i;
                visited[i] = true;
                while (!previousVertex.isEmpty()) {
                    int currentVertex = previousVertex.peek();
                    Iterator<Edge> currentIterator = previousIterator.peek();
                    if (currentIterator.hasNext()) {
                        int child = currentIterator.next().getDest();
                        if (!visited[child]) {
                            parent[child] = currentVertex;
                            previousVertex.push(child);
                            previousIterator.push(graph.edgeIterator(child));
                            discoveryOrder[discoveryIndex++] = child;
                            visited[child] = true;
                        }
                    } else {
                        finishOrder[finishIndex++] = currentVertex;
                        previousIterator.pop();
                        previousVertex.pop();
                    }
                }
            }
        }
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