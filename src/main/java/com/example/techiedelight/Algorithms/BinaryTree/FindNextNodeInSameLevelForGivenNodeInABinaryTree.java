package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

class FindNextNodeInSameLevelForGivenNodeInABinaryTree
{
    // Function to find next node of given node in the same level
    // in given binary tree
    public static Node findRightNode(Node root, int val)
    {
        // return null if tree is empty
        if (root == null) {
            return null;
        }
 
        // create an empty queue and enqueue root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
 
        // pointer to store current node
        Node front;
 
        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate number of nodes in current level
            int size = queue.size();
 
            // process every node of current level and enqueue their
            // non-empty left and right child to queue
            while (size-- > 0)
            {
                front = queue.poll();
 
                // if desired node is found, return its next right node
                if (front.key == val)
                {
                    // if next right node doesn't exists, return null
                    if (size == 0) {
                        return null;
                    }
 
                    return queue.peek();
                }
 
                if (front.left != null) {
                    queue.add(front.left);
                }
 
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
        }
 
        return null;
    }
 
    public static void main(String[] args) {
        /* Construct below Tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        Node right = findRightNode(root, 5);
        if (right != null) {
            System.out.print("Right Node is " + right.key);
        } else {
            System.out.print("Right Node doesn't exists");
        }
    }
}




class FindNextNodeInSameLevelForGivenNodeInABinaryTreeA2
{
    // Function to find next node for given node  in same level in a
    // binary tree by using pre-order traversal
    public static Node findRightNode(Node root, int value, int level,
                                     AtomicInteger value_level)
    {
        // return null if tree is empty
        if (root == null) {
            return null;
        }

        // if desired node is found, set value_level to current level
        if (root.key == value)
        {
            value_level.set(level);
            return null;
        }

        // if value_level is already set, then current node is the next right node
        else if (value_level.get() != 0)
        {
            if (level == value_level.get()) {
                return root;
            }
        }

        // recur for left subtree by increasing level by 1
        Node left = findRightNode(root.left, value, level + 1, value_level);

        // if node is found in left subtree, return it
        if (left != null) {
            return left;
        }

        // recur for right subtree by increasing level by 1
        return findRightNode(root.right, value, level + 1, value_level);
    }

    // Function to find next node of given node in the same level
    // in given binary tree
    public static Node findRightNode(Node root, int value)
    {
        AtomicInteger value_level = new AtomicInteger(0);
        return findRightNode(root, value, 1, value_level);
    }

    public static void main(String[] args)
    {
        /* Construct below Tree
                  1
                /  \
               /    \
              2      3
             / \      \
            4   5      6
                      / \
                     7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        Node right = findRightNode(root, 5);
        if (right != null) {
            System.out.print("Right Node is " + right.key);
        } else {
            System.out.print("Right Node doesn't exists");
        }

    }
}