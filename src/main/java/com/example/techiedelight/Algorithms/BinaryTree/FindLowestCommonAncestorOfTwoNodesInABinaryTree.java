package com.example.techiedelight.Algorithms.BinaryTree;

class FindLowestCommonAncestorOfTwoNodesInABinaryTree
{
    // Wrapper over Node class
    static class NodeWrapper {
        public NodeData node;
 
        NodeWrapper(NodeData node) {
            this.node = node;
        }
    }
 
    // Function to check if given node is present in binary tree or not
    public static boolean isNodePresent(NodeData root, NodeData node)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        // if node is found, return true
        if (root == node) {
            return true;
        }
 
        // return true if node is found in the left subtree or right subtree
        return isNodePresent(root.left, node) || isNodePresent(root.right, node);
    }
 
    // Function to find lowest common ancestor of given nodes x and y where
    // both x and y are present in the binary tree.
    // The function returns true if x or y is found in subtree rooted at root
    // lca -> stores LCA(x, y)
    public static boolean findLCA(NodeData root, NodeWrapper lca, NodeData x, NodeData y)
    {
        // base case 1: return false if tree is empty
        if (root == null) {
            return false;
        }
 
        // base case 2: return true if either x or y is found
        if (root == x || root == y)
        {
            // set lca to current node
            lca.node = root;
            return true;
        }
 
        // recursively check if x or y exists in the left subtree
        boolean left = findLCA(root.left, lca, x, y);
 
        // recursively check if x or y exists in the right subtree
        boolean right = findLCA(root.right, lca, x, y);
 
        // if x is found in one subtree and y is found in other subtree,
        // update lca to current node
        if (left && right) {
            lca.node = root;
        }
 
        // return true if x or y is found in either left or right subtree
        return left || right;
    }
 
    // Function to find lowest common ancestor of nodes x and y
    public static void findLCA(NodeData root, NodeData x, NodeData y)
    {
        // lca stores lowest common ancestor
        NodeData lca = null;
 
        // Wrap lca node so it's reference can be changed inside findLCA() method
        NodeWrapper LCA = new NodeWrapper(lca);
 
        // call LCA procedure only if both x and y are present in the tree
        if (isNodePresent(root, y) && isNodePresent(root, x)) {
            findLCA(root, LCA, x, y);
            lca = LCA.node;
        }
 
        // if LCA exists, print it
        if (lca != null) {
            System.out.println("LCA is " + lca.data);
        } else {
            System.out.print("LCA do not exist\n");
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2          3
           \     / \
            4   5   6
               / \
              7   8
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.right = new NodeData(4);
        root.right.left = new NodeData(5);
        root.right.right = new NodeData(6);
        root.right.left.left = new NodeData(7);
        root.right.right.right = new NodeData(8);
 
        findLCA(root, root.right.left.left, root.right.right);
        findLCA(root, root.right.left.left, new NodeData(10));
        findLCA(root, root.right.left.left, root.right.left.left);
        findLCA(root, root.right.left.left, root.right.left);
        findLCA(root, root.left, root.right.left);
    }
}