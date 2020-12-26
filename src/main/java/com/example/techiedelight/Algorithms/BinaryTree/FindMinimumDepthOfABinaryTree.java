package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

class FindMinimumDepthOfABinaryTree {
 
    // Recursive function to find the minimum depth of a path starting
    // from the given node in a binary tree
    public static int minDepth(Node root)
    {
        // base case
        if (root == null) {
            return 0;
        }
 
        // find minimum depth of the left subtree
        int l = minDepth(root.left);
 
        // find minimum depth of the right subtree
        int r = minDepth(root.right);
 
        // if the left child does not exist, consider the depth
        // returned by the right subtree
        if (root.left == null) {
            return 1 + r;
        }
 
        // if right child does not exist, consider the depth
        // returned by the left subtree
        if (root.right == null) {
            return 1 + l;
        }
 
        // otherwise choose minimum depth returned by the
        // left and right subtree
        return Integer.min(l, r) + 1;
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
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.right = new Node(12);
 
        System.out.println("The minimum depth is " + minDepth(root));
    }
}




// Queue node for storing a pointer to a tree node and its current depth
class qNode {
    Node node;
    int depth;

    public qNode(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

class FindMinimumDepthOfABinaryTreeA2
{
    // Returns true if the given tree node is a leaf, false otherwise
    public static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Iterative function to find the minimum depth of a path starting
    // from the given node in a binary tree
    public static int minDepth(Node root)
    {
        // base case
        if (root == null) {
            return 0;
        }

        // create an empty queue and push root of the tree with depth as 1
        Queue<qNode> q = new ArrayDeque<>();
        q.add(new qNode(root, 1));

        // run till queue is empty
        while (!q.isEmpty())
        {
            // pop front node from the queue
            Node node = q.peek().node;
            int depth = q.peek().depth;

            q.poll();

            // if the popped node is a leaf node, return its depth
            if (isLeaf(node)) {
                return depth;
            }

            // enqueue left child of the popped node with +1 depth
            if (node.left != null) {
                q.add(new qNode(node.left, depth + 1));
            }

            // enqueue right child of the popped node with +1 depth
            if (node.right != null) {
                q.add(new qNode(node.right, depth + 1));
            }
        }
        return 0;
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
        root.left.left.right = new Node(8);
        root.left.right.right = new Node(9);
        root.right.right.left = new Node(10);
        root.right.right.left = new Node(11);
        root.left.left.right.right = new Node(12);

        System.out.println("The minimum depth is " + minDepth(root));
    }
}