package com.example.techiedelight.Algorithms.BST;

class DeletionFromBinarySearchTree
{
    // Function to perform inorder traversal of the BST
    public static void inorder(Node root)
    {
        if (root == null)
            return;
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 
    // Helper function to find minimum value node in subtree rooted at curr
    public static Node minimumKey(Node curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
 
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
 
    // Function to delete node from a BST
    public static Node deleteNode(Node root, int key)
    {
        // pointer to store parent node of current node
        Node parent = null;
 
        // start with root node
        Node curr = root;
 
        // search key in BST and set its parent pointer
        while (curr != null && curr.data != key)
        {
            // update parent node as current node
            parent = curr;
 
            // if given key is less than the current node, go to left subtree
            // else go to right subtree
            if (key < curr.data) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        // return if key is not found in the tree
        if (curr == null) {
            return root;
        }
 
        // Case 1: node to be deleted has no children i.e. it is a leaf node
        if (curr.left == null && curr.right == null)
        {
            // if node to be deleted is not a root node, then set its
            // parent left/right child to null
            if (curr != root) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            // if tree has only root node, delete it and set root to null
            else {
                root = null;
            }
        }
 
        // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null)
        {
            // find its in-order successor node
            Node successor  = minimumKey(curr.right);
 
            // store successor value
            int val = successor.data;
 
            // recursively delete the successor. Note that the successor
            // will have at-most one child (right child)
            deleteNode(root, successor.data);
 
            // Copy the value of successor to current node
            curr.data = val;
        }
 
        // Case 3: node to be deleted has only one child
        else
        {
            // find child node
            Node child = (curr.left != null)? curr.left: curr.right;
 
            // if node to be deleted is not a root node, then set its parent
            // to its child
            if (curr != root)
            {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
 
            // if node to be deleted is root node, then set the root to child
            else {
                root = child;
            }
        }
 
        return root;
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16 };
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        root = deleteNode(root, 16);
        inorder(root);
    }
}





class DeletionFromBinarySearchTreeA2
{
    // Function to perform inorder traversal of the BST
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Helper function to find maximum value node in subtree rooted at ptr
    public static Node maximumKey(Node ptr)
    {
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        return ptr;
    }

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

    // Function to delete node from a BST
    public static Node deleteNode(Node root, int key)
    {
        // base case: key not found in tree
        if (root == null) {
            return null;
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        // if given key is more than the root node, recur for right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }

        // key found
        else
        {
            // Case 1: node to be deleted has no children (it is a leaf node)
            if (root.left == null && root.right == null) {
                // update root to null
                return null;
            }

            // Case 2: node to be deleted has two children
            else if (root.left != null && root.right != null)
            {
                // find its in-order predecessor node
                Node predecessor = maximumKey(root.left);

                // Copy the value of predecessor to current node
                root.data = predecessor.data;

                // recursively delete the predecessor. Note that the
                // predecessor will have at-most one child (left child)
                root.left = deleteNode(root.left, predecessor.data);
            }

            // Case 3: node to be deleted has only one child
            else
            {
                // find child node
                Node child = (root.left != null) ? root.left: root.right;
                root = child;
            }
        }

        return root;
    }

    public static void main(String[] args)
    {
        Node root = null;
        int[] keys = { 15, 10, 20, 8, 12, 25 };

        for (int key : keys) {
            root = insert(root, key);
        }

        root = deleteNode(root, 12);
        inorder(root);
    }
}