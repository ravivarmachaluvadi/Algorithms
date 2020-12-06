package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayList;
import java.util.List;

class DetermineIfGivenBinaryTreeIsASubtreeOfAnotherBinaryTreeOrNot
{
    // Function to store in-order traversal of the tree in a list
    public static void inorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }
 
    // Function to store post-order traversal of the tree in a list
    public static void postorder(Node node, List<Node> list)
    {
        if (node == null) {
            return;
        }
 
        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node);
    }
 
    // Utility function to convert the list to a string and remove opening &
    // closing Brackets from it
    public static String toString(List<Node> list) {
        if (list == null) {
            return "";
        }
        return list.toString().replace("[", "").replace("]", "");
    }
 
    // Function to check if given binary tree is a subtree of another
    // binary tree or not
    public static boolean checkSubtree(Node tree, Node subtree)
    {
        // base case: both trees are same
        if (tree == subtree) {
            return true;
        }
 
        // base case: if first tree is empty but second tree is non-empty
        if (tree == null) {
            return false;
        }
 
        // store in-order traversal of both trees in first and second respectively
        List<Node> first = new ArrayList<>(), second = new ArrayList<>();
        inorder(tree, first);
        inorder(subtree, second);
 
        // return false if second list is not a sub-list of first list
        if (!toString(first).contains(toString(second))) {
            return false;
        }
 
        // reset both lists
        first.clear();
        second.clear();
 
        // Now store post-order traversal of both trees in first and second respectively
        postorder(tree, first);
        postorder(subtree, second);
 
        // return false if second list is not a sub-list of first list
        if (!toString(first).contains(toString(second))) {
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (checkSubtree(root, root.right)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }
}