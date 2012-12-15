package Grafos;

import java.util.HashSet;
import java.util.Set;

public class DijkstrasAlgorithm {

    public static void dijkstrasAlgorithm(Graph graph,
            int start,
            int[] pred,
            double[] dist) {
        int numV = graph.getNumV();
        Set<Integer> vMinusS = new HashSet<Integer>(numV);
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }
        while (vMinusS.size() != 0) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            vMinusS.remove(u);
            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight();
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }
 }
