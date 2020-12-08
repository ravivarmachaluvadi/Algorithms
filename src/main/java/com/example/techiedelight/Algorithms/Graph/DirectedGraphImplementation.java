package com.example.techiedelight.Algorithms.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
// class to represent a graph object
class DirectedGraphImplementation
{
    // data structure to store graph edges
    static class Edge {
        int src, dest;
 
        Edge(int src, int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    };
 
    // A list of lists  to represent adjacency list
    List<List<Integer>> adj = new ArrayList<>();
 
    // Constructor to construct graph
    public DirectedGraphImplementation(List<Edge> edges)
    {
        // find maximum numbered vertex
        int n = 0;
        for (Edge e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }
 
        // allocate memory for adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge current : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj.get(current.src).add(current.dest);
 
            // Uncomment line 38 for undirected graph
    
            // allocate new node in adjacency List from dest to src
            // adj.get(current.dest).add(current.src);
        }
    }
 
    // print adjacency list representation of graph
    private static void printGraph(DirectedGraphImplementation graph)
    {
        int src = 0;
        int n = graph.adj.size();
 
        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (int dest : graph.adj.get(src))
                System.out.print("(" + src + " --> " + dest + ")\t");
 
            System.out.println();
            src++;
        }
    }
 
    // Directed DirectedGraphImplementation Implementation in Java
    public static void main (String[] args)
    {
        // Input: List of edges in a digraph (as per above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2), 
                                new Edge(2, 0), new Edge(2, 1),new Edge(3, 2), 
                                new Edge(4, 5), new Edge(5, 4));
 
        // construct graph from given list of edges
        DirectedGraphImplementation graph = new DirectedGraphImplementation(edges);
 
        // print adjacency list representation of the graph
        printGraph(graph);
    }
}




// class to represent a graph object
class WeightedDigraphImplementation
{
    // data structure to store graph edges
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight)
        {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    };

    // data structure for adjacency list node
    static class Node {
        int value, weight;

        Node(int value, int weight)
        {
            this.value = value;
            this.weight = weight;
        }
    };

    // A list of lists to represent adjacency list
    List<List<Node>> adj = new ArrayList<>();

    // Constructor to construct graph
    public WeightedDigraphImplementation(List<Edge> edges)
    {
        // find maximum numbered vertex
        int n = 0;
        for (Edge e : edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // allocate memory for adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }

        // add edges to the undirected graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj.get(e.src).add(new Node(e.dest, e.weight));

            // Uncomment line 39 for undirected graph

            // allocate new node in adjacency List from dest to src
            // adj.get(e.dest).add(new Node(e.src, e.weight));
        }
    }

    // print adjacency list representation of graph
    private static void printGraph(WeightedDigraphImplementation graph)
    {
        int src = 0;
        int n = graph.adj.size();

        while (src < n)
        {
            // print current vertex and all its neighboring vertices
            for (Node edge : graph.adj.get(src)) {
                System.out.print(src + " --> " + edge.value +
                        " (" + edge.weight + ")\t");
            }

            System.out.println();
            src++;
        }
    }

    // Weighted Directed Graph Implementation in Java
    public static void main (String[] args)
    {
        // Input: List of edges in a weighted digraph (as per above diagram)
        // tuple (x, y, w) represents an edge from x to y having weight w
        List<Edge> edges = Arrays.asList(new Edge(0, 1, 6), new Edge(1, 2, 7),
                new Edge(2, 0, 5), new Edge(2, 1, 4),
                new Edge(3, 2, 10), new Edge(4, 5, 1),
                new Edge(5, 4, 3));

        // construct graph from given list of edges
        WeightedDigraphImplementation graph = new WeightedDigraphImplementation(edges);

        // print adjacency list representation of the graph
        printGraph(graph);
    }
}