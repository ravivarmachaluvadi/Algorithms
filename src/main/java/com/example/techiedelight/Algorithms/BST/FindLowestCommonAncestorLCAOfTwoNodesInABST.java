package com.example.techiedelight.Algorithms.BST;

class FindLowestCommonAncestorLCAOfTwoNodesInABST
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
 
    // Iterative function to search a given key in root
    public static boolean search(Node root, int key)
    {
        // traverse the tree and search for the key
        while (root != null)
        {
            // if given key is less than the current node, go to left
            // subtree else go to right subtree
 
            if (key < root.data) {
                root = root.left;
            }
            else if (key > root.data) {
                root = root.right;
            }
            // if key is found return true
            else {
                return true;
            }
        }
 
        // we reach here if the key is not present in the BST
        return false;
    }
 
    // Recursive function to find Lowest Common Ancestor of given nodes
    // x and y where both x and y are present in the Binary Search Tree
    public static Node LCARecursive(Node root, int x, int y)
    {
        // base case: empty tree
        if (root == null) {
            return null;
        }
 
        // if both x and y is smaller than root, LCA exists in left subtree
        if (root.data > Integer.max(x, y)) {
            return LCARecursive(root.left, x, y);
        }
 
        // if both x and y is greater than root, LCA exists in right subtree
        else  if (root.data < Integer.min(x, y)) {
            return LCARecursive(root.right, x, y);
        }
 
        // if one key is greater (or equal) than root and one key is smaller
        // (or equal) than root, then the current node is LCA
        return root;
    }
 
    // Print Lowest Common Ancestor of two nodes in a BST
    public static void LCA(Node root, int x, int y)
    {
        // return if tree is empty or either x or y is not present
        // in the tree
        if (root == null || !search(root, x) || !search(root, y)) {
            return;
        }
 
        // lca stores lowest common ancestor of x and y
        Node lca = LCARecursive(root, x, y);
 
        // if lowest common ancestor exists, print it
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        }
        else {
            System.out.println("LCA do not exist");
        }
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below tree
             15
            /  \
           /    \
          10     20
         / \     / \
        /   \   /   \
        8   12 16   25
        */
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        LCA(root, 8, 12);
    }
}






class FindLowestCommonAncestorLCAOfTwoNodesInABSTIterative
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

    // Iterative function to search a given key in root
    public static boolean search(Node root, int key)
    {
        // traverse the tree and search for the key
        while (root != null)
        {
            // if given key is less than the current node, go to left
            // subtree else go to right subtree

            if (key < root.data) {
                root = root.left;
            }
            else if (key > root.data) {
                root = root.right;
            }
            // if key is found return true
            else {
                return true;
            }
        }

        // we reach here if the key is not present in the BST
        return false;
    }

    // Iterative function to find Lowest Common Ancestor of given nodes
    // in the Binary Search Tree
    public static Node LCA(Node root, int x, int y)
    {
        // return if tree is empty or either x or y is not present
        // in the tree
        if (root == null || !search(root, x) || !search(root, y)) {
            return null;
        }

        // start from root node
        Node curr = root;

        // traverse the tree
        while (curr != null)
        {
            // if both x & y is smaller than root, LCA exists in left subtree
            if (curr.data > Integer.max(x, y)) {
                curr = curr.left;
            }

            // if both x & y is greater than root, LCA exists in right subtree
            else if (curr.data < Integer.min(x, y)) {
                curr = curr.right;
            }

            // if one key is greater (or equal) than root and one key is
            // smaller (or equal) than root, then the current node is LCA
            else {
                return curr;
            }
        }
        return curr;
    }

    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below tree
             15
            /  \
           /    \
          10     20
         / \     / \
        /   \   /   \
        8   12 16   25
        */
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = insert(root, key);
        }

        // lca stores lowest common ancestor of 8 and 12
        Node lca = LCA(root, 8, 12);

        // if lowest common ancestor exists, print it
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        } else {
            System.out.println("LCA do not exist");
        }
    }
}