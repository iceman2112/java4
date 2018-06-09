package tatun.lesson7;

import tatun.lesson3.Stack;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Graph {
    private static final int MAX_VERTICES = 32;
    private Vertex[] vertices;
    private int[][] adjMatrix;
    private int size;


    public Graph() {
        vertices = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        this.size = 0;
    }

    public void addVertex(char label) {
        vertices[size++] = new Vertex(label);
    }

    public void addAdjacency(int start, int end, int weight) {
        adjMatrix[start][end] = weight;
        adjMatrix[end][start] = weight;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertices[vertex]);
    }

    private int getNextUnvisitedVertex(int v) {
        for (int i = 0; i < size; i++) {
            if (adjMatrix[v][i] > 0 && !vertices[i].wasVisited)
                return i;
        }
        return -1;
    }

    public void depthTravers() {
        Stack<Integer> stack = new Stack<Integer>(size);
        vertices[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getNextUnvisitedVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertices[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++)
            vertices[i].wasVisited = false;
    }

    public void findPath(int begin, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        vertices[begin].wasVisited = true;
        vertices[end].length = 9999;
        queue.add(begin);

        // Обходим в ширины и считаем длину пути пути
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            for (int i = 0; i < MAX_VERTICES; i++){
                if (adjMatrix[currentVertex][i] > 0 && !vertices[i].wasVisited) {
                    int length = vertices[currentVertex].length + adjMatrix[currentVertex][i];
                    if (end == i) {
                        if (vertices[end].length > length) {
                            vertices[end].length = length;
                            vertices[end].lastVertex = currentVertex;
                        }
                    } else {
                        vertices[i].length = length;
                        vertices[i].lastVertex = currentVertex;
                        vertices[i].wasVisited = true;
                        queue.add(i);
                    }
                }
            }
        }

        // Выводим путь
        int currentVertex = end;
        System.out.println("Length: " + vertices[currentVertex].length);
        while (currentVertex != begin) {
            displayVertex(currentVertex);
            currentVertex = vertices[currentVertex].lastVertex;
        }
        displayVertex(begin);
    }
}
