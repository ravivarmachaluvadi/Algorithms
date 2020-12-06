package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LongestIncreasingSubsequenceUsingDynamicProgramming
{
    // Function to find length of longest increasing subsequence
    public static int LIS(int[] A, int i, int n, int prev)
    {
        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = LIS(A, i + 1, n, prev);
 
        // case 2: include the current element if it is greater
        // than previous element in LIS
        int incl = 0;
        if (A[i] > prev) {
            incl = 1 + LIS(A, i + 1, n, A[i]);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }
 
    // Program for Longest Increasing Subsequence
    public static void main(String[] args)
    {
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
 
        System.out.print("Length of LIS is "
                        + LIS(A, 0, A.length, Integer.MIN_VALUE));
    }
}




class LongestIncreasingSubsequenceUsingDynamicProgrammingA2
{
    // Iterative function to find length of longest increasing sub-sequence
    // of given array
    public static int LIS(int[] A)
    {
        // array to store sub-problem solution. L[i] stores the length
        // of the longest increasing sub-sequence ends with A[i]
        int[] L = new int[A.length];

        // longest increasing sub-sequence ending with A[0] has length 1
        L[0] = 1;

        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in sub-array A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest increasing sub-sequence that ends with A[j]
                // where A[j] is less than the current element A[i]
                if (A[j] < A[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }
            // include A[i] in LIS
            L[i]++;
        }

        // return longest increasing sub-sequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }

    public static void main(String[] args)
    {
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.print("Length of LIS is " + LIS(A));
    }
}





class LongestIncreasingSubsequenceUsingDynamicProgrammingA3
{
    // Iterative function to find longest increasing subsequence
    // of given array
    public static void findLIS(int[] arr)
    {
        // LIS.get(i) stores the longest increasing subsequence of subarray
        // arr[0..i] that ends with arr[i]
        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LIS.add(new ArrayList<>());
        }

        // LIS[0] denotes longest increasing subsequence ending with arr[0]
        LIS.get(0).add(arr[0]);

        // start from second element in the array
        for (int i = 1; i < arr.length; i++)
        {
            // do for each element in subarray arr[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest increasing subsequence that ends with arr[j]
                // where arr[j] is less than the current element arr[i]

                if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }

            // include arr[i] in LIS.get(i)
            LIS.get(i).add(arr[i]);
        }

        // uncomment below lines to print contents of vector LIS
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println("LIS[" + i + "] - " + LIS.get(i));
        }*/

        // j will contain index of LIS
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }

        // print LIS
        System.out.print(LIS.get(j));
    }

    public static void main(String[] args)
    {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        findLIS(arr);
    }
}