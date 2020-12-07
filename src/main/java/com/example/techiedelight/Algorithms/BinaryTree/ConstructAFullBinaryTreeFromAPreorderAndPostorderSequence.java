package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class ConstructAFullBinaryTreeFromAPreorderAndPostorderSequence
{
    // Recursive function to perform inorder traversal of a binary tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // A recursive function to construct a full binary tree from given preorder
    // and postorder sequence
    public static Node buildTree(int[] preorder, AtomicInteger pIndex,
                                 int start, int end, Map<Integer, Integer> map)
    {
        // Consider the next item from the given preorder sequence
        // This item would be the root node of subtree formed by
        // the postorder[start, end] and increment pIndex
        Node root = new Node(preorder[pIndex.getAndIncrement()]);
 
        // return if all keys are processed
        if (pIndex.get() == preorder.length) {
            return root;
        }
 
        // find the index of next key in postorder sequence to determine the
        // boundary of left and right subtree of current root node
        int index = map.get(preorder[pIndex.get()]);
 
        // fill the left and right subtree together
        if (start <= index && index + 1 <= end - 1)
        {
            // build the left subtree
            root.left  = buildTree(preorder, pIndex, start, index, map);
 
            // build the right subtree
            root.right = buildTree(preorder, pIndex, index + 1, end - 1, map);
        }
 
        return root;
    }
 
    // Construct a full binary tree from preorder and postorder sequence
    public static Node buildTree(int[] preorder, int[] postorder)
    {
        // map is used to efficiently find index of any element in given
        // postorder sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
 
        // pIndex stores index of next node in the preorder sequence
        AtomicInteger pIndex = new AtomicInteger(0);
 
        // set range [start, end] for subtree formed by postorder sequence
        int start = 0;
        int end = preorder.length - 1;
 
        // construct the binary tree and return it
        return buildTree(preorder, pIndex, start, end, map);
    }
 
    public static void main(String[] args)
    {
        int[] preorder  = { 1, 2, 4, 5, 3, 6, 8, 9, 7 };
        int[] postorder = { 4, 5, 2, 8, 9, 6, 7, 3, 1 };
 
        Node root = buildTree(preorder, postorder);
 
        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}