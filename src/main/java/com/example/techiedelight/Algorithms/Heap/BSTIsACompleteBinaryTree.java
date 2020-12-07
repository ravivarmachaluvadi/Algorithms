package com.example.techiedelight.Algorithms.Heap;

import java.util.ArrayDeque;
import java.util.Queue;

//Convert a Binary Search Tree into a Min Heap


class BSTIsACompleteBinaryTree
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
 
        // if given key is less than the root node, recur for left subtree
        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }
 
        return root;
    }
 
    // Helper function to perform level order traversal of binary tree
    public static void printLevelOrderTraversal(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
 
        while (!q.isEmpty())
        {
            int n = q.size();
            while (n-- > 0)
            {
                Node front = q.poll();
                System.out.print(front.key + " ");
 
                if (front.left != null) {
                    q.add(front.left);
                }
 
                if (front.right != null) {
                    q.add(front.right);
                }
            }
 
            System.out.println();
        }
    }
 
    // Function to perform inorder traversal of a binary tree and
    // push all nodes in a queue (in encountered order)
    public static void inorder(Node root, Queue<Integer> keys)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left, keys);
        keys.add(root.key);
        inorder(root.right, keys);
    }
 
    // Function to perform preorder traversal of the binary tree
    // Assign each encountered node with next key from the queue
    public static void preorder(Node root, Queue<Integer> keys)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }
 
        // replace root's key value with next key from the queue
        root.key = keys.poll();
 
        // process left subtree
        preorder(root.left, keys);
 
        // process right subtree
        preorder(root.right, keys);
    }
 
    // Function to convert a BST to a min heap
    public static void convert(Node root)
    {
        // maintain a queue to store inorder traversal of the tree
        Queue<Integer> keys = new ArrayDeque<>();
 
        // fill the queue in inorder fashion
        inorder(root, keys);
 
        // traverse tree in preorder fashion and for each encountered node,
        // dequeue a key from the queue and assign it to the node
        preorder(root, keys);
    }
 
    public static void main(String[] args)
    {
        Node root = null;
 
        /* Construct below bst
                   5
                 /   \
                /     \
               3       8
              / \     / \
             /   \   /   \
            2     4 6    10
        */
 
        int[] keys = { 5, 3, 2, 4, 8, 6, 10 };
        for (int key: keys) {
            root = insert(root, key);
        }
 
        convert(root);
        printLevelOrderTraversal(root);
    }
}





// Data structure to store a Binary Tree node
class Node
{
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
    }
}





class BSTIsNotACompleteBinaryTree
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new Node(key);
        }
        // if given key is less than the root node, recur for left subtree
        if (key < root.key) {
            root.left = insert(root.left, key);
        }
        // if given key is more than the root node, recur for right subtree
        else {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Helper function to perform level order traversal of binary tree
    public static void printLevelOrderTraversal(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty())
        {
            int n = q.size();
            while (n-- > 0)
            {
                Node front = q.poll();

                System.out.print(front.key + " ");

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            System.out.println();
        }
    }

    // Function to construct a complete binary tree from sorted keys in the queue
    public static Node construct(Queue<Integer> keys)
    {
        // construct a queue to store the parent nodes
        Queue<Node> q = new ArrayDeque<>();

        // initialize root node of the complete binary tree
        Node root = new Node(keys.poll());

        // add root node to the queue
        q.add(root);

        // loop till all keys are processed
        while (!keys.isEmpty())
        {
            // Dequeue front node from the queue
            Node parent = q.poll();

            // allocate left child of the parent node with next key
            parent.left = new Node(keys.poll());

            // add left child node to the queue
            q.add(parent.left);

            // if next key is exists
            if (!keys.isEmpty())
            {
                // allocate right child of the parent node with next key
                parent.right = new Node(keys.poll());

                // add right child node to the queue
                q.add(parent.right);

            }
        }

        // return the root node of complete binary tree
        return root;
    }

    // Function to perform inorder traversal of a binary tree and
    // push all nodes in a queue (in encountered order)
    public static void inorder(Node root, Queue<Integer> keys)
    {
        if (root == null) {
            return;
        }

        inorder(root.left, keys);
        keys.add(root.key);
        inorder(root.right, keys);
    }

    // Function to convert a BST into a min heap without using
    // any auxiliary space
    public static Node convert(Node root)
    {
        // maintain a queue to store inorder traversal of the tree
        Queue<Integer> keys = new ArrayDeque<>();

        // fill the queue in inorder fashion
        inorder(root, keys);

        // construct a complete binary tree from sorted keys in the queue
        root = construct(keys);
        return root;
    }

    public static void main(String[] args)
    {
        Node root = null;

        /* Construct below bst
                   5
                 /   \
                /     \
               3       8
              / \       \
             /   \       \
            2     4      10
        */

        int[] keys = { 5, 3, 2, 4, 8, 10 };
        for (int key: keys) {
            root = insert(root, key);
        }

        root = convert(root);
        printLevelOrderTraversal(root);
    }
}





