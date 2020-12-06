package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//Approach 1: Sorting

//Approach 2: Using Min Heap
class FindKThLargestElementInAnArray
{
    // Function to find the K'th largest element in the
    // array using min-heap
    public static int FindKthLargest(List<Integer> ints, int k)
    {
        // create a min-heap using PriorityQueue class and insert
        // first k elements of the array into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(ints.subList(0, k));
 
        // do for remaining array elements
        for (int i = k; i < ints.size(); i++)
        {
            // if current element is more than the root of the heap
            if (ints.get(i) > pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(ints.get(i));
            }
        }
 
        // return the root of min-heap
        return pq.peek();
    }
 
 
    public static void main(String[] args)
    {
        List<Integer> ints  = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;
 
        System.out.println("K'th largest element in the array is " +
                FindKthLargest(ints, k));
    }
}


//Approach 3: Using Max Heap
class FindKThLargestElementInAnArrayA3
{
    // Function to find the K'th largest element in the
    // array using max-heap
    public static int FindKthLargest(List<Integer> ints, int k)
    {
        // create a max-heap using PriorityQueue class from all
        // elements in the list
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // or pass Comparator.reverseOrder()
        pq.addAll(ints);

        // pop from max-heap exactly (k-1) times
        while (--k > 0) {
            pq.poll();
        }

        // return the root of max-heap
        return pq.peek();
    }


    public static void main(String[] args)
    {
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;

        System.out.println("K'th largest element in the array is " +
                FindKthLargest(ints, k));
    }
}


//Approach 4: Using std::nth_element

/*
#include <algorithm>
#include <iostream>
#include <vector>

int main()
        {
        std::vector<int> a = { 7, 4, 6, 3, 9, 1 };
        const std::size_t k = 2;

        std::nth_element(a.begin(), a.begin() + k, a.end(), std::greater<int>());
        std::cout << "K'th largest element in the array is " << a[k - 1];

        return 0;
        }*/
