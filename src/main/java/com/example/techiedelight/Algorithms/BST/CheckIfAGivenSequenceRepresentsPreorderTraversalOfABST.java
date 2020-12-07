package com.example.techiedelight.Algorithms.BST;

import java.util.concurrent.atomic.AtomicInteger;

class CheckIfAGivenSequenceRepresentsPreorderTraversalOfABST
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Recursive function to build a BST from given sequence
    public static Node buildTree(int[] seq)
    {
        Node root = null;
 
        // construct a BST by inserting keys from the given sequence
        for (int key: seq) {
            root = insert(root, key);
        }
 
        // return root node
        return root;
    }
 
    // Function to compare the preorder traversal of a BST with given sequence
    public static boolean comparePreOrder(Node root, int[] seq, AtomicInteger index)
    {
        // base case
        if (root == null) {
            return true;
        }
 
        // return false if next element in the given sequence doesn't match
        // with the next element in preorder traversal of BST
        if (seq[index.get()] != root.data) {
            return false;
        }
 
        // increment index
        index.incrementAndGet();
 
        // compare the left and right subtrees
        return comparePreOrder(root.left, seq, index) &&
                comparePreOrder(root.right, seq, index);
    }
 
    // Function to check if a given sequence represents preorder traversal of a BST
    public static boolean isBST(int[] seq)
    {
        /* 1. Construct the BST from given sequence */
 
        Node root = buildTree(seq);
 
        /* 2. Compare the preorder traversal of BST with given sequence */
 
        // index stores index of next unprocessed node in preorder sequence
 
        // use AtomicInteger as Integer is passed by value in Java
        AtomicInteger index = new AtomicInteger(0);
 
        return comparePreOrder(root, seq, index) && (index.get() == seq.length);
    }
 
    public static void main(String[] args)
    {
        int[] seq = { 15, 10, 8, 12, 20, 16, 25 };
 
        if (isBST(seq)) {
            System.out.print("Given sequence represents preorder traversal of a BST");
        }
        else {
            System.out.print("Given sequence doesn't represent preorder traversal of a BST");
        }
    }
}






class CheckIfAGivenSequenceRepresentsPreorderTraversalOfABSTA2
{
    // Recursive function to build a BST from given sequence in preorder fashion
    public static Node buildTree(int[] seq, AtomicInteger index, int min, int max)
    {
        // Base case
        if (index.get() == seq.length) {
            return null;
        }

        // Return if next element of the given sequence is within the invalid range
        int val = seq[index.get()];
        if (val < min || val > max) {
            return null;
        }

        // Construct the root node and increment index
        Node root = new Node(val);
        index.incrementAndGet();

        // Since all elements in the left sub-tree of a BST must be less
        // than the value of root node, set range as [min, val-1] and recur
        root.left = buildTree(seq, index, min, val - 1);

        // Since all elements in the right sub-tree of a BST must be greater
        // than the value of root node, set range as [val+1..max] and recur
        root.right = buildTree(seq, index, val + 1, max);

        // return root node
        return root;
    }

    // Function to check if a given sequence represents preorder traversal of a BST
    public static boolean isBST(int[] seq)
    {
        /* 1. Construct the BST from given sequence in preorder fashion */

        // stores index of the next unprocessed node in the sequence
        // use AtomicInteger as Integer is passed by value in Java
        AtomicInteger index = new AtomicInteger(0);

        // set range of the root node as [Integer.MIN_VALUE, Integer.MAX_VALUE] and recur
        buildTree(seq, index, Integer.MIN_VALUE, Integer.MAX_VALUE);

        /* 2. just check if whole sequence is traversed or not */
        return index.get() == seq.length;
    }

    public static void main(String[] args) {
        int[] seq = {15, 10, 8, 12, 20, 16, 25};

        if (isBST(seq)) {
            System.out.print("Given sequence represents preorder traversal of a BST");
        }
        else {
            System.out.print("Given sequence doesn't represent preorder traversal of a BST");
        }
    }
}