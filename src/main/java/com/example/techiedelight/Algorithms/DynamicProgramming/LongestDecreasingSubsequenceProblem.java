package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LongestDecreasingSubsequenceProblem
{
    // Function to find length of longest decreasing subsequence
    // of given sub-array A[i..n)
    public static int LDS(int[] A, int i, int n, int prev)
    {
        // Base case: nothing is remaining
        if (i == n) {
            return 0;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = LDS(A, i + 1, n, prev);
 
        // case 2: include the current element if it is smaller
        // than previous element in LDS
        int incl = 0;
        if (A[i] < prev) {
            incl = 1 + LDS(A, i + 1, n, A[i]);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
 
        System.out.println("Length of LDS is " +
                LDS(A, 0, A.length, Integer.MAX_VALUE));
    }
}





class LongestDecreasingSubsequenceProblemA2
{
    // Iterative function to find length of longest decreasing subsequence
    // of given array
    public static int LDS(int[] A)
    {
        // array to store sub-problem solution. L[i] stores the length
        // of the longest decreasing subsequence ends with A[i]
        int[] L = new int[A.length];

        // longest decreasing subsequence ending with A[0] has length 1
        L[0] = 1;

        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in subarray A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest decreasing subsequence that ends with A[j]
                // where A[j] is more than the current element A[i]

                if (A[j] > A[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }

            // include A[i] in LDS
            L[i]++;
        }

        // return longest decreasing subsequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }

    public static void main(String[] args)
    {
        int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
        System.out.println("Length of LDS is " + LDS(A));
    }
}





class LongestDecreasingSubsequenceProblemA3
{
    // Iterative function to find longest decreasing subsequence
    // of given array
    public static void findLDS(int[] arr)
    {
        // LDS[i] stores the longest decreasing subsequence of sub-array
        // arr[0..i] that ends with arr[i]
        List<List<Integer>> LDS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LDS.add(new ArrayList<>());
        }

        // LDS[0] denotes longest decreasing subsequence ending with arr[0]
        LDS.get(0).add(arr[0]);

        // start from second element in the array
        for (int i = 1; i < arr.length; i++)
        {
            // do for each element in subarray arr[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find longest decreasing subsequence that ends with arr[j]
                // where arr[j] is more than the current element arr[i]

                if (arr[j] > arr[i] && LDS.get(j).size() > LDS.get(i).size())
                    LDS.set(i, new ArrayList<>(LDS.get(j)));
            }

            // include arr[i] in LDS[i]
            LDS.get(i).add(arr[i]);
        }

        // uncomment below lines to print contents of list LDS
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println("LDS[" + i + "] - " + LDS.get(i));
        }*/

        // j will contain index of LDS
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (LDS.get(j).size() < LDS.get(i).size()) {
                j = i;
            }
        }

        // print LDS
        System.out.print(LDS.get(j));
    }

    public static void main(String[] args)
    {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        findLDS(arr);
    }
}