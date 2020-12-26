package com.example.techiedelight.Algorithms.Graph;

import java.util.Arrays;
import java.util.List;

class CheckWhetherAnUndirectedGraphIsEulerian
{
    // Utility function to perform DFS Traversal on the graph
    public static void DFS(Graph graph, int v, boolean[] discovered) {
        // mark current node as discovered
        discovered[v] = true;
 
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v)) {
            // u is not discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
 
    // Function to check if all vertices with nonzero degree in a graph
    // belong to a single connected component
    public static boolean isConnected(Graph graph, int N) {
        // stores vertex is visited or not
        boolean[] visited = new boolean[N];
 
        // start DFS from the first vertex with nonzero degree
        for (int i = 0; i < N; i++) {
            if (graph.adjList.get(i).size() > 0) {
                DFS(graph, i, visited);
                break;
            }
        }
 
        // if a single DFS call couldn't visit all vertices with nonzero degree,
        // the graph contains more than one connected component
        for (int i = 0; i < N; i++) {
            if (!visited[i] && graph.adjList.get(i).size() > 0) {
                return false;
            }
        }
        return true;
    }
 
    // Utility function to return the number of vertices in a graph
    // with an odd degree
    public static int countOddVertices(Graph graph) {
        int count = 0;
        for (List<Integer> list: graph.adjList) {
            if ((list.size() & 1) == 1) {
                count++;
            }
        }
        return count;
    }
 
    public static void main(String[] args) {
 
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 3), new Edge(3, 4));
 
        // number of nodes in the graph
        int N = 5;
 
        // create an undirected graph from given edges
        Graph graph = new Graph(edges, N);
 
        // check if all vertices with nonzero degree belong to a
        // single connected component
        boolean is_connected = isConnected(graph, N);
 
        // find the number of vertices with an odd degree
        int odd = countOddVertices(graph);
 
        // Eulerian path exists if all nonzero degree vertices are connected
        // and zero or two vertices have an odd degree
 
        if (is_connected && (odd == 0 || odd == 2)) {
            System.out.println("The Graph has an Eulerian path");
 
            // A connected graph has an Eulerian cycle if every vertex has even degree
            if (odd == 0) {
                System.out.println("The Graph has an Eulerian cycle");
            }
            // The graph has an Eulerian path, but not an Eulerian cycle
            else {
                System.out.println("The Graph is Semi-Eulerian");
            }
        }
        else {
            System.out.println("The Graph is not Eulerian");
        }
    }
}