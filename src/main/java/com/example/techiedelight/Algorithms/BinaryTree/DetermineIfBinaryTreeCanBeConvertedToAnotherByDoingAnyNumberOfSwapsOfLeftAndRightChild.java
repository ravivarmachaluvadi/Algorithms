package com.example.techiedelight.Algorithms.BinaryTree;

class DetermineIfBinaryTreeCanBeConvertedToAnotherByDoingAnyNumberOfSwapsOfLeftAndRightChild
{
    // Function to determine if two given binary trees can be transformed
    // to each other by doing any number of swaps of left and right subtree
    public static boolean equal(NodeData X, NodeData Y)
    {
        // base case: both trees are same (handles case when both trees are empty)
        if (X == Y) {
            return true;
        }
 
        return (X != null && Y!= null ) && (X.data == Y.data) &&
                ((equal(X.left, Y.left) && equal(X.right, Y.right)) ||
                (equal(X.right, Y.left) && equal(X.left, Y.right)));
    }
 
    public static void main(String[] args)
    {
        // construct first tree
        NodeData X = new NodeData(6);
        X.left = new NodeData(3);
        X.right = new NodeData(8);
        X.left.left = new NodeData(1);
        X.left.right = new NodeData(7);
        X.right.left = new NodeData(4);
        X.right.right = new NodeData(2);
        X.right.left.left = new NodeData(1);
        X.right.left.right = new NodeData(7);
        X.right.right.right  = new NodeData(3);
 
        // construct second tree
        NodeData Y = new NodeData(6);
        Y.left = new NodeData(8);
        Y.right = new NodeData(3);
        Y.left.left = new NodeData(2);
        Y.left.right = new NodeData(4);
        Y.right.left = new NodeData(7);
        Y.right.right = new NodeData(1);
        Y.left.left.left = new NodeData(3);
        Y.left.right.left = new NodeData(1);
        Y.left.right.right = new NodeData(7);
 
        if (equal(X, Y)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}