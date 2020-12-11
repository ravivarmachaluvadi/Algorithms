package com.example.techiedelight.Algorithms.Graph;

import java.util.*;

class FindCorrectOrderOfAlphabetsInAGivenDictionaryOfAncientOrigin
{
    // define maximum number of alphabets in the ancient dictionary
    private static final int N = 100;
 
    // Perform DFS on graph and set departure time of all vertices of the graph
    public static int DFS(GraphN graph, int v, boolean[] discovered,
                           int[] departure, int time)
    {
        // mark current node as discovered
        discovered[v] = true;
 
        // set arrival time
        time = time + 1;
 
        // do for every edge (v -> u)
        for (int u : graph.adjList.get(v)) {
            // u is not discovered
            if (!discovered[u]) {
                time = DFS(graph, u, discovered, departure, time);
            }
        }
 
        // ready to backtrack
 
        // set departure time of vertex v
        departure[time] = v;
        time = time + 1;
        return time;
    }
 
    // Utility function to performs Topological Sort on a given DAG
    public static void doTopologicalSort(GraphN graph, Map<Integer,String> map)
    {
        // departure[] stores the vertex number using departure time as index
        int[] departure = new int[2*N];
        Arrays.fill(departure, -1);
 
        // Note if we had done the other way around i.e. fill the array with
        // departure time by using vertex number as index, we would need to
        // sort the array later
 
        // stores vertex is discovered or not
        boolean[] discovered = new boolean[N];
        int time = 0;
 
        // perform DFS on all undiscovered connected vertices
        for (int i = 0; i < N; i++) {
            if (!discovered[i] && graph.adjList.get(i).size() != 0) {
                time = DFS(graph, i, discovered, departure, time);
            }
        }
 
        System.out.print("The correct order of alphabets in ancient language are: ");
 
        // Print the vertices in order of their decreasing
        // departure time in DFS i.e. in topological order
 
        for (int i = 2*N - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.print(map.get(departure[i]) + " ");
            }
        }
    }
 
    // Utility function to print adjacency list representation of graph
    public static void printGraph(GraphN graph, Map<Integer,String> map)
    {
        for (int i = 0; i < N; i++)
        {
            // ignore vertices with no outgoing edges
            if (graph.adjList.get(i).size() != 0)
            {
                // print current vertex
                System.out.print(map.get(i) + " -> ");
 
                // print all neighboring vertices of vertex i
                for (int v : graph.adjList.get(i)) {
                    System.out.print(map.get(v) + " ");
                }
 
                System.out.println();
            }
        }
        System.out.println();
    }
 
    // Utility function to construct an inverse map from the original map to do
    // the reverse lookup in constant time
    public static<V,K> Map inverse_map(Map<K,V> map)
    {
        Map<V,K> inverse = new HashMap<>();
        for (Map.Entry<K,V> entry: map.entrySet()) {
            inverse.put(entry.getValue(), entry.getKey());
        }
 
        return inverse;
    }
 
    // Function to find the correct order of alphabets in a given dictionary of
    // ancient origin. This function assumes that the input is correct.
    public static void findDictinaryAlphabetsOrder(List<List<String>> dict)
    {
        // create a Map to map each non-ascii character present in the
        // given dictionary with an unique integer
 
        Map<String, Integer> map = new HashMap<>();
 
        int k = 0;
 
        // do for each word
        for (List<String> word: dict) {
            // do for each non-ascii character of the word
            for (String s: word) {
                // if current character is not present in the map, insert it
                map.putIfAbsent(s, k++);
            }
        }
 
        // create a graph containing N nodes
        GraphN graph = new GraphN(N);
 
        // iterate through the complete dictionary and compare adjacent words
        // for character mismatch
 
        for (int i = 1; i < dict.size(); i++)
        {
            // previous word in the dictionary
            List<String> prev = dict.get(i - 1);
 
            // current word in the dictionary
            List<String> curr = dict.get(i);
 
            // iterate through both 'prev' and 'curr' simultaneously and
            // find the first mismatching character
 
            for (int j = 0; j < prev.size() && j < curr.size(); j++)
            {
                // mismatch found
                if (prev.get(j) != curr.get(j))
                {
                    // add an edge from current character of 'prev' to
                    // current character of 'curr' in the graph
 
                    graph.adjList.get(map.get(prev.get(j)))
                            .add(map.get(curr.get(j)));
                    break;
                }
            }
        }
 
        // create a reverse map
        Map<Integer,String> reverse = inverse_map(map);
        printGraph(graph, reverse);
 
        // perform topological sort on the above graph
        doTopologicalSort(graph, reverse);
    }
 
    public static void main(String[] args)
    {
        // ancient dictionary containing words ¥€±, €±€, €±‰ð, ðß, ±±ð, ±ßß
        // individual characters of each word are stored as String since
        // they are non-ASCII
 
        List<List<String>> dict = Arrays.asList(
                Arrays.asList("¥", "€", "±"),
                Arrays.asList("€", "±", "€"),
                Arrays.asList("€", "±", "‰", "ð"),
                Arrays.asList("ð", "ß"),
                Arrays.asList("±", "±", "ð"),
                Arrays.asList("±", "ß", "ß"));
 
        findDictinaryAlphabetsOrder(dict);
    }
}



// Class to represent a graph object
class GraphN
{
    // A List of Lists to represent an adjacency list
    List<List<Integer>> adjList = null;

    // Constructor
    GraphN(int N) {
        adjList = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
    }
}