package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

class DetermineIfABinaryTreeSatisfyTheHeightBalancedPropertyOfRedBlackTree
{
    // Recursive function to determine if the given binary tree
    // satisfy the height-balanced property of red–black tree or not
    // It takes reference to rootMax variable for storing the
    // maximum height of the root node
    public static boolean isHeightBalanced(Node root, AtomicInteger rootMax)
    {
        // Base case
        if (root == null) {
            return true;
        }
 
        // to hold maximum height of left and right subtree
        AtomicInteger leftMax = new AtomicInteger(0);
        AtomicInteger rightMax = new AtomicInteger(0);
 
        // proceed only if both left and right subtree are balanced
        if (isHeightBalanced(root.left, leftMax) &&
                    isHeightBalanced(root.right, rightMax))
        {
            // Calculate the minimum and maximum height of the left and right subtree
            int rootMin = Math.min(leftMax.get(), rightMax.get()) + 1;
            rootMax.set(Math.max(leftMax.get(), rightMax.get()) + 1);
 
            // return true if the root node is height balanced
            return (rootMax.get() <= 2*rootMin);
        }
 
        // return false if either left or right subtree is unbalanced
        return false;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               2       3
              /       / \
             /       /   \
            4       5     6
                   / \
                  /   \
                 7     8
                / \
               /   \
              9    10
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.left.left.left = new Node(9);
        root.right.left.left.right = new Node(10);
 
        AtomicInteger rootMax = new AtomicInteger(0);
 
        if (isHeightBalanced(root, rootMax)) {
            System.out.print("Given Binary tree is height-balanced");
        }
        else {
            System.out.print("Given Binary tree is not height-balanced");
        }
    }
}