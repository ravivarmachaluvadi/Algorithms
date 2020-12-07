package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

class FindMaximumSumPathBetweenTwoLeavesInABinaryTree
{
    // Recursive function to find the maximum sum path between two leaves
    // in a binary tree
    public static int maxSumPath(Node root, AtomicInteger max_sum)
    {
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // find maximum sum node-to-leaf path starting from left child
        int left = maxSumPath(root.left, max_sum);
 
        // find maximum sum node-to-leaf path starting from right child
        int right = maxSumPath(root.right, max_sum);
 
        // find maximum sum path "through" the current node
        int cur_sum = left + right + root.key;
 
        // update maximum sum path found so far (Note that maximum sum path
        // "excluding" the current node in subtree rooted at current node
        // is already updated as we're doing postorder traversal)
        max_sum.set(Math.max(cur_sum, max_sum.get()));
 
        // important - return maximum sum node-to-leaf path starting from
        // current node
 
        // case 1: left child is null
        if (root.left == null) {
            return right + root.key;
        }
 
        // case 2: right child is null
        if (root.right == null) {
            return left + root.key;
        }
 
        // case 3: both left and right child exists
        return Math.max(left, right) + root.key;
    }
 
    // Function to return maximum sum path between two leaves in a binary tree
    public static int maxSumPath(Node root)
    {
        // Using AtomicBoolean as Integer is passed by value in Java
        AtomicInteger max_sum = new AtomicInteger(Integer.MIN_VALUE);
        maxSumPath(root, max_sum);
 
        return max_sum.get();
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2       3
           \     / \
           -4   5   6
               / \
              7   8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(-4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        System.out.println(maxSumPath(root));
    }
}