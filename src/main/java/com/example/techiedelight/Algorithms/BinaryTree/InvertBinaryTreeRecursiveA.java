package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class InvertBinaryTreeRecursiveA
{
    // Function to perform preorder traversal of the binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(Node root) {
        if (root == null) {
            return;
        }
 
        Node temp = root.left;
        root.left =  root.right;
        root.right = temp;
    }
 
    // Function to invert given binary Tree using preorder traversal
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null)
            return;
 
        // swap left subtree with right subtree
        swap(root);
 
        // invert left subtree
        invertBinaryTree(root.left);
 
        // invert right subtree
        invertBinaryTree(root.right);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        invertBinaryTree(root);
        preorder(root);
    }
}




class IterativeUsingQueue
{
    // Function to perform preorder traversal of the binary tree
    public static void preorder(Node root)
    {
        if (root == null)
            return;

        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left =  root.right;
        root.right = temp;
    }

    // Iterative Function to invert given binary Tree using queue
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null) {
            return;
        }

        // maintain a queue and push push root node
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        // loop till queue is empty
        while (!q.isEmpty())
        {
            // pop top node from queue
            Node curr = q.poll();

            // swap left child with right child
            swap(curr);

            // push left child of popped node to the queue
            if (curr.left != null) {
                q.add(curr.left);
            }

            // push right child of popped node to the queue
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        invertBinaryTree(root);
        preorder(root);
    }
}




class IterativeUsingStack
{
    // Function to perform preorder traversal of the binary tree
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.key + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Utility function to swap left subtree with right subtree
    public static void swap(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left =  root.right;
        root.right = temp;
    }

    // Iterative Function to invert given binary Tree using stack
    public static void invertBinaryTree(Node root)
    {
        // base case: if tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push root node
        Deque<Node> s = new ArrayDeque<>();
        s.add(root);

        // loop till stack is empty
        while (!s.isEmpty())
        {
            // pop top node from stack
            Node curr = s.pollLast();

            // swap left child with right child
            swap(curr);

            // push right child of popped node to the stack
            if (curr.right != null) {
                s.add(curr.right);
            }

            // push left child of popped node to the stack
            if (curr.left != null) {
                s.add(curr.left);
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        invertBinaryTree(root);
        preorder(root);
    }
}