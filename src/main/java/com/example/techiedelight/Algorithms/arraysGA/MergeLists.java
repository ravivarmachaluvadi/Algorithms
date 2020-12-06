package com.example.techiedelight.Algorithms.arraysGA;

import java.util.PriorityQueue;

//Merge M sorted lists each containing N elements
class MergeLists
{
    // Function to merge M sorted lists each of size N and
    // print them in ascending order
    public static void printSorted(int[][] list)
    {
        // create an empty min-heap
        PriorityQueue<Node> pq = new PriorityQueue();
 
        // push first element of each list into the min-heap
        // along with list number and their index in the list
        for (int i = 0; i < list.length; i++) {
            pq.add(new Node(list[i][0], i, 0));
        }
 
        // run till min-heap is empty
        while (!pq.isEmpty())
        {
            // extract minimum node from the min-heap
            Node min = pq.poll();
 
            // print the minimum element
            System.out.print(min.getValue() + " ");
 
            // take next element from "same" list and
            // insert it into the min-heap
            if (min.getIndex() + 1 < list[0].length)
            {
                min.setIndex(min.getIndex() + 1);
                min.setValue(list[min.getListNum()][min.getIndex()]);
                pq.add(min);
            }
        }
    }
 
    public static void main(String[] args)
    {
        int[][] list =
        {
            { 10, 20, 30, 40 },
            { 15, 25, 35, 45 },
            { 27, 29, 37, 48 },
            { 32, 33, 39, 50 },
            { 16, 18, 22, 28 }
        };
 
        printSorted(list);
    }
}