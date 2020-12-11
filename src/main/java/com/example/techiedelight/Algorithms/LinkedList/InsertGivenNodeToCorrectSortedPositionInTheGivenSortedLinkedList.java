package com.example.techiedelight.Algorithms.LinkedList;

class InsertGivenNodeToCorrectSortedPositionInTheGivenSortedLinkedList
{
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Function to insert the given node into the correct sorted position in
    // the given list sorted in increasing order
    public static Node SortedInsert(Node head, Node newNode)
    {
        // Special case for the head end
        if (head == null || head.data >= newNode.data)
        {
            newNode.next = head;
            head = newNode;
            return head;
        }

        // Locate the node before the point of insertion
        Node current = head;
        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = {2, 4, 6, 8};

        // points to the head node of the linked list
        Node head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = SortedInsert(head, new Node(5));
        head = SortedInsert(head, new Node(9));
        head = SortedInsert(head, new Node(1));

        // print linked list
        printList(head);
    }
}




//Using Dummy Node
class InsertGivenNodeToCorrectSortedPositionInTheGivenSortedLinkedListA2
{
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Function to insert given node in correct sorted position in the given
    // list sorted in increasing order using dummy node strategy for head end
    public static Node SortedInsert(Node head, Node newNode)
    {
        Node dummy = new Node();
        Node current = dummy;
        dummy.next = head;

        while (current.next != null && current.next.data < newNode.data) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        return dummy.next;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = {2, 4, 6, 8};

        // points to the head node of the linked list
        Node head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = SortedInsert(head, new Node(5));
        head = SortedInsert(head, new Node(9));
        head = SortedInsert(head, new Node(1));

        // print linked list
        printList(head);
    }
}






