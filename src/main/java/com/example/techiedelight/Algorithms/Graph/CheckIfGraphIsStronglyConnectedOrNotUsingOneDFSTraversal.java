package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class CheckIfGraphIsStronglyConnectedOrNotUsingOneDFSTraversal
{
    // Perform DFS on graph starting from vertex v
    public static int DFS(GraphImmu graph, int v, boolean[] discovered,
                          int[] arrival, AtomicBoolean isSC, AtomicInteger time)
    {
        // terminate the search if graph is not strongly connected
        if (!isSC.get()) {
            return 0;
        }
 
        // set arrival time of vertex v
        arrival[v] = time.incrementAndGet();
 
        // mark vertex as discovered
        discovered[v] = true;
 
        // initialize arr to arrival time of vertex v
        int arr = arrival[v];
 
        // do for every EdgeImmutable (v -> w)
        for (int w : graph.adjList.get(v))
        {
            // vertex w is not yet explored
            if (!discovered[w]) {
                arr = Math.min(arr, DFS(graph, w, discovered, arrival, isSC, time));
                // vertex w is explored before
            }
            else {
                // If the vertex is w is already discovered,
                // that means there is either a cross EdgeImmutable
                // or a back EdgeImmutable starting from v. Note that
                // the arrival time is already defined for w
                arr = Math.min(arr, arrival[w]);
            }
        }
 
        // if v is not root node and value of arr didn't
        // change i.e. it is still set to arrival time of
        // vertex v, the graph is not strongly connected
        if (v != 0 && arr == arrival[v]) {
            isSC.set(false);
        }
 
        // we return the minimum arrival time
        return arr;
    }
 
    // Check if given Graph is Strongly Connected or not
    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<EdgeImmutable> edges = Arrays.asList(EdgeImmutable.of(0, 4), EdgeImmutable.of(1, 0),
                                    EdgeImmutable.of(1, 2), EdgeImmutable.of(2, 1),
                                    EdgeImmutable.of(2, 4), EdgeImmutable.of(3, 1),
                                    EdgeImmutable.of(3, 2), EdgeImmutable.of(4, 3));
 
        // Number of vertices in the graph
        int N = 5;
 
        // create a graph from given edges
        GraphImmu graph = new GraphImmu(edges, N);
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // array to store arrival time of vertex.
        int[] arrival = new int[N];
 
        // flag to determine if graph is strongly connected or not
        AtomicBoolean isSC = new AtomicBoolean(true);
        AtomicInteger time = new AtomicInteger(-1);
 
        // Do DFS traversal starting from first vertex.
        DFS(graph, 0, discovered, arrival, isSC, time);
 
        // If DFS traversal doesn’t visit all vertices,
        // then graph is not strongly connected
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                isSC.set(false);
            }
        }
 
        if (isSC.get()) {
            System.out.print("Graph is Strongly Connected");
        }
        else {
            System.out.print("Graph is not Strongly Connected");
        }
    }
}



// Data structure to store graph edges
class EdgeImmutable
{
    public final int source, dest;

    private EdgeImmutable(int source, int dest) {
        this.source = source;
        this.dest = dest;
    }

    // Factory method for creating a EdgeImmutable immutable instance
    public static EdgeImmutable of(int a, int b) {
        return new EdgeImmutable(a, b);        // calls private constructor
    }
}




// Class to represent a graph object
class GraphImmu
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    GraphImmu(List<EdgeImmutable> edges, int N)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        // add edges to the undirected graph
        for (EdgeImmutable edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;

            adjList.get(src).add(dest);
        }
    }
}
