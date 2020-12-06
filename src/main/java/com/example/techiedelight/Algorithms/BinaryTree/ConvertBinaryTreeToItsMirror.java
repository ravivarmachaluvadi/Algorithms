package com.example.techiedelight.Algorithms.BinaryTree;

class ConvertBinaryTreeToItsMirror
{
    // Function to perform preorder traversal of the binary tree
    public static void preorder(NodeData root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Utility function to swap left subtree with right subtree
    public static void swap(NodeData root) {
        if (root == null) {
            return;
        }

        NodeData temp = root.left;
        root.left =  root.right;
        root.right = temp;
    }
 
    // Function to convert given binary Tree to its mirror
    public static void convertToMirror(NodeData root)
    {
        // base case: if tree is empty
        if (root == null) {
            return;
        }
 
        // convert left subtree
        convertToMirror(root.left);
 
        // convert right subtree
        convertToMirror(root.right);
 
        // swap left subtree with right subtree
        swap(root);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2       3
         / \     / \
        4   5   6   7   */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.left = new NodeData(4);
        root.left.right = new NodeData(5);
        root.right.left = new NodeData(6);
        root.right.right = new NodeData(7);
 
        convertToMirror(root);
        preorder(root);
    }
}