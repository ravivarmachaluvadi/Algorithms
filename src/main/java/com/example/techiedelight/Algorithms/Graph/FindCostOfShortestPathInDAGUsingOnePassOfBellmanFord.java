package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindCostOfShortestPathInDAGUsingOnePassOfBellmanFord
{
    // Perform DFS on GraphWeight and set departure time of all
    // vertices of the GraphWeight
    private static int DFS(GraphWeight GraphWeight, int v, boolean[] discovered,
                           int[] departure, int time)
    {
        // mark current node as discovered
        discovered[v] = true;
 
        // set arrival time - not needed
        // time++;
 
        // do for every EdgeWeight (v -> u)
        for (EdgeWeight EdgeWeight: GraphWeight.adjList.get(v))
        {
            int u = EdgeWeight.dest;
 
            // u is not discovered
            if (!discovered[u]) {
                time = DFS(GraphWeight, u, discovered, departure, time);
            }
        }
 
        // ready to backtrack
        // set departure time of vertex v
        departure[time] = v;
        time++;
 
        return time;
    }
 
    // The function performs topological sort on a given DAG and then finds out
    // the longest distance of all vertices from given source by running one pass
    // of Bellman-Ford algorithm on edges of vertices in topological order
    public static void findShortestDistance(GraphWeight GraphWeight, int source, int N)
    {
        // departure[] stores the vertex number using departure time as index
        int[] departure = new int[N];
        Arrays.fill(departure, -1);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
        int time = 0;
 
        // perform DFS on all undiscovered vertices
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                time = DFS(GraphWeight, i, discovered, departure, time);
            }
        }
 
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
 
        cost[source] = 0;
 
        // Process the vertices in topological order i.e. in order
        // of their decreasing departure time in DFS
        for (int i = N - 1; i >= 0; i--)
        {
            // for each vertex in topological order,
            // relax cost of its adjacent vertices
            int v = departure[i];
            for (EdgeWeight e: GraphWeight.adjList.get(v))
            {
                // EdgeWeight e from v to u having weight w
                int u = e.dest;
                int w = e.weight;
 
                // if the distance to the destination u can be shortened by
                // taking the EdgeWeight vu, update cost to the new lower value
                if (cost[v] != Integer.MAX_VALUE && cost[v] + w < cost[u]) {
                    cost[u] = cost[v] + w;
                }
            }
        }
 
        // print shortest paths
        for (int i = 0; i < N - 1; i++) {
            System.out.printf("dist(%d, %d) = %2d\n", source, i, cost[i]);
        }
    }
 
    // Find the cost of Shortest Path in DAG
    public static void main(String[] args)
    {
        // List of GraphWeight edges as per above diagram
        List<EdgeWeight> edges = Arrays.asList(
                                new EdgeWeight(0, 6, 2), new EdgeWeight(1, 2, -4),
                                new EdgeWeight(1, 4, 1), new EdgeWeight(1, 6, 8),
                                new EdgeWeight(3, 0, 3), new EdgeWeight(3, 4, 5),
                                new EdgeWeight(5, 1, 2), new EdgeWeight(7, 0, 6),
                                new EdgeWeight(7, 1, -1), new EdgeWeight(7, 3, 4),
                                new EdgeWeight(7, 5, -4)
                            );
 
        // Set number of vertices in the GraphWeight
        final int N = 8;
 
        // create a GraphWeight from given edges
        GraphWeight GraphWeight = new GraphWeight(edges, N);
 
        // source vertex
        int source = 7;
 
        // find Shortest distance of all vertices from given source
        findShortestDistance(GraphWeight, source, N);
    }
}



// Data structure to store GraphWeight edges
class EdgeWeight
{
    int source, dest, weight;

    public EdgeWeight(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}


// Class to represent a GraphWeight object
class GraphWeight
{
    // A List of Lists to represent an adjacency list
    List<List<EdgeWeight>> adjList = null;

    // Constructor
    GraphWeight(List<EdgeWeight> edges, int N) {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected GraphWeight
        for (EdgeWeight edge: edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}