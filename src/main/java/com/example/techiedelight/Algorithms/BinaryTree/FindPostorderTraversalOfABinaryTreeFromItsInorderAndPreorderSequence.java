package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class FindPostorderTraversalOfABinaryTreeFromItsInorderAndPreorderSequence
{
    // Recursive function to find postorder traversal of binary tree
    // from its inorder and preorder sequence
    public static void printPostorder(int start, int end,
                                      int[] preorder, AtomicInteger preIndex,
                                      Map<Integer, Integer> map)
    {
        // base case
        if (start > end) {
            return;
        }
 
        // The next element in preorder sequence will be the root node of
        // subtree formed by inorder[start, end]
        int value = preorder[preIndex.getAndIncrement()];
 
        // if current node is leaf node (no children)
        if (start == end)
        {
            // print the value of root node and return
            System.out.print(value + " ");
            return;
        }
 
        // get the index of root node in inorder sequence to determine the
        // boundary of its left and right subtree
        int i = map.get(value);
 
        // recur for left subtree
        printPostorder(start, i - 1, preorder, preIndex, map);
 
        // recur for right subtree
        printPostorder(i + 1, end, preorder, preIndex, map);
 
        // print the value of root node
        System.out.print(value + " ");
    }
 
    // Find postorder traversal of a binary tree from its inorder and
    // preorder sequence. This function assumes that the input is valid
    // i.e. given inorder and preorder sequence forms a binary tree
    public static void findPostorder(int[] inorder, int[] preorder)
    {
        // create a map to efficiently find the index of any element in
        // given inorder sequence
        Map<Integer, Integer> map = new HashMap<>();
 
        // fill the map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
 
        // preIndex stores index of next unprocessed node in preorder sequence
        // start with root node (present at 0'th index)
        AtomicInteger preIndex = new AtomicInteger(0);
 
        System.out.print("Postorder Traversal is: ");
        printPostorder(0, inorder.length - 1, preorder, preIndex, map);
    }
 
    public static void main(String[] args)
    {
        /* Consider below tree
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
        */
 
        int[] inorder  = { 4, 2, 1, 7, 5, 8, 3, 6 };
        int[] preorder = { 1, 2, 4, 3, 5, 7, 8, 6 };
 
        findPostorder(inorder, preorder);
    }
}