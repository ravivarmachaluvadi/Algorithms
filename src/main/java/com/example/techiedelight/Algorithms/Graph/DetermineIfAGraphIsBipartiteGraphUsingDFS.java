package com.example.techiedelight.Algorithms.Graph;

import java.util.Arrays;
import java.util.List;

class DetermineIfAGraphIsBipartiteGraphUsingDFS
{
    // Perform DFS on graph starting from vertex v
    public static boolean DFS(Graph graph, int v, boolean[] discovered,
                             boolean[] color)
    {
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v))
        {
            // if vertex u is explored for first time
            if (discovered[u] == false)
            {
                // mark current node as discovered
                discovered[u] = true;
                // set color as opposite color of parent node
                color[u] = !color[v];
 
                // if DFS on any subtree rooted at v
                // we return false
                if (DFS(graph, u, discovered, color) == false)
                    return false;
            }
            // if the vertex is already been discovered and
            // color of vertex u and v are same, then the
            // graph is not Bipartite
            else if (color[v] == color[u]) {
                return false;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                new Edge(5, 9), new Edge(8, 9), new Edge(2, 4)
                // if we remove 2->4 edge, graph is becomes Bipartite
        );
 
        // Set number of vertices in the graph
        final int N = 10;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // stores color 0 or 1 of each vertex in DFS
        boolean[] color = new boolean[N];
 
        // mark source vertex as discovered and
        // set its color to 0
        discovered[0] = true;
        color[0] = false;
 
        // start DFS traversal from any node as graph
        // is connected and undirected
        if (DFS(graph, 1, discovered, color))
            System.out.println("Bipartite Graph");
        else
            System.out.println("Not a Bipartite Graph");
    }
}