package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;

//Move all zeros present in an array to the end
//Given an array of integers, move all zeros present in the array to the end. The solution should maintain the relative order of items in the array.

//TC - O(N) , SC - O(1)
class MoveAllZerosPresentInAnArrayToTheEnd
{
    // Function to move all zeros present in the array to the end
    public static void reorder(int[] A)
    {
        // k stores index of next available position
        int k = 0;
 
        // do for each element
        for (int i: A)
        {
            // if current element is non-zero, put the element at
            // next free position in the array
            if (i != 0) {
                A[k++] = i;
            }
        }
 
        // move all 0's to the end of the array (remaining indices)
        for (int i = k; i < A.length; i++) {
            A[i] = 0;
        }
    }
 
    // Move all zeros present in the array to the end
    public static void main(String[] args)
    {
        int[] A = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };
 
        reorder(A);
        System.out.println(Arrays.toString(A));
    }
}


//TC - O(N) , SC - O(1)
class MoveAllZerosPresentInAnArrayToTheEndUsingQuickSort
{
    public static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Function to move all zeros present in the array to the end
    public static void partition(int[] A)
    {
        int j = 0;

        // each time we encounter a non-zero, j is incremented and
        // the element is placed before the pivot
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != 0)    // pivot is 0
            {
                swap(A, i, j);
                j++;
            }
        }
    }

    // Move all zeros present in the array to the end
    public static void main(String[] args)
    {
        int[] A = { 6, 0, 8, 2, 3, 0, 4, 0, 1 };

        partition(A);
        System.out.println(Arrays.toString(A));
    }
}