package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ConstructAnAncestorMatrixFromABinaryTree
{
    // Recursive function to calculate size of the binary tree
    public static int size(Node root)
    {
        // base case
        if (root == null) {
            return 0;
        }
 
        return size(root.left) + 1 + size(root.right);
    }
 
    // Traverse the tree in preorder fashion and update ancestors of
    // all nodes in boolean ancestor matrix
    public static void constructAncestorMatrix(Node root, Set<Node> ancestors,
                                                int[][] ancestorMatrix)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // update all ancestors of the current node
        for (Node node: ancestors) {
            ancestorMatrix[node.key][root.key] = 1;
        }
 
        // add current node to the set of ancestors
        ancestors.add(root);
 
        // recur for left and right subtree
        constructAncestorMatrix(root.left, ancestors, ancestorMatrix);
        constructAncestorMatrix(root.right, ancestors, ancestorMatrix);
 
        // remove current node from the set of ancestors since all
        // descendants of the current node are already processed
        ancestors.remove(root);
    }
 
    // Function to construct an ancestor matrix from a given binary tree
    public static int[][] constructAncestorMatrix(Node root)
    {
        // calculate the size of the binary tree
        int n = size(root);
 
        // create an ancestor matrix of size n x n, initialized by 0
        int[][] ancestorMatrix = new int[n][n];
 
        // stores ancestors of a node
        Set<Node> ancestors = new HashSet<>();
 
        // construct the ancestor matrix
        constructAncestorMatrix(root, ancestors, ancestorMatrix);
 
        return ancestorMatrix;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                 4
               /   \
              3     1
             / \     \
            2   0     5
        */
 
        Node root = new Node(4);
        root.left = new Node(3);
        root.right = new Node(1);
        root.left.left = new Node(2);
        root.left.right = new Node(0);
        root.right.right = new Node(5);
 
        // construct the ancestor matrix
        int[][] ancestorMatrix = constructAncestorMatrix(root);
 
        // print the ancestor matrix
        for (int[] row: ancestorMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}