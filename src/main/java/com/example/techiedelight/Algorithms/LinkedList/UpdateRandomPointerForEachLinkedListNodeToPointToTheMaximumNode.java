package com.example.techiedelight.Algorithms.LinkedList;

class UpdateRandomPointerForEachLinkedListNodeToPointToTheMaximumNode
{
    // Helper function to insert new Node in the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }
 
    // Function to print a linked list with extra random pointer
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data);
 
            if (head.random != null) {
                System.out.print("(" + head.random.data + ") -> ");
            }
            else {
                System.out.print("(X) -> ");
            }
            head = head.next;
        }
 
        System.out.println("X");
    }
 
    // Function to reverse a linked list by changing its .next pointers
    // and its head pointer. It takes a reference to the head pointer.
    public static Node reverse(Node head)
    {
        Node prev = null;    // the prev pointer
        Node curr = head;        // the main pointer
 
        // traverse the list
        while (curr != null)
        {
            // tricky: note the next node
            Node next = curr.next;
 
            curr.next = prev;    // fix the curr node
 
            // advance the two pointers
            prev = curr;
            curr = next;
        }
 
        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }
 
    // Function to update random pointer of each linked list node
    // to point to node with maximum value to their right
    public static Node setRandomNodes(Node head)
    {
        // Reverse the linked list
        head = reverse(head);
 
        // max points to the node with maximum value
        Node max = head;
        head.random = null;
 
        // start from the second node in the list
        Node node = head.next;
        while (node != null)
        {
            // update random pointer of current node to point to the
            // maximum node so far
            node.random = max;
 
            // update max if current node is greater
            if (max.data < node.data) {
                max = node;
            }
 
            // advance to the next node
            node = node.next;
        }
 
        // restore the linked list original order
        head = reverse(head);
        return head;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 5, 10, 7, 9, 4, 3 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }
 
        printList("Original Linked List: ", head);
 
        // assign random nodes
        setRandomNodes(head);
 
        printList(" Final Linked List : ", head);
    }
}






class UpdateRandomPointerForEachLinkedListNodeToPointToTheMaximumNodeA2
{
    // Helper function to insert new Node in the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        return newNode;
    }

    // Function to print a linked list with extra random pointer
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data);

            if (head.random != null) {
                System.out.print("(" + head.random.data + ") -> ");
            } else {
                System.out.print("(X) -> ");
            }
            head = head.next;
        }

        System.out.println("X");
    }

    // Recursive function to update random pointer of each linked list node
    // to point to node with maximum value to their right
    public static Node setRandomNodes(Node head)
    {
        // Base case 1: empty list
        if (head == null) {
            return null;
        }

        // Base case 2: last node
        if (head.next == null) {
            head.random = null;
            return head;
        }

        // max points to the node with maximum value found so far
        // to the right of head node
        Node max = setRandomNodes(head.next);

        // update random pointer of current node to point to the
        // maximum node so far
        head.random = max;

        // update max if current node is greater and return it
        return (max.data > head.data) ? max: head;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 5, 10, 7, 9, 4, 3 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = push(head, keys[i]);
        }

        printList("Original Linked List: ", head);

        // assign random nodes
        setRandomNodes(head);

        printList(" Final Linked List : ", head);
    }
}