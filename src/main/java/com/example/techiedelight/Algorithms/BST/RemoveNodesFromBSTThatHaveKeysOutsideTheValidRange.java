package com.example.techiedelight.Algorithms.BST;

class RemoveNodesFromBSTThatHaveKeysOutsideTheValidRange
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
 
    // Function to truncate the BST and remove nodes having keys
    // outside valid range
    public static Node truncate(Node root, int min, int max)
    {
        // base case
        if (root == null) {
            return root;
        }
 
        // recursively truncate left and right subtree first
        root.left = truncate(root.left, min, max);
        root.right = truncate(root.right, min, max);
 
        // if root's key is smaller than the minimum allowed, delete it
        if (root.data < min) {
            root = root.right;
        }
        // if root's key is larger than the maximum allowed, delete it
        else if (root.data > max) {
            root = root.left;
        }
 
        return root;
    }
 
    // Remove nodes from BST that have keys outside the valid range
    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below tree
              15
             /  \
            /    \
          10      20
         / \      / \
        /   \    /   \
        8    12  16   25
        */
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // [9, 12] is valid range
        root = truncate(root, 9, 12);
        inorder(root);
    }
}