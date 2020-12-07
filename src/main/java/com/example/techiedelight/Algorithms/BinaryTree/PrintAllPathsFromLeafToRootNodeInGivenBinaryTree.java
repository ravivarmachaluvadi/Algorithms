package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class PrintAllPathsFromLeafToRootNodeInGivenBinaryTree
{
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // Print path present in the list in reverse order (leaf to root node)
    public static void printPath(Deque<Integer> path)
    {
        Iterator<Integer> itr = path.descendingIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next());
 
            if (itr.hasNext()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
 
    // Recursive function to print all paths from leaf to root node
    public static void printLeafToRootPaths(Node node, Deque<Integer> path)
    {
        // base case
        if (node == null) {
            return;
        }
 
        // include current node to path list
        path.addLast(node.key);
 
        // if leaf node is found, print the path
        if (isLeaf(node)) {
            printPath(path);
        }
 
        // recur for left and right subtree
        printLeafToRootPaths(node.left, path);
        printLeafToRootPaths(node.right, path);
 
        // remove current node after left and right subtree are done
        path.removeLast();
    }
 
    // PrintAllPathsFromLeafToRootNodeInGivenBinaryTree function to print all paths from leaf to root node
    public static void printLeafToRootPaths(Node node)
    {
        // Deque to store left to root path
        Deque<Integer> path = new ArrayDeque<>();
 
        // call recursive function
        printLeafToRootPaths(node, path);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);
 
        // print all left to root paths
        printLeafToRootPaths(root);
    }
}