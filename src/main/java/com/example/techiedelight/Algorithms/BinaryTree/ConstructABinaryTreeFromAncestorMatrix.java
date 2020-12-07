package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class ConstructABinaryTreeFromAncestorMatrix
{
    // Utility function to print binary tree nodes in-order fashion
    public static void inorder(Node node)
    {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }
 
    // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                        Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
 
    // Function to construct a binary tree from specified ancestor matrix
    public static Node constructBT(int[][] mat)
    {
        // get number of rows in the matrix
        int N = mat.length;
 
        // create an empty multi-map
        Map<Integer, List<Integer>> multimap = new TreeMap<>();
 
        // Use sum as key and row numbers as values in the multi-map
        for (int i = 0; i < N; i++)
        {
            // find the sum of the current row
            int sum = Arrays.stream(mat[i]).sum();
 
            // insert the sum and row number into the multimap
            insertIntoMultiMap(multimap, sum, i);
        }
 
        // node[i] will store node for i in constructed tree
        Node[] node = new Node[N];
        int last = 0;
 
        // the value of parent[i] is true if parent is set for i'th node
        boolean[] parent = new boolean[N];
 
        // Traverse the TreeMap in sorted order (default behavior)
        for (Map.Entry<Integer, List<Integer>> entry: multimap.entrySet())
        {
            for (int row: entry.getValue())
            {
                last = row;
                // create a new node
                node[row] = new Node(row);
 
                // if leaf node, do nothing
                if (entry.getKey() == 0) {
                    continue;
                }
 
                // traverse row
                for (int i = 0; i < N; i++)
                {
                    // do if parent is not set and ancestor exits
                    if (parent[i] == false && mat[row][i] == 1)
                    {
                        // check for the unoccupied node
                        if (node[row].left == null) {
                            node[row].left = node[i];
                        } else {
                            node[row].right = node[i];
                        }
 
                        // set parent for i'th node
                        parent[i] = true;
                    }
                }
            }
        }
 
        // last processed node is the root
        return node[last];
    }
 
    // Construct a Binary Tree from Ancestor Matrix
    public static void main(String[] args)
    {
        int[][] mat =
        {
            { 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0 },
            { 1, 1, 1, 1, 0 }
        };
 
        Node root = constructBT(mat);
        inorder(root);
    }
}