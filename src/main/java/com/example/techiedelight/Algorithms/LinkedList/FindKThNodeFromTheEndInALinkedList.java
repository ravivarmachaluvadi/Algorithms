package com.example.techiedelight.Algorithms.LinkedList;

class FindKThNodeFromTheEndInALinkedList
{
    // Iterative function to return K'th node from the end in a linked list
    public static Node getKthFromtheEnd(Node head, int k)
    {
        int n = 0;
        Node curr = head;
 
        // Count number of nodes in the linked list
        while (curr != null)
        {
            curr = curr.next;
            n++;
        }
 
        // if number of nodes is more than or equal to K
        if (n >= k)
        {
            // return (n-k+1)th node from the beginning
            curr = head;
            for (int i = 0; i < n - k; i++) {
                curr = curr.next;
            }
        }
 
        return curr;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        int k = 3;
        Node node = getKthFromtheEnd(head, k);
 
        if (node != null) {
            System.out.println("K'th node from the end is " + node.data);
        }
    }
}




class FindKThNodeFromTheEndInALinkedListA2
{
    // Iterative function to return K'th node from the end in a linked list
    public static Node getKthFromtheEnd(Node head, int k)
    {
        Node curr = head;

        // move k nodes ahead in the linked list
        for (int i = 0; curr != null && i < k; i++) {
            curr = curr.next;
        }

        // return if k is more than number of nodes in the list
        if (curr == null) {
            return null;
        }

        // move head and curr parallelly till curr reaches end of the list
        while (curr != null)
        {
            head = head.next;
            curr = curr.next;
        }

        // head now will contains Kth node from the end
        return head;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        int k = 3;
        Node node = getKthFromtheEnd(head, k);

        if (node != null) {
            System.out.println("K'th node from the end is " + node.data);
        }
    }
}




//Recursive solution
class FindKThNodeFromTheEndInALinkedListA3
{
    // Recursive function to return K'th node from the end in a linked list
    public static int getKthFromtheEnd(Node node, int k)
    {
        // base case
        if (node == null) {
            return 0;
        }

        int count = getKthFromtheEnd(node.next, k) + 1;

        if (count == k) {
            System.out.println("K'th node from the end is " + node.data);
        }

        return count;
    }


    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        int k = 3;
        getKthFromtheEnd(head, k);
    }
}

