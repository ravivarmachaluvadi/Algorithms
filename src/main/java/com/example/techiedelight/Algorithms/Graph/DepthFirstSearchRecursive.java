package com.example.techiedelight.Algorithms.Graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class DepthFirstSearchRecursive
{
    // Function to perform DFS Traversal
    public static void DFS(Graph graph, int v, boolean[] discovered)
    {
        // mark current node as discovered
        discovered[v] = true;
 
        // print current node
        System.out.print(v + " ");
 
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v))
        {
            // u is not discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
 
    // Recursive Java implementation of Depth first search
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected node
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11)
        );
 
        // Set number of vertices in the graph (0-12)
        final int N = 13;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // Do DFS traversal from all undiscovered nodes to
        // cover all unconnected components of graph
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }
    }
}




class DepthFirstSearchIterative
{
    // Perform iterative DFS on graph g starting from vertex v
    public static void iterativeDFS(Graph graph, int v, boolean[] discovered)
    {
        // create a stack used to do iterative DFS
        Stack<Integer> stack = new Stack<>();

        // push the source node into stack
        stack.push(v);

        // loop till stack is empty
        while (!stack.empty())
        {
            // Pop a vertex from stack
            v = stack.pop();

            // if the vertex is already discovered yet, ignore it
            if (discovered[v])
                continue;

            // we will reach here if the popped vertex v
            // is not discovered yet. We print it and process
            // its undiscovered adjacent nodes into stack
            discovered[v] = true;
            System.out.print(v + " ");

            // do for every edge (v -> u)
            List<Integer> adj = graph.adjList.get(v);
            for (int i = adj.size() - 1; i >= 0; i--)
            {
                int u = adj.get(i);
                if (!discovered[u]) {
                    stack.push(u);
                }
            }
        }
    }

    // Iterative Java implementation of Depth first search
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected node
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11)
                // , new Edge(6, 9) // introduce cycle
        );

        // Set number of vertices in the graph (0-12)
        final int N = 13;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // Do iterative DFS traversal from all undiscovered nodes to
        // cover all unconnected components of graph
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                iterativeDFS(graph, i, discovered);
            }
        }
    }
}