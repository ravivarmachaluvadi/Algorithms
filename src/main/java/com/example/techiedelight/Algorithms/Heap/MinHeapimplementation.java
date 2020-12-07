package com.example.techiedelight.Algorithms.Heap;

import java.util.Arrays;

class MinHeapimplementation
{
    // Program for Max Heap Implementation in Java
    public static void main (String[] args)
    {
        // create a Priority Queue of initial capacity 10
        // Priority of an element is decided by element's value
        PriorityQueue pq = new PriorityQueue(10);

        // insert three integers
        pq.add(3);
        pq.add(2);
        pq.add(15);

        // print Priority Queue size
        System.out.println("Priority Queue Size is " + pq.size());

        // search 2 in Priority Queue
        Integer searchKey = 2;

        if (pq.contains(searchKey)) {
            System.out.println("Priority Queue contains " + searchKey + "\n");
        }

        // empty queue
        pq.clear();

        if (pq.isEmpty()) {
            System.out.println("Queue is Empty");
        }

        System.out.println("\nCalling remove operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.poll() + '\n');

        System.out.println("Calling peek operation on an empty heap");
        System.out.println("Element with highest priority is " + pq.peek() + '\n');

        // again insert three integers
        pq.add(5);
        pq.add(4);
        pq.add(45);

        // construct array containing all elements present in the queue
        Integer[] I = pq.toArray();
        System.out.println("Printing array: " + Arrays.toString(I));

        System.out.println("\nElement with highest priority is " + pq.poll());
        System.out.println("Element with highest priority is " + pq.peek());
    }
}