package com.example.techiedelight.Algorithms.arrays;

class FindLengthOfSmallestSubarrayWhoseSumOfElementsIsGreaterThanTheGivenNumber
{
    // Function to find the length of smallest subarray whose sum
    // of elements is greater than the given number
    public static int smallestSubarray(int[] A, int k)
    {
        // stores the current window sum
        int windowSum = 0;
 
        // stores the result
        int len = Integer.MAX_VALUE;
 
        // stores window's starting index
        int left = 0;
 
        // maintain a sliding window [left..right]
        for (int right = 0; right < A.length; right++)
        {
            // include current element in the window
            windowSum += A[right];
 
            // window becomes unstable if its sum becomes more than k
            while (windowSum > k && left <= right)
            {
                // update the result if current window's length is less
                // than minimum found so far
                len = Integer.min(len, right - left + 1);
 
                // remove elements from the window's left side till window
                // becomes stable again
                windowSum -= A[left];
                left++;
            }
        }
 
        // return result
        return len;
    }
 
    public static void main(String[] args)
    {
        // array of positive numbers
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 21;
 
        // find length of the smallest sub-array
        int len = smallestSubarray(A, k);
 
        if (len != Integer.MAX_VALUE) {
            System.out.print("Smallest sub-array length is " + len);
        } else {
            System.out.print("No sub-array exists");
        }
    }
}