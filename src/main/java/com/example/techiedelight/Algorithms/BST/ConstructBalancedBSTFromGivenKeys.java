package com.example.techiedelight.Algorithms.BST;

import java.util.Arrays;

class ConstructBalancedBSTFromGivenKeys
{
    // Function to perform in-order traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Function to construct balanced BST from given sorted array
    public static Node convert(int[] keys, int low, int high, Node root)
    {
        // base case
        if (low > high) {
            return root;
        }
 
        // find middle element of current range
        int mid = (low + high) / 2;
 
        // construct a new node from mid element and assign it to root
        root = new Node(keys[mid]);
 
        // left subtree of root will be formed by keys less than mid element
        root.left = convert(keys, low, mid - 1, root.left);
 
        // right subtree of root will be formed by keys less than mid element
        root.right = convert(keys, mid + 1, high, root.right);
 
        return root;
    }
 
    // Function to construct balanced BST from given unsorted array
    public static Node convert(int[] keys)
    {
        // sort the keys first
        Arrays.sort(keys);
 
        // construct balanced BST and
        // return root node of the tree
        return convert(keys, 0, keys.length - 1, null);
    }
 
    // Construct balanced BST from given keys
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        // construct balanced binary search tree
        Node root = convert(keys);
 
        // print the keys in in-order fashion
        inorder(root);
    }
}