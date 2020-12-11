package com.example.techiedelight.Algorithms.LinkedList;

class FlattenALinkedList
{
    // Helper function to insert new node in the beginning of the vertical linked list
    public static Node push(Node head, int data)
    {
        Node newNode = new Node();
 
        newNode.data = data;
        newNode.next = null;
        newNode.down = head;
 
        return newNode;
    }
 
    // Takes two lists sorted in increasing order, and merge their nodes
    // together to make one big sorted list which is returned
    public static Node SortedMerge(Node a, Node b)
    {
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }
 
        Node result;
 
        // Pick either a or b, and recur
        if (a.data <= b.data)
        {
            result = a;
            result.down = SortedMerge(a.down, b);
        }
        else
        {
            result = b;
            result.down = SortedMerge(a, b.down);
        }
 
        return result;
    }
 
    /*
        Split the nodes of the given list into front and back halves.
        If the length is odd, the extra node should go in the front list.
        It uses the fast/slow reference strategy
    */
 
    public static Node[] FrontBackSplit(Node source)
    {
        // if length is less than 2, handle separately
        if (source == null || source.down == null) {
            return new Node[]{ source, null } ;
        }
 
        Node slow = source;
        Node fast = source.down;
 
        // Advance 'fast' two nodes, and advance 'slow' one node
        while (fast != null)
        {
            fast = fast.down;
            if (fast != null)
            {
                slow = slow.down;
                fast = fast.down;
            }
        }
 
        // 'slow' is before the midpoint in the list, so split it in two
        // at that point.
        Node[] arr = new Node[]{ source, slow.down };
        slow.down = null;
 
        return arr;
    }
 
    // Sort given linked list using Merge sort algorithm
    public static Node MergeSort(Node head)
    {
        // Base case -- length 0 or 1
        if (head == null || head.down == null) {
            return head;
        }
 
        // Split head into 'a' and 'b' sublists
        Node[] arr = FrontBackSplit(head);
        Node front = arr[0];
        Node back = arr[1];
 
        // Recursively sort the sublists
        front = MergeSort(front);
        back = MergeSort(back);
 
        // answer = merge the two sorted lists together
        return SortedMerge(front, back);
    }
 
    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.down;
        }
 
        System.out.println("null");
    }
 
    // Iterative function to flatten and sort a given list
    public static void flatten (Node head)
    {
        Node curr = head;
 
        while (curr != null)
        {
            Node temp = curr;
            while (temp.down != null) {
                temp = temp.down;
            }
            temp.down = curr.next;
            curr = curr.next;
        }
    }
 
    // Helper function to create a linked list with elements of given vector
    public static Node createVerticalList(Node head, int[] arr)
    {
        for (int key: arr) {
            head = push(head, key);
        }
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = null;
 
        int[] arr1 = { 8, 6, 4, 1 };
        int[] arr2 = { 7, 3, 2 };
        int[] arr3 = { 9, 5 };
        int[] arr4 = { 12, 11, 10 };
 
        head = createVerticalList(head, arr1);
        head.next = createVerticalList(head.next, arr2);
        head.next.next = createVerticalList(head.next.next, arr3);
        head.next.next.next = createVerticalList(head.next.next.next, arr4);
 
        // flatten the list
        flatten(head);
 
        //sort the list
        MergeSort(head);
 
        // print the flattened & sorted linked list
        printList(head);
    }
}




//
class FlattenALinkedListA2
{
    // Helper function to insert new node in the beginning of the vertical linked list
    public static Node push(Node head, int data)
    {
        Node newNode = new Node();

        newNode.data = data;
        newNode.next = null;
        newNode.down = head;

        return newNode;
    }

    // Takes two lists sorted in increasing order, and merge their nodes
    // together to make one big sorted list which is returned
    public static Node SortedMerge(Node a, Node b)
    {
        // Base cases
        if (a == null) {
            return b;
        }
        else if (b == null) {
            return a;
        }

        Node result;

        // Pick either a or b, and recur
        if (a.data <= b.data)
        {
            result = a;
            result.down = SortedMerge(a.down, b);
        }
        else
        {
            result = b;
            result.down = SortedMerge(a, b.down);
        }

        return result;
    }

    // Helper function to print given linked list
    public static void printList(Node head)
    {
        Node ptr = head;
        while (ptr != null)
        {
            System.out.print(ptr.data + " -> ");
            ptr = ptr.down;
        }

        System.out.println("null");
    }

    // Recursive function to flatten and sort a given list
    public static Node flatten(Node head)
    {
        // base case: an empty list
        if (head == null) {
            return head;
        }

        // Merge this list with the list on right side
        Node sorted = SortedMerge(head, flatten(head.next));

        // set next link to null after flattening
        head.next = null;

        return sorted;
    }

    // Helper function to create a linked list with elements of given vector
    public static Node createVerticalList(Node head, int[] arr)
    {
        for (int key: arr) {
            head = push(head, key);
        }
        return head;
    }

    public static void main(String[] args)
    {
        Node head = null;

        int[] arr1 = { 8, 6, 4, 1 };
        int[] arr2 = { 7, 3, 2 };
        int[] arr3 = { 9, 5 };
        int[] arr4 = { 12, 11, 10 };

        head = createVerticalList(head, arr1);
        head.next = createVerticalList(head.next, arr2);
        head.next.next = createVerticalList(head.next.next, arr3);
        head.next.next.next = createVerticalList(head.next.next.next, arr4);

        // flatten and sort the list
        flatten(head);

        // print the flattened & sorted linked list
        printList(head);
    }
}