/*<listing chapter="10" number="5">*/
package Graph;

import java.io.FileReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

/** Program to solve a maze represented as a graph.
 *  This program performs a breadth-first search of the graph
 *  to find the "shortest" path from the start vertex to the
 *  end. It is assumed that the start vertex is 0, and the
 *  end vertex is numV-1.
 *  @author Koffman and Wolfgang
 */
public class Maze {

    /** Main method to solve the maze.
     *  pre: args[0] contains the name of the input file.
     *  @param args Command line argument
     */
    public static void main(String[] args) {
        int numV = 0; // The number of vertices.
        Graph theMaze = null;
        // Load the graph data from a file.
        try {
            Scanner scan = new Scanner(new FileReader(args[0]));
            theMaze = AbstractGraph.createGraph(scan, false, "List");
            numV = theMaze.getNumV();
        } catch (IOException ex) {
            System.err.println("IO Error while reading graph");
            System.err.println(ex.toString());
            System.exit(1);
        }
        // Perform breadth-first search.
        int parent[] =
                BreadthFirstSearch.breadthFirstSearch(theMaze, 0);
        // Construct the path.
        Deque<Integer> thePath = new ArrayDeque<Integer>();
        int v = numV - 1;
        while (parent[v] != -1) {
            thePath.push(new Integer(v));
            v = parent[v];
        }
        // Output the path.
        System.out.println("The Shortest path is:");
        while (!thePath.isEmpty()) {
            System.out.println(thePath.pop());
        }
    }
}
/*</listing>*/

