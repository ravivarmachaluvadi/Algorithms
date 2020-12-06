package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

class PrintCornerNodesOfEveryLevelInBinaryTree
{
    // Iterative function to print corner nodes of every level in binary tree
    public static void print(NodeData root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue to store Tree nodes
        Queue<NodeData> q = new ArrayDeque<>();
 
        // enqueue root node
        q.add(root);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // get size of current level
            int size = q.size();
            int n = size;
 
            // process all nodes present in current level
            while (n-- > 0)
            {
                NodeData node = q.poll();
 
                // if corner node found, print it
                if (n == size - 1 || n == 0) {
                    System.out.print(node.data + " ");
                }
 
                // enqueue left and right child of current node
                if (node.left != null) {
                    q.add(node.left);
                }
 
                if (node.right != null) {
                    q.add(node.right);
                }
            }
 
            // terminate level by printing newline
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                     1
                    / \
                   /   \
                  2     3
                 /     / \
                /     /   \
               4     5     6
              /     / \     \
             /     /   \     \
            7     8     9     10
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.left = new NodeData(4);
        root.right.left = new NodeData(5);
        root.right.right = new NodeData(6);
        root.left.left.left = new NodeData(7);
        root.right.left.left = new NodeData(8);
        root.right.left.right = new NodeData(9);
        root.right.right.right  = new NodeData(10);
 
        print(root);
    }
}