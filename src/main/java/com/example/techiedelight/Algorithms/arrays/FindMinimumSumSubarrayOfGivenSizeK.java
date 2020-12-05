package com.example.techiedelight.Algorithms.arrays;

//Sliding Window Technique
class FindMinimumSumSubarrayOfGivenSizeK
{
    // Find minimum sum sub-array of given size k
    public static void findSubarray(int[] arr, int k)
    {
        // stores sum of element in current window
        int window_sum = 0;
 
        // stores sum of minimum sum sub-array found so far
        int min_window = Integer.MAX_VALUE;
 
        // stores ending index of minimum sum sub-array found so far
        int last = 0;
 
        for (int i = 0; i < arr.length; i++)
        {
            // add current element to the window
            window_sum += arr[i];
 
            // if window size is more than equal to k
            if (i + 1 >= k)
            {
                // update minimum sum window
                if (min_window > window_sum)
                {
                    min_window = window_sum;
                    last = i;
                }
 
                // remove leftmost element from the window
                window_sum -= arr[i + 1 - k];
            }
        }
 
        System.out.printf("Minimum sum sub-array is (%d, %d)", last - k + 1, last);
    }
 
    public static void main(String[] args)
    {
        int[] arr = { 10, 4, 2, 5, 6, 3, 8, 1 };
        int k = 3;
 
        findSubarray(arr, k);
    }
}