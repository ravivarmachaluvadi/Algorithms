package com.example.techiedelight.Algorithms.arrays;

import java.util.Arrays;
 
class LongestAlternatingSubarrayProblem
{
    // Function to find length of longest subarray with alternating
    // positive and negative elements
    public static void findLongestSubArray(int[] arr)
    {
        // stores length of longest alternating subarray found so far
        int maxLen = 1;
 
        // stores ending index of longest alternating subarray found so far
        int endIndex = 0;
 
        // stores length of longest alternating subarray ending at current position
        int currLen = 1;
 
        // traverse the given array starting from the second index
        for (int i = 1; i < arr.length; i++)
        {
            // if current element has opposite sign than the previous element
            if (arr[i] * arr[i - 1] < 0)
            {
                // include current element in longest alternating subarray ending at
                // previous index
                currLen++;
 
                // update result if current sub-array length is found to be greater
                if (currLen > maxLen)
                {
                    maxLen = currLen;
                    endIndex = i;
                }
            }
            // reset length if current element has same sign as previous element
            else {
                currLen = 1;
            }
        }
 
        int[] subarray = Arrays.copyOfRange(arr, (endIndex - maxLen + 1), endIndex + 1);
        System.out.println("The longest alternating subarray is "
                            + Arrays.toString(subarray));
    }
 
    public static void main (String[] args)
    {
        int[] arr = { 1, -2, 6, 4, -3, 2, -4, -3 };
 
        findLongestSubArray(arr);
    }
}