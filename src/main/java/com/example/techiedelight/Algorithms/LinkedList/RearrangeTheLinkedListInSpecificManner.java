package com.example.techiedelight.Algorithms.LinkedList;

class RearrangeTheLinkedListInSpecificManner
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
 
    // Helper function to insert new node in the beginning of the linked list
    public static Node push(Node head, int data) {
        return new Node(data, head);
    }
 
    // Function to rearrange the linked list in specific manner
    public static Node rearrange(Node head)
    {
        // empty list or one node
        if (head == null || (head).next == null)
            return head;
 
        // create two dummy nodes
        Node dummyFirst = new Node();
        Node dummySecond = new Node();
 
        // tail pointer for first and second list
        Node first = dummyFirst;
        Node second = dummySecond;
 
        Node curr = head;
 
        // iterate through the list and process two nodes at a time
        while (curr != null)
        {
            // move current node to first list
            first.next = curr;
            first = first.next;
 
            // move next node to second list
            if (curr.next != null)
            {
                second.next = curr.next;
                second = second.next;
                curr = curr.next;
            }
            curr = curr.next;
        }
 
        // combine first list with second list
        first.next = dummySecond.next;
        second.next = null;
 
        // fix head pointer
        head = dummyFirst.next;
 
        return head;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5 };
        int n = keys.length;
 
        Node head = null;
        for (int i = n - 1; i >= 0; i--)
            head = push(head, keys[i]);
 
        head = rearrange(head);
 
        printList(head);
    }
}