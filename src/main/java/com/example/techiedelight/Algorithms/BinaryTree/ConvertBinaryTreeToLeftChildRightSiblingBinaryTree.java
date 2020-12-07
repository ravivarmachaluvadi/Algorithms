package com.example.techiedelight.Algorithms.BinaryTree;

class ConvertBinaryTreeToLeftChildRightSiblingBinaryTree
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
 
 
    // Function to convert a normal binary tree to Left-child
    // right-sibling (LC-RS) binary tree
    public static void convert(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // recursively convert left and right subtree first
        convert(root.left);
        convert(root.right);
 
        // if left child is empty, then make right child as left's
        // and set right to null
        if (root.left == null)
        {
            root.left = root.right;
            root.right = null;
        }
 
        // if left child already exists, then make right child of the
        // left child to point to right child of current node and
        // set current right child as null
        else
        {
            root.left.right = root.right;
            root.right = null;
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below Tree
                  1
                /  \
               /    \
              2      3
             / \    /
            4   5  6
                  / \
                 7   8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        convert(root);
        preorder(root);
    }
}