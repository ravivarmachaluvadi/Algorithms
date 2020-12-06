package com.example.techiedelight.Algorithms.BinaryTree;

class CheckIfGivenBinaryTreeIsASumTreeOrNot
{
    // Recursive function to check if given binary tree is a sum tree or not
    public static int isSumTree(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return 0;
        }
 
        // special case: leaf node
        if (root.left == null && root.right == null) {
            return root.key;
        }
 
        // if root's value is equal to sum of all elements present in its
        // left and right subtree
        if (root.key == isSumTree(root.left) + isSumTree(root.right)) {
            return 2 * root.key;
        }
 
        return Integer.MIN_VALUE;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                 44
                /  \
               /    \
              9     13
             / \    / \
            4   5  6   7
        */
 
        Node root = new Node(44);
        root.left = new Node(9);
        root.right = new Node(13);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isSumTree(root) != Integer.MIN_VALUE) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}