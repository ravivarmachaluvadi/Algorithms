package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class PrintDiagonalTraversalOfBinaryTreeRecursive
{
    // Recursive function to do a pre-order traversal of the tree and
    // fill the map with diagonal elements
    public static void printDiagonal(Node node, int diagonal,
                                     Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (node == null) {
            return;
        }
 
        // insert current node in current diagonal
        map.putIfAbsent(diagonal, new ArrayList<>());
        map.get(diagonal).add(node.key);
 
        // recur for left subtree by increasing diagonal by 1
        printDiagonal(node.left, diagonal + 1, map);
 
        // recur for right subtree with same diagonal
        printDiagonal(node.right, diagonal, map);
    }
 
    // Function to print the diagonal elements of given binary tree
    public static void printDiagonal(Node root)
    {
        // create an empty multi-map to store diagonal element in every slope
        Map<Integer, List<Integer>> map = new HashMap<>();
 
        // do pre-order traversal of the tree and fill the map
        printDiagonal(root, 0, map);
 
        // traverse the map and print diagonal elements
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
       */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
 
        printDiagonal(root);
    }
}




class PrintDiagonalTraversalOfBinaryTreeIterative
{
    // Iterative function to print the diagonal elements of given binary tree
    public static void diagonalPrint(Node root)
    {
        // create an empty queue
        Queue<Node> q = new ArrayDeque<>();

        // create a sentinel (dummy) node to denote end of a diagonal
        Node sentinel = new Node(-1);

        // enqueue all nodes of first diagonal in binary tree
        while (root != null) {
            q.add(root);
            root = root.right;
        }

        // enqueue sentinel node at the end of each diagonal
        q.add(sentinel);

        // run till only sentinel is left
        while (q.size() != 1)
        {
            // dequeue front node
            Node front = q.poll();

            if (front != sentinel)
            {
                // print current node
                System.out.print(front.key + " ");

                // enqueue nodes of next diagonal in binary tree
                Node node = front.left;
                while (node != null)
                {
                    q.add(node);
                    node = node.right;
                }
            }
            else
            {
                // if end of current diagonal is reached, enqueue sentinel node
                // and print newline
                q.add(sentinel);
                System.out.println();
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
             /      /  \
            /      /    \
           4      5      6
                 / \
                /   \
               7     8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);

        diagonalPrint(root);
    }
}