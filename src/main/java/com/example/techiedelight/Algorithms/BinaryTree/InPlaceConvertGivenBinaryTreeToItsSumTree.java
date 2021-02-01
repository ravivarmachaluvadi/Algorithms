package com.example.techiedelight.Algorithms.BinaryTree;

class InPlaceConvertGivenBinaryTreeToItsSumTree
{
    // Function to print pre-order traversal of given tree
    public static void preorder(NodeData root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Recursive function to in-place convert the given binary tree to its
    // sum tree by traversing the tree in post-order manner
    public static int convertToSumTree(NodeData root)
    {
        // base case: tree is empty
        if (root == null) {
            return 0;
        }
 
        // recursively convert left and right subtree first before
        // processing the root node
        int left = convertToSumTree(root.left);
        int right = convertToSumTree(root.right);
 
        // stores current value of root node
        int old = root.data;
 
        // update root to sum of left and right subtree
        root.data = left + right;
 
        // return the updated value plus old value (sum of tree rooted at root node)
        return root.data + old;
    }
 
    public static void main(String[] args)
    {
        NodeData root = null;
        root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.right = new NodeData(4);
        root.right.left = new NodeData(5);
        root.right.right = new NodeData(6);
        root.right.left.left = new NodeData(7);
        root.right.left.right = new NodeData(8);
 
        convertToSumTree(root);
        preorder(root);
    }
}



class NodeData
{
    int data;
    NodeData left = null, right = null;

    NodeData(int data) {
        this.data = data;
    }

    // Utility function to check if a given node is a leaf node
    boolean isLeaf() {
        return this.left == null && this.right == null;
    }
}