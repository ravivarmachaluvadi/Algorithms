package com.example.techiedelight.Algorithms.LinkedList;

class SplitLinkedListIntoTwoListsWhereEachListContainingAlternatingElementsFromIt
{
    // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
 
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    /*
    Given the source list, split its nodes into two shorter lists.
    If we number the elements 0, 1, 2, ... then all the even elements
    should go in the first list, and all the odd elements in the second.
    The elements in the new lists may be in any order.
    */
    public static Node[] AlternatingSplit(Node source)
    {
        // Split the nodes to these 'a' and 'b' lists
        Node a = null;
        Node b = null;
        Node current = source;
 
        while (current != null)
        {
            // Move a node to 'a'
 
            Node newNode = current;    // the front source node
            current = current.next;    // Advance the source
 
            newNode.next = a;       // Link the old dest off the new node
            a = newNode;            // Move dest to point to the new node
 
            if (current != null) {
                // Move a node to 'b'
 
                newNode = current;      // the front source node
                current = current.next; // Advance the source
 
                newNode.next = b;       // Link the old dest off the new node
                b = newNode;            // Move dest to point to the new node
            }
        }
 
        return new Node[] { a, b };
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };
 
        // construct first linked list
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        Node[] nodes = AlternatingSplit(head);
 
        // print both linked list
        printList("First List  : ", nodes[0]);
        printList("Second List : ", nodes[1]);
    }
}




//Using Dummy Nodes
class SplitLinkedListIntoTwoListsWhereEachListContainingAlternatingElementsFromItA2
{
    // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);

        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    /*
    Given the source list, split its nodes into two shorter lists.
    If we number the elements 0, 1, 2, ... then all the even elements
    should go in the first list, and all the odd elements in the second.
    The elements in the new lists may be in any order.
    */
    public static Node[] AlternatingSplit(Node source)
    {
        Node aDummy = new Node();
        Node aTail = aDummy; // points to the last node in 'a'
        aDummy.next = null;

        Node bDummy = new Node();
        Node bTail = bDummy; // points to the last node in 'b'
        bDummy.next = null;

        Node current = source;

        while (current != null)
        {
            // add at 'a' tail

            Node newNode = current;
            current = current.next;

            newNode.next = aTail.next;
            aTail.next = newNode;

            aTail = aTail.next;                 // advance the 'a' tail
            if (current != null)
            {
                // add at 'b' tail

                newNode = current;
                current = current.next;

                newNode.next = bTail.next;
                bTail.next = newNode;

                bTail = bTail.next;     // advance the 'b' tail
            }
        }

        return new Node[] { aDummy.next, bDummy.next };
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };

        // construct first linked list
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        Node[] nodes = AlternatingSplit(head);

        // print both linked list
        printList("First List  : ", nodes[0]);
        printList("Second List : ", nodes[1]);
    }
}




//Using Recursion
class SplitLinkedListIntoTwoListsWhereEachListContainingAlternatingElementsFromItA3
{
    // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);

        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    // Recursive function to split given linked list into two lists where
    // each list containing alternating elements from the original list.
    // The solution maintains the same order as the source list
    public static void AlternatingSplit(Node odd, Node even)
    {
        if (odd == null || even == null) {
            return;
        }

        if (odd.next != null) {
            odd.next = odd.next.next;
        }

        if (even.next != null) {
            even.next = even.next.next;
        }

        AlternatingSplit(odd.next, even.next);
    }

    /*
    Given the source list, split its nodes into two shorter lists.
    If we number the elements 0, 1, 2, ... then all the even elements
    should go in the first list, and all the odd elements in the second.
    The elements in the new lists may be in any order.
    */
    public static Node[] AlternatingSplit(Node source)
    {
        Node aRef = source;
        Node bRef = source.next;
        AlternatingSplit(aRef, bRef);

        return new Node[] { aRef, bRef };
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7 };

        // construct first linked list
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        Node[] nodes = AlternatingSplit(head);

        // print both linked list
        printList("First List  : ", nodes[0]);
        printList("Second List : ", nodes[1]);
    }
}
