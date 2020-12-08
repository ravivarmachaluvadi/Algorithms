package com.example.techiedelight.Algorithms.Graph;

import java.util.Arrays;
import java.util.List;

class TwoEdgeConnectivityInAGraph
{
    // Perform DFS on graph starting from vertex v and find
    // all Bridges in the process
    public static int DFS(Graph graph, int v, boolean[] discovered,
                            int[] arrival, int parent, int time)
    {
        // set arrival time of vertex v
        arrival[v] = ++time;
 
        // mark vertex as discovered
        discovered[v] = true;
 
        // initialize array to arrival time of vertex v
        int arr = arrival[v];
 
        // (v, w) forms an edge
        for (int w: graph.adjList.get(v))
        {
            // w is not discovered
            if (!discovered[w])
                arr = Integer.min(arr, DFS(graph, w, discovered, arrival, v, time));
 
                // w is discovered and w is not parent of v
            else if (w != parent)
                // If the vertex w is already discovered, that
                // means that there is a back edge starting
                // from v. Note that as discovered[u] is already
                // true, arrival[u] is already defined
                arr = Integer.min(arr, arrival[w]);
        }
 
        // if the value of arr remains unchanged i.e. it is equal
        // to the arrival time of vertex v and if v is not root
        // node, then (parent[v] -> v) forms a Bridge
        if (arr == arrival[v] && parent != -1)
            System.out.println(parent + ", " + v);
 
        // we return the minimum arrival time
        return arr;
    }
 
    public static void main(String[] args)
    {
        // initialize edges as per above diagram
        // (u, v, w) triplet represent undirected edge from
        // vertex u to vertex v having weight w
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 2),
                new Edge(2, 3), new Edge(2, 4),
                new Edge(3, 4), new Edge(3, 5)
        );
 
        // Number of vertices in the graph
        final int N = 6;
 
        // construct graph
        Graph graph = new Graph(edges, N);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // stores arrival time of a node in DFS
        int[] arrival = new int[N];
 
        int start = 0, parent = -1, time = 0;
 
        // As given graph is connected, DFS will cover every node
        DFS(graph, start, discovered, arrival, parent, time);
    }
}