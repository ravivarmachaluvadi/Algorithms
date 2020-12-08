package com.example.techiedelight.Algorithms.Graph;

import java.util.Arrays;
import java.util.List;

class TransitiveClosureOfAGraph
{
    // C is connectivity matrix and stores transitive closure of graph
    // root is the topmost node in DFS tree(it is starting vertex of DFS)
    // descendant is current vertex to be explored in DFS
    // Invariant: A path already exists from root -> descendant in graph
    public static void DFS(Graph graph, byte[][] C, int root, int descendant)
    {
        for (int child : graph.adjList.get(descendant))
        {
            // if child is an adjacent vertex of descendant, we have
            // found a path from root->child
            if (C[root][child] == 0)
            {
                C[root][child] = 1;
                DFS(graph, C, root, child);
            }
        }
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 0), new Edge(3, 1)
        );
 
        // Set number of vertices in the graph
        final int N = 4;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
 
        // C is connectivity matrix and stores the transitive closure
        // of the graph. The value of C[i][j] is 1 only if a directed
        // path exists from vertex i to vertex j.
        byte C[][] = new byte[N][N];
 
        // consider each vertex and start DFS from it
        for (int v = 0; v < N; v++)
        {
            C[v][v] = 1;
            DFS(graph, C, v, v);
 
            // print path info for vertex v
            System.out.println(Arrays.toString(C[v]));
        }
    }
}