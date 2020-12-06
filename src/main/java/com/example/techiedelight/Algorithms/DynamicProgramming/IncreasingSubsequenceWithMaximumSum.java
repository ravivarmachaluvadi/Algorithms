package com.example.techiedelight.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IncreasingSubsequenceWithMaximumSum
{
    // Function to find maximum sum of increasing subsequence
    public static int MSIS(int[] A, int i, int n, int prev, int sum)
    {
        // Base case: nothing is remaining
        if (i == n) {
            return sum;
        }
 
        // case 1: exclude the current element and process the
        // remaining elements
        int excl = MSIS(A, i + 1, n, prev, sum);
 
        // case 2: include the current element if it is greater
        // than previous element
        int incl = sum;
        if (A[i] > prev) {
            incl = MSIS(A, i + 1, n, A[i], sum + A[i]);
        }
 
        // return maximum of above two choices
        return Integer.max(incl, excl);
    }
 
    public static void main(String[] args)
    {
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
 
        System.out.print("Maximum sum of increasing subsequence is " +
                        MSIS(A, 0, A.length, Integer.MIN_VALUE, 0));
    }
}





class IncreasingSubsequenceWithMaximumSumA2
{
    // Iterative function to find maximum sum of an increasing sub-sequence
    public static int MSIS(int[] A)
    {
        // array to store sub-problem solution. sum[i] stores the maximum
        // sum of the increasing sub-sequence that ends with A[i]
        int[] sum = new int[A.length];

        // base case
        sum[0] = A[0];

        // start from second element in the array
        for (int i = 1; i < A.length; i++)
        {
            // do for each element in sub-array A[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find increasing sub-sequence with maximum sum that ends
                // with A[j] where A[j] is less than the current element A[i]

                if (sum[i] < sum[j] && A[i] > A[j]) {
                    sum[i] = sum[j];
                }
            }

            // include A[i] in MSIS
            sum[i] += A[i];
        }

        // find increasing sub-sequence with maximum sum
        return Arrays.stream(sum).max().getAsInt();
    }

    public static void main(String[] args)
    {
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };

        System.out.print("Maximum sum of increasing subsequence is " +
                MSIS(A));
    }
}





class IncreasingSubsequenceWithMaximumSumA3
{
    // Iterative function to print increasing subsequence with the maximum sum
    public static void printMSIS(int[] arr)
    {
        int n = arr.length;

        // MSIS[i] stores the increasing subsequence having maximum sum
        // that ends with arr[i]
        List<List<Integer>> MSIS = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MSIS.add(i, new ArrayList<>());
        }
        MSIS.get(0).add(arr[0]);

        // sum[i] stores the maximum sum of the increasing subsequence
        // that ends with arr[i]
        int[] sum = new int[n];
        sum[0] = arr[0];

        // start from second element in the array
        for (int i = 1; i < n; i++)
        {
            // do for each element in subarray arr[0..i-1]
            for (int j = 0; j < i; j++)
            {
                // find increasing subsequence with maximum sum that ends with
                // arr[j] where arr[j] is less than the current element arr[i]

                if (sum[i] < sum[j] && arr[i] > arr[j])
                {
                    // update increasing subsequence
                    MSIS.set(i, new ArrayList<>(MSIS.get(j)));

                    // update maximum sum
                    sum[i] = sum[j];
                }
            }

            // include current element in increasing subsequence
            MSIS.get(i).add(arr[i]);

            // add current element to maximum sum
            sum[i] += arr[i];
        }

        // uncomment below lines to print contents of list MSIS
        /*for (int i = 0; i < n; i++) {
            System.out.println("MSIS[" + i + "] - " + MSIS.get(i));
        }*/

        // j will contain index of MSIS
        int j = 0;
        for (int i = 1; i < n; i++) {
            if (sum[i] > sum[j]) {
                j = i;
            }
        }

        // print MSIS
        System.out.println(MSIS.get(j));
    }

    public static void main(String[] args)
    {
        int[] arr = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
        printMSIS(arr);
    }
}