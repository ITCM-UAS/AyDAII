package Grafos;

import java.util.Iterator;

public class MatrixGraph extends AbstractGraph {

    private double[][] edges;

    public MatrixGraph(int numV, boolean directed) {
        super(numV, directed);
        edges = new double[numV][];
        if (!directed) {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new double[numV];
                for (int j = 0; j != numV; ++j) {
                    edges[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        } else {
            for (int i = 0; i != numV; ++i) {
                edges[i] = new double[i + 1];
                for (int j = 0; j != i + 1; ++j) {
                    edges[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    @Override
    public void insert(Edge edge) {
        setEdgeValue(edge.getSource(), edge.getDest(),
                edge.getWeight());
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return Double.POSITIVE_INFINITY != getEdgeValue(source, dest);
    }

    @Override
    public Edge getEdge(int source, int dest) {
        return new Edge(source, dest,
                getEdgeValue(source, dest));
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return new Iter(source);
    }

    private void setEdgeValue(int source, int dest, double wt) {
        if (isDirected() || source <= dest) {
            edges[source][dest] = wt;
        } else {
            edges[dest][source] = wt;
        }
    }

    private double getEdgeValue(int source, int dest) {
        if (isDirected() | source <= dest) {
            return edges[source][dest];
        } else {
            return edges[dest][source];
        }
    }

    private class Iter implements Iterator<Edge> {

        private int source;
        private int index;

        public Iter(int source) {
            this.source = source;
            index = -1;
            advanceIndex();
        }

        @Override
        public boolean hasNext() {
            return index != getNumV();
        }

        @Override
        public Edge next() {
            if (index == getNumV()) {
                throw new java.util.NoSuchElementException();
            }
            Edge returnValue = new Edge(source, index,
                    getEdgeValue(source, index));
            advanceIndex();
            return returnValue;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        private void advanceIndex() {
            do {
                index++;
            } while (index != getNumV() && Double.POSITIVE_INFINITY == getEdgeValue(source, index));
        }
    }
}
