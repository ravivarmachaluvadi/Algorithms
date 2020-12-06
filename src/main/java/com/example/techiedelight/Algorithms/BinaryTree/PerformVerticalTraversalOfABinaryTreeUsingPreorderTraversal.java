package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class PerformVerticalTraversalOfABinaryTreeUsingPreorderTraversal
{
    // Utility function to add an element to List corresponding to the given
    // key in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                        Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }
 
    // Recursive function to do a pre-order traversal of the tree and fill map
    // Here node has 'dist' horizontal distance from the root of the tree
    public static void printVertical(Node node, int dist,
                                    Map<Integer, List<Integer>> map)
    {
        // base case: empty tree
        if (node == null) {
            return;
        }
 
        // insert nodes present at current horizontal distance into the map
        insertIntoMultiMap(map, dist, node.key);
 
        // recur for left subtree by decreasing horizontal distance by 1
        printVertical(node.left, dist - 1, map);
 
        // recur for right subtree by increasing horizontal distance by 1
        printVertical(node.right, dist + 1, map);
    }
 
    // Function to perform vertical traversal of a given binary tree
    public static void printVertical(Node root)
    {
        // create an empty TreeMap where
        // key -> relative horizontal distance of the node from root node
        // value -> nodes present at same horizontal distance
        Map<Integer, List<Integer>> map = new TreeMap<>();
 
        // do pre-order traversal of the tree and fill the map
        printVertical(root, 0, map);
 
        // traverse the TreeMap and print vertical nodes
        for (Collection<Integer> collection: map.values()) {
            System.out.println(collection);
        }
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
                    /   \
                   /     \
                  5       6
                /   \
               /     \
              7       8
                    /   \
                   /     \
                  9      10
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.left.right.right = new Node(10);
 
        printVertical(root);
    }
}





class PerformVerticalTraversalOfABinaryTreeUsingLevelOrderTraversal
{
    // Utility function to add an element to List corresponding to the
    // given key in a Map<Integer,List<Integer>>.
    public static void insertIntoMultiMap(Map<Integer,List<Integer>> map,
                                          Integer key, Integer value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(value);
    }

    // Function to perform vertical traversal of a given binary tree
    public static void printVertical(Node root)
    {
        // base case
        if (root == null) {
            return;
        }

        // Create a TreeMap to store vertical order of binary tree nodes
        Map<Integer, List<Integer>> map = new TreeMap<>();

        // create an empty queue for level order traversal
        // It stores binary tree nodes and their horizontal distance from root
        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();

        // enqueue root node with horizontal distance as 0
        q.add(Pair.of(root, 0));

        // loop till queue is empty
        while (!q.isEmpty())
        {
            // pop front node from the queue
            Node node = q.peek().first;
            int dist = q.peek().second;
            q.poll();

            // insert front node value to the map using its horizontal distance
            // as the key
            insertIntoMultiMap(map, dist, node.key);

            // enqueue non-empty left and right child of front node
            // with their corresponding horizontal distance
            if (node.left != null) {
                q.add(Pair.of(node.left, dist - 1));
            }

            if (node.right != null) {
                q.add(Pair.of(node.right, dist + 1));
            }
        }

        // print the TreeMap
        for (List<Integer> list: map.values()) {
            System.out.println(list);
        }
    }

    public static void main(String[] args)
    {
        /* Construct below tree
              1
            /   \
           /     \
          2       3
                /   \
               /     \
              5       6
            /   \
           /     \
          7       8
                /   \
               /     \
              9      10
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        root.right.left.right.left = new Node(9);
        root.right.left.right.right = new Node(10);

        printVertical(root);
    }
}