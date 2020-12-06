package com.example.techiedelight.Algorithms.BinaryTree;

class DetermineIfGivenTwoNodesAreCousinsOfEachOther
{
    // Data structure to store a Binary Tree node along
    // with its level and parent information
    static class NodeInfo
    {
        int key;
        int level;
        Node parent = null;
 
        NodeInfo(int key, int level, Node parent) {
            this.key = key;
            this.level = level;
            this.parent = parent;
        }
    }
 
    // Perform in-order traversal of the binary tree and update x and y
    public static void inorder(Node root, Node parent, int level, NodeInfo x, NodeInfo y)
    {
        // base case: tree is empty
        if (root == null) {
            return;
        }
 
        // traverse left subtree
        inorder(root.left, root, level + 1, x, y);
 
        // if first element is found, save its level and parent node
        if (root.key == x.key)
        {
            x.level = level;
            x.parent = parent;
        }
 
        // if second element is found, save its level and parent node
        if (root.key == y.key)
        {
            y.level = level;
            y.parent = parent;
        }
 
        // traverse right subtree
        inorder(root.right, root, level + 1, x, y);
    }
 
    // Function to determine if two given nodes are cousins of each other
    public static boolean iterative(Node root, int elem1, int elem2)
    {
        // return if tree is empty
        if (root == null) {
            return false;
        }
 
        int level = 1;                // level of root is 1
        Node parent = null;        // parent of root is null
 
        NodeInfo x = new NodeInfo(elem1, level, parent);
        NodeInfo y = new NodeInfo(elem2, level, parent);
 
        // perform in-order traversal of the array and update x and y
        inorder(root, null, 1, x, y);
 
        // return false if x and y have different level or same parent
        if (x.level != y.level || x.parent == y.parent) {
            return false;
        }
 
        return true;
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (iterative(root, 5, 6)) {
            System.out.print("Given nodes are cousins");
        } else {
            System.out.print("Given nodes are not cousins");
        }
    }
}