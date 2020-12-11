package com.example.techiedelight.Algorithms.LinkedList;

class AddASingleDigitNumberToALinkedListRepresentingANumber
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
 
    // Function to reverse the given linked list
    public static Node reverse(Node head)
    {
        Node prev = null;
        Node current = head;
        Node next;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            next = current.next;
 
            // fix the current node
            current.next = prev;
 
            // advance the two pointers
            prev = current;
            current = next;
        }
 
        // fix the head pointer to point to the new front
        head = prev;
        return head;
    }
 
    // Function to add a single-digit number to a singly linked list
    // whose nodes represents digits of a number
    public static Node addDigit(Node head, int digit)
    {
        // empty list
        if (head == null) {
            return head;
        }
 
        // reverse the linked list
        head = reverse(head);
 
        // initialize carry with given digit
        int carry = digit;
 
        // traverse the reversed list
        Node curr = head;
        while (carry > 0)
        {
            // get sum of current node and carry
            int sum = curr.data + carry;
 
            // update value of the current node with the single-digit sum
            curr.data = sum % 10;
 
            // set carry for the next node
            carry = sum / 10;
 
            // break if current node is the last node
            if (curr.next == null) {
                break;
            }
 
            // move to the next node
            curr = curr.next;
        }
 
        // add a new node at the end of linked list if there is any carry left
        if (carry > 0) {
            curr.next = new Node(carry);
        }
 
        // reverse the list again to restore the original order
        head = reverse(head);
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(3);
 
        int digit = 7;
 
        printList(" Original Linked List: ", head);
        head = addDigit(head, digit);
        printList("Resultant Linked List: ", head);
    }
}





class AddASingleDigitNumberToALinkedListRepresentingANumberA2
{
    // Helper function to push a new node at the beginning of the linked list
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;

        head = node;
        return head;
    }

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

    // Recursive function to add a given digit to the linked list representing
    // a number.
    public static int add(Node head, int digit)
    {
        // base case: end of the linked list is reached
        if (head == null) {
            return digit;
        }

        // store carry returned by the recursive call of the next node
        int carry = add(head.next, digit);

        // optimization: terminate the recursion if carry is 0 at any point
        if (carry == 0) {
            return 0;
        }

        // get sum of the current node and the carry
        int sum = head.data + carry;

        head.data = sum % 10;    // update value of the current node
        return sum/10;            // return carry
    }

    // Function to add a single-digit number to a singly linked list
    // whose nodes represents digits of a number
    public static Node addDigit(Node head, int digit)
    {
        // Add given digit to the linked list using recursion
        int carry = add(head, digit);

        // if there is any carry left, add a new node at the beginning of the list
        if (carry > 0) {
            head = push(head, carry);
        }

        return head;
    }

    public static void main(String[] args)
    {
        int[] number = { 9, 9, 9, 9, 3 };

        Node head = null;
        for (int i = number.length - 1; i >= 0; i--) {
            head = push(head, number[i]);
        }

        int digit = 7;

        printList(" Original Linked List: ", head);
        head = addDigit(head, digit);
        printList("Resultant Linked List: ", head);
    }
}

