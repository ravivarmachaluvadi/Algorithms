package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Approach 1 (Sorting)

//Approach 2 (Using Max Heap)
class FindKThSmallestElementInAnArray
{
    // Function to find the K'th smallest element in the
    // array using max-heap
    public static int findKthSmallest(List<Integer> A, int k)
    {
        // create a max-heap using PriorityQueue class and
        // insert first k elements of the array into the heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(A.subList(0, k));
 
        // do for remaining array elements
        for (int i = k; i < A.size(); i++)
        {
            // if current element is less than the root of the heap
            if (A.get(i) < pq.peek())
            {
                // replace root with the current element
                pq.poll();
                pq.add(A.get(i));
            }
        }
 
        // return the root of max-heap
        return pq.peek();
    }
 
    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
 
        System.out.println("K'th smallest element in the array is " +
                                   findKthSmallest(A, k));
    }
}


//Approach 3 (Using Min Heap)
class FindKThSmallestElementInAnArrayA1
{
    // Function to find the K'th smallest element in the
    // array using min-heap
    public static int findKthSmallest(List<Integer> A, int k)
    {
        // create an empty min-heap and initialize it with all input elements
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);

        // pop from min-heap exactly (k-1) times
        while (--k > 0) {
            pq.poll();
        }

        // return the root of min-heap
        return pq.peek();
    }

    public static void main(String[] args)
    {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;

        System.out.println("K'th smallest element in the array is " +
                findKthSmallest(A, k));
    }
}



//Approach 4 (Using std::nth_element)

/*
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Find K'th smallest element in an array
        int main()
        {
        vector<int> a = { 7, 4, 6, 3, 9, 1 };
        const size_t k = 3;

        nth_element(a.begin(), a.begin() + k - 1, a.end());

        cout << "K'th smallest element in the array is " << a[k - 1];

        return 0;
        }*/
