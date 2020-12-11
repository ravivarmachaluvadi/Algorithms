package com.example.techiedelight.Algorithms.LinkedList;

class AddTwoLinkedListsWithoutUsingAnyExtraSpace
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
 
    // Iterate through the list and move/insert each node to the
    // front of the out list like a Push of the node
    public static Node reverse(Node head)
    {
        Node out = null;
        Node current = head;
 
        // traverse the list
        while (current != null)
        {
            // tricky: note the next node
            Node next = current.next;
 
            // move the current node onto the out
            current.next = out;
            out = current;
 
            // process next node
            current = next;
        }
 
        // fix head
        return out;
    }
 
    // Function to add two lists X and Y
    public static Node add(Node X, Node Y)
    {
        Node head = null;
 
        // stores last seen node
        Node prevNode = null;
 
        // initialize carry with 0
        int carry = 0;
 
        // run till both list are empty
        while (X != null || Y  != null)
        {
            // sum is X's data + Y's data + carry (if any)
            int sum = 0;
            if (X != null) {
                sum += X.data;
            }
            if (Y != null ) {
                sum += Y.data;
            }
            sum += carry;
 
            // if sum of 2-digit number, reduce it and update carry
            carry = sum / 10;
            sum = sum % 10;
 
            // create a new node with calculated sum
            Node node = new Node(sum, null);
 
            // if the output list is empty
            if (head == null)
            {
                // update prev and head to point to the new node
                prevNode = node;
                head = node;
            }
            else
            {
                // add new node to the output list
                prevNode.next = node;
 
                // update prev node to point to the new node
                prevNode = node;
            }
 
            // advance X and Y for next iteration of the loop
            if (X != null) {
                X = X.next;
            }
 
            if (Y != null) {
                Y = Y.next;
            }
        }
 
        if (carry != 0) {
            prevNode.next = new Node(carry, prevNode.next);
        }
 
        return head;
    }
 
    // Function to add two lists X and Y
    public static Node addLists(Node X, Node Y)
    {
        // reverse X and Y to access elements from the end
        X = reverse(X);
        Y = reverse(Y);
 
        return reverse(add(X, Y));
    }
 
    public static void main(String[] args)
    {
        int x = 5734;
        int y = 946;
 
        // construct list X (5 -> 7 -> 3 -> 4) from number x
        Node X = null;
        while (x != 0)
        {
            X = new Node(x % 10, X);
            x = x/10;
        }
 
        // construct list Y (9 -> 4 -> 6) from number y
        Node Y = null;
        while (y != 0)
        {
            Y = new Node(y % 10, Y);
            y = y/10;
        }
 
        printList(addLists(X, Y));
    }
}