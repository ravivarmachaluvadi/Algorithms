package com.example.techiedelight.Algorithms.LinkedList;

class StaticLinkedList
{
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }
 
        System.out.println("null");
    }
 
    public static void main(String[] args)
    {
        Node e = new Node(5, null); // last node
        Node d = new Node(4, e);
        Node c = new Node(3, d);
        Node b = new Node(2, c);
        Node a = new Node(1, b);    // first node
 
        Node head = a;
        printList(head);
    }
}




class StaticLinkedListA2
{
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 3, 4, 5 };

        Node[] node = new Node[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            node[i] = new Node(arr[i], null);

            if (i > 0) {
                node[i - 1].next = node[i];
            }
        }

        Node head = node[0];
        printList(head);
    }
}





class StaticLinkedListA3
{
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = null;

        // Entering block scope
        {
            Node[] node = new Node[arr.length];
            for (int i = 0; i < arr.length; i++)
            {
                node[i] = new Node(arr[i], null);

                if (i > 0) {
                    node[i - 1].next = node[i];
                }
            }

            head = node[0];
        }
        // Exiting block scope

        printList(head);
    }
}





class StaticLinkedListA4
{
    public static final int N = 5;
    private static Node[] node = new Node[N];

    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null) {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.next;
        }

        System.out.println("null");
    }

    public static Node createStaticList(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
        {
            node[i] = new Node(arr[i], null);

            if (i > 0) {
                node[i - 1].next = node[i];
            }
        }

        return node[0];
    }

    public static void main(String[] args)
    {
        int arr[] = { 1, 2, 3, 4, 5 };

        Node head = createStaticList(arr);
        printList(head);
    }
}



