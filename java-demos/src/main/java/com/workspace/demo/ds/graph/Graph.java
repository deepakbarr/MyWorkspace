package com.workspace.demo.ds.graph;

import com.workspace.demo.ds.queue.Queue;
import com.workspace.demo.ds.sort.InsertionSort;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by deepak on 11/25/14.
 */

class Vertex {
    char label;

    Vertex(char label) {
        this.label = label;
    }

    public char getLabel() {
        return label;
    }
}

public class Graph {

    private int[][] edges;
    private Vertex[] vertices;
    private int max_vertices;
    int size;

    public Graph(int max_vertices) {
        this.max_vertices = max_vertices;
        edges = new int[max_vertices][max_vertices];
        vertices = new Vertex[max_vertices];
        size = 0;
    }

    public void addVertex(char c) {
        if (size == max_vertices) {
            System.out.println("Graph Overflow");
            return;
        }
        vertices[size++] = new Vertex(c);
    }

    public void addEdge(char a, char b) {

        int i = findIndex(a);
        int j = findIndex(b);

        if (i == -1 || j == -1) {
            System.out.println("Invalid Vertex");
            return;
        }
        addEdge(i, j);
    }


    public void addEdge(int i, int j) {

        if (i >= size || j >= size) {
            System.out.println("Invalid Vertex");
            return;
        }
        edges[i][j] = 1;
        edges[j][i] = 1;

    }

    private int findIndex(char c) {

        for (int i = 0; i < size; i++) {
            if (vertices[i].getLabel() == c)
                return i;
        }
        return -1;
    }

    public void printVertices() {
        for (Vertex v : vertices)
            System.out.print(v.getLabel() + "\t");
        System.out.println();
    }

    public List<Integer> getAdjacent(int temp, boolean[] visited) {

        List<Integer> unvisitedVertices = new LinkedList<Integer>();
        for (int i = 0; i < size; i++) {
            if (edges[temp][i] == 1 && edges[i][temp] == 1 && !visited[i])
                unvisitedVertices.add(i);
        }
        return unvisitedVertices;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(start);
        boolean[] visited = new boolean[size];

        while (!queue.isEmpty()) {

            int idx = queue.dequeue();
            System.out.println("label = " + vertices[idx].getLabel());
            visited[idx] = true;
            List<Integer> neighbours = getAdjacent(idx, visited);

            if (neighbours.size()>=0)
                for (int i : neighbours)
                    queue.enqueue(i);
            }
        }

}
