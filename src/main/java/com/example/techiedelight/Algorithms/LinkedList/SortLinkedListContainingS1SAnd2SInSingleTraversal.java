package com.example.techiedelight.Algorithms.LinkedList;

class SortLinkedListContainingS1SAnd2SInSingleTraversal
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
 
    // Function to sort linked list containing 0’s, 1’s and 2’s in single traversal
    public static Node sortList(Node head)
    {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
 
        // maintain three dummy nodes
        Node first = new Node(), second = new Node(), third = new Node();
 
        // maintain three references
        Node zero = first, one = second, two = third;
 
        // traverse the list
        Node curr = head;
        while (curr != null)
        {
            if (curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if (curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else
            {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
 
        // combine lists containing 0's, 1's and 2's
        zero.next = (second.next != null)? (second.next): (third.next);
        one.next = third.next;
        two.next = null;
 
        // change head
        return first.next;
    }
 
    // Sort linked list containing 0’s, 1’s and 2’s in single traversal
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 0, 0, 1, 2, 1, 2, 1 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = sortList(head);
        printList(head);
    }
}