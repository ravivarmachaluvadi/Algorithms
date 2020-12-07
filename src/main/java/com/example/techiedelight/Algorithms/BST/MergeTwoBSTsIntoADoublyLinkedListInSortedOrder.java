package com.example.techiedelight.Algorithms.BST;

class MergeTwoBSTsIntoADoublyLinkedListInSortedOrder
{
    // Helper function to print a doubly linked list
    public static void printDoublyList(Node head)
    {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.right;
        }
        System.out.print("null");
    }
 
    // Function to insert a BST node at the front of a doubly linked list
    public static Node push(Node root, Node head)
    {
        // insert the given node at the front of the DDL
        root.right = head;
 
        // update the left pointer of the existing head node of the DDL
        // to point to the BST node
        if (head != null) {
            head.left = root;
        }
 
        // update the head pointer of DDL
        head = root;
        return head;
    }
 
    /*
    Recursive function to convert a binary search tree into a doubly linked list
        root -> Pointer to the root node of the binary search tree
        head -> Reference to the head node of the doubly linked list
    */
    public static Node convertBSTtoDLL(Node root, Node head)
    {
        // Base case
        if (root == null) {
            return head;
        }
 
        // recursively convert the right subtree a
        head = convertBSTtoDLL(root.right, head);
 
        // push current node at the front of the doubly linked list
        head = push(root, head);
 
        // recursively convert the left subtree
        head = convertBSTtoDLL(root.left, head);
 
        return head;
    }
 
    // Recursive function to merge two doubly linked list into a
    // single doubly linked list in sorted order
    public static Node mergeDDLs(Node a, Node b)
    {
        // if the first list is empty, return the second list
        if (a == null) {
            return b;
        }
 
        // if the second list is empty, return the first list
        if (b == null) {
            return a;
        }
 
        // if head node of the first list is smaller
        if (a.data < b.data) {
            a.right = mergeDDLs(a.right, b);
            a.right.left = a;
            return a;
        }
 
        // if head node of the second list is smaller
        else {
            b.right = mergeDDLs(a, b.right);
            b.right.left = b;
            return b;
        }
    }
 
    // Function to merge two binary search trees into a doubly linked list
    // in sorted order
    public static Node merge(Node a, Node b)
    {
        // Convert first binary search tree to a doubly linked list
        Node first = null;
        first = convertBSTtoDLL(a, first);
 
        // Convert second binary search tree to a doubly linked list
        Node second = null;
        second = convertBSTtoDLL(b, second);
 
        // Merge both doubly linked lists
        return mergeDDLs(first, second);
    }
 
    public static void main(String[] args)
    {
        /*
        Construct first BST
              20
             /  \
            10  30
               /  \
              25  100
        */
 
        Node a = new Node(20);
        a.left = new Node(10);
        a.right = new Node(30);
        a.right.left = new Node(25);
        a.right.right = new Node(100);
 
        /*
        Construct second BST
              50
             /  \
            5   70
        */
 
        Node b = new Node(50);
        b.left = new Node(5);
        b.right = new Node(70);
 
        // merge both BSTs into a doubly linked list
        Node root = merge(a, b);
        printDoublyList(root);
    }
}