package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class EfficientlyPrintAllNodesBetweenTwoGivenLevelsInABinaryTree
{
    // Iterative function to print all nodes between two given
    // levels in a binary tree
    public static void printNodes(Node root, int start, int end)
    {
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // maintains level of current node
        int level = 0;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // increment level by 1
            level++;
 
            // calculate number of nodes in current level
            int size = queue.size();
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0)
            {
                curr = queue.poll();
 
                // print the node if its level is between given levels
                if (level >= start && level <= end)
                    System.out.print(curr.key + " ");
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
 
            if (level >= start && level <= end) {
                System.out.println();
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
        root.right.right.right = new Node(30);
 
        int start = 2, end = 3;
        printNodes(root, start, end);
    }
}





class EfficientlyPrintAllNodesBetweenTwoGivenLevelsInABinaryTreeA2
{
    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void printNodes(Node root, int start, int end, int level,
                                  Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // push current node into the map corresponding to their level
        if (level >= start && level <= end) {
            map.putIfAbsent(level, new ArrayList<>());
            map.get(level).add(root.key);
        }

        // recur for left and right subtree by increasing level by 1
        printNodes(root.left, start, end, level + 1, map);
        printNodes(root.right, start, end, level + 1, map);
    }

    // Recursive function to print all nodes between two given
    // levels in a binary tree
    public static void printNodes(Node root, int start, int end)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, List<Integer>> map = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        printNodes(root, start, end, 1, map);

        // iterate through the map and print all nodes between given levels
        for (int i = start; i <= end; i++) {
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

        int start = 2, end = 3;
        printNodes(root, start, end);
    }
}