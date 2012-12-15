package Grafos;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BFS_Main {

    public static void main(String[] args) {
        int numV = 0; 
        Graph g = null;
        try {
            Scanner scan = new Scanner(new FileReader("src/Grafos/in.txt"));
            g = AbstractGraph.createGraph(scan, false, "List");
            numV = g.getNumV();
        } catch (IOException ex) {
            System.err.println("Error al Leer el Grafo.");
            System.err.println(ex.toString());
            System.exit(1);
        }
        int parent[] =
                BreadthFirstSearch.breadthFirstSearch(g, 0);
        Deque<Integer> thePath = new ArrayDeque<Integer>();
        int v = numV - 1;
        while (parent[v] != -1) {
            thePath.push(new Integer(v));
            v = parent[v];
        }
        System.out.println("El Camino mas Corto es:");
        while (!thePath.isEmpty()) {
            System.out.println(thePath.pop());
        }
    }
}