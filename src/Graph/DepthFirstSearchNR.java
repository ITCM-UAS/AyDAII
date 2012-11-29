package Graph;

import java.util.Iterator;
import java.util.Deque;
import java.util.ArrayDeque;

/** Class to implement the depth-first search algorithm.
 *   @author Koffman and Wolfgang
 **/
public class DepthFirstSearchNR {

    // Data Fields
    /** A reference to the graph being searched. */
    private Graph graph;
    /** Array of parents in the depth-first search tree. */
    private int[] parent;
    /** Flag to indicate whether this vertex has been visited. */
    private boolean[] visited;
    /** The array that contains each vertex in discovery order. */
    private int[] discoveryOrder;
    /** The array that contains each vertex in finish order. */
    private int[] finishOrder;

    // Constructors
    /*<exercise chapter="10" section="4" type="programming" number="2">*/
    /**
     * Construct the depth-first search of a Graph
     * starting at vertex 0 and visiting the start vertices in
     * ascending order.
     * Depth-First Search is performed without using recursion
     * @param graph The graph
     */
    public DepthFirstSearchNR(Graph graph) {
        // Use a Deque as a Stack
        // Stack to hold the last previous vertex
        Deque<Integer> previousVertex = new ArrayDeque<Integer>();
        // Stack to hole the previous edge iterator
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
        // Create DFS trees starting at each unvisited vertex
        for (int i = 0; i < n; i++) {
            // Put a starting value into each of the stacks.
            if (!visited[i]) {
                previousVertex.push(i);
                previousIterator.push(graph.edgeIterator(i));
                discoveryOrder[discoveryIndex++] = i;
                visited[i] = true;
                // Loop while there are still edges to explore
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
    /*</exercise>*/

    /** Get the finish order
     *  @return finish order
     */
    public int[] getFinishOrder() {
        return finishOrder;
    }

    /** Get the discovery  order
     *  @return discovery order
     */
    public int[] getDiscoveryOrder() {
        return discoveryOrder;
    }

    /** Get the parent
     *  @return the parent
     */
    public int[] getParent() {
        return parent;
    }
}
