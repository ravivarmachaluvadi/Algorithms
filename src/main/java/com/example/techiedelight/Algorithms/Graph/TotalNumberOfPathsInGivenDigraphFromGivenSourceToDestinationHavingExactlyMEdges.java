package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class TotalNumberOfPathsInGivenDigraphFromGivenSourceToDestinationHavingExactlyMEdges
{
    // Perform BFS on graph g starting from vertex v
    public static int modifiedBFS(Graph g, int src, int dest, int m)
    {
        // create a queue used to do BFS
        Queue<Node> q = new ArrayDeque<>();
 
        // push source vertex into the queue
        q.add(new Node(src, 0));
 
        // stores number of paths from source to destination
        // having exactly m edges
        int count = 0;
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // pop front node from queue
            Node node = q.poll();
 
            int v = node.ver;
            int depth = node.minDist;
 
            // if destination is reached and BFS depth is equal to m
            // update count
            if (v == dest && depth == m)
                count++;
 
            // don't consider nodes having BFS depth more than m.
            // This check will result in optimized code and also
            // handle cycles in the graph (else loop will never break)
            if (depth > m)
                break;
 
            // do for every adjacent vertex u of v
            for (int u : g.adjList.get(v))
            {
                // push every vertex (discovered or undiscovered) into
                // the queue
                q.add(new Node(u, depth + 1));
            }
        }
 
        // return number of paths from source to destination
        return count;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(0, 1), new Edge(1, 6),
                new Edge(1, 5), new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(5, 2), new Edge(5, 3),
                new Edge(5, 4), new Edge(6, 5), new Edge(7, 6),
                new Edge(7, 1)
        );
 
        // Number of vertices in the graph
        final int N = 8;
 
        // construct graph
        Graph g = new Graph(edges, N);
 
        int src = 0, dest = 3, m = 4;
 
        // Do modified BFS traversal from source vertex src
        System.out.println(modifiedBFS(g, src, dest, m));
    }
}