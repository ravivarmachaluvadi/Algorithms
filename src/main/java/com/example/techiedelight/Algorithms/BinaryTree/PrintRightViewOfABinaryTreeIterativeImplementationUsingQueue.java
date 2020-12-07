package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

class PrintRightViewOfABinaryTreeIterativeImplementationUsingQueue
{
    // Iterative function to print right view of given binary tree
    public static void rightView(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            int size = queue.size();
            int i = 0;
 
            // process every node of current level and enqueue their
            // non-empty right and right child to queue
            while (i++ < size) {
                curr = queue.poll();
 
                // if this is last node of current level, print it
                if (i == size) {
                    System.out.print(curr.key + " ");
                }
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        rightView(root);
    }
}




class RecursiveImplementationUsingHashing
{
    // traverse nodes in reverse pre-order
    public static void rightView(Node root, int level, Map<Integer, Integer> map)
    {
        if (root == null) {
            return;
        }

        // insert the current node and level information into the map
        map.put(level, root.key);

        // recur for right subtree before right subtree
        rightView(root.left, level + 1, map);
        rightView(root.right, level + 1, map);
    }

    // Function to print right view of given binary tree
    public static void rightView(Node root)
    {
        // create an empty map to store last node for each level
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill map
        rightView(root, 1, map);

        // iterate through the map in sorted order of its keys and print right view
        for (int i = 1; i <= map.size(); i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        rightView(root);
    }
}






class RecursiveImplementationUsingPreorderTraversal1
{
    // Recursive function to print right view of given binary tree
    public static int rightView(Node root, int level, int lastLevel)
    {
        // base case: empty tree
        if (root == null) {
            return lastLevel;
        }

        // if current node is last node of current level
        if (lastLevel < level)
        {
            // print the node's data
            System.out.print(root.key + " ");

            // update last level to current level
            lastLevel = level;
        }

        // recur for right and left subtree by increasing level by 1
        lastLevel = rightView(root.right, level + 1, lastLevel);
        lastLevel = rightView(root.left, level + 1, lastLevel);

        return lastLevel;
    }

    // Function to print right view of given binary tree
    public static void rightView(Node root) {
        rightView(root, 1, 0);
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        rightView(root);
    }
}