package com.example.techiedelight.Algorithms.LinkedList;

class RearrangeALinkedListBySeparatingOddNodesFromTheEvenOnes
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
 
    // Rearrange the given linked list by separating odd nodes
    // from even ones and maintaining their relative order.
    // This approach do not use any dummy node.
    public static Node rearrangeEvenOdd(Node head)
    {
        Node odd = null, oddTail = null;
        Node even = null, evenTail = null;
        Node curr = head;
 
        while (curr != null)
        {
            if ((curr.data & 1) != 0) // current node is odd
            {
                // handle head for first odd node
                if (odd == null) {
                    odd = oddTail = curr;
                }
                else
                {
                    oddTail.next = curr;
                    oddTail = oddTail.next;
                }
            }
            else // current node is even
            {
                // handle head for first even node
                if (even == null) {
                    even = evenTail = curr;
                }
                else
                {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            }
            curr = curr.next;
        }
 
        // if list contains at-least one even node
        if (even != null)
        {
            head = even;
            evenTail.next = odd;
        }
        // special case - list contains all odd nodes
        else {
            head = odd;
        }
 
        // null to terminate the list,
        // else it will go in infinite loop
        if (oddTail != null) {
            oddTail.next = null;
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }
 
        head = rearrangeEvenOdd(head);
        printList(head);
    }
}




//Using Dummy Nodes
class RearrangeALinkedListBySeparatingOddNodesFromTheEvenOnesA2
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

    // Rearrange the given linked list by separating odd nodes
    // from even ones and maintaining their relative order.
    // This approach uses dummy node
    public static Node rearrangeEvenOdd(Node head)
    {
        Node odd = new Node(), even = new Node();
        Node oddTail = odd, evenTail = even;

        Node curr = head;

        while (curr != null)
        {
            if ((curr.data & 1) != 0)
            {
                oddTail.next = curr;
                oddTail = oddTail.next;
            }
            else
            {
                evenTail.next = curr;
                evenTail = curr;
            }
            curr = curr.next;
        }

        evenTail.next = odd.next;
        oddTail.next = null;
        return even.next;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrangeEvenOdd(head);
        printList(head);
    }
}




//Using Recursion
class RearrangeALinkedListBySeparatingOddNodesFromTheEvenOnesA3
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

    // Recursive function to rearrange the list
    public static Node rearrange(Node head, Node odd, Node even,
                                 Node oddRef)
    {
        // we have reached the end of the list
        if (head == null)
        {
            // null terminate the list
            odd.next = null;

            // join even sublist and odd sublist
            even.next = oddRef.next;
            return head;
        }

        // if current node is odd
        if ((head.data & 1) != 0)
        {
            odd.next = head;
            rearrange(head.next, head, even, oddRef);
        }

        // if current node is even
        else
        {
            even.next = head;
            rearrange(head.next, odd, head, oddRef);
        }

        return head;
    }

    // Rearrange the given linked list by separating odd nodes
    // from even ones and maintaining their relative order.
    public static Node rearrangeEvenOdd(Node head)
    {
        Node odd = new Node();
        Node even = new Node();

        rearrange(head, odd, even, odd);

        return even.next;
    }

    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        head = rearrangeEvenOdd(head);
        printList(head);
    }
}

