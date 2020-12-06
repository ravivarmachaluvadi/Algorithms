package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class FindAncestorsOfGivenNodeInABinaryTree
{
    // Recursive function to print all ancestors of given node in a binary tree. The
    // function returns true if node is found in subtree rooted at given root node
    public static boolean printAncestors(NodeData root, int node)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        // return true if given node is found
        if (root.data == node) {
            return true;
        }
 
        // search node in left subtree
        boolean left = printAncestors(root.left, node);
 
        // search node in right subtree
        boolean right = false;
        if (!left) {
            right = printAncestors(root.right, node);
        }
 
        // if given node is found in either left or right subtree,
        // current node is an ancestor of given node
        if (left || right) {
            System.out.print(root.data + " ");
        }
 
        // return true if node is found
        return left || right;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2          3
               \     / \
                4   5   6
                   / \
                  7   8
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.right = new NodeData(4);
        root.right.left = new NodeData(5);
        root.right.right = new NodeData(6);
        root.right.left.left = new NodeData(7);
        root.right.right.right = new NodeData(8);
 
        int node = 7;
        printAncestors(root, node);
    }
}




class FindAncestorsOfGivenNodeInABinaryTreeIterative
{
    // Function to print root to leaf paths without using recursion
    public static void printTopToBottomPath(Map<Integer, Integer> parent, int key)
    {
        while ((key = parent.get(key)) != 0) {
            System.out.print(key + " ");
        }
    }

    // iterative function to set parent nodes for all nodes of binary tree
    // in given map. The function is similar to iterative pre-order traversal
    public static void setParent(NodeData root, Map<Integer, Integer> parent)
    {
        // create an empty stack and push root node to it
        Deque<NodeData> stack = new ArrayDeque<>();
        stack.add(root);

        // loop till stack is empty
        while (!stack.isEmpty())
        {
            // Pop the top item from stack
            NodeData curr = stack.pollLast();

            // push its right child to stack and set its parent in the map
            if (curr.right != null) {
                parent.put(curr.right.data, curr.data);
                stack.add(curr.right);
            }

            // push its left child to stack and set its parent in the map
            if (curr.left != null) {
                parent.put(curr.left.data, curr.data);
                stack.add(curr.left);
            }
        }
    }

    // Iterative function to print all ancestors of given node in a binary tree
    public static void printAncestors(NodeData root, int node)
    {
        // Base Case
        if (root == null)
            return;

        // create an empty map to store parent pointers of binary tree nodes
        Map<Integer, Integer> parent = new HashMap<>();

        // set parent of root node as null
        parent.put(root.data, 0);

        // set parent nodes for all nodes of binary tree
        setParent(root, parent);

        // print ancestors of given node using parent map
        printTopToBottomPath(parent, node);
    }

    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2          3
           \     / \
            4   5   6
               / \
              7   8
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.right = new NodeData(4);
        root.right.left = new NodeData(5);
        root.right.right = new NodeData(6);
        root.right.left.left = new NodeData(7);
        root.right.right.right = new NodeData(8);

        int node = 7;
        printAncestors(root, node);
    }
}