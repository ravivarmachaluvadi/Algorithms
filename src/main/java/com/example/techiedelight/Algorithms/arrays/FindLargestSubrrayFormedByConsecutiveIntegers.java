package com.example.techiedelight.Algorithms.arrays;

/*
Find largest sub-array formed by consecutive integers
Given an array of integers, find largest sub-array formed by consecutive integers. The sub-array should contain all distinct values.
*/

class FindLargestSubrrayFormedByConsecutiveIntegers
{
    // Function to check if sub-array A[i..j] is formed by consecutive
    // integers. Here min and max denotes the minimum and maximum element
    // in the sub-array respectively
    private static boolean isConsecutive(int[] A, int i, int j, int min, int max)
    {
        // in order for an array to contain consecutive integers, the diff
        // between maximum and element element in it should be exactly j-i
        if (max - min != j - i) {
            return false;
        }
 
        // create a visited array (we can also use a set)
        boolean visited[] = new boolean[j - i + 1];
 
        // traverse the sub-array and checks if each element appears
        // only once
        for (int k = i; k <= j; k++)
        {
            // if element is seen before, return false
            if (visited[A[k] - min]) {
                return false;
            }
 
            // mark element as seen
            visited[A[k] - min] = true;
        }
 
        // we reach here when all elements in array are distinct
        return true;
    }
 
    // Find largest sub-array formed by consecutive integers
    public static void findMaxSubArray(int[] A)
    {
        int len = 1;
        int start = 0, end = 0;
 
        // consider each sub-array formed by A[i..j]
 
        // i denotes the beginning of sub-array
        for (int i = 0; i < A.length - 1; i++)
        {
            // stores minimum and maximum element in a sub-array A[i..j]
            int min_val = A[i], max_val = A[i];
 
            // j denotes the end of sub-array
            for (int j = i + 1; j < A.length; j++)
            {
                // update minimum and maximum element of the sub-array
                min_val = Math.min(min_val, A[j]);
                max_val = Math.max(max_val, A[j]);
 
                // check if A[i..j] is formed by consecutive integers
                if (isConsecutive(A, i, j, min_val, max_val))
                {
                    if (len < max_val - min_val + 1)
                    {
                        len = max_val - min_val + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
 
        // print maximum length sub-array
        System.out.println("The largest sub-array is [" + start + ", " + end + "]");
    }
 
    public static void main (String[] args)
    {
        int[] A = { 2, 0, 2, 1, 4, 3, 1, 0 };
 
        findMaxSubArray(A);
    }
}