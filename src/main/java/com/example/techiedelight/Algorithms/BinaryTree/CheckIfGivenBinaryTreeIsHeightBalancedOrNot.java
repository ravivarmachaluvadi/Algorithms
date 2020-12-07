package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicBoolean;

class CheckIfGivenBinaryTreeIsHeightBalancedOrNot
{
    // Recursive function to check if given binary tree is height balanced or not
    public static int isHeightBalanced(Node root, AtomicBoolean isBalanced)
    {
        // base case: tree is empty or tree is not balanced
        if (root == null || !isBalanced.get()) {
            return 0;
        }
 
        // get height of left subtree
        int left_height = isHeightBalanced(root.left, isBalanced);
 
        // get height of right subtree
        int right_height = isHeightBalanced(root.right, isBalanced);
 
        // tree is unbalanced if absolute difference between height of
        // its left subtree and right subtree is more than 1
        if (Math.abs(left_height - right_height) > 1) {
            isBalanced.set(false);
        }
 
        // return height of subtree rooted at current node
        return Math.max(left_height, right_height) + 1;
    }
 
    // CheckIfGivenBinaryTreeIsHeightBalancedOrNot function to check if given binary tree is height balanced or not
    public static boolean isHeightBalanced(Node root)
    {
        // Using AtomicBoolean as boolean is passed by value in Java
        AtomicBoolean isBalanced =  new AtomicBoolean(true);
        isHeightBalanced(root, isBalanced);
 
        return isBalanced.get();
    }
 
    public static void main(String[] args) {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     /
            4   5   6
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
 
        if (isHeightBalanced(root)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}