package com.example.techiedelight.Algorithms.LinkedList;

class PairwiseSwapAdjacentNodesOfALinkedList
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
 
    // Function to pairwise swap adjacent nodes of a linked list
    public static Node rearrange(Node head)
    {
        // if list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }
 
        Node curr = head, prev = null;
 
        // consider two nodes at a time and swap their links
        while (curr != null && curr.next != null)
        {
            Node temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
 
            if (prev == null) {
                head = temp;
            } else {
                prev.next = temp;
            }
 
            prev = curr;
            curr = curr.next;
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
 
        Node head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            head = new Node(arr[i], head);
        }
 
        printList("Before : ", head);
        head = rearrange(head);
        printList("After  : ", head);
    }
}





class PairwiseSwapAdjacentNodesOfALinkedListA2
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

    // Function to pairwise swap adjacent nodes of a linked list
    public static Node rearrange(Node head, Node prev)
    {
        // base case: if list is empty or contains just one node
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node temp = curr.next;
        curr.next = temp.next;
        temp.next = curr;

        if (prev == null) {
            head = temp;
        } else {
            prev.next = temp;
        }

        prev = curr;
        rearrange(curr.next, prev);

        return head;
    }

    // The wrapper function to call rearrange()
    public static Node rearrange(Node head)
    {
        return rearrange(head, null);
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };

        Node head = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            head = new Node(arr[i], head);
        }

        printList("Before : ", head);
        head = rearrange(head);
        printList("After  : ", head);
    }
}