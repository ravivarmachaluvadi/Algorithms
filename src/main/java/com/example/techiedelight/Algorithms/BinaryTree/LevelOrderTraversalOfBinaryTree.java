package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class LevelOrderTraversalOfBinaryTree
{
    // Function to print all nodes of a given level from left to right
    public static boolean printLevel(Node root, int level)
    {
        // base case
        if (root == null) {
            return false;
        }
 
        if (level == 1)
        {
            System.out.print(root.key + " ");
 
            // return true if at-least one node is present at given level
            return true;
        }
 
        boolean left = printLevel(root.left, level - 1);
        boolean right = printLevel(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // start from level 1 -- till height of the tree
        int level = 1;
 
        // run till printLevel() returns false
        while (printLevel(root, level)) {
            level++;
        }
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        levelOrderTraversal(root);
    }
}




class LevelOrderTraversalOfBinaryTreeA2
{
    // Function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // pointer to store current node
        Node curr;

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their
            // non-empty left and right child to queue
            curr = queue.poll();

            System.out.print(curr.key + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        levelOrderTraversal(root);
    }
}




class LevelOrderTraversalOfBinaryTreeA3
{
    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // insert current node and its level into the map
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(root.key);

        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    // Recursive function to print level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, List<Integer>> map = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 1, map);

        // iterate through the map and print all nodes between given levels
        for (int i = 1; i <= map.size(); i++) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        root.right.right.right = new Node(30);

        levelOrderTraversal(root);
    }
}