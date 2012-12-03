package Grafos;

import Graph.*;
import java.io.IOException;
import java.util.Scanner;

public abstract class AbstractGraph implements Graph {

    private int numV;
    private boolean directed;

    public AbstractGraph(int numV, boolean directed) {
        this.numV = numV;
        this.directed = directed;
    }

    @Override
    public int getNumV() {
        return numV;
    }

    @Override
    public boolean isDirected() {
        return directed;
    }
    public void loadEdgesFromFile(Scanner scan) throws IOException {
        String line;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            String[] tokens = line.split("\\s+");
            int source = Integer.parseInt(tokens[0]);
            int dest = Integer.parseInt(tokens[1]);
            double weight = 1.0;
            if (tokens.length == 3) {
                weight = Double.parseDouble(tokens[2]);
            }
            insert(new Edge(source, dest, weight));
        }
    }
    public static Graph createGraph(Scanner scan,
            boolean isDirected,
            String type) throws IOException {
        int numV = scan.nextInt();
        scan.nextLine();
        AbstractGraph returnValue = null;
        if (type.equalsIgnoreCase("Matrix")) {
            returnValue = new MatrixGraph(numV, isDirected);
        } else if (type.equalsIgnoreCase("List")) {
            returnValue = new ListGraph(numV, isDirected);
        } else {
            throw new IllegalArgumentException();
        }
        returnValue.loadEdgesFromFile(scan);
        return returnValue;
    }
}
