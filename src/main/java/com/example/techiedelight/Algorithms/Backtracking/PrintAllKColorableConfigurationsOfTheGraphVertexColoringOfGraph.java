package com.example.techiedelight.Algorithms.Backtracking;

import java.util.Arrays;
import java.util.List;

class PrintAllKColorableConfigurationsOfTheGraphVertexColoringOfGraph
{
    // string array to store colors (10-colorable graph)
    private static String COLORS[] = {"", "BLUE", "GREEN", "RED", "YELLOW",
                        "ORANGE", "PINK", "BLACK", "BROWN", "WHITE", "PURPLE"};
 
    // Function to check if it is safe to assign color c to vertex v
    private static boolean isSafe(Graph graph, int[] color, int v, int c)
    {
        // check color of every adjacent vertex of v
        for (int u : graph.adjList.get(v))
            if (color[u] == c)
                return false;
 
        return true;
    }
 
    public static void kColorable(Graph g, int[] color, int k, int v, int N)
    {
        // if all colors are assigned, print the solution
        if (v == N)
        {
            for (v = 0; v < N; v++)
                System.out.printf("%-8s" , COLORS[color[v]]);
 
            System.out.println();
 
            return;
        }
 
        // try all possible combinations of available colors
        for (int c = 1; c <= k; c++)
        {
            // if it is safe to assign color c to vertex v
            if (isSafe(g, color, v, c))
            {
                // assign color c to vertex v
                color[v] = c;
 
                // recur for next vertex
                kColorable(g, color, k, v + 1, N);
 
                // backtrack
                color[v] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 4),
                new Edge(0, 5), new Edge(4, 5),
                new Edge(1, 4), new Edge(1, 3),
                new Edge(2, 3), new Edge(2, 4)
        );
 
        // Set number of vertices in the graph
        final int N = 6;
 
        // create a graph from edges
        Graph g = new Graph(edges, N);
 
        int k = 3;
 
        int[] color = new int[N];
 
        // print all k-colorable configurations of the graph
        kColorable(g, color, k, 0, N);
    }
}