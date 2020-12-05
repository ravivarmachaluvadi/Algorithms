package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class ReverseEveryConsecutiveMElementsOfTheGivenSubarray
{
    // Utility function to swap two elements A[i] and A[j] in the array
    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
 
    // Utility function to reverse sub-array arr[i, j]
    public static int[] reverse (int[] A, int i, int j)
    {
        if (i >= j) {
            return A;
        }
 
        // else swap two elements
        swap(A, i, j);
 
        // recur for next pair
        return reverse(A, i + 1, j - 1);
    }
 
    // Function to reverse every consecutive m elements of
    // the sub-array arr[beg, end]
    public static void reverse(int[] A, int beg, int end, int m)
    {
        // return if sub-array length is less than m
        if (m > end - beg + 1) {
            return;
        }
 
        // reverse every consecutive m elements
        for (int i = beg; i <= end; i = i + m) {
            // check if sub-array length is atleast m
            if (i + m - 1 <= end) {
                reverse(A, i, i + m - 1);
            }
        }
    }
 
    public static void main (String[] args)
    {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int m = 3;
        int beg = 1, end = 8;
 
        // reverse the array
        reverse(A, beg, Math.min(end, A.length - 1), m);
 
        // print the modified array
        System.out.println(Arrays.toString(A));
    }
}