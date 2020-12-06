package com.example.techiedelight.Algorithms.arraysGA;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//FindSmallestRangeWithAt-LeastOneElementFromEachOfTheGivenLists
class MinimumRange
{
    // Function to compute the minimum range that includes
    // at-least one element from given M lists
    public static Pair5 findMinimumRange(List<List<Integer>> list)
    {
        // high will be maximum element in the heap
        int high = Integer.MIN_VALUE;
 
        // stores minimum and maximum element found so far in heap
        Pair5<Integer, Integer> p = new Pair5(0, Integer.MAX_VALUE);
 
        // create an empty min-heap
        PriorityQueue<Node> pq = new PriorityQueue<>();
 
        // push first element of each list into the min-heap
        // along with list number and their index in the list
        for (int i = 0; i < list.size(); i++)
        {
            pq.add(new Node(list.get(i).get(0), i, 0));
            high = Integer.max(high, list.get(i).get(0));
        }
 
        // run till end of any list is reached
        while (true)
        {
            // remove root node
            Node top = pq.poll();
 
            // retrieve root node information from the min-heap
            int low = top.getValue();
            int i = top.getListNum();
            int j = top.getIndex();
 
            // update low, high if new min is found
            if (high - low < p.getSecond() - p.getFirst()) {
                p = new Pair5(low, high);
            }
 
            // return on reaching the end of any list
            if (j == list.get(i).size() - 1) {
                return p;
            }
 
            // take next element from "same" list and
            // insert it into the min-heap
            pq.add(new Node(list.get(i).get(j + 1), i, j + 1));
 
            // update high if new element is greater
            high = Integer.max(high, list.get(i).get(j + 1));
        }
    }
 
    public static void main(String[] args)
    {
        List<List<Integer>> list = Arrays.asList(
                                        Arrays.asList(3, 6, 8, 10, 15),
                                        Arrays.asList(1, 5, 12),
                                        Arrays.asList(4, 8, 15, 16),
                                        Arrays.asList(2, 6)
                                    );

        Pair5<Integer, Integer> p = findMinimumRange(list);
        System.out.println("Minimum range is " + p.getFirst() +
                                   "-" + p.getSecond());
    }
}

// A simple Pair class in Java
class Pair5<U,V> {
    private final U first;
    private final V second;

    Pair5(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}