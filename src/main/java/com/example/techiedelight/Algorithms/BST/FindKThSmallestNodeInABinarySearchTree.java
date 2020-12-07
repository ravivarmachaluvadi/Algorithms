package com.example.techiedelight.Algorithms.BST;

import java.util.concurrent.atomic.AtomicInteger;

class FindKThSmallestNodeInABinarySearchTree
{
    // Recursive function to find the node with k'th smallest node
    // in a Binary Search Tree (using inorder traversal)
    public static Node kthSmallest(Node root, AtomicInteger counter, int k)
    {
        // base case
        if (root == null) {
            return null;
        }
 
        // recur for left subtree
        Node left = kthSmallest(root.left, counter, k);
 
        // if k'th smallest node is found
        if (left != null) {
            return left;
        }
 
        // if root is k'th smallest node
        if (counter.incrementAndGet() == k) {
            return root;
        }
 
        // recur for right subtree only if k'th smallest node is not found
        // in the right subtree
        return kthSmallest(root.right, counter, k);
    }
 
    // Function to find the k'th smallest node in a Binary Search Tree (BST)
    public static Node findKthSmallest(Node root, int k)
    {
        // counter to keep track of the number of the visited nodes
        // use AtomicInteger as Integer is passed by value in Java
        AtomicInteger counter = new AtomicInteger(0);
 
        // recursively find the k'th smallest node
        return kthSmallest(root, counter, k);
    }
 
    public static void main(String[] args)
    {
        /* Construct below BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */
 
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        int k = 4;
 
        // find the k'th smallest node
        Node res = findKthSmallest(root, k);
 
        if (res != null) {
            System.out.printf("%d'th smallest node is %d", k, res.data);
        } else {
            System.out.printf("%d'th smallest node does not exist.", k);
        }
    }
}