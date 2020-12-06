package com.example.techiedelight.Algorithms.BinaryTree;

class CheckIfABinaryTreeIsSymmetricOrNot
{
    // Function to check if subtree rooted at X and Y are mirror images
    // of each other or not
    public static boolean isSymmetric(Node X, Node Y)
    {
        // base case: if both tree are empty
        if (X == null && Y == null) {
            return true;
        }
 
        // return true if
        // 1. both trees are non-empty and
        // 2. left subtree is mirror image of right subtree and
        // 3. right subtree is mirror image of left subtree
        return (X != null && Y != null) &&
                       isSymmetric(X.left, Y.right) &&
                       isSymmetric(X.right, Y.left);
    }
 
    // Function to check if given binary Tree has a symmetric structure or not
    public static boolean isSymmetric(Node root)
    {
        // return true if left subtree and right subtree are
        // mirror images or each other
        return isSymmetric(root.left, root.right);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2       3
           \     /
            5   6
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(5);
 
        if (isSymmetric(root)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}