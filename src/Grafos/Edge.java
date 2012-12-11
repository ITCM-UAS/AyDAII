package Grafos;

public class Edge {

    private int source;
    
    private int dest;
    private double weight;

    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        weight = 1.0;
    }

    public Edge(int source, int dest, double w) {
        this.source = source;
        this.dest = dest;
        weight = w;
    }

    public int getSource() {
        return source;
    }
public int getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[(");
        sb.append(Integer.toString(source));
        sb.append(", ");
        sb.append(Integer.toString(dest));
        sb.append("): ");
        sb.append(Double.toString(weight));
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge) {
            Edge edge = (Edge) obj;
            return (source == edge.source && dest == edge.dest);
        } else {
            return false;
        }
    }
    @Override
    public int hashCode() {
        return (source << 16) ^ dest;
    }
}