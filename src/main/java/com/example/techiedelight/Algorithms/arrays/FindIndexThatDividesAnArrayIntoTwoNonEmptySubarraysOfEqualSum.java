package com.example.techiedelight.Algorithms.arrays;

import java.util.stream.IntStream;
 
class FindIndexThatDividesAnArrayIntoTwoNonEmptySubarraysOfEqualSum
{
    // Function to find index i in the array such that sum of left
    // sub-array of A[i] is equal to sum of its right sub-array
    public static void findBreakPoint(int[] A)
    {
        // calculate sum of all elements present in the array
        int total = IntStream.of(A).sum();
 
        // stores sum of left sub-array
        int left_sum = A[0];
 
        // start from index 1 to find non-empty sub-arrays
        for (int i = 1; i < A.length - 1; i++)
        {
            // if sum of A[0..i-1] is equal to A[i+1, n-1]
            if (left_sum == total - (A[i] + left_sum)) {
                System.out.println("Index is " + i);
            }
 
            // update left sub-array sum
            left_sum += A[i];
        }
    }
 
    public static void main(String[] args)
    {
        int[] A = { -1, 6, 3, 1, -2, 3, 3 };
 
        // divide array into two non-empty sub-arrays of equal sum
        findBreakPoint(A);
    }
}