package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

class ConstructAFullBinaryTreeFromPreorderSequenceWithLeafNodeInformation
{
    // Function to print the preorder traversal of a binary tree
    public static void preorderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.key + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
 
    // Recursive function to construct a full binary tree from given
    // preorder sequence with extra information about leaf nodes
    public static Node construct(int[] preorder, int[] isLeaf, AtomicInteger pIndex)
    {
        // Base Case
        if (pIndex.get() == preorder.length) {
            return null;
        }
 
        // Construct the current node, check if it an internal node,
        // and increment pIndex
        Node node = new Node(preorder[pIndex.get()]);
        boolean isInternalNode = (isLeaf[pIndex.get()] == 0);
        pIndex.incrementAndGet();
 
        // if current node is an internal node, construct its 2 children
        if (isInternalNode) {
            node.left  = construct(preorder, isLeaf, pIndex);
            node.right = construct(preorder, isLeaf, pIndex);
        }
 
        // return current node
        return node;
    }
 
    // Construct a full binary tree from preorder sequence with leaf node information
    public static Node constructTree(int[] preorder, int[] isLeaf)
    {
        // pIndex stores index of next unprocessed key in preorder sequence
        // start with the root node (at 0'th index)
        // Using Atomicint as Integer is passed by value in Java
        AtomicInteger pIndex = new AtomicInteger(0);
        return construct(preorder, isLeaf, pIndex);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            /   \   /   \
           4     5 6     7
                  / \
                 /   \
                8     9
        */
 
        int[] preorder = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
        int[] isLeaf   = { 0, 0, 1, 1, 0, 0, 1, 1, 1 };
 
        // construct the tree
        Node root = constructTree(preorder, isLeaf);
 
        // print the tree in preorder fashion
        System.out.print("Preorder Traversal of the constructed tree is: ");
        preorderTraversal(root);
    }
}