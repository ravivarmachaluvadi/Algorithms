package com.example.techiedelight.Algorithms.BST;

// Data structure to store a Binary Search Tree node
class Node
{
    int data;
    Node left, right;

    // Function to create a new binary tree node having given key
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}


class InsertionInBSTRecursive
{
    // Function to perform inorder traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node,
        // recur for left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
 
        // else recur for right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key: keys) {
            root = insert(root, key);
        }
 
        inorder(root);
    }
}





class InsertionInBSTIterativeSolution
{
    // Function to perform inorder traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Iterative function to insert a key into BST.
    // Root is passed by reference to the function
    public static Node insertIterative(Node root, int key)
    {
        // start with root node
        Node curr = root;

        // pointer to store parent node of current node
        Node parent = null;

        // if tree is empty, create a new node and set root
        if (root == null) {
            return new Node(key);
        }

        // traverse the tree and find parent node of key
        while (curr != null)
        {
            // update parent node as current node
            parent = curr;

            // if given key is less than the current node,
            // go to left subtree else go to right subtree
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }

        // construct a new node and assign to appropriate parent pointer
        if (key < parent.data) {
            parent.left = new Node(key);
        }
        else {
            parent.right = new Node(key);
        }

        return root;
    }

    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key: keys) {
            root = insertIterative(root, key);
        }

        inorder(root);
    }
}