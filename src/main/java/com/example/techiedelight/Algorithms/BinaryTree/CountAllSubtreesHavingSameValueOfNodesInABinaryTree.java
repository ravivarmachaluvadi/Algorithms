package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

class CountAllSubtreesHavingSameValueOfNodesInABinaryTree
{
    // Helper function to count all subtrees having same value of nodes
    // The function returns the value of the root node if all nodes in subtree
    // rooted at root have same values, else it returns infinity
    // Here count stores the result and it is passed by reference
    public static int countSubtrees(Node root, AtomicInteger count)
    {
        // base case: empty tree
        if (root == null)
            return Integer.MIN_VALUE;
 
        // if root is a leaf node, increase the count and return root node key
        if (root.left == null && root.right == null)
        {
            count.incrementAndGet();
            return root.key;
        }
 
        // recur for left subtree and right subtree
        int left = countSubtrees(root.left, count);
        int right = countSubtrees(root.right, count);
 
        // 1. left subtree is empty & right subtree key matches with root
        // 2. right subtree is empty & left subtree key matches with root
        // 3. both left & right subtree are non-empty & their key matches with root
 
        if ((left == Integer.MIN_VALUE && right == root.key) ||
                    (right == Integer.MIN_VALUE && left == root.key) ||
                    (left == right && left == root.key))
        {
            // increase the count and return root node key
            count.incrementAndGet();
            return root.key;
        }
 
        // return infinity if root's key doesn't match with left or right subtree
        return Integer.MAX_VALUE;
    }
 
    // CountAllSubtreesHavingSameValueOfNodesInABinaryTree function to count all subtrees having same value of nodes
    public static int countSubtrees(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger count = new AtomicInteger(0);
        countSubtrees(root, count);
 
        return count.get();
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                     1
                    / \
                   /   \
                  2     3
                 /     / \
                /     /   \
               4     5     6
              /     / \     \
             /     /   \     \
            4     5     5     7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(4);
        root.right.left.left = new Node(5);
        root.right.left.right = new Node(5);
        root.right.right.right = new Node(7);
 
        System.out.print(countSubtrees(root));
    }
}