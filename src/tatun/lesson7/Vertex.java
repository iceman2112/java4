package tatun.lesson7;

public class Vertex {
    char label; //anything useful
    boolean wasVisited; //meta
    public int lastVertex;
    public int length;

    Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
    }

    @Override
    public String toString() {
        return "Vertex: " + label;
    }
}