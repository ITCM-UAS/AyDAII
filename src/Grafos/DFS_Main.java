package Grafos;

import java.io.FileReader;
import java.util.Scanner;

public class DFS_Main {

    public static void main(String[] args) {
        Graph g = null;
        int numVertices = 0;
        try {
            Scanner scan = new Scanner(new FileReader("src/Grafos/in.txt"));
            g = AbstractGraph.createGraph(scan, true, "List");
            numVertices = g.getNumV();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        DepthFirstSearch dfs = new DepthFirstSearch(g);
        int[] discoveryOrder = dfs.getDiscoveryOrder();
        int[] finishOrder = dfs.getFinishOrder();
        System.out.println("Discovery & Finish Order");
        
        for (int i =0; i< numVertices; i++) {
            System.out.println(discoveryOrder[i] + " " + finishOrder[i]);    
        }
    }
}
