package com.example.techiedelight.Algorithms.BinaryTree;

class FixABinaryTreeThatIsOnlyOneSwapAwayFromBecomingABST
{
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;
 
        NodeWrapper() {
            this.node = null;
        }
 
        NodeWrapper(int key) {
            this.node = new Node(key);
        }
    }
 
    // Function to perform in-order traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // Function to exchange key of given linked list nodes
    public static void swapData(Node first, Node second)
    {
        int key = first.key;
        first.key = second.key;
        second.key = key;
    }
 
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
 
    // Recursive function to fix a binary tree that is only one swap
    // away from becoming a BST. Here, prev is previous processed node in
    // in-order traversal and x, y stores node to be swapped (if any)
    public static void correctBST(Node root, NodeWrapper x, NodeWrapper y, NodeWrapper prev)
    {
        // base case
        if (root == null) {
            return;
        }
 
        // recur for left subtree
        correctBST(root.left, x, y, prev);
 
        // if current node is less than the previous node
        if (root.key < prev.node.key)
        {
            // if this is first occurrence, update x and y to previous node
            // and current node respectively
            if (x.node == null) {
                x.node = prev.node;
            }
 
            // if this is second occurrence, update y to current node
            y.node = root;
        }
 
        // update previous node and recur for right subtree
        prev.node = root;
        correctBST(root.right, x, y, prev);
    }
 
    // Fix given binary tree that is only one swap away from becoming a BST
    public static void correctBST(Node root)
    {
        // Wrap x, y, prev nodes so their reference can be changed
        // inside the correctBST() method
 
        // x and y stores node to be swapped
        NodeWrapper x = new NodeWrapper();
        NodeWrapper y = new NodeWrapper();
 
        // stores previous processed node in in-order traversal
        // initialize it by minus infinity
        NodeWrapper prev = new NodeWrapper(Integer.MIN_VALUE);
 
        // fix the binary tree
        correctBST(root, x, y, prev);
 
        // swap the nodes
        if (x.node != null && y.node != null ) {
            swapData(x.node, y.node);
        }
    }
 
    public static void main(String[] args)
    {
        Node root = null;
        /* Construct below BST
                  15
                /    \
               /      \
              10       20
             /  \     /  \
            /    \   /    \
           8     12 16    25
        */
 
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
 
        for (int key : keys) {
            root = insert(root, key);
        }
 
        // swap any two nodes values
        swapData(root.left, root.right.right);
 
        // fix the BST
        correctBST(root);
 
        // print the BST after fixing it
        inorder(root);
    }
}