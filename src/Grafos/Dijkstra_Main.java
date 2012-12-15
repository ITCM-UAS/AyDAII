package Grafos;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Dijkstra_Main {

    public static void main(String[] args) {
        Graph g = null;
        int numV = 0;
        int pred[];

        try {
            Scanner scan = new Scanner(new File("src/Grafos/in_App.txt"));
            g = AbstractGraph.createGraph(scan, true, "List");
            numV = g.getNumV();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        pred = new int[numV];
        double dist[] = {10, 100, 50, 60, 20, 10, 30,00,00,00};

        DijkstrasAlgorithm.dijkstrasAlgorithm(g, 0, pred, dist);
        System.out.println("       d[v]    " + " p[v]        ");

        for (int i = 1; i < pred.length; i++) {

            System.out.println("      " + dist[i] + "      " + pred[i]);

        }
    }
}