class BSTIsNotACompleteBinaryTreeA3
{
    // Recursive function to insert a key into BST
    public static Node insert(Node root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null)
            return new Node(key);

        // if given key is less than the root node, recur for left subtree
        if (key < root.key)
            root.left = insert(root.left, key);

            // if given key is more than the root node, recur for right subtree
        else
            root.right = insert(root.right, key);

        return root;
    }

    // Helper function to perform level order traversal of binary tree
    public static void printLevelOrderTraversal(Node root)
    {
        // base case: empty tree
        if (root == null) {
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty())
        {
            int n = q.size();
            while (n-- > 0)
            {
                Node front = q.poll();
                System.out.print(front.key + " ");

                if (front.left != null) {
                    q.add(front.left);
                }

                if (front.right != null) {
                    q.add(front.right);
                }
            }

            System.out.println();
        }
    }

    // Insert a tree node at the front of a linked list
    public static Node push(Node node, Node head)
    {
        // initialize head pointer of the linked list
        if (head == null) {
            head = node;
            head.right = null;
            return head;
        }

        // update right child of the node to point to current head of list
        node.right =  head;

        // update head pointer to point to the given node
        head = node;

        return head;
    }

    // Function to convert a BST into a sorted linked list
    public static Node convertTreeToList(Node root, Node head)
    {
        // base case: empty tree
        if (root == null) {
            return head;
        }

        // process right child first
        head = convertTreeToList(root.right, head);

        // Insert current root node at the front of the linked list
        head = push(root, head);

        // process left child
        head = convertTreeToList(root.left, head);

        // set left child as null
        // (since right child of the linked list acts as a next pointer)
        root.left = null;

        return head;
    }

    // Function to convert a sorted linked list into a min heap
    public static Node convertListToMinHeap(Node heapRef, Node head)
    {
        // base case: empty linked list
        if (head == null) {
            return heapRef;
        }

        // construct a queue to store the parent nodes
        Queue<Node> q = new ArrayDeque<>();

        // root node of min heap would be the front node in the sorted list
        heapRef = head;

        // add root node to the queue
        q.add(heapRef);

        // advance the linked list to next node
        head = head.right;

        // unlink the root node from the unprocessed linked list by
        // setting its right child as null
        heapRef.right = null;

        // loop till the end of list is reached
        while (head != null)
        {
            // Dequeue next node from the queue
            Node parent = q.poll();

            /* Assign next node of the linked list to the left child of the
            parent node */

            // process next node in the linked list
            Node next = head;

            // add next node to the queue
            q.add(next);

            // advance the linked list to next node
            head = head.right;

            // unlink the next node from the unprocessed linked list by
            // setting its right child as null
            next.right = null;

            // set next node as the left child of parent
            parent.left = next;


            /* Assign next node of the linked list to the right child of the
            parent node (if any) */

            if (head != null)
            {
                // process next node in the linked list
                next = head;

                // add next node to the queue
                q.add(next);

                // advance the linked list to next node
                head = head.right;

                // unlink the next node from the unprocessed linked list by
                // setting its right child as null
                next.right = null;

                // set next node as the right child of parent
                parent.right = next;
            }
        }

        return heapRef;
    }

    // Function to convert a BST into a min heap without using
    // any auxiliary space
    public static Node convert(Node root)
    {
        // points to head of the linked list
        Node head = null;

        // Convert the BST into a sorted linked list
        head = convertTreeToList(root, head);

        // Convert the sorted list into a min heap
        root = convertListToMinHeap(root, head);

        return root;
    }

    public static void main(String[] args)
    {
        Node root = null;

        /* Construct below bst
                   5
                 /   \
                /     \
               3       8
              / \       \
             /   \       \
            2     4      10
        */

        int[] keys = { 5, 3, 2, 4, 8, 10 };
        for (int key: keys) {
            root = insert(root, key);
        }

        root = convert(root);
        printLevelOrderTraversal(root);
    }
}