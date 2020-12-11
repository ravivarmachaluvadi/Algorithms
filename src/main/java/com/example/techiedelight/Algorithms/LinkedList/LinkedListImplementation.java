package com.example.techiedelight.Algorithms.LinkedList;

class LinkedListImplementation
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
 
    // Naive function for Linked List Implementation containing three nodes
    public static Node constructList()
    {
        // construct linked list nodes
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
 
        // rearrange the references to construct a list
        Node head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
 
        // return reference to first node in the list
        return head;
    }
 
    // main method to implement linked list
    public static void main(String[] args)
    {
        // 'head' points to the head node of the linked list
        Node head = constructList();
 
        // print linked list
        printList(head);
    }
}



// A linked list node
class Node
{
    int data;
    String datas;
    Node next, child , prev,down,random,left,right,mid;

    // Constructor
    Node(String str)
    {
        this.datas = str;
        this.next = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node() {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Helper function to print linked list starting from current node
    public void print()
    {
        Node ptr = this;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
        System.out.println("null");
    }
}



// A linked list node
class NodeNext
{
    int data;
    NodeNext next;

    NodeNext(int data, NodeNext next) {
        this.data = data;
        this.next = next;
    }
}



