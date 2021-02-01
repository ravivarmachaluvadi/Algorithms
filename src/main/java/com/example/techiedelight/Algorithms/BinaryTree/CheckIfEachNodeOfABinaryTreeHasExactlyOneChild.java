package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

class CheckIfEachNodeOfABinaryTreeHasExactlyOneChild {
 
    // Recursive function to calculate the size of a binary tree
    public static int getSize(Node root)
    {
        // Base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recur for the left and right subtree
        return 1 + getSize(root.left) + getSize(root.right);
    }
 
    // Recursive function to calculate the height of a binary tree
    public static int getHeight(Node root)
    {
        // Base case: an empty tree has a height of 0
        if (root == null) {
            return 0;
        }
 
        // recur for the left and right subtree and consider the maximum depth
        return 1 + Integer.max(getHeight(root.left), getHeight(root.right));
    }
 
    // Function to check if each node of a binary tree has exactly one child
    public static boolean isSkewedTree(Node root) {
        return getSize(root) == getHeight(root);
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.left.left = new Node(18);
        root.right.left.left.right = new Node(20);
 
        boolean isSkewed = isSkewedTree(root);
        if (isSkewed) {
            System.out.println("The binary tree is skewed");
        }
        else {
            System.out.println("The binary tree is not skewed");
        }
    }
}




    // Recursive function to return the height of a binary tree.
// It also calculates the tree size and stores it in variable `size`
  /*  public static int getHeight(Node root, AtomicInteger size)
    {
        // Base case: an empty tree has a height of 0
        if (root == null) {
            return 0;
        }

        size.incrementAndGet();

        // recur for the left and right subtree and consider the maximum depth
        return 1 + Integer.max(getHeight(root.left, size), getHeight(root.right, size));
    }

    // Function to check if each node of a binary tree has exactly one child
    public static boolean isSkewedTree(Node root)
    {
        AtomicInteger size = new AtomicInteger(0);
        int height = getHeight(root, size);
        return height == size.get();
    }*/



class CheckIfEachNodeOfABinaryTreeHasExactlyOneChildA3
{
    // Function to check if each node of a binary tree has exactly one child
    public static boolean isSkewedTree(Node root)
    {
        // Base case: empty tree
        if (root == null) {
            return true;
        }

        // return false if both the left child and the right child
        // exists for a node
        if (root.left != null && root.right != null ) {
            return false;
        }

        // recur for the left and right subtree
        return isSkewedTree(root.left) && isSkewedTree(root.right);
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.right = new Node(30);
        root.right.left = new Node(25);
        root.right.left.left = new Node(18);
        root.right.left.left.right = new Node(20);

        boolean isSkewed = isSkewedTree(root);
        if (isSkewed) {
            System.out.println("The binary tree is skewed");
        }
        else {
            System.out.println("The binary tree is not skewed");
        }
    }
}




