package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

//Check if given binary tree is complete binary tree or not

class LevelOrderTraversalBFS
{
    // Function to check if given Binary Tree is Complete or not
    public static boolean isComplete(Node root)
    {
        // return if tree is empty
        if (root == null) {
            return false;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node front;
 
        // flag to mark end of full nodes
        boolean flag = false;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // pop front node from the queue
            front = queue.poll();
 
            // if we have encountered a non-full node before and current node
            // is not a leaf, tree cannot be complete tree
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
 
            // if left child is empty & right child exists, tree cannot be complete
            if (front.left == null && front.right != null) {
                return false;
            }
 
            // if left child exists, enqueue it
            if (front.left != null) {
                queue.add(front.left);
            }
            // if current node is a non-full node, set flag to true
            else {
                flag = true;
            }
 
            // if right child exists, enqueue it
            if (front.right != null) {
                queue.add(front.right);
            }
            // if current node is a non-full node, set flag to true
            else {
                flag = true;
            }
        }
 
        return true;
    }
 
    public static void main(String[] args) {
        /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        if (isComplete(root)) {
            System.out.print("Given Binary Tree is a Complete Binary Tree");
        } else {
            System.out.print("Given Binary Tree is not a Complete Binary Tree");
        }
    }
}




class ArrayRepresentationOfCompleteTree
{
    // utility function to get size of the binary tree
    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Perform in-order traversal of the array and fill array A[]
    public static void inorder(Node root, boolean[] A, int i)
    {
        if (root == null || i >= A.length) {
            return;
        }

        // recur with index 2i+1 for left node
        inorder(root.left, A, 2*i + 1);

        // mark index i as visited
        A[i] = true;

        // recur with index 2i+2 for right node
        inorder(root.right, A, 2*i + 2);
    }

    // Function to check if given binary tree is complete binary tree or not
    public static boolean isComplete(Node root, int n)
    {
        // return if tree is empty
        if (root == null) {
            return true;
        }

        // construct an auxiliary boolean array of size n
        boolean[] A = new boolean[n];

        // fill array A[]
        inorder(root, A, 0);

        // check if all positions in the array are filled or not
        for (boolean e: A) {
            if (!e) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /* Construct below tree
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (isComplete(root, size(root))) {
            System.out.print("Given Binary Tree is a Complete Binary Tree");
        } else {
            System.out.print("Given Binary Tree is not a Complete Binary Tree");
        }
    }
}




class SpaceOptimizedPreviousApproach
{
    private static int size(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }

    // Recursive function to check if given binary tree is complete tree or not
    public static boolean isComplete(Node root, int i, int n)
    {
        // return if tree is empty
        if (root == null) {
            return true;
        }

        if ((root.left != null && 2*i + 1 >= n) || !isComplete(root.left, 2*i + 1, n)) {
            return false;
        }

        if ((root.right != null && 2*i + 2 >= n) || !isComplete(root.right, 2*i + 2, n)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            4   5   6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        if (isComplete(root, 0, size(root))) {
            System.out.print("Given Binary Tree is a Complete Binary Tree");
        } else {
            System.out.print("Given Binary Tree is not a Complete Binary Tree");
        }
    }
}