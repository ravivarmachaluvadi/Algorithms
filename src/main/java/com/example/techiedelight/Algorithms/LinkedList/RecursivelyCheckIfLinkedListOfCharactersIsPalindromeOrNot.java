package com.example.techiedelight.Algorithms.LinkedList;

class RecursivelyCheckIfLinkedListOfCharactersIsPalindromeOrNot
{
    // Construct String s1 and s2 out of given linked list with consecutive
    // elements of the list in forward and backward direction respectively
    public static void construct(Node head, StringBuilder s1, StringBuilder s2)
    {
        // Base case
        if (head == null) {
            return;
        }
 
        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(head.data);
    }
 
    // Function to check if a given linked list of characters is palindrome
    public static boolean isPalindrome(Node head)
    {
        // construct String s1 and s2 with consecutive elements of the linked list
        // starting from the beginning and the end respectively
 
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);
 
        // check if linked list is palindrome
        return s1.toString().equals(s2.toString());
    }
 
    public static void main(String[] args) {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');
 
        if (isPalindrome(head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        }
    }
}






class RecursivelyCheckIfLinkedListOfCharactersIsPalindromeOrNotA2
{
    // Wrapper over the Node class
    static class NodeWrapper {
        public Node node;

        NodeWrapper(Node node) {
            this.node = node;
        }
    }

    // Recursive function to check if a given linked list of characters is palindrome.
    public static boolean isPalindrome(NodeWrapper left, Node right)
    {
        // base case
        if (right == null) {
            return true;
        }

        // return false on first mismatch
        if (!isPalindrome(left, right.next)) {
            return false;
        }

        // copy left pointer
        Node prev_left = left.node;

        // advance the left pointer to the next node
        // this change would reflect in the parent recursive calls
        left.node = left.node.next;

        // In order for linked list to be palindrome, the character at the left
        // node should match with the character at the right node
        return (prev_left.data == right.data);
    }

    public static void main(String[] args)
    {
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        // Wrap left node so it's reference can be changed inside isPalindrome()
        NodeWrapper left = new NodeWrapper(head);

        if (isPalindrome(left, head)) {
            System.out.print("Linked List is a palindrome.");
        }
        else {
            System.out.print("Linked List is not a palindrome.");
        }
    }
}