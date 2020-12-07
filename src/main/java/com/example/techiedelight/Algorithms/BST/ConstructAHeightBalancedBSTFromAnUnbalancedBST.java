package com.example.techiedelight.Algorithms.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ConstructAHeightBalancedBSTFromAnUnbalancedBST
{
    // Helper function to perform the pre-order traversal of a BST
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 
    // Recursive function to push nodes of a given binary search tree in a
    // List in in-order fashion
    public static void pushTreeNodes(Node root, List<Node> nodes)
    {
        // base case
        if (root == null) {
            return;
        }
 
        pushTreeNodes(root.left, nodes);
        nodes.add(root);
        pushTreeNodes(root.right, nodes);
    }
 
    // Recursive function to construct a height-balanced BST from
    // given nodes in sorted order
    public static Node buildBalancedBST(List<Node> nodes, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // find the middle index
        int mid = (start + end) / 2;
 
        // The root node will be node present at the mid index
        Node root = nodes.get(mid);
 
        // recursively construct left and right subtree
        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);
 
        // return root node
        return root;
    }
 
    // Function to construct a height-balanced BST from an unbalanced BST
    public static Node constructBalancedBST(Node root)
    {
        // Push nodes of a given binary search tree in a List in sorted order
        List<Node> nodes = new ArrayList<>();
        pushTreeNodes(root, nodes);
 
        // Construct a height-balanced BST from sorted BST nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(15);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(2);
        root.left.left.left.right = new Node(8);
 
        root = constructBalancedBST(root);
 
        System.out.print("Preorder Traversal of the constructed BST is: ");
        preorder(root);
    }
}






class ConstructAHeightBalancedBSTFromAnUnbalancedBSTA2
{
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    // Helper function to perform the pre-order traversal of a BST
    public static void preorder(Node root)
    {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.out.print(root.data + " ");
        preorder(root.right);
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
    Recursive function to construct a sorted doubly linked list from a BST
        root  -> Pointer to the root node of the binary search tree
        head  -> Reference to the head node of the doubly linked list
        nodes -> Stores count of number of nodes processed so far in the BST
    */
    public static Node convertBSTtoSortedDLL(Node root, Node head, AtomicInteger nodes)
    {
        // Base case
        if (root == null) {
            return head;
        }

        // recursively convert the right subtree
        head = convertBSTtoSortedDLL(root.right, head, nodes);

        // push current node at the front of the doubly linked list
        head = push(root, head);

        // increment number of nodes
        nodes.incrementAndGet();

        // recursively convert the left subtree
        head = convertBSTtoSortedDLL(root.left, head, nodes);

        return head;
    }

    /*
    Recursive function to construct a height-balanced BST from a doubly linked list
        head -> Reference to the head node of the doubly linked list
        n    -> Number of nodes in the doubly linked list
    */
    public static Node convertSortedDLLToBST(NodeWrapper head, int n)
    {
        // base case
        if (n <= 0) {
            return null;
        }

        // recursively construct the left subtree
        Node leftSubTree = convertSortedDLLToBST(head, n/2);

        // head now points to the middle node of the sorted DDL

        // make mid node of the sorted DDL as root node of the BST
        Node root = head.node;

        // update left child of the root node
        root.left = leftSubTree;

        // update the head reference of the DLL
        head.node = head.node.right;

        // recursively construct the right subtree with the remaining nodes
        root.right = convertSortedDLLToBST(head, n - (n/2 + 1));
        /* +1 for the root Node */

        // return the root node
        return root;
    }

    // Function to construct a height-balanced BST from an unbalanced BST
    public static Node constructBalancedBST(Node root)
    {
        // Pointer to the head node of the DLL
        Node head = null;

        /* Convert the given BST into a sorted DLL and update counter with the
            number of nodes in the BST */

        // use AtomicInteger as Integer is passed by value in Java
        AtomicInteger nodes = new AtomicInteger(0);

        head = convertBSTtoSortedDLL(root, head, nodes);

        /* construct a height-balanced BST from the sorted DLL */

        // Wrap head node so it's reference can be changed inside convertSortedDLLToBST()
        root = convertSortedDLLToBST(new NodeWrapper(head), nodes.get());

        return root;
    }

    public static void main(String[] args)
    {
        Node root = new Node(20);
        root.left = new Node(15);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(2);
        root.left.left.left.right = new Node(8);

        root = constructBalancedBST(root);

        System.out.print("Preorder Traversal of the constructed BST is: ");
        preorder(root);
    }
}