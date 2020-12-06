package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.Map;
import java.util.TreeMap;

class PrintTopViewofBinaryTree
{
    // Recursive function to do a pre-order traversal of the tree and fill the map
    // Here node has 'dist' horizontal distance from the root of the
    // tree and level represent level of the node
    public static void printTop(Node root, int dist, int level,
                                Map<Integer, Pair<Integer, Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
        // if current level is less than maximum level seen so far
        // for the same horizontal distance or horizontal distance
        // is seen for the first time, update the map
        if (!map.containsKey(dist) || level < map.get(dist).second) {
            // update value and level for current distance
            map.put(dist, Pair.of(root.key, level));
        }
 
        // recur for left subtree by decreasing horizontal distance and
        // increasing level by 1
        printTop(root.left, dist - 1, level + 1, map);
 
        // recur for right subtree by increasing both level and
        // horizontal distance by 1
        printTop(root.right, dist + 1, level + 1, map);
    }
 
    // Function to print the top view of given binary tree
    public static void printTop(Node root)
    {
        // create a TreeMap where
        // key -> relative horizontal distance of the node from root node and
        // value -> pair containing node's value and its level
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
 
        // do pre-order traversal of the tree and fill the map
        printTop(root, 0, 0, map);
 
        // traverse the TreeMap and print top view
        for (Pair<Integer, Integer> it: map.values()) {
            System.out.print(it.first + " ");
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        printTop(root);
    }
}