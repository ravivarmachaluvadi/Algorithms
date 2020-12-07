package com.example.techiedelight.Algorithms.BST;

import java.util.ArrayList;
import java.util.List;

// Tuple class
class Tuple<X,Y,Z>
{
    public final X first;        // first field of a Tuple
    public final Y second;         // second field of a Tuple
    public final Z third;         // third field of a Tuple

    // Constructs a new Tuple with specified values
    private Tuple(X first, Y second, Z third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    // Factory method for creating a Typed Tuple immutable instance
    public static <X,Y,Z> Tuple <X,Y,Z> of(X a, Y b, Z c)
    {
        // calls private constructor
        return new Tuple<>(a, b, c);
    }
}
 
class FindATripletWithGivenSumInABST
{
    // Function to insert a given key at its correct position in BST
    public static Node insert(Node root, int data)
    {
        if (root == null) {
            return new Node(data);
        }
 
        if (data < root.data) {
            root.left = insert(root.left, data);
        }
        else {
            root.right = insert(root.right, data);
        }
 
        return root;
    }
 
    // Function to find a triplet in a List with given sum
    // If a triplet is found, the function stores it in the tuple and returns true
    public static Tuple findTriplet(List<Integer> arr, int sum)
    {
        // get number of nodes in the BST
        int n = arr.size()
                ;
 
        // check if triplet is formed by arr[i] and a pair from arr[i+1..n-1]
        for (int i = 0; i <= n - 3; i++)
        {
            // remaining sum
            int k = sum - arr.get(i);
 
            // maintain two indices pointing to end-points of the arr[i+1..n-1]
            int low = i + 1, high = n - 1;
 
            // loop till low is less than high
            while (low < high)
            {
                // increment low index if total is less than the remaining sum
                if (arr.get(low) + arr.get(high) < k) {
                    low++;
                }
 
                // decrement high index is total is more than the remaining sum
                else if (arr.get(low) + arr.get(high) > k) {
                    high--;
                }
 
                // triplet with given sum found
                else {
                    // create a tuple of the found triplet and return it
                    return Tuple.of(arr.get(i), arr.get(low), arr.get(high));
                }
            }
        }
 
        // no triplet found
        return null;
    }
 
    // Recursive function to push keys of a given BST in a List in inorder fashion
    public static void pushTreeNodes(Node root, List<Integer> keys)
    {
        // base case
        if (root == null) {
            return;
        }
 
        pushTreeNodes(root.left, keys);
        keys.add(root.data);
        pushTreeNodes(root.right, keys);
    }
 
    // Function to print a triplet with given sum in the given BST
    public static void printTriplet(Node root, int sum)
    {
        /* 1. Push keys of a given BST in a List in sorted order */
        List<Integer> keys = new ArrayList<>();
        pushTreeNodes(root, keys);
 
        /* 2: Find a triplet with given sum in the List */
 
        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(keys, sum);
 
        // find the triplet
        if (triplet != null)
        {
            System.out.print("Triplet found: ("
                                    + triplet.first + ", "
                                    + triplet.second + ", "
                                    + triplet.third + ")");
        }
        else {
            System.out.print("Triplet not found");
        }
    }
 
    public static void main(String[] args)
    {
        // input keys to construct a BST
        int[] keys = { 10, -15, 3, -40, 20, 15, 50 };
 
        // construct a BST from keys[]
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }
 
        // triplet sum
        int sum = 20;
 
        // print a triplet with given sum
        printTriplet(root, sum);
    }
}




class Nodes {
    Node head, tail;
    Nodes() {}
}

class FindATripletWithGivenSumInABSTA2
{
    // Function to insert a given key at its correct position in BST
    public static Node insert(Node root, int data)
    {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Function to insert a BST node at the front of a doubly linked list
    public static void push(Node node, Nodes nodes)
    {
        // update the right pointer of the given node to point to the current head
        node.right = nodes.head;

        // update the left pointer of the existing head node of the doubly linked list
        // to point to the new node
        if (nodes.head != null) {
            nodes.head.left = node;
        }

        // update the tail pointer of doubly linked list (updated only for the first node)
        if (nodes.tail == null) {
            nodes.tail = node;
        }

        // finally update and return the head pointer of doubly linked list
        nodes.head = node;
    }

    /*
    Recursive function to construct a sorted doubly linked list from a given BST
    */
    public static void convertBSTtoDLL(Node root, Nodes nodes)
    {
        // Base case
        if (root == null) {
            return;
        }

        // recursively convert the right subtree
        convertBSTtoDLL(root.right, nodes);

        // push current node at the front of the doubly linked list
        push(root, nodes);

        // recursively convert the left subtree
        convertBSTtoDLL(root.left, nodes);
    }

    // Returns true if a triplet with given sum is found in the given BST
    public static Tuple findTriplet(Node root, int sum)
    {
        /* 1. Convert the given BST into a sorted DLL */

        Nodes nodes = new Nodes();
        convertBSTtoDLL(root, nodes);
        Node head = nodes.head;
        Node tail= nodes.tail;

        /* 2: Find triplet with given sum in DLL */

        // loop till only 2 nodes are left
        while (head!= null && head.right != tail)
        {
            // Assuming current head node is part of the triplet, find other two nodes
            // of the triplet in search space [head.right, tail]

            // maintain two pointers pointing to end-points of the search space
            Node start = head.right;
            Node end = tail;

            // calculate the remaining sum
            int pairSum = sum - head.data;

            // reduce the search space [start, end] at each iteration of the loop
            while (start != end)
            {
                // get sum of the current start and end nodes
                int currSum = start.data + end.data;

                // if pair with desired sum is found in the BST
                if (currSum == pairSum)
                {
                    // create a tuple from the triplet and return true
                    return Tuple.of(head.data, start.data, end.data);
                }

                // if current sum is more than the desired sum, move left in the list
                else if (currSum > pairSum) {
                    end = end.left;
                }

                // if current sum is less than the desired sum, move right in the list
                else {
                    start = start.right;
                }
            }

            // move to the next node
            head = head.right;
        }

        // no triplet found
        return null;
    }

    public static void main(String[] args)
    {
        // input keys to construct a BST
        int[] keys = { 10, -15, 3, -40, 20, 15, 50 };

        // construct a BST from keys[]
        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        // triplet sum
        int sum = 20;

        // create a tuple to store the triplet
        Tuple<Integer, Integer, Integer> triplet = findTriplet(root, sum);

        // find the triplet
        if (triplet != null)
        {
            System.out.print("Triplet found: (" + triplet.first + ", " +
                    triplet.second + ", "  + triplet.third + ")");
        }
        else {
            System.out.print("Triplet not found");
        }
    }
}