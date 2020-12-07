package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.HashMap;
import java.util.Map;

class findTheDiagonalSumOfGivenBinaryTree
{
    // Recursive function to do a pre-order traversal of the tree and
    // fill the map with diagonal sum of elements
    public static void diagonalSum(Node root, int diagonal, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // update the current diagonal with node's value
        map.put(diagonal, map.getOrDefault(diagonal, 0) + root.key);
 
        // recur for left subtree by increasing diagonal by 1
        diagonalSum(root.left, diagonal + 1, map);
 
        // recur for right subtree with same diagonal
        diagonalSum(root.right, diagonal, map);
    }
 
    // Function to print the diagonal sum of given binary tree
    public static void diagonalSum(Node root)
    {
        // create an empty map to store diagonal sum for every slope
        Map<Integer, Integer> map = new HashMap<>();
 
        // do pre-order traversal of the tree and fill the map
        diagonalSum(root, 0, map);
 
        // traverse the map and print diagonal sum
        System.out.println(map.values());
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left  = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        diagonalSum(root);
    }
}