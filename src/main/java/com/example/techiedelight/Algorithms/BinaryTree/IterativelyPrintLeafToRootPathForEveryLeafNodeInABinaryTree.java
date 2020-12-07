package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class IterativelyPrintLeafToRootPathForEveryLeafNodeInABinaryTree
{
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }
 
    // Recursive function to print root-to-leaf path for a given leaf
    public static void printPathRecursive(Node curr, Map<Node, Node> map)
    {
        // base case : curr is root node (parent of root node is null)
        if (curr == null) {
            return;
        }
 
        // recursively call parent node
        printPathRecursive(map.get(curr), map);
        System.out.print(curr.key + (isLeaf(curr) ? "\n" : " -> "));
    }
 
    // Iterative function to print leaf-to-root path for a given leaf
    // For printing root-to-leaf path, we can use printPathRecursive() or a stack
    public static void printPathIterative(Node leafNode, Map<Node, Node> map)
    {
        // start from the leaf node
        Node curr = leafNode;
 
        // loop till root node is reached and print each node in the path
        while (map.get(curr) != null)
        {
            System.out.print(curr.key + " -> ");
            curr = map.get(curr);
        }
 
        System.out.println(curr.key);
    }
 
    // Iterative function to print leaf to root path for every leaf node
    public static void postorderIterative(Node root)
    {
        // create an empty stack
        Deque<Node> stack = new ArrayDeque<>();
 
        // create an empty map to store (child, parent) pairs
        Map<Node, Node> map = new HashMap<>();
 
        // parent of root node is null
        map.put(root, null);
 
        // push root node
        stack.add(root);
 
        // loop till stack is empty
        while (!stack.isEmpty())
        {
            // pop top node from the stack
            Node curr = stack.pollLast();
 
            // if leaf node is found, print the path
            if (isLeaf(curr))
            {
                // print leaf-to-root path for current leaf
                printPathIterative(curr, map);
 
                // print root-to-leaf path for current leaf
                // printPathRecursive(curr, map);
            }
 
            // push left and right child of popped node to the stack
            // include current node left and right child in a map
            if (curr.right != null)
            {
                stack.add(curr.right);
                map.put(curr.right, curr);
            }
 
            if (curr.left != null)
            {
                stack.add(curr.left);
                map.put(curr.left, curr);
            }
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right  = new Node(9);
 
        postorderIterative(root);
    }
}






class IterativelyPrintLeafToRootPathForEveryLeafNodeInABinaryTreeA2
{
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(Node node) {
        return (node.left == null && node.right == null);
    }

    public static void printLeafToRootPaths(Node root)
    {
        // create an empty stack to store a pair of tree node and
        // its path from the root node
        Deque<Pair<Node, String>> stack = new ArrayDeque<>();

        // push root node
        stack.add(Pair.of(root, ""));

        // loop till stack is empty
        while (!stack.isEmpty())
        {
            // we pop a node from the stack and push the data to output stack
            Pair<Node, String> p = stack.pollLast();

            // fetch current node
            Node curr = p.first;
            String path = p.second;

            // add current node to the existing path
            String delim = (path.equals("")) ? "\n" : " -> ";
            String rootToNodePath = curr.key + delim + path;

            // if leaf node, print the path
            if (isLeaf(curr)) {
                System.out.print(rootToNodePath);
            }

            // push left and right child of popped node to the stack
            if (curr.right != null) {
                stack.add(Pair.of(curr.right, rootToNodePath));
            }

            if (curr.left != null) {
                stack.add(Pair.of(curr.left, rootToNodePath));
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                   1
                 /   \
                /     \
               /       \
              2         3
             / \       / \
            /   \     /   \
           4     5   6     7
                    / \
                   /   \
                  8     9
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(9);

        printLeafToRootPaths(root);
    }
}