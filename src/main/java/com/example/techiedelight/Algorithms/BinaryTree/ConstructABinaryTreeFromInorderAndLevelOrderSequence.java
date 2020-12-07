package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.HashMap;
import java.util.Map;

class ConstructABinaryTreeFromInorderAndLevelOrderSequence
{
    // Recursive function to perform inorder traversal of a binary tree
    public static void inorderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }
 
    // Recursive function to construct a binary tree from in-order and
    // level-order traversals
    public static Node buildTree(int[] inorder, int start, int end,
                                Map<Integer, Integer> map)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // find the index of root node in inorder[] to determine the
        // boundary of left and right subtree
        int index = start;
        for (int j = start + 1; j <= end; j++)
        {
            // find node with minimum index in level order traversal
            // That would be the root node of inorder[start, end]
            if (map.get(inorder[j]) < map.get(inorder[index])) {
                index = j;
            }
        }
 
        // construct the root node
        Node root = new Node(inorder[index]);
 
        // recursively construct the left subtree
        root.left = buildTree(inorder, start, index - 1, map);
 
        // recursively construct the right subtree
        root.right = buildTree(inorder, index + 1, end, map);
 
        // return root node
        return root;
    }
 
    // Construct a binary tree from in-order and level-order traversals
    public static Node buildTree(int[] in, int[] level)
    {
        // create a map to efficiently find index of an element in
        // level-order sequence
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(level[i], i);
        }
 
        // Construct the tree and return it
        return buildTree(in, 0, in.length - 1, map);
    }
 
    public static void main(String[] args)
    {
        int[] inorder = { 4, 2, 5, 1, 6, 3, 7 };
        int[] level    = { 1, 2, 3, 4, 5, 6, 7 };
 
        Node root = buildTree(inorder, level);
 
        System.out.print("Inorder traversal of the constructed tree: ");
        inorderTraversal(root);
    }
}