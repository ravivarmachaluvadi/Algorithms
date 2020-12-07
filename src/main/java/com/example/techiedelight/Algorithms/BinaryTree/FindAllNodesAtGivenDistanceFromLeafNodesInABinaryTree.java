package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FindAllNodesAtGivenDistanceFromLeafNodesInABinaryTree
{
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // Recursive function to find all nodes at given distance from leaf nodes
    public static void leafNodeDistance(Node node, List<Node> path,
                                        Set<Node> set, int dist)
    {
        // base case: empty tree
        if (node == null) {
            return;
        }
 
        // if a leaf node is found, insert the node at distance 'dist' from
        // leaf node into the set
        if (isLeaf(node) && path.size() >= dist)
        {
            set.add(path.get(path.size() - dist));
            return;
        }
 
        // include current node into current path
        path.add(node);
 
        // recur for left and right subtree
        leafNodeDistance(node.left, path, set, dist);
        leafNodeDistance(node.right, path, set, dist);
 
        // remove current node from the current path
        path.remove(node);
    }
 
    // find all distinct nodes at given distance from leaf nodes
    public static void leafNodeDistance(Node node, int dist)
    {
        // list to store root to leaf path
        List<Node> path = new ArrayList<>();
 
        // create an empty set to store distinct nodes at given
        // distance from leaf nodes
        Set<Node> set = new HashSet<>();
 
        // find all nodes
        leafNodeDistance(node, path, set, dist);
 
        // print output
        for (Node e: set) {
            System.out.print(e.key + " ");
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  15
                /    \
               /      \
              10       20
             / \      /  \
            8   12   16  25
                    /
                   18
        */
 
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.left.left = new Node(18);
 
        int dist = 1;
        leafNodeDistance(root, dist);
    }
}