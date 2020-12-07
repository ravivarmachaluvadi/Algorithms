package com.example.techiedelight.Algorithms.BinaryTree;

class SinkNodesContainingZeroToTheBottomOfABinaryTree
{
 
    // Function to perform in-order traversal of given binary tree
    public static void inorder(Node root)
    {
        if (root == null)
            return;
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // Function to sink root node having value 0 to the bottom of the tree
    // The left and right subtree (if any) of root node are already sinked
    public static void sink(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return;
        }
 
        // if left subtree exists & left child has non-zero value
        if (root.left != null && root.left.key != 0)
        {
            // swap key of current node with its left child
            int temp = root.key;
            root.key = root.left.key;
            root.left.key = temp;
 
            // recur for left subtree
            sink(root.left);
        }
 
        // if right subtree exists & right child has non-zero value
        else if (root.right != null && root.right.key != 0)
        {
            // swap key of current node with its right child
            int temp = root.key;
            root.key = root.right.key;
            root.right.key = temp;
 
            // recur for right subtree
            sink(root.right);
        }
    }
 
    // SinkNodesContainingZeroToTheBottomOfABinaryTree function to sink nodes having zero value to the bottom
    // of the binary tree
    public static void sinkNodes(Node root)
    {
        // base case: tree is empty
        if (root == null) {
            return;
        }
 
        // fix left subtree and right subtree first
        sinkNodes(root.left);
        sinkNodes(root.right);
 
        // sink current node it has value 0
        if (root.key == 0) {
            sink(root);
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  0
                /   \
               /     \
              1       0
                    /   \
                   /     \
                  0       2
                /   \
               /     \
              3       4
        */
 
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(0);
        root.right.right = new Node(2);
        root.right.left.left = new Node(3);
        root.right.left.right  = new Node(4);
 
        sinkNodes(root);
 
        inorder(root);
    }
}