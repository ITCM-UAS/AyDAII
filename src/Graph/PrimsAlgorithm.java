package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/** A class for using Prim's algorithm.
 *  @author Koffman and Wolfgang
 */
public class PrimsAlgorithm {

    /*<listing chapter="10" number="8">*/
    /** 
     * Prim's Minimum Spanning Tree algorithm.
     * @param graph The weighted graph to be searched
     * @param start The start vertex
     * @return An ArrayList of edges that forms the MST
     */
    public static List<Edge> primsAlgorithm(Graph graph,
            int start) {
        List<Edge> result = new ArrayList<Edge>();
        int numV = graph.getNumV();
        // Use a HashSet to represent V�S.
        Set<Integer> vMinusS = new HashSet<Integer>(numV);
        // Declare the priority queue.
        Queue<Edge> pQ =
                new PriorityQueue<Edge>(numV, new CompareEdges());
        // Initialize V-S.
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        int current = start;
        // Main loop
        while (vMinusS.size() != 0) {
            // Update priority queue.
            Iterator<Edge> iter = graph.edgeIterator(current);
            while (iter.hasNext()) {
                Edge edge = iter.next();
                int dest = edge.getDest();
                if (vMinusS.contains(dest)) {
                    pQ.add(edge);
                }
            }
            // Find the shortest edge whose source is in S and
            // destination is in V�S.
            int dest = -1;
            Edge edge = null;
            do {
                edge = pQ.remove();
                dest = edge.getDest();
            } while (!vMinusS.contains(dest));
            // Take dest out of vMinusS.
            vMinusS.remove(dest);
            // Add edge to result.
            result.add(edge);
            // Make this the current vertex.
            current = dest;
        }
        return result;
    }
    /*</listing>*/
}
