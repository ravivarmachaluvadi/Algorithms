package com.example.techiedelight.Algorithms.LinkedList;

class CloneALinkedListNaiveApproach
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
 
    // Function that takes a linked list & returns its complete copy
    public static Node CopyList(Node head)
    {
        Node current = head;    // used to iterate over original list
        Node newList = null; // head of the new list
        Node tail = null;    // point to last node in new list
 
        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new Node(current.data, null);
                tail = newList;
            }
            else
            {
                tail.next = new Node();
                tail = tail.next;
                tail.data = current.data;
                tail.next = null;
            }
            current = current.next;
        }
 
        return newList;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};
 
        // points to the head node of the linked list
        Node head = null;
 
        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        // copy linked list
        Node copy = CopyList(head);
 
        // print duplicate linked list
        printList(copy);
    }
}





class CloneALinkedListUsingPush
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

    // Function that takes a linked list and returns a complete copy of that
    // list using dummy node using push() function
    public static Node CopyList(Node head)
    {
        Node current = head; // used to iterate over original list
        Node newList = null; // head of the new list
        Node tail = null;    // point to last node in new list

        while (current != null)
        {
            // special case for the first new node
            if (newList == null)
            {
                newList = new Node(current.data, newList);
                tail = newList;
            }
            else
            {
                // add each node at tail
                tail.next = new Node(current.data, tail.next);

                // advance the tail to new last node
                tail = tail.next;
            }
            current = current.next;
        }

        return newList;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};

        // points to the head node of the linked list
        Node head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // copy linked list
        Node dup = CopyList(head);

        // print duplicate linked list
        printList(dup);
    }
}





class UsingDummyNode
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

    // Function that takes a linked list and returns a complete copy of that
    // list using dummy node
    public static Node CopyList(Node head)
    {
        Node current = head; // used to iterate over the original list
        Node tail; // point to the last node in the new list
        Node dummy = new Node(); // build the new list off this dummy node

        tail = dummy; // start the tail pointing at the dummy

        while (current != null)
        {
            // add each node at the tail
            tail.next = new Node(current.data, tail.next);

            // advance the tail to the new last node
            tail = tail.next;
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};

        // points to the head node of the linked list
        Node head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // copy linked list
        Node dup = CopyList(head);

        // print duplicate linked list
        printList(dup);
    }
}




class RecursiveSolution
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

    // Recursive function that takes a linked list and returns a complete
    // copy of that list
    public static Node CopyList(Node head)
    {
        if (head == null) {
            return null;
        }

        // Allocate the new node & set its data
        Node newNode = new Node(head.data);

        // recursively set the next field of the new node by recur
        // for the rest nodes
        newNode.next = CopyList(head.next);

        return newNode;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4};

        // points to the head node of the linked list
        Node head = null;

        // construct linked list
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // copy linked list
        Node dup = CopyList(head);

        // print duplicate linked list
        printList(dup);
    }
}
