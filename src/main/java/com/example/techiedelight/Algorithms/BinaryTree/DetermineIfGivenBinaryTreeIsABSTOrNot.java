package com.example.techiedelight.Algorithms.BinaryTree;

class DetermineIfGivenBinaryTreeIsABSTOrNot
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Function to determine if given Binary Tree is a BST or not by keeping a
    // valid range (starting from [MIN_VALUE, MAX_VALUE]) and keep shrinking
    // it down for each node as we go down recursively
    public static boolean isBST(Node node, int minKey, int maxKey)
    {
        // base case
        if (node == null) {
            return true;
        }
 
        // if node's value fall outside valid range
        if (node.key < minKey || node.key > maxKey) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, minKey, node.key) &&
            isBST(node.right, node.key, maxKey);
    }
 
    // Function to determine if given Binary Tree is a BST or not
    public static void isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }
    }
 
    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // swap left and right nodes
        swap(root);
        isBST(root);
    }
}




class DetermineIfGivenBinaryTreeIsABSTOrNotA2
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.key) {
            root.left = insert(root.left, key);
        }

        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }


    // Function to perform inorder traversal of the given binary tree and
    // check if it is a BST or not. Here prev is previous processed node
    public static boolean isBST(Node root, Node prev)
    {
        // base case: empty tree is a BST
        if (root == null) {
            return true;
        }

        // check if left subtree is BST or not
        boolean left = isBST(root.left, prev);

        // value of current node should be more than that of previous node
        if (root.key <= prev.key) {
            return false;
        }

        // update previous node key and check if right subtree is BST or not
        prev.key = root.key;

        return left && isBST(root.right, prev);
    }

    // Function to determine if given Binary Tree is a BST or not
    public static void isBST(Node node)
    {
        // pointer to store previous processed node in inorder traversal
        Node prev = new Node(Integer.MIN_VALUE);

        // check if nodes are nodes are processed in sorted order
        if (isBST(node, prev)) {
            System.out.println("This is a BST.");
        } else {
            System.out.println("This is NOT a BST!");
        }
    }

    private static void swap(Node root) {
        Node left = root.left;
        root.left = root.right;
        root.right = left;
    }

    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        for (int key : keys) {
            root = insert(root, key);
        }

        // swap nodes
        swap(root);
        isBST(root);
    }
}