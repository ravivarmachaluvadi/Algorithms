package com.example.techiedelight.Algorithms.LinkedList;

import java.util.HashSet;
import java.util.Set;

//Using Hashing –
class DetectCycleInALinkedListFloydSCycleDetectionAlgorithm
{
    // Function to detect Cycle in a linked list using Hashing
    public static boolean detectCycle(Node head)
    {
        Node curr = head;
        Set<Node> set = new HashSet();
 
        // traverse the list
        while (curr != null)
        {
            // return false if we already have seen this node before
            if (set.contains(curr)) {
                return true;
            }
 
            // insert current node into the set
            set.add(curr);
 
            // move to the next node
            curr = curr.next;
        }
 
        // we reach here if list does not contain any cycle
        return false;
    }
 
    // Detect Cycle in a linked list
    public static void main(String[] args)
    {
        // input keys
        int[] keys = {1, 2, 3, 4, 5};
 
        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--)
            head = new Node(keys[i], head);
 
        // insert cycle
        head.next.next.next.next.next = head.next.next;
 
        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}




//Floyd’s Cycle Detection Algorithm –
class DetectCycleInALinkedListFloydSCycleDetectionAlgorithmA2
{
    // Function to detect Cycle in a linked list using
    // Floyd’s Cycle Detection Algorithm
    public static boolean detectCycle(Node head)
    {
        // take two references - slow and fast
        Node slow = head, fast = head;

        while (fast != null && fast.next != null)
        {
            // move slow by one
            slow = slow.next;

            // move fast by two
            fast = fast.next.next;

            // if they meet any node, linked list contains a cycle
            if (slow == fast) {
                return true;
            }
        }

        // we reach here if slow & fast do not meet
        return false;
    }

    // Detect Cycle in a linked list using Floyd’s Cycle Detection Algorithm
    public static void main(String[] args)
    {
        // input keys
        int[] keys = { 1, 2, 3, 4, 5 };

        Node head = null;
        for (int i = keys.length - 1; i >= 0; i--) {
            head = new Node(keys[i], head);
        }

        // insert cycle
        head.next.next.next.next.next = head.next.next;

        if (detectCycle(head)) {
            System.out.println("Cycle Found");
        } else {
            System.out.println("No Cycle Found");
        }
    }
}
