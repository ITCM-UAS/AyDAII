/*<listing chapter="10" number="1">*/
package Grafos;

import Graph.*;
import java.util.Iterator;


public interface Graph {

    int getNumV();
    boolean isDirected();
    void insert(Edge edge);

    boolean isEdge(int source, int dest);

    Edge getEdge(int source, int dest);
    Iterator<Edge> edgeIterator(int source);
}


