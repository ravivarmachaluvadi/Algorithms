package com.example.techiedelight.Algorithms.BinaryTree;

class ConstructACartesianTreeFromInOrderTraversal
{
    // Recursive function to perform inorder traversal of a Cartesian tree
    public static void inorderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorderTraversal(root.left);
        System.out.print(root.key + " ");
        inorderTraversal(root.right);
    }
 
    // Function to find index of the minimum element in inorder[start, end]
    public static int minElementIndex(int[] inorder, int start, int end)
    {
        int minIndex = start;
        for (int i = start + 1; i <= end; i++)
        {
            if (inorder[minIndex] > inorder[i]) {
                minIndex = i;
            }
        }
 
        return minIndex;
    }
 
    // Recursive function to construct a Cartesian tree from given
    // inorder sequence
    public static Node constructTree(int[] inorder, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // Find index of the minimum element in inorder[start, end]
        int index = minElementIndex(inorder, start, end);
 
        // The minimum element in given range of inorder sequence becomes the root
        Node root = new Node(inorder[index]);
 
        // recursively construct the left subtree
        root.left  = constructTree(inorder, start, index - 1);
 
        // recursively construct the right subtree
        root.right = constructTree(inorder, index + 1, end);
 
        // return current node
        return root;
    }
 
    public static void main(String[] args)
    {
        // input sequence of numbers representing the in-order sequence
        int[] inorder = { 9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5 };
 
        // construct the Cartesian tree
        Node root = constructTree(inorder, 0, inorder.length - 1);
 
        // print the Cartesian tree
        System.out.print("Inorder Traversal of constructed Cartesian tree is: ");
        inorderTraversal(root);
    }
}