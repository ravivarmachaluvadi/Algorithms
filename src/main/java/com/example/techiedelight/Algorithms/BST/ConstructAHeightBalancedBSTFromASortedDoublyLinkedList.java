package com.example.techiedelight.Algorithms.BST;

import java.util.ArrayList;
import java.util.List;

class ConstructAHeightBalancedBSTFromASortedDoublyLinkedList
{
    // Function to insert a new NodeNext at the beginning of the Doubly Linked List
    public static NodeNext push(NodeNext head, int data)
    {
        // allocate a new NodeNext and link it at the beginning
        NodeNext NodeNext = new NodeNext(data);
        NodeNext.next = head;
 
        // change prev of the existing head NodeNext to point to the new NodeNext
        if (head != null) {
            head.prev = NodeNext;
        }
 
        // update head pointer
        head = NodeNext;
        return head;
    }
 
    // Function to print nodes of a Doubly Linked List
    public static void printListNodes(NodeNext NodeNext)
    {
        while (NodeNext != null) {
            System.out.print(NodeNext.data + " ");
            NodeNext = NodeNext.next;
        }
 
        System.out.println();
    }
 
    // Function to print pre-order traversal of the BST
    public static void preorder(NodeNext root)
    {
        if (root == null) {
            return;
        }
 
        System.out.print(root.data + " ");
        preorder(root.prev);
        preorder(root.next);
    }
 
    // Function to push nodes of a given BST in a List
    public static void pushDDLNodes(NodeNext NodeNext, List<NodeNext> nodes)
    {
        while (NodeNext != null)
        {
            nodes.add(NodeNext);
            NodeNext = NodeNext.next;
        }
    }
 
    // Recursive function to construct a height-balanced BST from
    // given nodes in sorted order
    public static NodeNext buildBalancedBST(List<NodeNext> nodes, int start, int end)
    {
        // base case
        if (start > end) {
            return null;
        }
 
        // find the middle index
        int mid = (start + end) / 2;
 
        // The root NodeNext will be NodeNext present at the mid index
        NodeNext root = nodes.get(mid);
 
        // recursively construct left and right subtree
        root.prev = buildBalancedBST(nodes, start, mid - 1);
        root.next = buildBalancedBST(nodes, mid + 1, end);
 
        // return root NodeNext
        return root;
    }
 
    // Function to construct a height-balanced BST from a sorted Doubly Linked List
    public static NodeNext convertSortedDLLToBalancedBST(NodeNext head)
    {
        // Push nodes of a given BST in a List in original order
        List<NodeNext> nodes = new ArrayList<>();
        pushDDLNodes(head, nodes);
 
        // Construct a height-balanced BST from sorted BST nodes
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }
 
    public static void main(String[] args)
    {
        // Points to the head of a Doubly Linked List
        NodeNext head = null;
 
        // Construct a Doubly Linked List from sorted keys
        int[] keys = { 25, 20, 18, 15, 12, 10, 8 };
        for (int key: keys) {
            head = push(head, key);
        }
 
        System.out.print("Doubly Linked List: ");
        printListNodes(head);
 
        // Construct a height-balanced BST from a sorted Doubly Linked List
        NodeNext root = convertSortedDLLToBalancedBST(head);
 
        System.out.print("Preorder traversal of the constructed BST: ");
        preorder(root);
    }
}



// Data structure to store NodeNext of Doubly Linked List / BST
class NodeNext
{
    // value of NodeNext
    int data;

    // The prev and next pointer of the Doubly Linked List can act as
    // left and right child pointer for the BST respectively
    NodeNext prev, next;

    // Constructor
    NodeNext(int data)
    {
        this.data = data;
        this.prev = this.next = null;
    }
}





class ConstructAHeightBalancedBSTFromASortedDoublyLinkedListA2
{
    // Function to insert a new NodeNext at the beginning of the Doubly Linked List
    public static NodeNext push(NodeNext head, int data)
    {
        // allocate a new NodeNext and link it at the beginning
        NodeNext NodeNext = new NodeNext(data);
        NodeNext.next = head;

        // change prev of the existing head NodeNext to point to the new NodeNext
        if (head != null) {
            head.prev = NodeNext;
        }

        // update head pointer
        head = NodeNext;
        return head;
    }

    // Function to print and count number of nodes in a Doubly Linked List
    public static int printAndCountNodes(NodeNext NodeNext)
    {
        int counter = 0;

        while (NodeNext != null)
        {
            System.out.print(NodeNext.data + " ");
            NodeNext = NodeNext.next;
            counter++;
        }

        System.out.println();
        return counter;
    }

    // Function to print pre-order traversal of the BST
    public static void preorder(NodeNext root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.prev);
        preorder(root.next);
    }

    // Recursive function to construct a height-balanced BST from a sorted Doubly
    // Linked List. It takes the reference to the head NodeNext of the Doubly Linked
    // List and number of nodes in the Doubly Linked List as argument
    public static NodeNext convertSortedDLLToBalancedBST(NodeWrapper head, int n)
    {
        // base case
        if (n <= 0) {
            return null;
        }

        // recursively construct the left subtree
        NodeNext leftSubTree = convertSortedDLLToBalancedBST(head, n/2);

        // head now points to the middle NodeNext of the sorted DDL

        // make mid NodeNext of the sorted DDL as root NodeNext of the BST
        NodeNext root = head.NodeNext;

        // update left child of the root NodeNext
        root.prev = leftSubTree;

        // update the head reference of the DLL
        head.NodeNext = head.NodeNext.next;

        // recursively construct the right subtree with the remaining nodes
        root.next = convertSortedDLLToBalancedBST(head, n - (n/2 + 1));
        /* +1 for the root NodeNext */

        // return the root NodeNext
        return root;
    }


    public static void main(String[] args)
    {
        // Points to the head of a Doubly Linked List
        NodeNext head = null;

        // Construct a Doubly Linked List from sorted keys
        int[] keys = { 25, 20, 18, 15, 12, 10, 8 };
        for (int key: keys) {
            head = push(head, key);
        }

        // print the list and count number of nodes
        System.out.print("Doubly Linked List: ");
        int n = printAndCountNodes(head);

        // Construct a height-balanced BST from a sorted Doubly Linked List

        // Wrap head NodeNext so it's reference can be changed
        NodeNext root = convertSortedDLLToBalancedBST(new NodeWrapper(head), n);

        System.out.print("Preorder traversal of the constructed BST: ");
        preorder(root);
    }
}




// Wrapper over the NodeNext class
class NodeWrapper {
    public NodeNext NodeNext;

    NodeWrapper(NodeNext NodeNext) {
        this.NodeNext = NodeNext;
    }
}
