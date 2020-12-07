package com.example.techiedelight.Algorithms.BST;

import java.util.concurrent.atomic.AtomicInteger;

class BuildABinarySearchTreeFromAPreorderSequence
{
    // Recursive function to perform inorder traversal of a binary tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Recursive function to build a BST from a preorder sequence
    public static Node constructBST(int[] preorder, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Construct the root node of the sub-tree formed by keys of the
        // preorder sequence in range [start, end]
        Node node = new Node(preorder[start]);
 
        // search the index of first element in current range of preorder
        // sequence which is larger than the value of root node
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.data) {
                break;
            }
        }
 
        // recursively construct the left sub-tree
        node.left = constructBST(preorder, start + 1, i - 1);
 
        // recursively construct the right sub-tree
        node.right = constructBST(preorder, i, end);
 
        // return current node
        return node;
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
 
        int[] preorder = { 15, 10, 8, 12, 20, 16, 25 };
 
        // construct the BST
        Node root = constructBST(preorder, 0, preorder.length - 1);
 
        // print the BST
        System.out.print("Inorder Traversal of BST is : ");
 
        // inorder on the BST always returns a sorted sequence
        inorder(root);
    }
}





class BuildABinarySearchTreeFromAPreorderSequenceA2
{
    // Function to print the inorder traversal of a binary tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Recursive function to build a BST from a preorder sequence
    public static Node buildTree(int[] preorder, AtomicInteger pIndex,
                                 int min, int max)
    {
        // Base case
        if (pIndex.get() == preorder.length) {
            return null;
        }

        // Return if next element of preorder traversal is not in the valid range
        int val = preorder[pIndex.get()];
        if (val < min || val > max) {
            return null;
        }

        // Construct the root node and increment pIndex
        Node root = new Node(val);
        pIndex.incrementAndGet();

        // Since all elements in the left sub-tree of a BST must be less
        // than the value of root node, set range as [min, val-1] and recur
        root.left = buildTree(preorder, pIndex, min, val-1);

        // Since all elements in the right sub-tree of a BST must be greater
        // than the value of root node, set range as [val+1..max] and recur
        root.right = buildTree(preorder, pIndex, val+1, max);

        return root;
    }

    // Build a BST from a preorder sequence
    public static Node buildTree(int[] preorder)
    {
        // start from the root node (first element in preorder sequence)
        // use AtomicInteger as Integer is passed by value in Java
        AtomicInteger pIndex = new AtomicInteger(0);

        // set range of the root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and recur
        return buildTree(preorder, pIndex, Integer.MIN_VALUE, Integer.MAX_VALUE);
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

        // preorder traversal of BST
        int[] preorder = { 15, 10, 8, 12, 20, 16, 25 };

        // construct the BST
        Node root = buildTree(preorder);

        // print the BST
        System.out.print("Inorder Traversal of BST is: ");

        // inorder on the BST always returns a sorted sequence
        inorder(root);
    }
}