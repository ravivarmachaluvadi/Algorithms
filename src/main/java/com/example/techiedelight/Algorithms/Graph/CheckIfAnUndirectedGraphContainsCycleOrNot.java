package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class CheckIfAnUndirectedGraphContainsCycleOrNot
{
    // Perform BFS on graph starting from vertex src and
    // returns true of cycle is found in the graph
    public static boolean BFS(Graph graph, int src, int N)
    {
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // mark source vertex as discovered
        discovered[src] = true;
 
        // create a queue used to do BFS and
        // push source vertex into the queue
        Queue<NodeParent> q = new ArrayDeque<>();
        q.add(new NodeParent(src, -1));
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // pop front NodeParent from queue and print it
            NodeParent NodeParent = q.poll();
 
            // do for every edge (v -> u)
            for (int u : graph.adjList.get(NodeParent.v))
            {
                if (!discovered[u])
                {
                    // mark it discovered
                    discovered[u] = true;
 
                    // construct the queue NodeParent containing info
                    // about vertex and push it into the queue
                    q.add(new NodeParent(u, NodeParent.v));
                }
 
                // u is discovered and u is not a parent
                else if (u != NodeParent.parent)
                {
                    // we found a cross-edge ie. cycle is found
                    return true;
                }
            }
        }
 
        // No cross-edges found in the graph
        return false;
    }
 
    // Check if an undirected graph contains cycle or not
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                                new Edge(7, 11), new Edge(7, 12), new Edge(6, 10)
                                // edge (6->10) introduces a cycle in the graph
                            );
 
        // Set number of vertices in the graph
        final int N = 13;
 
        // create a graph from edges
        Graph graph = new Graph(edges, N);
 
        // Do BFS traversal in connected components of graph
        if (BFS(graph, 1, N))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain any cycle");
    }
}




// NodeParent to store vertex and its parent info in BFS
class NodeParent
{
    int v, parent;

    NodeParent(int v, int parent) {
        this.v = v;
        this.parent = parent;
    }
}




class CheckIfAnUndirectedGraphContainsCycleOrNotUsingDFS
{
    // Function to perform DFS Traversal
    public static boolean DFS(Graph graph, int v,
                              boolean[] discovered, int parent)
    {
        // mark current node as discovered
        discovered[v] = true;

        // do for every edge (v -> w)
        for (int w : graph.adjList.get(v))
        {
            // w is not discovered
            if (!discovered[w])
            {
                if (DFS(graph, w, discovered, v))
                    return true;
            }

            // w is discovered and w is not a parent
            else if (w != parent)
            {
                // we found a back-edge (cycle)
                return true;
            }
        }

        // No back-edges found in the graph
        return false;
    }

    // Check if an undirected graph contains cycle or not
    public static void main(String[] args)
    {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 7),
                new Edge(1, 8), new Edge(2, 3),
                new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9),
                new Edge(8, 12), new Edge(9, 10),
                new Edge(9, 11), new Edge(11, 12)
                // edge (11->12) introduces a cycle in the graph
        );

        // Set number of vertices in the graph
        final int N = 13;

        // create a graph from edges
        Graph graph = new Graph(edges, N);

        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];

        // Do DFS traversal from first vertex
        if (DFS(graph, 1, discovered, -1))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't contain any cycle");
    }
}