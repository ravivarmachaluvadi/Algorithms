package com.example.techiedelight.Algorithms.BinaryTree;

class CalculateHeightOfABinaryTreeWithLeafNodesFormingACircularDoublyLinkedList
{
    // Recursive function to calculate height of a binary tree with
    // leaf nodes forming a circular doubly linked list
    public static int height(Node node)
    {
        // base case: if node is null
        if (node == null) {
            return 0;
        }
 
        // node is a leaf if its left's right and its right's left
        // are pointing to the node itself
        if ((node.left != null && node.left.right == node) &&
                    (node.right != null  && node.right.left == node)) {
            return 1;
        }
 
        // recur for left and right subtree and consider maximum depth
        return 1 + Math.max(height(node.left), height(node.right));
    }
 
    public static void main(String[] args)
    {
        // construct the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);         // leaf node
        root.right.right = new Node(6);        // leaf node
        root.left.left.left = new Node(7);    // leaf node
 
        // construct circular doubly linked list from leaves
        Node first = root.left.left.left;
        Node second = root.left.right;
        Node third = root.right.right;
 
        // set previous and next pointers of the linked list
        // (left and right pointer of binary tree node respectively)
        first.left = third;
        first.right = second;
 
        second.left = first;
        second.right = third;
 
        third.left = second;
        third.right = first;
 
        System.out.println("The height of given binary tree is " + height(root));
    }
}