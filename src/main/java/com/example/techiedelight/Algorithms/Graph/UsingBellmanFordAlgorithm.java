package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

//Determine negative-weight cycle in a graph

class UsingBellmanFordAlgorithm
{
    // N is number of vertices in the graph
    private static final int N = 4;
 
    // define infinity as maximum value of the integer
    private static final int INF = Integer.MAX_VALUE;
 
    // Function to run Bellman-Ford algorithm from given source
    public static boolean BellmanFord(List<EdgeWeight> edges, int source)
    {
        // cost[] stores shortest-path information
        int[] cost = new int[N];
 
        // initialize cost[]. Initially all vertices except
        // source vertex have a weight of infinity
        Arrays.fill(cost, INF);
        cost[source] = 0;
 
        int u, v, w;
 
        // Relaxation step (run V-1 times)
        for (int k = 1; k < N; k++)
        {
            for (EdgeWeight e: edges)
            {
                // edge from u to v having weight w
                u = e.source;
                v = e.dest;
                w = e.weight;
 
                // if the cost to the destination u can be
                // shortened by taking the edge u -> v
                if (cost[u] != INF && cost[u] + w < cost[v])
                {
                    // update cost to the new lower value
                    cost[v] = cost[u] + w;
                }
            }
        }
 
        // Run relaxation step once more for N'th time to
        // check for negative-weight cycles
        for (EdgeWeight e: edges)
        {
            // edge from u to v having weight w
            u = e.source;
            v = e.dest;
            w = e.weight;
 
            // if the cost to the destination u can be
            // shortened by taking the edge u -> v
            if (cost[u] != INF && cost[u] + w < cost[v]) {
                return true;
            }
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        // given adjacency representation of matrix
        int[][] adjMatrix =
                {
                        { 0,    INF, -2, INF },
                        { 4,    0,    -3, INF },
                        { INF, INF, 0,    2 },
                        { INF, -1, INF, 0 }
                };
 
        // create a List to store graph edges
        List<EdgeWeight> edges = new ArrayList<>();
 
        for (int v = 0; v < N; v++) {
            for (int u = 0; u < N; u++) {
                if (adjMatrix[v][u] != 0 && adjMatrix[v][u] != INF) {
                    edges.add(new EdgeWeight(v, u, adjMatrix[v][u]));
                }
            }
        }
 
        // run Bellman-Ford algorithm from each vertex as source
        // and check for any Negative Weight Cycle
        if (IntStream.range(0, N).anyMatch(i -> BellmanFord(edges, i))) {
            System.out.print("Negative Weight Cycle Found!!");
        }
    }
}




class UsingFloydWarshallAlgorithm
{
    // Number of vertices in the adjMatrix
    private static final int N = 4;

    // define infinity as maximum value of the integer
    private static final int INF = Integer.MAX_VALUE;

    // Function to run Floyd-Warshell algorithm
    public static void FloydWarshell(int[][] adjMatrix)
    {
        // cost[] stores shortest-path information
        int[][] cost = new int[N][N];

        // initialize cost[] matrix
        for (int v = 0; v < N; v++)
        {
            for (int u = 0; u < N; u++)
            {
                // Initially cost would be same as weight of the edge
                cost[v][u] = adjMatrix[v][u];
            }
        }

        // Run Floyd-Warshell
        for (int k = 0; k < N; k++)
        {
            for (int v = 0; v < N; v++)
            {
                for (int u = 0; u < N; u++)
                {
                    // If vertex k is on the shortest path from v to u,
                    // then update the value of cost[v][u]

                    if (cost[v][k] != INF && cost[k][u] != INF
                            && cost[v][k] + cost[k][u] < cost[v][u])
                    {
                        cost[v][u] = cost[v][k] + cost[k][u];
                    }
                }

                // If diagonal elements become negative, the
                // graph contains a negative weight cycle
                if (cost[v][v] < 0)
                {
                    System.out.print("Negative Weight Cycle Found!!");
                    return;
                }
            }
        }

        System.out.print("No Negative Weight Cycle Found");
    }

    public static void main(String[] args)
    {
        // given adjacency representation of matrix
        int[][] adjMatrix =
                {
                        { 0,    INF, -2, INF },
                        { 4,    0,    -3, INF },
                        { INF, INF, 0,    2 },
                        { INF, -1, INF, 0 }
                };

        // Run Floyd Warshell algorithm
        FloydWarshell(adjMatrix);
    }
}



