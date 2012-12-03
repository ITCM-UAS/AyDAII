package Grafos;

import Graph.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListGraph extends AbstractGraph {

    private List<Edge>[] edges;

    public ListGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new List[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return edges[source].contains(new Edge(source, dest));
    }

    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected()) {
            edges[edge.getDest()].add(new Edge(edge.getDest(),
                    edge.getSource(),
                    edge.getWeight()));
        }
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }

    @Override
    public Edge getEdge(int source, int dest) {
        Edge target =
                new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source]) {
            if (edge.equals(target)) {
                return edge;
            }
        }

        return target;
    }
}
