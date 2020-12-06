package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

//Print all nodes of a perfect binary tree in specific order

class PrintTopDown
{
    // Function to print all nodes of a given binary tree in specific
    // order from top to bottom
    public static void printNodes(Node root)
    {
        // return is tree is empty
        if (root == null) {
            return;
        }
 
        // print root node
        System.out.print(root.key + " ");
 
        // create a two empty queues and enqueue root's left and
        // right child respectively
        Queue<Node> first = new ArrayDeque<>();
        first.add(root.left);
 
        Queue<Node> second = new ArrayDeque<>();
        second.add(root.right);
 
        // loop till queue is empty
        while (!first.isEmpty())
        {
            // calculate number of nodes in current level
            int n = first.size();
 
            // process every node of current level
            while (n-- > 0)
            {
                // pop front node from first queue and print it
                Node x = first.poll();
 
                System.out.print(x.key + " ");
 
                // push left and right child of x to first queue
                if (x.left != null) {
                    first.add(x.left);
                }
 
                if (x.right != null) {
                    first.add(x.right);
                }
 
                // pop front node from second queue and print it
                Node y = second.poll();
 
                System.out.print(y.key + " ");
 
                // push right and left child of y to second queue
                if (y.right != null) {
                    second.add(y.right);
                }
 
                if (y.left != null) {
                    second.add(y.left);
                }
            }
        }
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
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);
 
        printNodes(root);
    }
}





class PrintBottomup
{
    // Utility function to add an element to List corresponding to the given key
    // in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    // Function to print all nodes of a given binary tree in
    // specific order from bottom to top
    public static void printNodes(Node root)
    {
        // return is tree is empty
        if (root == null) {
            return;
        }

        // start with level 1 (of root node)
        int level = 1;

        // create an empty multi-map of integers (every key can be
        // associated with multiple values)
        Map<Integer, List<Integer>> map = new HashMap<>();

        // insert root node at first level
        insertIntoMultiMap(map, level, root.key);

        // create a two empty queues and enqueue root's left and
        // right child respectively
        Queue<Node> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.add(root.left);
        q2.add(root.right);

        // loop till queue is empty
        while (!q1.isEmpty())
        {
            // increment level by 1
            level++;

            // calculate number of nodes in current level
            int n = q1.size();

            // process every node of current level
            while (n-- > 0)
            {
                // pop front node from first queue and insert it into the map
                Node x = q1.poll();
                insertIntoMultiMap(map, level, x.key);

                // push left and right child of x to first queue
                if (x.left != null) {
                    q1.add(x.left);
                }

                if (x.right != null) {
                    q1.add(x.right);
                }

                // pop front node from second queue and insert it into the map
                Node y = q2.poll();

                map.get(level).add(y.key);

                // push right and left child of y to second queue
                if (y.right != null) {
                    q2.add(y.right);
                }

                if (y.left != null) {
                    q2.add(y.left);
                }
            }
        }

        // iterate through the HashMap and print all nodes present in very level
        for (int i = map.size(); i > 0; i--) {
            System.out.print(map.get(i));
        }
    }

    public static void main(String[] args)
    {
        Node root = null;
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        root.right.right.right = new Node(15);

        printNodes(root);
    }
}