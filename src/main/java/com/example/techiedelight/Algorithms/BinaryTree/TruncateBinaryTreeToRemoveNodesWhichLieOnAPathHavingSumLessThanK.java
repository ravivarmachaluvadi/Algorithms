package com.example.techiedelight.Algorithms.BinaryTree;

class TruncateBinaryTreeToRemoveNodesWhichLieOnAPathHavingSumLessThanK
{
    // Function to perform inorder traversal of the tree
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
 
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // TruncateBinaryTreeToRemoveNodesWhichLieOnAPathHavingSumLessThanK function to truncate given binary tree to remove nodes
    // which lie on a path having sum less than k
    public static Node trunc(Node curr, int k, int sum)
    {
        // base case: empty tree
        if (curr == null) {
            return null;
        }
 
        // update sum of nodes in path from root node to current node
        sum = sum + (curr.key);
 
        // Recursively truncate left and right subtrees
        curr.left = trunc(curr.left, k, sum);
        curr.right = trunc(curr.right, k, sum);
 
        // Since we are doing postorder traversal, it is possible that subtree rooted
        // at current node is already truncated and current node is a leaf now
 
        // if current node is a leaf node and its path from root node has sum
        // less than the required sum, remove it
        if (sum < k && isLeaf(curr)) {
            // set current node as null
            return null;
        }
 
        return curr;
    }
 
    // Function to truncate given binary tree to remove nodes which lie on
    // a path having sum less than k
    public static Node truncate(Node root, int k)
    {
        int sum = 0;
        return trunc(root, k, sum);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  6
                /   \
               /     \
              3       8
                    /   \
                   /     \
                  4          2
                /   \      \
               /     \      \
              1       7      3
        */
 
        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.right.left = new Node(4);
        root.right.right = new Node(2);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(7);
        root.right.right.right  = new Node(3);
 
        int k = 20;
        root = truncate(root, k);
        inorder(root);
    }
}