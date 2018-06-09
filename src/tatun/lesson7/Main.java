package tatun.lesson7;

public class Main {
    public static void main(String[] args) {
        // Можно 10 вершин наделать, но какая разница. Нужно найти путь из а в d, причем есть прямое ребро, но
        // его вес = 3.
        Graph graph = new Graph();
        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');

        graph.addAdjacency(0, 1, 1);
        graph.addAdjacency(0, 2, 1);
        graph.addAdjacency(1, 3, 1);
        graph.addAdjacency(0, 3, 3);

        graph.findPath(0, 3);
    }
}
