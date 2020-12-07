package com.example.techiedelight.Algorithms.BinaryTree;

class FindTheDifferenceBetweenSumOfAllNodesPresentAtOddAndEvenLevelsInABinaryTree
{
    // Helper function
    public static int findDiff(Node root, int diff, int level)
    {
        // base case
        if (root == null) {
            return diff;
        }
 
        // if current level is odd
        if (level % 2 == 1) {
            diff = diff + root.key;
        }
        // if current level is even
        else {
            diff = diff - root.key;
        }
 
        // recur for left subtree and right subtree
        diff = findDiff(root.left, diff, level + 1);
        diff = findDiff(root.right, diff, level + 1);
 
        return diff;
    }
 
    // Function to calculate the difference between sum of all nodes present
    // at odd levels and sum of all nodes present at even level
    public static int findDiff(Node root)
    {
        return findDiff(root, 0, 1);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
         */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        System.out.print(findDiff(root));
    }
}