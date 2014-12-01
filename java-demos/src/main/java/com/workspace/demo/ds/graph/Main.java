package com.workspace.demo.ds.graph;

/**
 * Created by deepak on 11/30/14.
 */
public class Main {

    public static void main(String[] args) {

        Graph graph = new Graph(10);

        graph.addVertex('a');
        graph.addVertex('b');
        graph.addVertex('c');
        graph.addVertex('d');
        graph.addVertex('e');
        graph.addVertex('f');

        graph.addEdge('a', 'b');
        graph.addEdge('a', 'c');
        graph.addEdge('b', 'e');
        graph.addEdge('c', 'd');

        graph.bfs(0);
        graph.dfs(0);


    }
}
