package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

class PrintAllPathsFromRootToLeafNodesInABinaryTree
{
    // Function to check if given node is a leaf node or not
    public static boolean isLeaf(NodeData node) {
        return (node.left == null && node.right == null);
    }
 
    // Recursive function to find paths from root node to every leaf node
    public static void printRootToleafPaths(NodeData node, Deque<Integer> path)
    {
        // base case
        if (node == null) {
            return;
        }
 
        // include current node to the path
        path.addLast(node.data);
 
        // if leaf node is found, print the path
        if (isLeaf(node)) {
            System.out.println(path);
        }
 
        // recur for left and right subtree
        printRootToleafPaths(node.left, path);
        printRootToleafPaths(node.right, path);
 
        // remove current node after left and right subtree are done
        path.removeLast();
    }
 
    // PrintAllPathsFromRootToLeafNodesInABinaryTree function to print paths from root node to every leaf node
    public static void printRootToleafPaths(NodeData node)
    {
        // list to store root to leaf path
        Deque<Integer> path = new ArrayDeque<>();
        printRootToleafPaths(node, path);
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.left = new NodeData(4);
        root.left.right = new NodeData(5);
        root.right.left = new NodeData(6);
        root.right.right = new NodeData(7);
        root.right.left.left = new NodeData(8);
        root.right.right.right = new NodeData(9);
 
        // print all root to leaf paths
        printRootToleafPaths(root);
    }
}




class PrintAllPathsFromRootToLeafNodesInABinaryTreeA2
{
    public static void printRootToleafPathIterative(NodeData root)
    {
        // create an empty stack to store a pair of tree node and
        // its path from the root node
        Deque<Pair<NodeData, String>> stack = new ArrayDeque<>();

        // push root node
        stack.add(Pair.of(root, ""));

        // loop till stack is empty
        while (!stack.isEmpty())
        {
            // we pop a node from the stack and push the data to output stack
            Pair<NodeData, String> pair = stack.pollLast();

            // fetch current node
            NodeData curr = pair.first;
            String path = pair.second;

            // add current node to the existing path
            String separator = (path.equals("")) ? "\n" : " -> ";
            path += (separator + curr.data);

            // if leaf node, print the path
            if (curr.left == null && curr.right == null) {
                System.out.print(path);
            }

            // push left and right child of popped node to the stack
            if (curr.right != null) {
                stack.add(Pair.of(curr.right, path));
            }

            if (curr.left != null) {
                stack.add(Pair.of(curr.left, path));
            }
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
                   /     \
                  8       9
        */

        NodeData root = new NodeData(1);
        root.left = new NodeData(2);
        root.right = new NodeData(3);
        root.left.left = new NodeData(4);
        root.left.right = new NodeData(5);
        root.right.left = new NodeData(6);
        root.right.right = new NodeData(7);
        root.right.left.left = new NodeData(8);
        root.right.right.right = new NodeData(9);

        printRootToleafPathIterative(root);
    }
}