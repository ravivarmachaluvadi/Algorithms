package com.example.techiedelight.Algorithms.arrays;

/*
Find Longest Bitonic Subarray in an array
The longest bitonic subarray problem is to find a subarray of a given sequence in which the subarray’s elements are first
sorted in in increasing order, then in decreasing order, and the subarray is as long as possible. Strictly ascending or
descending subarrays are also accepted.
*/

//TC - O(N) , SC - O(N)
class FindLongestBitonicSubarrayInAnArray
{
    // Function to find length of Longest Bitonic Subarray in an array
    public static void findBitonicSubarray(int[] A)
    {
        // I[i] stores the length of the longest increasing sub-array
        // ending at A[i]
        int[] I = new int[A.length];
        I[0] = 1;
        for (int i = 1; i < A.length; i++) {
            I[i] = 1;
            if (A[i - 1] < A[i]) {
                I[i] = I[i - 1] + 1;
            }
        }
 
        // D[i] stores the length of the longest decreasing sub-array
        // starting with A[i]
        int[] D = new int[A.length];
        D[A.length - 1] = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            D[i] = 1;
            if (A[i] > A[i + 1]) {
                D[i] = D[i + 1] + 1;
            }
        }
 
        // consider each element as peak and calculate LBS
        int lbs_len = 1;
        int beg = 0, end = 0;
 
        for (int i = 0; i < A.length; i++)
        {
            int len = I[i] + D[i] - 1;
            if (lbs_len < len) {
                lbs_len = len;
                beg = i - I[i] + 1;
                end = i + D[i] - 1;
            }
        }
 
        // print longest bitonic sub-array
        System.out.println("The length of longest bitonic sub-array is " + lbs_len);
        System.out.println("The longest bitonic sub-array is [" + beg + ", " + end + "]");
 
    }
 
    public static void main(String[] args)
    {
        int[] A = { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 };
 
        findBitonicSubarray(A);
    }
}



class FindLongestBitonicSubarrayInAnArrayOpti
{
    // Function to find length of Longest Bitonic Subarray in an array
    public static void findBitonicSubarray(int[] A)
    {
        int n = A.length;
        int end_index = 0, max_len = 0;

        int i = 0;
        while (i + 1 < n)
        {
            // check for Longest Bitonic Subarray starting at A[i]

            // reset length to 1
            int len = 1;

            // run till sequence is increasing
            while (i + 1 < n && A[i] < A[i + 1]) {
                i++;
                len++;
            }

            // run till sequence is decreasing
            while (i + 1 < n && A[i] > A[i + 1]) {
                i++;
                len++;
            }

            // update Longest Bitonic Subarray if required
            if (len > max_len)
            {
                max_len = len;
                end_index = i;
            }
        }

        // print longest bitonic sub-array
        System.out.println("The length of longest bitonic sub-array is "
                + max_len);

        System.out.println("The longest bitonic sub-array is [" +
                (end_index - max_len + 1) + ", " + end_index + "]");
    }

    public static void main(String[] args)
    {
        int[] A = { 3, 5, 8, 4, 5, 9, 10, 8, 5, 3, 4 };

        findBitonicSubarray(A);
    }
}