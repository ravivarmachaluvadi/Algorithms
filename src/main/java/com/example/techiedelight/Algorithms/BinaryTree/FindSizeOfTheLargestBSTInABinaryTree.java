package com.example.techiedelight.Algorithms.BinaryTree;

class FindSizeOfTheLargestBSTInABinaryTree
{
    // Recursive function to calculate the size of a given binary tree
    public static int size(Node root)
    {
        // base case: empty tree has size 0
        if (root == null) {
            return 0;
        }
 
        // recursively calculate the size of left and right subtrees and
        // return sum of size of left and right subtrees + 1 (for root node)
        return size(root.left) + 1 + size(root.right);
    }
 
    // Recursive function to determine if given Binary Tree is a BST or not
    // by keeping a valid range (starting from [MIN_VALUE, MAX_VALUE]) and
    // keep shrinking it down for each node as we go down recursively
    public static boolean isBST(Node node, int min, int max)
    {
        // base case
        if (node == null)
            return true;
 
        // if node's value fall outside valid range
        if (node.key < min || node.key > max) {
            return false;
        }
 
        // recursively check left and right subtrees with updated range
        return isBST(node.left, min, node.key) &&
            isBST(node.right, node.key, max);
    }
 
    // Recursive function to find the size of the largest BST in a given binary tree
    public static int findLargestBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }
 
        return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }
 
    public static void main(String[] args)
    {
        /* Construct below binary tree
                  10
                /    \
               /      \
              15       8
             /  \     / \
            /    \   /   \
           12    20 5     2
        */
 
        Node root = new Node(10);
 
        root.left = new Node(15);
        root.right = new Node(8);
 
        root.left.left = new Node(12);
        root.left.right = new Node(20);
 
        root.right.left = new Node(5);
        root.right.right = new Node(2);
 
        System.out.println("The size of the largest BST is " + findLargestBST(root));
    }
}




// key structure to store information about binary tree rooted under a node
class SubTreeInfo
{
    // stores the min and the max value in the binary tree rooted under the current node
    // min, max fields are relevant only if isBST flag is true
    int min, max;

    // stores the size of largest BST in binary tree rooted under the current node
    int size;

    // true if binary tree rooted under the current node is a BST
    boolean isBST;

    // Constructor
    SubTreeInfo(int min, int max, int size, boolean isBST)
    {
        this.min = min;
        this.max = max;
        this.size = size;
        this.isBST = isBST;
    }
}

class FindSizeOfTheLargestBSTInABinaryTreeA2
{
    // Recursive function to find the size of the largest BST in a given binary tree
    public static SubTreeInfo findLargestBST(Node root)
    {
        // Base case: empty tree
        if (root == null) {
            return new SubTreeInfo(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }

        // Recur for left subtree and right subtrees
        SubTreeInfo left = findLargestBST(root.left);
        SubTreeInfo right = findLargestBST(root.right);

        SubTreeInfo info = null;

        // Check if binary tree rooted under the current root is a BST

        // 1. Left and right subtree are also BST
        // 2. The value of the root node should be more than the largest value
        //    in the left subtree
        // 3. The value of the root node should be less than the smallest value
        //    in the right subtree
        if (left.isBST && right.isBST &&
                (root.key > left.max && root.key < right.min))
        {
            info = new SubTreeInfo(Math.min(root.key, Math.min(left.min, right.min)),
                    Math.max(root.key, Math.max(left.max, right.max)),
                    left.size + 1 + right.size,
                    true);
        }
        else
        {
            // If binary tree rooted under the current root is not a BST
            // return the size of largest BST in its left and right subtree

            info = new SubTreeInfo(0, 0, Math.max(left.size, right.size), false);
        }

        return info;
    }

    public static void main(String[] args)
    {
        /* Construct below binary tree
                      10
                    /    \
                   /      \
                  15       8
                 / \      / \
                /   \    /   \
               12   20  5     9
              / \      / \     \
             /   \    /   \     \
            2    14  4    7     10
        */

        Node root = new Node(10);

        root.left = new Node(15);
        root.right = new Node(8);

        root.left.left = new Node(12);
        root.left.right = new Node(20);
        root.right.left = new Node(5);
        root.right.right = new Node(9);

        root.left.left.left = new Node(2);
        root.left.left.right = new Node(14);
        root.right.left.left = new Node(4);
        root.right.left.right = new Node(7);

        root.right.right.right = new Node(10);

        System.out.print("The size of the largest BST is " +
                findLargestBST(root).size);
    }
}