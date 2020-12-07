package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class ComputeMaximumNumberOfNodesInAnyLevelInGivenBinaryTreeIterative
{
    // Function to find maximum width of the tree using level order
    // traversal of given binary tree
    public static void maxWidth(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node curr = null;
 
        // stores maximum width
        int max = 0;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            // This is equal to width of current level
            int width = queue.size();
 
            // update maximum width if number of nodes in current level
            // is more than maximum width found so far
            if (max < width) {
                max = width;
            }
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (width-- > 0)
            {
                curr = queue.poll();
 
                if (curr.left != null) {
                    queue.add(curr.left);
                }
 
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
 
        System.out.print("Maximum width is " + max);
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
 
        maxWidth(root);
    }
}



class ComputeMaximumNumberOfNodesInAnyLevelInGivenBinaryTreeRecursive
{
    // Traverse the tree in pre-order fashion and store count of nodes
    // in each level
    public static void preorder(Node root, int level, Map<Integer, Integer> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // increment count of nodes in current level
        map.put(level, map.getOrDefault(level, 0) + 1);

        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    // Recursive function to find maximum width of the tree
    public static void maxWidth(Node root)
    {
        // create an empty map to store count of nodes in each levels
        Map<Integer, Integer> map = new HashMap<>();

        // traverse the tree and fill map
        preorder(root, 1, map);

        // iterate through the map and find maximum width
        int maxWidth = map.values().stream().max(Comparator.naturalOrder()).get();
        System.out.print("Maximum width is " + maxWidth);
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

        maxWidth(root);
    }
}