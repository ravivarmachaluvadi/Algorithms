package com.example.techiedelight.Algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/*
Find majority element (Boyer–Moore Majority Vote Algorithm)
Given an array of integers containing duplicates, return the majority element in an array if present. A majority element
appears more than n/2 times where n is the size of the array.
For example, the majority element is 2 in the array {2, 8, 7, 2, 2, 5, 2, 3, 1, 2, 2}

Naive solution would be to count frequency of each element present in the first half of the array to check if it is
majority element or not. Below is the naive implementation –
*/


/*

int majorityElementNaive(int A[], int n)
        {
        // check if A[i] is majority element or not
        for (int i = 0; i <= n/2; i++)
        {
        int count = 1;
        for (int j = i + 1; j < n; j++) {
        if (A[j] == A[i]) {
        count++;
        }
        }

        if (count > n/2) {
        return A[i];
        }
        }

        return -1;
        }

        The time complexity of above solution is O(n2).


        We can improve worst case time complexity to O(nlog(n)) by sorting the array and then perform binary search for first and last occurrence of each element. If difference between first and last occurrence is more than n/2, we have found majority element.

*/




class FindMajorityElement
{
    // Function to return majority element present in given array
    public static int majorityElement(int[] A)
    {
        // create an empty Hash Map
        Map<Integer, Integer> map = new HashMap<>();
 
        // store each element's frequency in a map
        for (int i: A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
 
        // return the element if its count is more than n/2
        for (Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if (entry.getValue() > A.length/2) {
                return entry.getKey();
            }
        }
 
        // no majority element is present
        return -1;
    }
 
    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };
 
        int res = majorityElement(arr);
        if (res != -1) {
            System.out.println("Majority element is " + res);
        } else {
            System.out.println("Majority element does not exist");
        }
    }
}


//Boyer–Moore majority vote algorithm
class BoyerMooreMajorityVoteAlgorithm
        {
    // Function to return majority element present in given array
    public static int majorityElement(int[] A)
    {
        // m stores majority element if present
        int m = -1;

        // initialize counter i with 0
        int i = 0;

        // do for each element A[j] of the array
        for (int j = 0; j < A.length; j++)
        {
            // if the counter i becomes 0
            if (i == 0)
            {
                // set the current candidate to A[j]
                m = A[j];

                // reset the counter to 1
                i = 1;
            }

            // else increment the counter if A[j] is current candidate
            else if (m == A[j]) {
                i++;
            }
            // else decrement the counter if A[j] is not current candidate
            else {
                i--;
            }
        }

        return m;
    }

    public static void main (String[] args)
    {
        // Assumption - valid input (majority element is present)
        int[] arr = { 1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2 };

        System.out.println("Majority element is " + majorityElement(arr));
    }
}


