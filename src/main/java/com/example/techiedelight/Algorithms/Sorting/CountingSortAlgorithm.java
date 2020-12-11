package com.example.techiedelight.Algorithms.Sorting;

import java.util.Arrays;
 
class CountingSortAlgorithm
{
    /*
        arr -- the input array of integers to be sorted
        k -- a number such that all integers are in the range 0..k-1
    */
    public static void countSort(int[] arr, int k)
    {
        // create an integer array of size n to store sorted array
        int[] output = new int[arr.length];
 
        // create an integer array of size k, initialized by all zero
        int[] freq = new int[k];
 
        // using value of integer in the input array as index,
        // store count of each integer in freq[] array
        for (int i: arr) {
            freq[i]++;
        }
 
        // calculate the starting index for each integer
        int total = 0;
        for (int i = 0; i < k; i++)
        {
            int oldCount = freq[i];
            freq[i] = total;
            total += oldCount;
        }
 
        // copy to output array, preserving order of inputs with equal keys
        for (int i: arr)
        {
            output[freq[i]] = i;
            freq[i]++;
        }
 
        // copy the output array back to the input array
        Arrays.setAll(arr, i -> output[i]);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };
 
        // range of array elements
        int k = 11;
 
        countSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}





class CountingSortAlgorithmA2
{
    /*
    arr -- the input array of integers to be sorted
    k -- a number such that all integers are in the range 0..k-1
    */
    public static void countSort(int[] arr, int k)
    {
        // create an integer array of size k to store count of each integer
        // in the input array
        int[] freq = new int[k];

        // using value of integer in the input array as index,
        // store count of each integer in freq[] array
        for (int i: arr) {
            freq[i]++;
        }

        // overwrite the input array with sorted order
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (freq[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 4, 2, 10, 10, 1, 4, 2, 1, 10 };

        // range of array elements
        int k = 11;

        countSort(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}