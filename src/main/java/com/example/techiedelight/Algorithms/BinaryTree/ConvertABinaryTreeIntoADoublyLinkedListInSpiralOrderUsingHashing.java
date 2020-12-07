package com.example.techiedelight.Algorithms.BinaryTree;

import java.util.*;

class ConvertABinaryTreeIntoADoublyLinkedListInSpiralOrderUsingHashing
{
    // Helper function to print a doubly linked list
    public static void printDoublyList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + " -> ");
            node = node.right;
        }
 
        System.out.print("null");
    }
 
    // Insert a tree node at the front of the doubly linked list
    public static Node push(Node node, Node head)
    {
        // initialize head pointer of doubly linked list
        if ( head == null) {
            head = node;
            head.left =  head.right = null;
            return head;
        }
 
        // insert given node at the front of the doubly linked list
        head.left = node;
        node.right =  head;
 
        // update left child pointer to null
        node.left = null;
 
        // update head pointer to point to given node
        head = node;
        return head;
    }
 
    // Traverse the tree in preorder fashion and store nodes into the map
    // corresponding to their level
    public static void preorder(Node root, int level, Map<Integer, Deque<Node>> map)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // insert current node and its level into the map
        map.putIfAbsent(level, new ArrayDeque<>());
 
        // if level is odd insert at front, else insert at back
        if ((level & 1) == 1) {
            map.get(level).addFirst(root);
        } else {
            map.get(level).addLast(root);
        }
 
        // recur for left and right subtree with level increased by 1
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    // Recursive function to convert a binary tree into a doubly linked list
    // using Hashing
    public static Node convert(Node root, Node head)
    {
        // create an empty map to store nodes between given levels
        Map<Integer, Deque<Node>> map = new HashMap<>();
 
        // traverse the tree and insert its nodes into the map
        // corresponding to the their level
        preorder(root, 0, map);
 
        // iterate through the map in decreasing order of level and
        // push nodes of each level into the doubly linked list
        int n = map.size();
        for (int i = n - 1; i >=0; i--)
        {
            for (Node node: map.get(i)) {
                head = push(node, head);
            }
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            /   \   /   \
           4     5 6     7
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        Node head = null;
        head = convert(root, head);
        printDoublyList(head);
    }
}





class ConvertABinaryTreeIntoADoublyLinkedListInSpiralOrderByTraversingTheTreeInSpiralOrder
{
    // Helper function to print a doubly linked list
    public static void printDoublyList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + " -> ");
            node = node.right;
        }

        System.out.print("null");
    }

    // Insert a tree node at the front of the doubly linked list
    public static Node push(Node node, Node head)
    {
        // initialize head pointer of doubly linked list
        if ( head == null) {
            head = node;
            head.left =  head.right = null;
            return head;
        }

        // insert given node at the front of the doubly linked list
        head.left = node;
        node.right =  head;

        // update left child pointer to null
        node.left = null;

        // update head pointer to point to given node
        head = node;
        return head;
    }


    // Function to convert a binary tree into a doubly linked list
    // using spiral order traversal
    public static Node convert(Node root, Node head)
    {
        // base case
        if (root == null) {
            return head;
        }

        // create an empty double ended queue and enqueue root node
        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        // flag used to differentiate between odd or even level
        boolean flag = false;

        // create a stack for storing binary tree nodes in spiral order
        Stack<Node> s = new Stack<>();

        // loop till deque is empty
        while (!deque.isEmpty())
        {
            // calculate number of nodes in current level
            int nodeCount = deque.size();

            // process level left to right
            if (flag)
            {
                // process each node of current level and enqueue their
                // non-empty left and right child to deque
                while (nodeCount > 0)
                {
                    // pop from front if flag is true
                    Node curr = deque.pollFirst();

                    // push left child to back followed by the right child
                    // if flag is true

                    if (curr.left != null) {
                        deque.addLast(curr.left);
                    }

                    if (curr.right != null) {
                        deque.addLast(curr.right);
                    }

                    // push current node to the stack
                    s.push(curr);
                    nodeCount--;
                }
            }

            // process level right to left
            else
            {
                // process each node of current level and enqueue their
                // non-empty right and left child to queue
                while (nodeCount > 0)
                {
                    // Pop from back if flag is false
                    Node curr = deque.pollLast();

                    // Push right child to front followed by the left child
                    // if flag is false

                    if (curr.right != null) {
                        deque.addFirst(curr.right);
                    }

                    if (curr.left != null) {
                        deque.addFirst(curr.left);
                    }

                    // push current node to the stack
                    s.push(curr);
                    nodeCount--;
                }
            }

            // flip the flag for next level
            flag = !flag;
        }

        // Insert all nodes in the stack to the beginning of the
        // doubly linked list
        while (!s.empty()) {
            head = push(s.pop(), head);
        }

        return head;
    }

    public static void main(String[] args)
    {
        /* Construct below tree
                  1
                /   \
               /     \
              2       3
             / \     / \
            /   \   /   \
           4     5 6     7
        */


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node head = null;
        head = convert(root, head);
        printDoublyList(head);
    }
}