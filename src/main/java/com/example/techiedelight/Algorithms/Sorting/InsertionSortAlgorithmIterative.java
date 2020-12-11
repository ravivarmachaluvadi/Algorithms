package com.example.techiedelight.Algorithms.Sorting;

import java.util.Arrays;
 
class InsertionSortAlgorithmIterative
{
    // Function to perform insertion sort on arr[]
    public static void insertionSort(int[] arr)
    {
        // Start from the second element
        // (element at index 0 is already sorted)
        for (int i = 1; i < arr.length; i++)
        {
            int value = arr[i];
            int j = i;
 
            // Find the index j within the sorted subset arr[0..i-1]
            // where element arr[i] belongs
            while (j > 0 && arr[j - 1] > value)
            {
                arr[j] = arr[j - 1];
                j--;
            }
 
            // Note that sub-array arr[j..i-1] is shifted to
            // the right by one position i.e. arr[j+1..i]
 
            arr[j] = value;
        }
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 3, 8, 5, 4, 1, 9, -2 };
 
        insertionSort(arr);
 
        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}




class InsertionSortAlgorithmRecursive
{
    // Recursive function to perform insertion sort on sub-array arr[i..n]
    public static void insertionSort(int[] arr, int i, int n)
    {
        int value = arr[i];
        int j = i;

        // Find index j within the sorted subset arr[0..i-1]
        // where element arr[i] belongs
        while (j > 0 && arr[j - 1] > value)
        {
            arr[j] = arr[j - 1];
            j--;
        }

        arr[j] = value;

        // Note that subarray arr[j..i-1] is shifted to
        // the right by one position i.e. arr[j+1..i]

        if (i + 1 <= n) {
            insertionSort(arr, i + 1, n);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 3, 8, 5, 4, 1, 9, -2 };

        // Start from second element (element at index 0
        // is already sorted)
        insertionSort(arr, 1, arr.length - 1);

        // print the sorted array
        System.out.println(Arrays.toString(arr));
    }
}