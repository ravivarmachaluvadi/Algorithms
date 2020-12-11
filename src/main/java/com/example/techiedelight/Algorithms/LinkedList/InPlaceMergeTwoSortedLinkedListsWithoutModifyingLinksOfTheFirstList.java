package com.example.techiedelight.Algorithms.LinkedList;

class InPlaceMergeTwoSortedLinkedListsWithoutModifyingLinksOfTheFirstList
{
    // Helper function to print given linked list
    public static void printList(String msg, Node head)
    {
        System.out.print(msg);
        while (head != null)
        {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    // Function to exchange data of given linked list nodes
    public static void swapData(Node first, Node second)
    {
        int data = first.data;
        first.data = second.data;
        second.data = data;
    }
 
    // Function to insert the given node into the correct sorted position in
    // the given list sorted in increasing order
    public static Node sortedInsert(Node head, Node newNode)
    {
        // Special case for the head end
        if (head == null || (head).data >= newNode.data)
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
 
    // Function to in-place merge two sorted linked lists without
    // modifying links of the first list.
    public static Node mergeLists(Node first, Node second)
    {
        // loop till either list runs out
        while (first != null && second != null)
        {
            // compare each element of the first list with the first element
            // of second list
            if (first.data > (second).data)
            {
                // exchange data if current node of the first list has more value
                // than the first node of the second list
                swapData(first, second);
 
                // pop front node from the second list
                Node front = second;
                second = (second).next;
 
                // insert front node at its correct place in the second list
                second = sortedInsert(second, front);
            }
 
            // advance first list to the next node
            first = first.next;
        }
 
        return second;
    }
 
    public static void main(String[] args)
    {
        // construct first list
        Node first = new Node(2);
        first.next = new Node(6);
        first.next.next = new Node(9);
        first.next.next.next = new Node(10);
        first.next.next.next.next = new Node(15);
 
        // construct second list
        Node second = new Node(1);
        second.next = new Node(4);
        second.next.next = new Node(5);
        second.next.next.next = new Node(20);
 
        // print both lists before merge
        System.out.print("Before Merging:\n\n");
        printList("First List : ", first);
        printList("Second List: ", second);
 
        // merge both lists
        second = mergeLists(first, second);
 
        // print both lists after merge
        System.out.print("\n\nAfter Merging:\n\n");
        printList("First List : ", first);
        printList("Second List: ", second);
    }
}