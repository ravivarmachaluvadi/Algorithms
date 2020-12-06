package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class SpiralOrderTraversalOfBinaryTree
{
    // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(Node root, int level)
    {
        if (root == null) {
            return false;
        }
 
        if (level == 1) {
            System.out.print(root.key + " ");
            return true;
        }
 
        // process left child before right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        boolean right = printLevelLeftToRight(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(Node root, int level)
    {
        if (root == null) {
            return false;
        }
 
        if (level == 1) {
            System.out.print(root.key + " ");
            return true;
        }
 
        // process right child before left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        boolean left = printLevelRightToLeft(root.left, level - 1);
 
        return right || left;
    }
 
    // Function to print level order traversal of given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null)
            return;
 
        // start from level 1 -- till height of the tree
        int level = 1;
 
        // run till either function returns false
        while (printLevelLeftToRight(root, level++) &&
                       printLevelRightToLeft(root, level++));
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
 
        spiralOrderTraversal(root);
    }
}




class SpiralOrderTraversalOfBinaryTreeA2
{
    // Function to print Spiral order traversal of given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        // create an empty double ended queue and enqueue root node
        Deque<Node> deque = new ArrayDeque<>();      // or use deque
        deque.addFirst(root);

        // flag used to differentiate between odd or even level
        boolean flag = false;

        // loop till deque is empty
        while (!deque.isEmpty())
        {
            // calculate number of nodes in current level
            int nodeCount = deque.size();

            // print left to right
            if (flag)
            {
                // process each node of current level and enqueue their
                // non-empty left and right child to deque
                while (nodeCount > 0)
                {
                    // pop from front if flag is true
                    Node curr = deque.pollFirst();
                    System.out.print(curr.key + " ");

                    // push left child to end followed by right child if flag is true

                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    nodeCount--;
                }
            }

            // print right to left
            else
            {
                // process each node of current level and enqueue their
                // non-empty right and left child to queue
                while (nodeCount > 0)
                {
                    // Important - pop from back if flag is false
                    Node curr = deque.pollLast();
                    System.out.print(curr.key + " ");   // print front node

                    // Important - push right child to front followed by left
                    // child if flag is false

                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }

                    nodeCount--;
                }
            }

            // flip the flag for next level
            flag = !flag;
            System.out.println();
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

        spiralOrderTraversal(root);
    }
}




class SpiralOrderTraversalOfBinaryTreeA3
{
    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, Deque<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // insert current node and its level into the map
        map.putIfAbsent(level, new ArrayDeque<>());

        // if level is odd insert at back, else insert at front
        if (level % 2 == 1) {
            map.get(level).addLast(root.key);
        } else {
            map.get(level).addFirst(root.key);
        }

        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    // Recursive function to print spiral order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, Deque<Integer>> map = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 1, map);

        // iterate through the map and print all nodes present in very level
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
        root.left.left.left = new Node(20);
        root.right.right.right = new Node(30);

        levelOrderTraversal(root);
    }
}