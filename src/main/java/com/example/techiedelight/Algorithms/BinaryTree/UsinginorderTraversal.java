package com.example.techiedelight.Algorithms.BinaryTree;

//In-place convert given Binary Tree to Doubly Linked List

//Using in-order traversal
class UsinginorderTraversal
{
    // Helper function to print given doubly linked list
    public static void printDLL(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }
 
    // Function to in-place convert given Binary Tree to a Doubly Linked List
    // by doing normal inorder traversal
    public static Node convert(Node root, Node head)
    {
        // base case: tree is empty
        if (root == null) {
            return head;
        }
 
        // recursively convert left subtree first
        head = convert(root.left, head);
 
        // store right child
        Node right = root.right;
 
        // insert current node in the beginning of DLL
        root.right = head;
        if (head != null) {
            head.left = root;
        }
 
        head = root;
 
        // recursively convert right subtree
        return convert(right, head);
    }
 
    // Function to reverse a doubly linked list
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
 
        while (current != null)
        {
            // swap current.left with current.right
            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
 
            prev = current;
            current = current.left;
        }
 
        return prev;
    }
 
    // UsinginorderTraversal function to in-place convert given Binary Tree to a Doubly Linked List
    public static void convert(Node root)
    {
        // head of doubly linked list
        Node head = null;
 
        // convert above binary tree to DLL
        head = convert(root, head);
 
        // reverse the linked list
        head = reverse(head);
 
        // print list
        printDLL(head);
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
        */
 
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        convert(root);
    }
}






class UsingReverseInOrderTraversal
{
    // Helper function to print given doubly linked list
    public static void printDLL(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    // Function to in-place convert given Binary Tree to a Doubly Linked List
    // by doing reverse inorder traversal
    public static Node convert(Node root, Node head)
    {
        // base case: tree is empty
        if (root == null) {
            return head;
        }

        // recursively convert right subtree first
        head = convert(root.right, head);

        // insert current node in the beginning of DLL
        root.right = head;

        if (head != null) {
            head.left = root;
        }

        head = root;

        // recursively convert left subtree
        return convert(root.left, head);
    }

    // in-place convert given Binary Tree to a Doubly Linked List
    public static Node convert(Node root)
    {
        // head of doubly linked list
        Node head = null;

        // convert above binary tree to DLL
        return convert(root, head);
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
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = convert(root);

        // print list
        printDLL(root);
    }
}





class KeepingTrackOfPreviousProcessedNodeInInOrderTraversal
{
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    // Helper function to print given doubly linked list
    public static void printDLL(Node head)
    {
        Node curr = head;
        while (curr != null)
        {
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    // Function to in-place convert given Binary Tree to a Doubly Linked List

    // root -> current node
    // head -> head of the doubly linked list (Passed by reference)
    // prev -> previous processed node (Passed by reference)
    public static Node convert(Node curr, Node head, NodeWrapper prev)
    {
        // base case: tree is empty
        if (curr == null) {
            return head;
        }

        // recursively convert left subtree first
        head = convert(curr.left, head, prev);

        // adjust pointers
        if (prev.node != null)
        {
            // set current node's left child to prev
            curr.left = prev.node;

            // make prev's right child as curr
            prev.node.right = curr;
        }

        // if prev is null, then update head of DLL as this is first node in inorder
        else {
            head = curr;
        }

        // after current node is visited, update previous pointer to current node
        prev.node = curr;

        // recursively convert right subtree
        return convert(curr.right, head, prev);
    }

    // in-place convert given Binary Tree to a Doubly Linked List
    public static Node convert(Node root)
    {
        // prev - keep track of previous processed node in inorder traversal
        Node prev = null;

        // Wrap prev node so it's reference can be changed inside convert() method
        NodeWrapper _prev = new NodeWrapper(prev);

        // convert above binary tree to DLL (using inorder traversal)
        return convert(root, root, _prev);
    }

    public static void main(String[] args)
    {
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

        root = convert(root);

        // root is now head of doubly linked list

        // print list
        printDLL(root);
    }
}