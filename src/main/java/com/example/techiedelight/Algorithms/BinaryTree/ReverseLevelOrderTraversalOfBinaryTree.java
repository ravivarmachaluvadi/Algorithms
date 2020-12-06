package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class ReverseLevelOrderTraversalOfBinaryTree
{
    // Function to print reverse level order traversal of given binary tree
    public static void reverseLevelOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // create a stack to reverse level order nodes
        Deque<Integer> stack = new ArrayDeque<>();
 
        // pointer to store current node
        Node curr;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // process each node in queue and enqueue their children
            curr = queue.poll();
 
            // push current node to stack
            stack.push(curr.key);
 
            // important - process right node before left node
            if (curr.right != null) {
                queue.add(curr.right);
            }
 
            if (curr.left != null) {
                queue.add(curr.left);
            }
        }
 
        // pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
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
 
        reverseLevelOrderTraversal(root);
    }
}




class ReverseLevelOrderTraversalOfBinaryTreeA2
{
    // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    // traverse the tree in pre-order fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        // insert current node and its level into the map
        insertIntoMultiMap(map, level, root.key);

        // recur for left and right subtree by increasing level by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }

    // Recursive function to do reverse level order traversal of given binary tree
    public static void levelOrderTraversal(Node root)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, List<Integer>> map = new HashMap<>();

        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 1, map);

        // iterate through the map in reverse order and
        // print all nodes present in very level
        for (int i = map.size(); i > 0; i--) {
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