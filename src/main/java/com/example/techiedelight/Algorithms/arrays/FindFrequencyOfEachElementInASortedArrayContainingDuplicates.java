package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

//recursive
class FindFrequencyOfEachElementInASortedArrayContainingDuplicates
{
    // Function to find frequency of each element in a sorted array
    public static void findFrequency(int[] A, int left, int right,
                                    Map<Integer, Integer> freq)
    {
        if (left > right) {
            return;
        }
 
        // if every element in the sub-array A[left..right] is equal,
        // then increment the element count by n
        if (A[left] == A[right])
        {
            Integer count = freq.get(A[left]);
            if (count == null) {
                count = 0;
            }
 
            freq.put(A[left], count + (right - left + 1));
            return;
        }
 
        int mid = (left + right)/2;
 
        // divide array into left and right sub-array and recur
        findFrequency(A, left, mid, freq);
        findFrequency(A, mid + 1, right, freq);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9 };
 
        // find frequency of each element of the array and store it in map
        Map<Integer, Integer> freq = new HashMap<>();
        findFrequency(A, 0, A.length - 1, freq);
 
        System.out.println(freq);
    }
}



//Iterartive
class FindFrequencyOfEachElementInASortedArrayContainingDuplicatesA1
{
    // Function to find frequency of each element in a sorted array
    public static void findFrequency(int[] A, Map<Integer, Integer> freq)
    {
        // search space is A[left..right]
        int left = 0, right = A.length - 1;

        // run till search space is exhausted
        while (left <= right)
        {
            // A[left..right] consists of only one element,
            // then update its count
            if (A[left] == A[right])
            {
                freq.put(A[left], freq.getOrDefault(A[left], 0) + (right - left + 1));

                // Now discard A[left..right] and continue searching in
                // A[right+1.. n-1] for A[left]
                left = right + 1;
                right = A.length - 1;
            }
            else {
                // reduce the search space
                right = (left + right) / 2;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] A = { 2, 2, 2, 4, 4, 4, 5, 5, 6, 8, 8, 9};

        // map to store frequency of each element of the array
        Map<Integer, Integer> count = new HashMap<>();
        findFrequency(A, count);

        count.keySet().forEach(
                key -> System.out.println(key + " occurs " + count.get(key) + " times")
        );
    }
}