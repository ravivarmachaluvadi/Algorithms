package com.example.techiedelight.Algorithms.BST;

class FindInorderSuccessorForGivenKeyInABST
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
 
 
    // Helper function to find minimum value node in given BST
    public static Node findMinimum(Node root)
    {
        while (root.left != null) {
            root = root.left;
        }
 
        return root;
    }
 
    // Recursive function to find inorder successor for given key in a BST
    public static Node findSuccessor(Node root, Node succ, int key)
    {
        // base case
        if (root == null) {
            return null;
        }
 
        // if node with key's value is found, the successor is minimum
        // value node in its right subtree (if any)
        if (root.data == key)
        {
            if (root.right != null) {
                return findMinimum(root.right);
            }
        }
 
        // if given key is less than the root node, recur for left subtree
        else if (key < root.data)
        {
            // update successor to current node before recursing in
            // left subtree
            succ = root;
            return findSuccessor(root.left, succ, key);
        }
 
        // if given key is more than the root node, recur for right subtree
        else {
            return findSuccessor(root.right, succ, key);
        }
 
        return succ;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                   15
                 /    \
                /      \
               10       20
              /  \     /  \
             /    \   /    \
            8     12 16    25
        */
 
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
 
        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // find in-order successor for each key
        for (int key : keys)
        {
            Node prec = findSuccessor(root, null, key);
 
            if (prec != null) {
                System.out.println("Successor of node " + key + " is "
                                    + prec.data);
            } else {
                System.out.println("Successor doesn't exists for node "
                                    + key);
            }
        }
    }
}





class FindInorderSuccessorForGivenKeyInABSTIterative
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


    // Helper function to find minimum value node in given BST
    public static Node findMinimum(Node root)
    {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Iterative function to find inorder successor for given key in a BST
    public static Node findSuccessor(Node root, int key)
    {
        Node succ = null;

        while (true)
        {
            // if given key is less than the root node, visit left subtree
            if (key < root.data)
            {
                // update successor to current node before visiting
                // left subtree
                succ = root;
                root = root.left;
            }

            // if given key is more than the root node, visit right subtree
            else if (key > root.data)
            {
                root = root.right;
            }

            // if node with key's value is found, the successor is minimum
            // value node in its right subtree (if any)
            else
            {
                if (root.right != null) {
                    succ = findMinimum(root.right);
                }
                break;
            }

            // if key doesn't exist in binary tree
            if (root == null)
                return null;
        }

        // return Successor if any
        return succ;
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                   15
                 /    \
                /      \
               10       20
              /  \     /  \
             /    \   /    \
            8     12 16    25
        */

        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        // find in-order successor for each key
        for (int key : keys)
        {
            Node prec = findSuccessor(root, key);

            if (prec != null) {
                System.out.println("Successor of node " + key + " is "
                        + prec.data);
            } else {
                System.out.println("Successor doesn't exists for node "
                        + key);
            }
        }
    }
}