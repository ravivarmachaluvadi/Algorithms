package com.example.techiedelight.Algorithms.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
Find Equilibrium Index of an Array
Given an array of integers, find equilibrium index in it.

For an array A consisting n elements, index i is an equilibrium index if sum of elements of sub-array A[0..i-1]
is equal to the sum of elements of sub-array A[i+1..n-1] i.e.

(A[0] + A[1] + ... + A[i-1]) = (A[i+1] + A[i+2] + ... + A[n-1])   where 0 < i < n-1
Similarly, 0 is an equilibrium index if (A[1] + A[2] + ... + A[n-1]) = 0 and n-1 is an equilibrium index if (A[0] + A[1] + ... + A[n-2]) = 0
For example, consider the array {0, -3, 5, -4, -2, 3, 1, 0}. The equilibrium index found at index 0, 3 and 7.
*/

//TC - O(N) , SC - O(N)
class FindEquilibriumIndexOfAnArray
{
    // Function to find equilibrium index of an array
    public static void equilibriumIndex(int A[])
    {
        // left[i] stores sum of elements of sub-array A[0..i-1]
        int left[] = new int[A.length];
 
        left[0] = 0;
 
        // traverse array from left to right
        for (int i = 1; i < A.length; i++) {
            left[i] = left[i - 1] + A[i - 1];
        }
 
        // right stores sum of elements of sub-array A[i+1..n)
        int right = 0;
 
        // maintain list of indices
        List<Integer> indices = new ArrayList<>();
 
        // traverse array from right to left
        for (int i = A.length - 1; i >= 0; i--)
        {
            /* if sum of elements of sub-array A[0..i-1] is equal to
               the sum of elements of sub-array A[i+1..n) i.e.
               (A[0] + .. + A[i-1]) = (A[i+1] + A[i+2] + .. + A[n-1]) */
 
            if (left[i] == right) {
                indices.add(i);
            }
 
            // new right = A[i] + (A[i+1] + A[i+2] + .. + A[n-1])
            right += A[i];
        }
 
        System.out.println("Equilibrium Index found at " + indices);
    }
 
    // Program to find the equilibrium index of an array
    public static void main (String[] args)
    {
        int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };
        equilibriumIndex(A);
    }
}

//The time complexity of above solution is O(n) and auxiliary space used by the program is O(n).


//TC - O(N) , SC - O(1)
class FindEquilibriumIndexOfAnArrayOpti
{
    // Optimized method to find equilibrium index of an array
    public static void equilibriumIndex(int[] A)
    {
        // total stores sum of all elements of the array
        int total = IntStream.of(A).sum();

        // right stores sum of elements of sub-array A[i+1..n)
        int right = 0;

        // maintain list of indices
        List<Integer> indices = new ArrayList<>();

        // traverse array from right to left
        for (int i = A.length - 1; i >= 0; i--)
        {
            /* i is equilibrium index if sum of elements of sub-array
                A[0..i-1] is equal to the sum of elements of sub-array
                A[i+1..n) i.e. (A[0] + A[1] + .. + A[i-1]) =
                (A[i+1] + A[i+2] + .. + A[n-1]) */

            // sum of elements of left sub-array A[0..i-1] is
            // (total - (A[i] + right))
            if (right == total - (A[i] + right)) {
                indices.add(i);
            }

            // new right = A[i] + (A[i+1] + A[i+2] + .. + A[n-1])
            right += A[i];
        }

        System.out.println("Equilibrium Index found at " + indices);
    }

    // Program to find the equilibrium index of an array
    public static void main (String[] args)
    {
        int[] A = { 0, -3, 5, -4, -2, 3, 1, 0 };

        equilibriumIndex(A);
    }
}
