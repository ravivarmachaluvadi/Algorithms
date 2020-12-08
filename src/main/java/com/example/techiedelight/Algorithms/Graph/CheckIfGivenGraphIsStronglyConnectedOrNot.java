package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CheckIfGivenGraphIsStronglyConnectedOrNot
{
    // Function to perform DFS Traversal
    private static void DFS(Graph graph, int v, boolean[] visited)
    {
        // mark current node as visited
        visited[v] = true;
 
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v))
        {
            // u is not visited
            if (!visited[u])
                DFS(graph, u, visited);
        }
    }
 
    // Check if graph is strongly connected or not
    public static boolean check(Graph graph, int N)
    {
        // do for every vertex
        for (int i = 0; i < N; i++)
        {
            // stores vertex is visited or not
            boolean[] visited = new boolean[N];
 
            // start DFS from first vertex
            DFS(graph, i, visited);
 
            // If DFS traversal doesn’t visit all vertices,
            // then graph is not strongly connected
            for (boolean b: visited)
                if (!b)
                return false;
        }
        return true;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
                new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
                new Edge(3, 2) , new Edge(4, 3)
        );
 
        // Number of vertices in the graph
        final int N = 5;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        // check if graph is not strongly connected or not
        if (check(graph, N))
            System.out.println("Graph is Strongly Connected");
        else
            System.out.println("Graph is not Strongly Connected");
    }
}







class CheckIfGivenGraphIsStronglyConnectedOrNotA2
{
    // Function to perform DFS Traversal
    private static void DFS(Graph graph, int v, boolean[] visited)
    {
        // mark current node as visited
        visited[v] = true;

        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v))
        {
            // u is not visited
            if (!visited[u])
                DFS(graph, u, visited);
        }
    }

    // check if graph is strongly connected or not
    public static boolean check(Graph graph, int N)
    {
        // stores vertex is visited or not
        boolean[] visited = new boolean[N];

        // choose random starting point
        int v = 0;

        // run a DFS starting at v
        DFS(graph, v, visited);

        // If DFS traversal doesn’t visit all vertices,
        // then graph is not strongly connected
        for (boolean b: visited)
            if (!b)
                return false;

        // reset visited array
        Arrays.fill(visited, false);

        // Reverse the direction of all edges in the
        // directed graph
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < N; i++)
            for (int j : graph.adjList.get(i))
                edges.add(new Edge(j, i));

        // Create a graph from reversed edges
        Graph gr = new Graph(edges, N);

        // Again run a DFS starting at v
        DFS(gr, v, visited);

        // If DFS traversal doesn’t visit all vertices,
        // then graph is not strongly connected
        for (boolean b: visited)
            if (!b)
                return false;

        // if graph "passes" both DFSs, it is strongly connected
        return true;
    }

    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
                new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
                new Edge(3, 2) , new Edge(4, 3)
        );

        // Number of vertices in the graph
        final int N = 5;

        // construct graph
        Graph graph = new Graph(edges, N);

        // check if graph is not strongly connected or not
        if (check(graph, N))
            System.out.println("Graph is Strongly Connected");
        else
            System.out.println("Graph is not Strongly Connected");
    }
}




